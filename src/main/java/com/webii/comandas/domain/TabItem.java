package com.webii.comandas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TabItem {
    private int id;
    private Tab tab;
    private Product product;
    private int quantity;
    private double subtotal;
}
