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

    private String customer;

    private String status;

    private Integer tableNumber;

    @OneToMany(mappedBy = "tab", cascade = CascadeType.ALL)
    private List<TabItem> items;

    private Double total;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;
}
