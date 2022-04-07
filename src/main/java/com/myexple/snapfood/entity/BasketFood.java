package com.myexple.snapfood.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bf_id")
    private Long id;

    @ManyToOne
    private Food food;

    @ManyToOne
    private Basket basket;
}
