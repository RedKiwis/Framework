package com.hb.Framework.support;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);		
		HandlerMapping.setMap("/0526_Framework/list.do", "com.hb.Framework.Controller.ListController");
		HandlerMapping.setMap("/0526_Framework/add.do", "com.hb.Framework.Controller.AddController");
		HandlerMapping.setMap("/0526_Framework/insert.do", "com.hb.Framework.Controller.InsertController");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// /list.do       (get)     ->    /page/list.jsp              -> list
		// /detail.do     (get)     ->    /page/detail.jsp            -> detail
		// /add.do        (get)     ->    /page/form.jsp              -> form
		// /insert.do     (post)    ->    redirect : /page/list.do
		// /edit.do       (get)     ->    /page/form.jsp 재사용
		// /update.do     (post)    ->    redirect : /page/detail.do
		// /delete.do     (post)    ->    redirect : /page/list.do

		// controller
		String uri = request.getRequestURI();
		MyController controller = HandlerMapping.mapping(uri);		
		String pathname = controller.execute(request, response);
		
		// view
		String url = null;
		if(pathname.startsWith("redirect:")){
			url = pathname.replace("redirect:", "");
			response.sendRedirect(url);
			return;			
		}
		
		String prifix = "/page/";
		String sufix = ".jsp";
		url = prifix+pathname+sufix;
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
