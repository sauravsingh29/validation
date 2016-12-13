/*
 * 
 */
package com.rxp.apm.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.rxp.apm.response.BaseResponse;
import com.rxp.apm.validator.ValidatorOutput;

/**
 * The Class CommonUtils.
 */
public class CommonUtils {
	
	/**
	 * Find getters.
	 *
	 * @param c the c
	 * @return the list
	 */
	public static List<Method> findGetters(Class<?> c) {
		List<Method> list = new ArrayList<Method>();
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods)
			if (isGetter(method))
				list.add(method);
		return list;
	}

	/**
	 * Checks if is getter.
	 *
	 * @param method the method
	 * @return true, if is getter
	 */
	public static boolean isGetter(Method method) {
		if (Modifier.isPublic(method.getModifiers())
				&& method.getParameterTypes().length == 0) {
			if (method.getName().matches("^get[A-Z].*")
					&& !method.getReturnType().equals(void.class))
				return true;
			if (method.getName().matches("^is[A-Z].*")
					&& method.getReturnType().equals(boolean.class))
				return true;
		}
		return false;
	}
	
	/**
	 * Gets the fields name.
	 *
	 * @param clazz the clazz
	 * @return the fields name
	 */
	public static List<String> getFieldsName(Class<?> clazz){
		List<String> filedList = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			filedList.add(field.getName());
		}
		return filedList;
	}
	
	/**
	 * Builds the response.
	 *
	 * @param <T> the generic type
	 * @param <K> the key type
	 * @param t the t
	 * @param k the k
	 * @param responseCode the response code
	 * @param responseMessage the response message
	 * @param errorMessages the error messages
	 * @return the k
	 * @throws Exception the exception
	 */
	public static <T, K> K buildResponse(T t, Class<K> k, String responseCode, String responseMessage,
		      Set<String> errorMessages) throws Exception {
			K r = null;
			try {
				r = k.newInstance();
				if (responseCode != null && responseMessage != null) {
					((BaseResponse) r).setResponseCode(responseCode);
					((BaseResponse) r).setResponseMessage(responseMessage);
				}
				if (!CollectionUtils.isEmpty(errorMessages)) {
					((BaseResponse) r).getMessages().addAll(errorMessages);
					((ValidatorOutput) r).isValid();
				}
			} catch (InstantiationException e) {
				throw new Exception(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				throw new Exception(e.getMessage(), e);
			}
			return r;
		}
	
}
