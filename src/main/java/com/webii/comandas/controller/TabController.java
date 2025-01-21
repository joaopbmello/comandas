package com.webii.comandas.controller;

import com.webii.comandas.domain.Tab;
import com.webii.comandas.repository.TabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tabs")
public class TabController {

    @Autowired
    private TabRepository tabRepository;

    // Endpoint para listar todas as comandas
    @GetMapping
    public List<Tab> getAllTabs() {
        return tabRepository.findAll();
    }

    // Endpoint para criar uma nova comanda
    @PostMapping
    public Tab createTab(@RequestBody Tab tab) {
        return tabRepository.save(tab);
    }

    // Endpoint para buscar uma comanda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tab> getTabById(@PathVariable Integer id) {
        return tabRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar uma comanda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTab(@PathVariable Integer id) {
        if (tabRepository.existsById(id)) {
            tabRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tab> updateCustomerName(@PathVariable Integer id, @RequestBody Tab updatedTab) {
        return tabRepository.findById(id).map(existingTab -> {
            existingTab.setCustomer(updatedTab.getCustomer());
            Tab savedTab = tabRepository.save(existingTab);
            return ResponseEntity.ok(savedTab);
        }).orElse(ResponseEntity.notFound().build());
    }
}
