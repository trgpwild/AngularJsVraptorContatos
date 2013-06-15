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
		return result.use(Results.json()).withoutRoot().from(object).recursive();
	}

}