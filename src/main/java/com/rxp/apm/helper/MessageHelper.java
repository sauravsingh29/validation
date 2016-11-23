package com.rxp.apm.helper;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageHelper {

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;

	public String getMessage(String message, Object[] params) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(message, params, locale);
	}

}
