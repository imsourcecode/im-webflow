package org.im.demo.webflow.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class PlanningFlowHandler extends AbstractFlowHandler {
	private static final Logger logger = LoggerFactory.getLogger(PlanningFlowHandler.class);

	@Override
	public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest request, HttpServletResponse response) {
		logger.info(" Outcome {}", outcome.getId());
		return super.handleExecutionOutcome(outcome, request, response);
	}
}
