package com.webii.comandas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tableNumber")
    private Integer tableNumber;

    @OneToMany(mappedBy = "tab", cascade = CascadeType.ALL)
    @JsonProperty("items")
    private List<TabItem> items;

    @JsonProperty("total")
    private Double total;

    @JsonProperty("openedAt")
    private LocalDateTime openedAt;

    @JsonProperty("closedAt")
    private LocalDateTime closedAt;

    public List<TabItem> getItems() {
        return items;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
