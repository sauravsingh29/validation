package com.rxp.apm.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component
public class ApmFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CR requestWrapper = new CR((HttpServletRequest) request);
		System.out.println(requestWrapper.getReader().readLine());
//		final ObjectMapper JSON_MAPPER = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).disable(DeserializationFeature.UNWRAP_ROOT_VALUE)
//				.setSerializationInclusion(JsonInclude.Include.NON_NULL)
//				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);;
//		Map<String, HashMap> map = new HashMap<>();
//		String inp = requestWrapper.getReader().readLine();
//		//
//		// // Calling your Object mapper
//		map = JSON_MAPPER.readValue(inp, new TypeReference<HashMap>() {
//		});
//		// HashMap<String, LinkedTreeMap> hashMap = new
//		// Gson().fromJson(requestWrapper.getReader().readLine(),
//		// HashMap.class);
//		// LinkedTreeMap result = new Gson().fromJson(inp ,
//		// LinkedTreeMap.class);
//		System.out.println(map.get("request").get("orderid"));
//		System.out.println(JSON_MAPPER.readValue(inp, Request.class).getOther());
		chain.doFilter(requestWrapper, response);
	}

	public static HashMap<String, Object> parse(String json) {
		JsonObject object = (JsonObject) new com.google.gson.JsonParser().parse(json);
		Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		HashMap<String, Object> map = new HashMap<String, Object>();
		while (iterator.hasNext()) {
			Map.Entry<String, JsonElement> entry = iterator.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			if (!value.isJsonNull()) {
				if (!value.isJsonPrimitive()) {
					map.put(key, parse(value.toString()));
				} else {
					map.put(key, value.getAsString());
				}
			} else {
				map.put(key, value);
			}
		}
		return map;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
