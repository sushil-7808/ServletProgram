package controller.service;

import controller.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    boolean createCustomer(Customer customer);

    List<Customer> findAllCustomer();
}
