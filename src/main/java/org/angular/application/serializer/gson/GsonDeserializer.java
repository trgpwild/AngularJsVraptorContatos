package org.angular.application.serializer.gson;

import java.util.List;

import com.google.gson.JsonDeserializer;

import br.com.caelum.vraptor.deserialization.gson.GsonDeserialization;
import br.com.caelum.vraptor.http.ParameterNameProvider;
import br.com.caelum.vraptor.ioc.Component;

@Component
@SuppressWarnings("rawtypes")
public class GsonDeserializer extends GsonDeserialization {

	public GsonDeserializer(ParameterNameProvider paramNameProvider, List<JsonDeserializer> adapters) {
		super(paramNameProvider, adapters);
	}
	
}