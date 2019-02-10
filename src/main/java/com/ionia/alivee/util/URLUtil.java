package com.ionia.alivee.util;

import org.apache.commons.validator.UrlValidator;

public class URLUtil {
	
	public static String putScheme(String url) {
		if (!url.startsWith("http")) {
			url = "http://".concat(url);
		}
		return url;
	}

	public static boolean isURLValid(String url) {
		boolean result = false;
		String[] schemes = { "http", "https" };
		UrlValidator urlValidator = new UrlValidator(schemes);
		if (urlValidator.isValid(url)) {
			result = false;
		}
		return result;
	}

}
