package com.kg.jbtsgl.commons;

import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		if (source != null && !"".equals(source.trim())) {
			try {
				return CommonDate.parseDate(source, CommonDate.SHORT8);
			} catch (ParseException e) {
				return null;
			}
		} else {
			return null;
		}
	}

}
