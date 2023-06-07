package br.com.santander.internetbanking.listcustomer;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ListCustomerController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/customers")
    public HashMap<String, Object> list() {
        List customers = manager.createQuery(" select c from NewCustomer c").getResultList();

        HashMap<String, Object> result = new HashMap<>();
        result.put("customers", customers.toString());

        return result;
    }

}
