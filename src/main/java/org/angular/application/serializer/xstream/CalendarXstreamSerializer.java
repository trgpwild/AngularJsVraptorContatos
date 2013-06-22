package org.angular.application.serializer.xstream;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.angular.application.Controller;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import br.com.caelum.vraptor.ioc.Component;

@Component
@SuppressWarnings("rawtypes")
public class CalendarXstreamSerializer implements SingleValueConverter {

    @Override
    public String toString(Object o) {
    	if (o != null) {
            Date data = ((Calendar) o).getTime();
            return new SimpleDateFormat(Controller.dateFormat).format(data);
    	} else {
    		return "";
    	}
    }

	@Override
	public Object fromString(String str) {
		return null;
	}
    
	@Override
    public boolean canConvert(Class type) {
        return Calendar.class.isAssignableFrom(type);  
    }

}