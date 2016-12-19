package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest re, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) re;
		HttpServletResponse response=(HttpServletResponse) res;
		// 获得用户请求的URI
		  String path = request.getRequestURI();
		  System.out.println(path);
		  System.out.println(request.getParameter("method"));
		// 登陆、主界面页面无需过滤
		  if(path.indexOf("/login.jsp") > -1||path.indexOf("/index.jsp") > -1||"login".equals(request.getParameter("method"))||path.equals("/Exam-12699-20161219-1/")) {
		   chain.doFilter(request, response);
		   return;
		  }else if (request.getSession().getAttribute("customer")==null) {
			  request.setAttribute("path", path);
			  request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			// 已经登陆,继续此次请求
			chain.doFilter(request,response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
