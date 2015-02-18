package com.gstv.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class UrlUtil {

	private static final String FORMAT_JSON = "format=json";
	private static final String ROOT_URL = "http://ws.audioscrobbler.com/2.0/?";
	private static final String PARAM_METHOD = "method=";
	private static final String PARAM_API_KEY = "api_key=";
	private static final String apiKey = "d7f2d91d74141457c49d10d1465a8cf5";
	private static final char AMPERSAND = '&';

	// TO:DO - Can have a different place holder. Will refactor later
	public static String buildUri(String method, Map<String, String> params,
			String... strings) {
		StringBuilder builder = new StringBuilder();
		builder.append(ROOT_URL);
		builder.append(AMPERSAND);
		builder.append(PARAM_METHOD);
		builder.append(method);
		builder.append(AMPERSAND);
		builder.append(PARAM_API_KEY);
		builder.append(apiKey);
		builder.append(AMPERSAND);
		for (Iterator<Entry<String, String>> it = params.entrySet().iterator(); it
				.hasNext();) {
			Entry<String, String> entry = it.next();
			builder.append(entry.getKey());
			builder.append('=');
			builder.append(entry.getValue());
			if (it.hasNext() || strings.length > 0)
				builder.append(AMPERSAND);
		}
		builder.append(AMPERSAND);
		builder.append(FORMAT_JSON);
		return builder.toString();
	}
}
