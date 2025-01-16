package com.webii.comandas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String customer;

    @Column(name = "table_number", nullable = false)
    private int tableNumber;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "tab", cascade = CascadeType.ALL)
    private List<TabItem> items;

    @Column(nullable = false)
    private double total;

    @Column(name = "opened_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openedAt;

    @Column(name = "closed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedAt;
}
