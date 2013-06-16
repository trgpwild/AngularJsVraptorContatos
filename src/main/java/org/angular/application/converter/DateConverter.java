package org.angular.application.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import br.com.caelum.vraptor.ioc.Component;

@Component
@SuppressWarnings("rawtypes")
public class DateConverter implements SingleValueConverter {

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String toString(Object o) {
    	if (o != null) {
            Date data = (Date) o;
            return "***" + df.format(data);
    	} else {
    		return "";
    	}
    }

    @Override
    public Object fromString(String string) {
        try {
			return df.parse(string);
		} catch (ParseException e) {
			return null;
		}
    }

	@Override
    public boolean canConvert(Class type) {
        return Date.class.isAssignableFrom(type);  
    }
    
}