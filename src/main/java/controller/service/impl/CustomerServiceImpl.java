package controller.service.impl;

import controller.dao.CustomerDAO;
import controller.model.Customer;
import controller.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {


    CustomerDAO customerDAO = new CustomerDAO();
    boolean result;



    @Override
    public boolean createCustomer(Customer customer) {

        try{

            /**
             * We can validate the the user ih this method.
             ***/
            result = customerDAO.createCustomer(customer);

            return result;

        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }


    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }
}
