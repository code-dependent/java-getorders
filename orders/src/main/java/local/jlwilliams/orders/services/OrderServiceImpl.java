package local.jlwilliams.orders.services;

import local.jlwilliams.orders.models.Customer;
import local.jlwilliams.orders.models.Order;
import local.jlwilliams.orders.repositories.CustomerRepository;
import local.jlwilliams.orders.repositories.OrderRepository;
import local.jlwilliams.orders.views.AdvanceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl
        implements OrderServices
{
    @Autowired
    private OrderRepository orderrepos;

    @Override
    public Order save(Order order)
    {
        return orderrepos.save(order);
    }

    @Override
    public Order findOrderById(long id)
    {
        return orderrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Order ID "+ id +" Not Found..."));

    }

    @Override
    public List<AdvanceOrders> listAdvanceOrders()
    {
        return orderrepos.getAdvanceOrders();
    }
}
