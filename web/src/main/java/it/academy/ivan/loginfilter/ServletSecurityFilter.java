package it.academy.ivan.loginfilter;

import it.academy.ivan.dao.ClientType;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(dispatcherTypes = {
//DispatcherType.REQUEST,
//DispatcherType.FORWARD,
//DispatcherType.INCLUDE
//}, urlPatterns = { "/pages/*" })
@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class ServletSecurityFilter implements Filter {
public void destroy() {
}

@Override
public void init(FilterConfig fConfig) throws ServletException {
	// TODO Auto-generated method stub
	
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;
	HttpSession session = req.getSession();

	ClientType type = (ClientType) session.getAttribute("userType");
	if (type == null) {
		type = ClientType.GUEST;
		session.setAttribute("userType", type);
		if (session.isNew()) {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages/login.jsp");
		dispatcher.forward(req, resp);
		return;
		}
	}
	// pass the request along the filter chain
	chain.doFilter(request, response);
	
}

}