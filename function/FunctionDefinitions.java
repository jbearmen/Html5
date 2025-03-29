

package com.smsgatewayadapter.ft.dynamic.function;

import com.smsgatewayadapter.ft.dynamic.utils.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

/**
 * @author: Xiongqiang Xu
 * @date: 2020/2/20
 */
public class FunctionDefinitions {

	public String now(){
		return DateFormatUtils.format(new Date());
	}

	public Long nowTimestamp(){
		return System.currentTimeMillis();
	}
	
	public synchronized String uuid() {
		return UUID.randomUUID().toString();
	}
	public String nullValue() {
		return null;
	}

	public String timeDuration(String text){
		return DateFormatUtils.format(new Date(Duration.parse(text).plusMillis(System.currentTimeMillis()).toMillis()));
	}

	public Long timestampDuration(String text){
		return new Date(Duration.parse(text).plusMillis(System.currentTimeMillis()).toMillis()).getTime();
	}
	
	//yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
	public Long currentDateTimestamp(String HHmmssSSS) throws ParseException {
		String dateTimeStr = this.currentDateTime(HHmmssSSS);
		return DateFormatUtils.parse(dateTimeStr).getTime();
	}

	public String lastDayOfLastMonth(String text) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, -1);
		return DateFormatUtils.format(new Date(Duration.parse(text).plusMillis(calendar.getTimeInMillis()).toMillis()));
	}

	public String firstDayOfTheMonth(String text) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return DateFormatUtils.format(new Date(Duration.parse(text).plusMillis(calendar.getTimeInMillis()).toMillis()));
	}
	
	public String currentDateTime(String HHmmssSSS) {
		return FastDateFormat.getInstance("yyyy-MM-dd", TimeZone.getTimeZone("UTC")).format(new Date()) + "T" + HHmmssSSS + "Z";
	}
	
	public Long timestampAfterPlusDays(String days, String HHmmssSSS) throws ParseException{
		String dateTimeStr = this.dateTimeAfterPlusDays(days, HHmmssSSS);
		return DateFormatUtils.parse(dateTimeStr).getTime();
	}

	public String dateTimeAfterPlusDays(String days, String HHmmssSSS) {
		return FastDateFormat.getInstance("yyyy-MM-dd", TimeZone.getTimeZone("UTC")).format(LocalDate.now().plusDays(Integer.valueOf(days))) + "T" + HHmmssSSS + "Z";
	}

	public int toInteger(String str){
		return Integer.parseInt(str);
	}

	public long currentTimeMillis(){
		return System.currentTimeMillis();
	}


}
