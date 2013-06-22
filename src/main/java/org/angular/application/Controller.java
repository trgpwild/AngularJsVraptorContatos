package org.angular.application;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.JSONSerialization;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.view.Results;

public class Controller {

	public static String dateFormat = "yyyy-MM-dd";
	
	protected Result result;

	public Controller(Result result) {
		this.result = result;
	}

	protected Serializer serializer(Object object) {
		return serializer(object, false);
	}
	
	protected Serializer serializer(Object object, boolean withRoot) {
		JSONSerialization json = result.use(Results.json());
		if (!withRoot) {
			json = (JSONSerialization) json.withoutRoot();
		}
		Serializer serializer = json.from(object).recursive();
		String[] excludeProps = excludeProps();
		if (excludeProps != null && excludeProps.length > 0) {
			serializer.exclude(excludeProps);
		}
		return serializer;
	}
	
	protected String[] excludeProps() {
		return null;
	}

}