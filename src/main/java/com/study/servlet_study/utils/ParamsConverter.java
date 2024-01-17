package com.study.servlet_study.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParamsConverter {

	public static Map<String, String> convertParamsMapToMap(Map<String, String[]> map) {
		Map<String, String> tmpmap = new HashMap();
		map.forEach((k, v) -> {
			StringBuilder builder = new StringBuilder();
			Arrays.asList(v).forEach(value -> builder.append(value));
			tmpmap.put(k, builder.toString());
		});

		return tmpmap;
	}
}
