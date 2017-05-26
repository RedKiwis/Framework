package com.hb.Framework.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.Framework.model.Simple02Dao;
import com.hb.Framework.model.Simple02Vo;
import com.hb.Framework.support.MyController;

public class InsertController implements MyController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errs = new HashMap<String,String>();
		
		if(!"POST".equals(request.getMethod())){
			request.setAttribute("err", "잘못된 접근 입니다.");
			return "form";
		}
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("name");
		String param2 = request.getParameter("nalja");
		String param3 = request.getParameter("pay");
		Simple02Vo vo = new Simple02Vo();
		vo.setName(param);
		vo.setNalja(param2);
		if(param == ""){
//			request.setAttribute("errNm", "빈칸 입력");
//			request.setAttribute("bean", vo);
//			return "form";
			errs.put("name", "이름 입력");
		}
		if(param2 == ""){
//			request.setAttribute("errNj", "빈칸 입력");

//			return "form";
			errs.put("nalja", "날짜 입력");
		}
		try{
			vo.setPay(Integer.parseInt(param3));	
		}catch(Exception e){
//			request.setAttribute("errPay", "pay의 입력확인");
//			request.setAttribute("bean", vo);
//			return "form";
			errs.put("pay", "금액 입력");
		}
		
		if(!errs.isEmpty()){
			request.setAttribute("errs", errs);
			request.setAttribute("bean", vo);
			return "form";
		}
		
		int result = 0;
		Simple02Dao dao = new Simple02Dao();
		
		try {
			result = dao.insertOne(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		if(result > 0){
			return "redirect:list.do";
		}else{
			return "form";
		}
	}
	
}
