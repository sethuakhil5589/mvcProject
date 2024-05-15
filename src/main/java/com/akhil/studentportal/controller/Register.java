package com.akhil.studentportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akhil.studentportal.model.Model;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdId=request.getParameter("studentId");
		String stdName=request.getParameter("studentName");
		String stdAge=request.getParameter("studentAge");
		String stdCity=request.getParameter("studentCity");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		
		
		if(password.equals(cpassword)) {
			Model model=new Model();
			model.setStudentId(stdId);
			model.setStudentName(stdName);
			model.setStudentAge(stdAge);
			model.setStudentCity(stdCity);
			model.setPassword(password);
			model.register();
			int row=model.getRow();
			System.out.println("student details"+stdId+stdName+stdAge+stdCity);
			System.out.println(row);
			if(row>0) {
				response.sendRedirect("/MVCProject/registersuccess.html");
			}
			else
				response.sendRedirect("/MVCProject/registerfail.html");
		}
		else {
			response.sendRedirect("/MVCProject/registerfail.html");
		}
	}

}
