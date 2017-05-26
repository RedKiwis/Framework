package com.hb.Framework.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.Framework.model.Simple02Dao;
import com.hb.Framework.support.MyController;

public class ListController implements MyController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Simple02Dao dao = new Simple02Dao();
		try {
			request.setAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}

}
