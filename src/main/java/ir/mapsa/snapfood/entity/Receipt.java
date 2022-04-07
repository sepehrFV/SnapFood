package ir.mapsa.snapfood.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rec_id")
    private Long id;

    @OneToOne
    private Order order;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date orderDate;




}
