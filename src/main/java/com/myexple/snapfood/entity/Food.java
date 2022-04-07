package com.myexple.snapfood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myexple.snapfood.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "f_id")
    private Long id;
    private String name;
    private FoodType type;
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "food")
    private List<Serve> serveRestaurant;


}
