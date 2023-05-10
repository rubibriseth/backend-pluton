package com.prueba.tecnica.backendpluton.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	private DateUtil() {
	}

	public static String dateToString(Date fechaDate, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return format.format(fechaDate);
		} catch (Exception e) {
			LOGGER.error("Problema en el metodo 'dateToString'." + e.getMessage(), e);
			return null;
		}
	}
	public static Date stringToDate(String fechaString, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return format.parse(fechaString);
		} catch (Exception e) {
			LOGGER.error("Problema en el metodo 'stringToDate'." + e.getMessage(), e);
			return null;
		}
	}
	
}
