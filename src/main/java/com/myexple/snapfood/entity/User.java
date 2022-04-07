package com.myexple.snapfood.entity;



import com.myexple.snapfood.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends Person {


    @Enumerated(value = EnumType.STRING)
    private Status status;


    private Integer score;



}
