package controller.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import controller.dao.CustomerDAO;
import controller.model.Customer;
import controller.enums.Gender;
import controller.service.CustomerService;
import controller.service.impl.CustomerServiceImpl;


@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();
    CustomerDAO customerDAO = new CustomerDAO();

    @Override

    /**
     * if user wants to go in landing page of customer then response is redirect to customer.jsp
     * if use wants to go in customer list page then response is redirect to list.jsp
     * He single servlet is communicating with two web pages.
     *
     * 2. To show colorList everytime we visit customer page we use requestDispatcher and setRedirect to colorList
     * **/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("landingPage")){
            //response.sendRedirect("customer.jsp");

            request.setAttribute("customerList", customerDAO.getCustomerByName());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
            requestDispatcher.forward(request, response);
        }
        else if (action.equalsIgnoreCase("listPage")){
            response.sendRedirect("list.jsp");
        } else {
            response.sendRedirect("customer.jsp");
        }
    }

    /***
     *  1. The data we entered in our forms in website are saved by method post and comes to doPost method.
     *
     *
     * **/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("save")) {
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String mobileNumber = request.getParameter("mobileNumber");
            String gender = request.getParameter("gender");

            /**
             * Here we can save data and send user message.
             * Instead of using sendRedirect we used request dispatcher so that we can give message along with page.
             * As we got data from our frontend now we save data in our customer object form our customer model class.
             * so that we can save customer object in database.
             * **/

            Customer customer = new Customer(fullName,password,address, email,mobileNumber,Gender.valueOf(gender));
            boolean result = customerService.createCustomer(customer);

            request.setAttribute("message", result ? "Customer Saved Successfully" : "Failed in creating customer");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
            requestDispatcher.forward(request, response);


        } else {
            response.sendRedirect("customer.jsp");

        }
    }

//    private List<String> colorList(){
//        List<String> colors = new ArrayList<>();
//        colors.add("red");
//        colors.add("blue");
//        colors.add("purple");
//        colors.add("black");
//        colors.add("green");
//        return colors;
//    }

}
