package account.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import account.wrapper.EncryptWrapper;


/**
 * Servlet Filter implementation class EncryptFilter
 */
/* 적용 대상 Servlet : InsertMemberServlet1, InsertMemberServlet2, LoginServlet, UpdatePasswordServlet */
@WebFilter(filterName = "encrypt", servletNames= {"InsertMemberServlet1", "InsertMemberServlet2", "LoginServlet", "UpdatePasswordServlet", "MemberControllerServlet", "TempPasswordServlet"})
// -> servletName으로 필터를 적용할 때는 반드시 배포명이 있어야 함(각 서블릿에서 수정)
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		EncryptWrapper encWrapper = new EncryptWrapper((HttpServletRequest)request);

		chain.doFilter(encWrapper, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
