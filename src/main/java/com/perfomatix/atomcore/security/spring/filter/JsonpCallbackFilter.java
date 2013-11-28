/**
 * 
 */
package com.perfomatix.atomcore.security.spring.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perfomatix.atomcore.security.spring.wrapper.GenericResponseWrapper;
import com.perfomatix.atomcore.util.UtilService;

/**
 * @author sandeep_ts
 * 
 */
public class JsonpCallbackFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Map<String, String[]> params = httpRequest.getParameterMap();

		String callback = (params.containsKey("callback") && (params.get("callback")[0] != null)) ? (params.get("callback")[0]).trim() : "";

		if (!callback.isEmpty()) {

			httpResponse.setHeader("Access-Control-Allow-Origin", "*");
			httpResponse.setHeader("Access-Control-Allow-Headers", "SecureToken,Content-Type");
			
			OutputStream out = httpResponse.getOutputStream();
			GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);
			chain.doFilter(request, wrapper);
			UtilService.createjsonp(wrapper, callback, out);

		} else {
			chain.doFilter(request, response);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
