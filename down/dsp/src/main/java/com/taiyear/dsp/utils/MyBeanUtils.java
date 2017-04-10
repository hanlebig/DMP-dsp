package com.taiyear.dsp.utils;

import org.springframework.beans.*;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liul on 2017/03/29.
 */
public class MyBeanUtils {

	/**
	 * 拷贝src对象里的属性到target，并且src对象里的null值不拷贝，注意属性必须要有get/set方法
	 * 
	 * @param src
	 * @param target
	 */
	public static void copyNonNullProperties(Object src, Object target) {
		// System.out.println(getNullPropertyNames(src)[0]);
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static void colne(Object src, Object target) {
		BeanUtils.copyProperties(src, target);

	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
}