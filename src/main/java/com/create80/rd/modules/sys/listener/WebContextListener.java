package com.create80.rd.modules.sys.listener;

import com.create80.rd.modules.sys.service.SystemService;
import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;

import com.create80.rd.modules.sys.service.SystemService;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		if (!SystemService.printKeyLoadMessage()){
			return null;
		}
		return super.initWebApplicationContext(servletContext);
	}
}
