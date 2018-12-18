package org.bzc.comicstore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtil {
	public int strToInt(String str) {
		int i = 0;
		try {
			if (str != null)
				i = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public String getTime() {
		Date date = new Date();
		String pattern = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		return simple.format(date);
	}
}
