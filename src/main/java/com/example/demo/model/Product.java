package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 100)
    private String name;

    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "store_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}
