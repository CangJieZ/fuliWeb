package com.fuli.web.common.server;

import com.fuli.web.common.utils.StringUtil;



public class ImageServer {

	private String host;
	
	private String protocol;
	
	private String port;
	
	private String project;	

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	public String bulidImageServerPath(){
		String url  = "";
		if(StringUtil.isBlank(port) || port.equals("80")){
			url = this.protocol + "://" + this.host;
		}else{
			url = this.protocol + "://" + this.host + ":" + this.port;
		}
		if(!StringUtil.isBlank(project)){
			url = url + "/" + this.project;
		}
		return url;
			
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	
}
