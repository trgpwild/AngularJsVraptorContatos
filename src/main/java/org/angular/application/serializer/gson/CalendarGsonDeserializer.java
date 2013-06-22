package org.angular.application.serializer.gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.angular.application.Controller;

import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.Component;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@Component
public class CalendarGsonDeserializer implements JsonDeserializer<Calendar> {

	public Calendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

		String value = json.getAsString();

		DateFormat format = new SimpleDateFormat(Controller.dateFormat);
		try {
			Date date = format.parse(value);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new ConversionError("Error to convert Calendar.");
		}

	}

}