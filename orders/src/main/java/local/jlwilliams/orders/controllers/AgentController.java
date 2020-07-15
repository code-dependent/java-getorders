package local.jlwilliams.orders.controllers;


import local.jlwilliams.orders.models.Agent;
import local.jlwilliams.orders.models.Customer;
import local.jlwilliams.orders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RestController
@RequestMapping(value = "/agent")
public class AgentController
{
    @Autowired
    private AgentServices agentService;

    @GetMapping(value = "/agent/{id}", produces = {"application/json"})
    public ResponseEntity<?> getAgentByid(@PathVariable long id){
        Agent rtn = agentService.getAgentById(id);
        return new ResponseEntity<>(rtn,
                HttpStatus.OK);
    }
}
