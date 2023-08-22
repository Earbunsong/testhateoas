package co.istad.deme.api.order;

import co.istad.deme.api.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order extends RepresentationModel<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_received")
//    @CreatedDate
    private LocalDateTime dataReceived;
    @Column(name = "data_delivered")
//    @LastModifiedDate
    private LocalDateTime dataDelivered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product products;
    public Object getProduct(){
        return null;
    }
    public void setProduct(Product product){
        this.products = product;
    }
}
