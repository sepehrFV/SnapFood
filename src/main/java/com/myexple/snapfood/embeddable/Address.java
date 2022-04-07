package com.myexple.snapfood.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {


    private int houseNumber;

    private String street;

    private String avenue;

    private Integer plaque;

    private Integer storey;

    private String city;

    private String coordinates;


}
