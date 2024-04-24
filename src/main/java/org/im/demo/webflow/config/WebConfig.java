package org.im.demo.webflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	//docs.spring.io/spring-framework/reference/web/webmvc/mvc-config/view-controller.html
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	// 19.2.1. Registering FlowHandlerAdapter
	@Bean
	public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor flowExecutor) {
		FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
		handlerAdapter.setFlowExecutor(flowExecutor);
		handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
		return handlerAdapter;
	}

	// 19.2.2. Defining Flow Mappings
	@Bean
	public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry flowRegistry) {
		FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
		handlerMapping.setFlowRegistry(flowRegistry);
		handlerMapping.setOrder(-1);
		return handlerMapping;
	}
}
