package com.example.springboot.util;

import org.apache.log4j.Logger;

public class LoggerUtil {
	public static final String START = "Start";
	public static final String END = "End";
	public static final String ADD_UPDATE = "AU";
	public static final String DELETE = "DE";
	
	private LoggerUtil() {
		
	}
	public static void pushLog(final Logger logger, String pushFlow, String startend, Long s, Long id, String action) {
		String message = String.format("Perf Push : %1$s Item N°%2$s, flowType: %3$s, action: %4$s, id: %5$s ", startend, s, pushFlow, action, id);
		logger.info(message);
    }
}