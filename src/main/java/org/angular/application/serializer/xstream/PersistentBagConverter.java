package org.angular.application.serializer.xstream;

import java.util.Collection;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PersistentBagConverter extends CollectionConverter {

	public PersistentBagConverter() {
		super(new XStream().getMapper());
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return Collection.class.isAssignableFrom(type);
	}

}
