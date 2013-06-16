package org.angular.application.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import br.com.caelum.vraptor.ioc.Component;

@Component
@SuppressWarnings("rawtypes")
public class DateConverter implements SingleValueConverter {

    @Override
    public String toString(Object o) {
        Date data = (Date) o;
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(data);
    }

    @Override
    public Object fromString(String string) {
        return null;
    }

	@Override
    public boolean canConvert(Class type) {
        return Date.class.isAssignableFrom(type);  
    }
    
}