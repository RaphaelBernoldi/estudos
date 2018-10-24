package br.com.poc.util;

import org.apache.commons.lang3.StringUtils;

public class HttpUtil {

	public static Boolean isHttps(String url) {
		return StringUtils
					.substringBefore(url, ":")
					.equals("https");
	}
}
