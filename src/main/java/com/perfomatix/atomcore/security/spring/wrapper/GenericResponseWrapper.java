/**
 * 
 */
package com.perfomatix.atomcore.security.spring.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author sandeep_ts
 * 
 */
public class GenericResponseWrapper extends HttpServletResponseWrapper {
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private int contentLength;
	private String contentType;

	public GenericResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}

	public byte[] getData() {
		try {
			output.flush();
			output.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return output.toByteArray();
	}

	@Override
	public ServletOutputStream getOutputStream() {
		return new FilterServletOutputStream(output);
	}

	@Override
	public PrintWriter getWriter() {
		return new PrintWriter(getOutputStream(), true);
	}

	@Override
	public void setContentLength(int length) {
		this.contentLength = length;
		super.setContentLength(length);
	}

	public int getContentLength() {
		return contentLength;
	}

	@Override
	public void setContentType(String type) {
		this.contentType = type;
		super.setContentType(type);
	}

	@Override
	public String getContentType() {
		return contentType;
	}

}
