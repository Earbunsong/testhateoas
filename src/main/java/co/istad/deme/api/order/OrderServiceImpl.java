package co.istad.deme.api.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> listAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @Override
    public Order getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found id :{}"+id));
        return order;
    }
}
