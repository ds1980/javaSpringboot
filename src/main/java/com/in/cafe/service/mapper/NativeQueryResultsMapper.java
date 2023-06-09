package com.in.cafe.service.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.in.cafe.mapper.NativeQueryResultColumn;



public class NativeQueryResultsMapper {
	
	public static <T> List<T> map(List<Object[]> objectArrayList, Class<T> genericType) {
		List<T> ret = new ArrayList<>();
		List<Field> mappingFields = getNativeQueryResultColumnAnnotatedFields(genericType);
		try {
			for (Object[] objectArr : objectArrayList) {
				T t = genericType.newInstance();
				for (int i = 0; i < objectArr.length; i++) {
					if (mappingFields != null && mappingFields.get(i) != null && mappingFields.get(i).getName() != null
							&& objectArr[i] != null)
						BeanUtils.setProperty(t, mappingFields.get(i).getName(), objectArr[i]);
				}
				ret.add(t);
			}
		} catch (Exception ie) {
			ret.clear();
		}
		return ret;
	}
	private static <T> List<Field> getNativeQueryResultColumnAnnotatedFields(Class<T> genericType) {
		Field[] fields = genericType.getDeclaredFields();
		List<Field> orderedFields = Arrays.asList(new Field[fields.length]);
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(NativeQueryResultColumn.class)) {
				NativeQueryResultColumn nqrc = fields[i].getAnnotation(NativeQueryResultColumn.class);
				orderedFields.set(nqrc.index(), fields[i]);
			}
		}
		return orderedFields;
	}
}
