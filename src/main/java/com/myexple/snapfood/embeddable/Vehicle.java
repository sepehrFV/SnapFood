package com.myexple.snapfood.embeddable;

import com.myexple.snapfood.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private VehicleType vehicleType;
    private String plateNumber;

}
