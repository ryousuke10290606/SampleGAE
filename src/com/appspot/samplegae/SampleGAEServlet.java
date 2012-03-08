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

@SuppressWarnings("serial")
public class SampleGAEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher(
        "/WEB-INF/sample.html");
        rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		if(name == null || "".equals(name)){
			resp.getWriter().println("Plese enter name");
			return;
		}

		if(email == null || "".equals(email)){
			//emailが空の場合は、入力nameの名前でデータストアに対し検索をかける
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Person person = pm.getObjectById(Person.class, name);
			pm.close();
			resp.getWriter().println("e-mail address of" + name +"is below:");
			resp.getWriter().println("name:"+person.getName());
			resp.getWriter().println("e-mail:"+person.getEmail());
			return;
		}else{
			//emailが空の場合は、nameとemailの情報をデータストアに保存する
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Person person = new Person(name,email);
			pm.makePersistent(person);
			pm.close();
			resp.getWriter().println("you entered:");
			resp.getWriter().println("name:"+name);
			resp.getWriter().println("e-mail:"+email);
			return;
		}

	}

}
