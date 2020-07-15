package local.jlwilliams.orders.controllers;

import local.jlwilliams.orders.models.Order;
import local.jlwilliams.orders.services.AgentServices;
import local.jlwilliams.orders.services.OrderServices;
import local.jlwilliams.orders.views.AdvanceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController
{
    @Autowired
    private OrderServices orderService;

    @GetMapping(value = "/order/{id}", produces = {"application/json"})
    public ResponseEntity<?> findOrderById(@PathVariable long id){
        Order rtn = orderService.findOrderById(id);
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }

    @GetMapping(value = "/advanceamount", produces = {"application/json"})
    public ResponseEntity<?> listOrdersByAdvanceamount(){
        List<AdvanceOrders> rtn = orderService.listAdvanceOrders();
        return new ResponseEntity<>(rtn, HttpStatus.OK);
    }
}
