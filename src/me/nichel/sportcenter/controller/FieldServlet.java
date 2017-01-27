package me.nichel.sportcenter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.nichel.sportcenter.dao.FieldDAOImpl;
import me.nichel.sportcenter.dao.GenericDAO;
import me.nichel.sportcenter.model.Field;

public class FieldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String LIST = "/fields_list.jsp";
	public static final String INSERT_OR_EDIT = "/field_edit.jsp";
	public static final String VIEW = "/field_view.jsp";

	private final GenericDAO<Field> dao;

	public FieldServlet() {
		super();

		dao = new FieldDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";

        final String action = request.getParameter("action");
        switch (action) {
        	case "delete": {
        		forward = LIST;
        		
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                
                request.setAttribute("fields", dao.getAll());
                
        		break;
        	}
        	
        	case "view": {
                forward = VIEW;

                int id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("field", dao.get(id));

        		break;
        	}
        	
        	case "edit": {
                forward = INSERT_OR_EDIT;

                int id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("field", dao.get(id));

        		break;
        	}
        	
        	case "insert": {
                forward = INSERT_OR_EDIT;
                
                break;
        	}
        	
        	case "list":
        	default: {
        		forward = LIST;
        		
                request.setAttribute("fields", dao.getAll());
        	}
        }

        final RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final Field field = new Field();
		field.setName(request.getParameter("name"));
		field.setType(0);
		
		final List<String> sports = new ArrayList<>();
		sports.add(request.getParameter("sport_001"));
		sports.add(request.getParameter("sport_002"));
		sports.add(request.getParameter("sport_003"));
		sports.add(request.getParameter("sport_004"));
		field.setSports(sports);

		final String id = request.getParameter("id");

		if (id == null || id.isEmpty())
			dao.add(field);
		else {
			field.setId(Integer.parseInt(id));
			dao.update(field);
		}
		
		final RequestDispatcher view = request.getRequestDispatcher(LIST);
		request.setAttribute("fields", dao.getAll());
		
		view.forward(request, response);
	}
}