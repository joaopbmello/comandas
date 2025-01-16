package com.webii.comandas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Tab {
    private int id;
    private String costumer;
    private int table;
    private String status;
    private TabItem[] items;
    private double total;
    private Date openedAt;
    private Date closedAt;
}
