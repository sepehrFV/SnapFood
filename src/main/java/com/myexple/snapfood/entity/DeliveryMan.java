package com.myexple.snapfood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myexple.snapfood.embeddable.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMan extends Person{


    @Embedded
    private Vehicle vehicle;

    private Integer score;

    @JsonIgnore
    @OneToMany(mappedBy = "deliveryMan")
    private List<Order> orders;

}
