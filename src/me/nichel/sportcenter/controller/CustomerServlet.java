package me.nichel.sportcenter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.nichel.sportcenter.dao.CustomerDAO;
import me.nichel.sportcenter.dao.CustomerDAOImpl;
import me.nichel.sportcenter.model.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String CUSTOMER_LIST = "/customers_list.jsp";
	public static final String INSERT_OR_EDIT = "/customer.jsp";

	private final CustomerDAO dao;

	public CustomerServlet() {
		super();

		dao = new CustomerDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";

        final String action = request.getParameter("action");
        switch (action) {
        	case "delete": {
        		forward = CUSTOMER_LIST;
        		
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                
                request.setAttribute("customers", dao.getAll());

        		break;
        	}
        	
        	case "edit": {
                forward = INSERT_OR_EDIT;

                int id = Integer.parseInt(request.getParameter("id"));
                final Customer customer = dao.get(id);

                request.setAttribute("customer", customer);

        		break;
        	}
        	
        	case "insert": {
                forward = INSERT_OR_EDIT;
                
                break;
        	}
        	
        	default: {
        		forward = CUSTOMER_LIST;
        		
                request.setAttribute("customers", dao.getAll());
        	}
        }

        final RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Customer customer = new Customer();
		customer.setFirstname(request.getParameter("firstname"));
		customer.setLastname(request.getParameter("lastname"));
		customer.setEmail(request.getParameter("email"));

		final String id = request.getParameter("id");

		if (id == null || id.isEmpty())
			dao.add(customer);
		else {
			customer.setId(Integer.parseInt(id));
			dao.update(customer);
		}
		
		final RequestDispatcher view = request.getRequestDispatcher(CUSTOMER_LIST);
		request.setAttribute("customers", dao.getAll());
		
		view.forward(request, response);
	}

}
