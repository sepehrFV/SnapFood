package com.myexple.snapfood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myexple.snapfood.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "b_id")
    private Long id;

    @OneToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "food")
    private List<BasketFood> orderedFoods;

    private Double totalPrice;

    @Enumerated(value = EnumType.STRING)
    private Status status;


}
