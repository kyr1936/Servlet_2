package com.yr.t1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.action.ActionForward;

/**
 * Servlet implementation class PointServlet
 */
@WebServlet("/PointServlet")
public class PointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		ActionForward actionForward = new ActionForward();
		
		if(command.equals("/pointList")) {
			String name = "iu";
			request.setAttribute("n", name);
			actionForward.setPath("../pointList.jsp");
			actionForward.setCheck(true);
			
		} else if(command.equals("/pointWrite")){
			String name ="suji";
			request.setAttribute("name", name);
			actionForward.setPath("../WEB-INF/views/point/pointWrite.jsp");
			actionForward.setCheck(true);
			
		} else if(command.equals("/pointDelete")) {
			System.out.println("Delete");
			actionForward.setPath("../pointList");
			actionForward.setCheck(false);
			
		}
		if(actionForward.isCheck()) {
		//forward
		RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
		view.forward(request, response);
		
		} else //Redirect
			response.sendRedirect(actionForward.getPath());
		
		
	/*
		//1. 요청 주소 - parameter는 가져오지 않는다
		 
		String uri = request.getRequestURI();
	//	StringBuffer url = request.getRequestURL();
		System.out.println(uri);
	//	System.out.println(url);
		int index = uri.lastIndexOf('/');
		uri = uri.substring(index);
		System.out.println(uri);
	*/	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
