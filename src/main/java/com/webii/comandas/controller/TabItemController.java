package com.webii.comandas.controller;

import com.webii.comandas.domain.TabItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tab-items")
public class TabItemController {
    private final List<TabItem> tabItems = new ArrayList<>();

    @GetMapping
    public List<TabItem> getAllTabItems() {
        return tabItems;
    }

    @PostMapping
    public TabItem addTabItem(@RequestBody TabItem tabItem) {
        tabItems.add(tabItem);
        return tabItem;
    }
}
