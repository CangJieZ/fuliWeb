package com.fuli.web.common.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @Description :参数处理
 * @author Troy
 * @version 1.0
 * @created 2011-9-1 下午04:37:53
 * @fileName com.chinagyl.common.util.ParameterUtil.java
 */
public class ParameterUtil {
	private static final Log log = LogFactory.getLog(ParameterUtil.class);

	/**
	 * 
	 * @Description 把name=value&name=value&name=value&name=value的字符串转换成map
	 * @param paramString
	 * @return
	 */
	public static Map<String, String> toMap(String paramString) {
		if (paramString == null)
			return null;

		String[] nameValueArr = paramString.split("\\&");
		if (nameValueArr == null || nameValueArr.length == 0)
			return null;

		Map<String, String> map = new HashMap<String, String>();
		for (String nameValue : nameValueArr) {
			if (nameValue == null)
				continue;
			String[] param = nameValue.split("=");
			if (param == null || param.length == 0)
				continue;

			map.put(param[0], param.length > 1 ? (param[1] == null ? "" : param[1]) : "");
		}

		return map;
	}

	/**
	 * 
	 * @Description
	 * @param map
	 *            把map转换成name=value&name=value&name=value&name=value各式的字符串
	 * @return
	 */
	public static String toString(Map<String, String> map) {
		if (map == null)
			return null;
		Set<Entry<String, String>> set = map.entrySet();
		if (set == null || set.size() == 0)
			return null;
		StringBuilder bu = new StringBuilder();

		int i = 0;
		for (Entry<String, String> entry : set) {
			bu.append(entry.getKey()).append("=").append(entry.getValue() == null ? "" : entry.getValue());
			if (i + 1 < set.size()) {
				bu.append("&");
			}
			i++;
		}

		return bu.toString();
	}

	/**
	 * 
	 * @Description 把对象的属性，转换成name=value&name=value&name=value&name=value各式的字符串
	 * @param obj
	 * @return
	 * 
	 */
	public static String toString(Object target) {
		if (target == null)
			return null;
		StringBuilder bu = new StringBuilder();
		// 取定义的全部属性
		Field[] fields = target.getClass().getDeclaredFields();
		if (fields == null) {
			return null;
		}

		int i = 0;
		for (Field field : fields) {
			if (field.getAnnotation(IgnoreToString.class) != null) {
				continue;
			}
			// 属性值
			Object value = null;
			try {
				boolean original = field.isAccessible();
				field.setAccessible(true);
				value = field.get(target);
				field.setAccessible(original);
				bu.append(field.getName()).append("=").append(value);
				if (i + 1 < fields.length)
					bu.append("&");
				i++;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		return bu.toString();
	}
	
	/**
	 * 是否忽略转换成字符串
	 * 
	 * @Description :
	 * @author Troy
	 * @version 1.0
	 * @created Oct 1, 2011 11:28:36 PM
	 * @fileName com.chinagyl.common.util.ParameterUtil.java
	 * 
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	@Inherited
	public static @interface IgnoreToString {
	}
}
