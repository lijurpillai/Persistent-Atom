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
import com.perfomatix.atomcore.util.Constants;
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

		
		if (Constants.HTTP_REQUEST_METHOD_POST.equalsIgnoreCase(httpRequest.getMethod()) 
				||	Constants.HTTP_REQUEST_METHOD_OPTIONS.equalsIgnoreCase(httpRequest.getMethod())) {
			
			httpResponse.setHeader(Constants.HTTP_RESPONSE_HEADER_ACAO, Constants.HTTP_RESPONSE_HEADER_ACAO_VALUE);
			httpResponse.setHeader(Constants.HTTP_RESPONSE_HEADER_ACAH, Constants.HTTP_RESPONSE_HEADER_ACAH_VALUE);
		}
		
		String callback = (params.containsKey(Constants.HTTP_REQUEST_CALLBACK) 
							&& (params.get(Constants.HTTP_REQUEST_CALLBACK)[0] != null)) 
							? (params.get(Constants.HTTP_REQUEST_CALLBACK)[0]).trim() 
							: "";

		if (!callback.isEmpty()) {
			
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
