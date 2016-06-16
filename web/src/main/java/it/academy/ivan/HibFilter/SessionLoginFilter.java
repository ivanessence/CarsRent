package it.academy.ivan.HibFilter;

import it.academy.ivan.hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by Ivan on 14.06.2016.
 */
@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class SessionLoginFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Session session = HibernateUtil.currentSession();
        System.out.print("1");
        filterChain.doFilter(request, response);
        HibernateUtil.closeSession();
        System.out.print("2");

    }

    @Override
    public void destroy() {

    }
}
