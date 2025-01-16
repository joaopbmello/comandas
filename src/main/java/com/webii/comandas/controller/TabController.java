package com.webii.comandas.controller;

import com.webii.comandas.domain.Tab;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tabs")
public class TabController {
    private final List<Tab> tabs = new ArrayList<>();

    @GetMapping
    public List<Tab> getAllTabs() {
        return tabs;
    }

    @PostMapping
    public Tab addTab(@RequestBody Tab tab) {
        tabs.add(tab);
        return tab;
    }
}
