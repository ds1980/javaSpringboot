package com.in.cafe.constants;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

public class MessageUtil {
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The accessor. */
	private static MessageSourceAccessor accessor;

	/**
	 * Inits the.
	 */
	@PostConstruct
	private synchronized void init() {
		accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
	}

	/**
	 * Gets the msg.
	 *
	 * @param code the code
	 * @return the msg
	 */
	public static String getMsg(String code) {
		return accessor.getMessage(code);
	}

	public static String getMsg(String code, String... fields) {
		return accessor.getMessage(code, fields);
	}

}
