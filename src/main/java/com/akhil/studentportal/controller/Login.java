package com.akhil.studentportal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.akhil.studentportal.model.*;
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("studentName");
		String password=request.getParameter("password");
		System.out.println(name+password+"--from user");
		Model model=new Model();
		model.login();
		System.out.println(model.getStudentName()+model.getPassword()+"--from db");
		if(name.equals(model.getStudentName())&& (password.equals(model.getPassword()))) {
			response.sendRedirect("/MVCProject/loginsuccess.html");
		}
		else
			response.sendRedirect("/MVCProject/loginfail.html");
	}

}
