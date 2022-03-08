package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="grants")
public class Grant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String type;

    Double quantity;

    @OneToOne(mappedBy = "grant")
    Student studen;

    public Grant() {
    }

    public Grant(Long id, String type, Double quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Grant{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
