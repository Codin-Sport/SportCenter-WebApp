package me.nichel.sportcenter.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.nichel.sportcenter.dao.CustomerDAOImpl;
import me.nichel.sportcenter.dao.FieldDAOImpl;
import me.nichel.sportcenter.dao.GenericDAO;
import me.nichel.sportcenter.dao.ReservationDAOImpl;
import me.nichel.sportcenter.model.Customer;
import me.nichel.sportcenter.model.Field;
import me.nichel.sportcenter.model.Reservation;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String LIST = "/reservations_list.jsp";
	public static final String INSERT_OR_EDIT = "/reservation_edit.jsp";
	public static final String VIEW = "/reservation_view.jsp";
	public static final String ERROR = "/error.jsp"; // TODO

	private final GenericDAO<Reservation> dao;
	private final GenericDAO<Customer> customerDao;
	private final GenericDAO<Field> fieldDao;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        dao = new ReservationDAOImpl();
        customerDao = new CustomerDAOImpl();
        fieldDao = new FieldDAOImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";

        final String action = request.getParameter("action");
        switch (action) {
        	case "delete": {
        		forward = LIST;
        		
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                
                request.setAttribute("reservations", dao.getAll());

        		break;
        	}
        	
        	case "view": {
                forward = VIEW;

                int id = Integer.parseInt(request.getParameter("id"));
                final Reservation reservation = dao.get(id);

                request.setAttribute("reservation", reservation);

        		break;
        	}
        	
        	
        	case "edit": {
                forward = INSERT_OR_EDIT;

                int id = Integer.parseInt(request.getParameter("id"));
                final Reservation reservation = dao.get(id);

                request.setAttribute("reservation", reservation);

        		break;
        	}
        	
        	case "insert": {
                forward = INSERT_OR_EDIT;
                request.setAttribute("customers", customerDao.getAll());
                request.setAttribute("fields", fieldDao.getAll());
                
                break;
        	}
        	
        	default: {
        		forward = LIST;
        		
                request.setAttribute("reservations", dao.getAll());
        	}
        }

        final RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Reservation reservation = new Reservation();
		
		// Get the IDs
		// The received string is in the form:
		// id: something
		String str[] = request.getParameter("customer_id").split(":");
		Long customerId = Long.parseLong(str[0]);
		str = request.getParameter("field_id").split(":");
		Long fieldId = Long.parseLong(str[0]);
		
		// Set IDs
		reservation.setCustomer_id(customerId);
		reservation.setField_id(fieldId);
		
		// Set start and end time
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		
		LocalDateTime startTime = LocalDateTime.parse(start_time);
		LocalDateTime endTime = LocalDateTime.parse(end_time);
		
		reservation.setStart_time(startTime);
		reservation.setEnd_time(endTime);
		
		// Set other fields
		reservation.setCtime(LocalDateTime.now());
		
		reservation.setInfo(request.getParameter("info"));

		final String id = request.getParameter("id");

		if (id == null || id.isEmpty())
			dao.add(reservation);
		else {
			reservation.setId(Integer.parseInt(id));
			dao.update(reservation);
		}
		
		final RequestDispatcher view = request.getRequestDispatcher(LIST);
		request.setAttribute("reservations", dao.getAll());
		
		view.forward(request, response);
	}

}
