package com.foo.lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.core.env.Environment;

public class ActuatorConfig extends WebMvcEndpointManagementContextConfiguration {

	private static final Logger log = LoggerFactory.getLogger(ActuatorConfig.class);

	@Override
	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(
		WebEndpointsSupplier webEndpointsSupplier, ServletEndpointsSupplier servletEndpointsSupplier,
		ControllerEndpointsSupplier controllerEndpointsSupplier, EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties,
		WebEndpointProperties webEndpointProperties, Environment environment
	) {
		var mapping = super.webEndpointServletHandlerMapping(
			webEndpointsSupplier, servletEndpointsSupplier, controllerEndpointsSupplier, endpointMediaTypes, corsProperties,
			webEndpointProperties,
			environment
		);
		log.info("actuator configuration loaded");
		return mapping;
	}

}
