package mk.ukim.finki.emt.ordermanagement.xport.rest;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderResource {


    private final OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.findAll();
    }
}
