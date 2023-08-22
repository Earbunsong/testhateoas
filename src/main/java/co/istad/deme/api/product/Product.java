package co.istad.deme.api.product;

import co.istad.deme.api.order.Order;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product extends RepresentationModel<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private String color;
    private String size;

    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        this.orders.add(order);
        order.setProducts(this);
    }
}
