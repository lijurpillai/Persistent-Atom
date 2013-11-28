package com.perfomatix.atomcore.security.spring.wrapper;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

public class FilterServletOutputStream extends ServletOutputStream {

	private final DataOutputStream stream;

	public FilterServletOutputStream(OutputStream output) {
		stream = new DataOutputStream(output);
	}

	@Override
	public void write(int b) throws IOException {
		stream.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		stream.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		stream.write(b, off, len);
	}

}
