package ir.mapsa.snapfood.entity;


import ir.mapsa.snapfood.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "o_id")
    private Long id;

    @OneToOne
    private Basket basket;

    @ManyToOne
    private DeliveryMan deliveryMan;

    @Temporal(TemporalType.TIMESTAMP)
    private Date arriveTime;

    @Enumerated(value = EnumType.STRING)
    private Status status;


}
