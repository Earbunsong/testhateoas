package co.istad.deme.api.order;

import java.util.List;

public interface OrderService {
    List<Order> listAll ();

    Order getById(Long id);
}
