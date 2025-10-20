package org.api.manapool.listener;

import java.io.Serializable;
import java.time.Instant;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class URLCallInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instant start;
	private long duration;
	private Instant end;
	private String url;
	private HttpResponse response;
	private HttpUriRequest request;

	@Override
	public String toString() {
		return request.toString();
	}
	
	
	public URLCallInfo() {
		start=Instant.now();
	}
	
	public Instant getStart() {
		return start;
	}

	public void setStart(Instant start) {
		this.start = start;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Instant getEnd() {
		return end;
	}

	public void setEnd(Instant end) {
		this.end = end;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpResponse getResponse() {
		return response;
	}

	public void setResponse(HttpResponse response) {
		this.response = response;
	}

	public HttpUriRequest getRequest() {
		return request;
	}

	public void setRequest(HttpUriRequest request) {
		this.request = request;
	}
	
	

}
