package me.nichel.sportcenter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.nichel.sportcenter.dao.CustomerDAOImpl;
import me.nichel.sportcenter.dao.GenericDAO;
import me.nichel.sportcenter.model.Customer;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LIST = "/customers_list.jsp";
	public static final String INSERT_OR_EDIT = "/customer_edit.jsp";
	public static final String VIEW = "/customer_view.jsp";

	private final GenericDAO<Customer> dao;

	public CustomerServlet() {
		super();

		dao = new CustomerDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";

        final String action = request.getParameter("action");
        switch (action) {
        	case "delete": {
        		forward = LIST;
        		
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                
                request.setAttribute("customers", dao.getAll());
                
        		break;
        	}
        	
        	case "view": {
                forward = VIEW;

                int id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("customer", dao.get(id));

        		break;
        	}
        	
        	case "edit": {
                forward = INSERT_OR_EDIT;

                int id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("customer", dao.get(id));

        		break;
        	}
        	
        	case "insert": {
                forward = INSERT_OR_EDIT;
                
                break;
        	}
        	
        	case "list":
        	default: {
        		forward = LIST;
        		
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
		
		final RequestDispatcher view = request.getRequestDispatcher(LIST);
		request.setAttribute("customers", dao.getAll());
		
		view.forward(request, response);
	}
}
