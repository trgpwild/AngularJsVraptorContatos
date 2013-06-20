package org.angular.application;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.view.Results;

public class Controller {

	protected Result result;

	public Controller(Result result) {
		this.result = result;
	}

	protected Serializer serializer(Object object) {
		return serializer(object, false);
	}
	
	protected Serializer serializer(Object object, boolean withRoot) {
		if (withRoot) {
			return result.use(Results.json()).from(object).recursive();
		} else {
			return result.use(Results.json()).withoutRoot().from(object).recursive();
		}
	}

}