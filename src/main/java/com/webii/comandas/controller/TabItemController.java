package com.webii.comandas.controller;

import com.webii.comandas.domain.Product;
import com.webii.comandas.domain.Tab;
import com.webii.comandas.domain.TabItem;
import com.webii.comandas.dto.AddTabItemRequest;
import com.webii.comandas.repository.ProductRepository;
import com.webii.comandas.repository.TabItemRepository;
import com.webii.comandas.repository.TabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tab-items")
public class TabItemController {

    @Autowired
    private TabItemRepository tabItemRepository;

    @Autowired
    private TabRepository tabRepository;

    @Autowired
    private ProductRepository productRepository;

    // Endpoint para listar todos os itens de comandas
    @GetMapping
    public List<TabItem> getAllTabItems() {
        return tabItemRepository.findAll();
    }

    // Endpoint para criar um novo item em uma comanda
    @PostMapping
    public ResponseEntity<TabItem> createTabItem(@RequestBody AddTabItemRequest request) {
        Tab tab = tabRepository.findById(request.getTabId())
                .orElseThrow(() -> new IllegalArgumentException("Tab not found"));
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        TabItem tabItem = new TabItem();
        tabItem.setTab(tab);
        tabItem.setProduct(product);
        tabItem.setAmmount(request.getAmmount());
        tabItem.setSubtotal(product.getPrice() * request.getAmmount());

        TabItem savedTabItem = tabItemRepository.save(tabItem);

        Double newTotal = tab.getItems().stream().mapToDouble(TabItem::getSubtotal).sum();
        tab.setTotal(newTotal);
        tabRepository.save(tab);

        return ResponseEntity.ok(savedTabItem);
    }


    // Endpoint para buscar um item por ID
    @GetMapping("/{id}")
    public ResponseEntity<TabItem> getTabItemById(@PathVariable Integer id) {
        return tabItemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um item de comanda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabItem(@PathVariable Integer id) {
        if (tabItemRepository.existsById(id)) {
            TabItem item = tabItemRepository.findById(id).orElse(null);
            if (item != null) {
                Tab tab = item.getTab();
                tabItemRepository.deleteById(id);

                Double newTotal = tab.getItems().stream()
                        .filter(i -> !i.getId().equals(id))
                        .mapToDouble(TabItem::getSubtotal)
                        .sum();
                tab.setTotal(newTotal);
                tabRepository.save(tab);
            }
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
