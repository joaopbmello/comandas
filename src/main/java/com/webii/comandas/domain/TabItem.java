package com.webii.comandas.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TabItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tab_id", nullable = false)
    @JsonIgnoreProperties("items")
    @JsonProperty("tab")
    private Tab tab;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonProperty("product")
    private Product product;

    @JsonProperty("ammount")
    private Integer ammount;

    @JsonProperty("subtotal")
    private Double subtotal;
}
