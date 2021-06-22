package controller.dao;
import controller.enums.Gender;
import controller.model.Customer;
import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/***
 * This class named DAO data access layer is solely designed
 * for working with our data i.e customer object.
 * ***/

public class CustomerDAO {

    /***
     * saveCustomer method for saving customer object in database.
     * Creating new database connection with method start.
     * Prepared statement for inserting data in database.
     * setting parameter with prepared statement
     * execute the query.
     * *****/

    public boolean createCustomer(Customer customer) throws SQLException {
        DatabaseConnection databaseconnection = new DatabaseConnection();
        try {
            String insertSQL = "insert into xyz_customer values (null,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseconnection.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getMobileNumber());
            preparedStatement.setInt(6, customer.getGender().ordinal());

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseconnection.connection.close();
        }
        return false;
    }
        /***
         * method designed to finding customer from the database;
         * we are fetching the data and adding the data in the list
         * Creating new arraylist to save data.
         * **/

        public List<Customer> findAllCustomer() throws SQLException{
            DatabaseConnection databaseconnection = new DatabaseConnection();
            List<Customer> customers = new ArrayList<>();

            try {
                String findAllSQL = "select * from xyz_customer";
                PreparedStatement preparedStatement = databaseconnection.connection.prepareStatement(findAllSQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    customers.add(new Customer(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            Gender.findByOrdinal(resultSet.getInt(6))));
                }


            } catch (Exception ex){
                ex.printStackTrace();
            } finally {
                databaseconnection.connection.close();
            }
            return null;

        }

        /**
         * Creating arraylist customer and adding all customer fullName from database
         * column Index in the List.
         * **/

        public List<String> getCustomerByName() {
            DatabaseConnection databaseconnection = new DatabaseConnection();
            List<String> customers = new ArrayList<>();

            try {
                String findNameSQL = "select * from xyz_customer";
                PreparedStatement preparedStatement = databaseconnection.connection.prepareStatement(findNameSQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    customers.add(resultSet.getString(2));
                }

            } catch (Exception ex ){
                ex.printStackTrace();
            } finally {
                try {
                    databaseconnection.connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return customers;
        }

}

