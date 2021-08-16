package com.alexsanderalves.mylist.api.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtils {

	public static long getLongNow() {
		return LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(0));
	}
	
}
