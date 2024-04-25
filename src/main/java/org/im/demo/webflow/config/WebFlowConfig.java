package org.im.demo.webflow.config;

import org.im.demo.webflow.handler.PlanningFlowHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.util.Collections;

//docs.spring.io/spring-webflow/docs/current/reference/index.html
// 18. System Setup, the Web Flow system for use in any web environment.

/**
 * 18.1. Java-based Configuration
 */
@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

	// 18.2.1. Register your flows
	@Bean
	public FlowDefinitionRegistry flowRegistry(FlowBuilderServices flowBuilderServices) {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices)
				.setBasePath("classpath:flows")
				.addFlowLocation("/event-planning.xml")
				.build();
	}

	// 18.2.2. Deploy a FlowExecutor, the central service for executing flows
	@Bean
	public FlowExecutor flowExecutor(FlowDefinitionRegistry flowRegistry) {
		return getFlowExecutorBuilder(flowRegistry).build();
	}

	// 18.3.7. Configuring Custom FlowBuilder Services
	@Bean
	public FlowBuilderServices flowBuilderServices(ViewFactoryCreator viewFactoryCreator) {
		return getFlowBuilderServicesBuilder()
				.setViewFactoryCreator(viewFactoryCreator)
				.setDevelopmentMode(true)
				.build();
	}

	//
	@Bean(name = "event-planning")
	public PlanningFlowHandler planningFlowHandler() {
		return new PlanningFlowHandler();
	}

	// 19.4. View Resolution
	@Bean
	public ViewFactoryCreator viewFactoryCreator(ThymeleafViewResolver viewResolver) {
		MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
		factoryCreator.setViewResolvers(
				Collections.singletonList(viewResolver));
		factoryCreator.setUseSpringBeanBinding(true);
		return factoryCreator;
	}
}
