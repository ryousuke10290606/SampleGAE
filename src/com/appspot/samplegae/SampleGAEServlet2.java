package com.appspot.samplegae;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleGAEServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Person.class);
		List<Person> persons = (List<Person>) query.execute();

		req.setAttribute("persons", persons);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
        "/WEB-INF/sample.jsp");
        rd.forward(req, resp);
	}
}
