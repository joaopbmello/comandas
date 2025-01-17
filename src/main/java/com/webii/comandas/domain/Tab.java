package com.webii.comandas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String client;

    private String status; // Enum no front-end, representado como String aqui.

    private Integer selectedTable;

    @OneToMany(mappedBy = "tab", cascade = CascadeType.ALL)
    private List<TabItem> products;

    private Double subtotal;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;
}
