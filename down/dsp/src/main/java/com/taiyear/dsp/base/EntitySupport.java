/**
 * 
 */
package com.taiyear.dsp.base;

import java.lang.reflect.Field;

/**
 * @author liul
 * 
 */
public abstract class EntitySupport {

	@Override
	public String toString() {
		return property2String(getClass());
	}

	/**
	 * 打印类成员信息
	 * 
	 * @param clazz
	 * @return
	 */
	private String property2String(Class<?> clazz) {
		try {
			return getSupperClassFields(clazz).substring(2);
		} catch (Exception e) {
			super.toString();
		}

		return null;
	}

	/**
	 * 获取参数父类成员属性
	 * 
	 * @param clazz
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private StringBuffer getSupperClassFields(Class<?> clazz)
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> superClazz = clazz.getSuperclass();
		StringBuffer buffer = new StringBuffer();

		if (!Object.class.equals(superClazz)) {
			buffer.append(getSupperClassFields(superClazz));
		}

		return buffer.append(getClassFields(clazz));
	}

	/**
	 * 获取参数成员属性
	 * 
	 * @param clazz
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private StringBuffer getClassFields(Class<?> clazz)
			throws IllegalArgumentException, IllegalAccessException {

		StringBuffer buffer = new StringBuffer();

		Field[] fields = clazz.getDeclaredFields();

		if (null != fields && fields.length > 0) {
			for (Field field : fields) {
				field.setAccessible(true);

				buffer.append(", " + field.getName() + ":" + field.get(this));
			}
		}

		return buffer;
	}
}
