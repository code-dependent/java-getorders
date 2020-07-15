package local.jlwilliams.orders.services;

import local.jlwilliams.orders.models.Agent;
import local.jlwilliams.orders.models.Customer;
import local.jlwilliams.orders.repositories.AgentRepository;
import local.jlwilliams.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl
        implements CustomerServices
{
    @Autowired
    private CustomerRepository customerrepos;

    @Override
    public Customer save(Customer customer)
    {
        return customerrepos.save(customer);
    }

    @Override
    public List<Customer> listAllCustomersOrders()
    {
        List<Customer> rtn = new ArrayList<>();
        customerrepos.findAll()
            .iterator()
            .forEachRemaining(rtn::add);
        return rtn;
    }

    @Override
    public Customer findById(long id)
    {
        return customerrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Customer ID "+ id +" Not Found..."));
    }

    @Override
    public List<Customer> findBySubname(String subname)
    {
        List<Customer> rtn = new ArrayList<>();
        rtn = customerrepos.findByCustnameContainingIgnoringCase(subname);
        if(rtn == null){
            throw new EntityNotFoundException("Customers With Subname " + subname + " Not Found");
        }
        return rtn;
    }


}
