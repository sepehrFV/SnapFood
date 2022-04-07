package ir.mapsa.snapfood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.mapsa.snapfood.enums.RestaurantType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "r_id")
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private RestaurantType type;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Serve> serveFood;


}
