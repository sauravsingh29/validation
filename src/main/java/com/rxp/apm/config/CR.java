package com.rxp.apm.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CR extends HttpServletRequestWrapper {
	private String _body;

	public CR(HttpServletRequest request) throws IOException {
		super(request);
		_body = "";
		BufferedReader bufferedReader = request.getReader();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			_body += line;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequestWrapper#getInputStream()
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(_body.getBytes());
		return new ServletInputStream() {
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener arg0) {
				
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequestWrapper#getReader()
	 */
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}

}
