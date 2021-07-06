package com.geekbrains.lesson5.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    @ManyToMany
    @JoinTable(
            name = "clients_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product(Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
}
