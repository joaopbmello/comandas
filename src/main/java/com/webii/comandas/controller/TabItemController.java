package com.webii.comandas.controller;

import com.webii.comandas.domain.TabItem;
import com.webii.comandas.repository.TabItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tab-items")
public class TabItemController {

    @Autowired
    private TabItemRepository tabItemRepository;

    // Endpoint para listar todos os itens de comandas
    @GetMapping
    public List<TabItem> getAllTabItems() {
        return tabItemRepository.findAll();
    }

    // Endpoint para criar um novo item em uma comanda
    @PostMapping
    public TabItem createTabItem(@RequestBody TabItem tabItem) {
        return tabItemRepository.save(tabItem);
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
            tabItemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
