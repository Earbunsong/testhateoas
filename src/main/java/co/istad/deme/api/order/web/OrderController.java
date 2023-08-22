package co.istad.deme.api.order.web;

import co.istad.deme.api.order.Order;
import co.istad.deme.api.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<?> orderAll(){
        List<Order> orders = orderService.listAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> productgetbyid(@PathVariable("id")Long id){
     Order order = orderService.getById(id);
     return new ResponseEntity<>(order,HttpStatus.OK);
    }

}
