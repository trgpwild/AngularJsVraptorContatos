package org.angular.application;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.JSONSerialization;
import br.com.caelum.vraptor.serialization.Serializer;
import br.com.caelum.vraptor.view.Results;

/**
 * 
 * @author trgp
 * 
 * Controller criado para ter funcionalidades genéricas para todos os controllers
 *
 */
public class Controller {

	/**
	 * Propriedade usada para definir o formato de renderização da data
	 * Usada por CalendarGsonDeserializer por exemplo
	 */
	public static String dateFormat = "yyyy-MM-dd";
	
	/**
	 * Propriedade do vraptor que se encarrega de renderizar a resposta de uma requisição http
	 */
	protected Result result;

	public Controller(Result result) {
		this.result = result;
	}

	/**
	 * 
	 * @param object
	 * @return Serializer
	 * 
	 * Método para serializar, ou seja, transformar em json, um objeto no response.
	 * 
	 */
	protected Serializer serializer(Object object) {
		return serializer(object, false);
	}
	
	/**
	 * 
	 * @param object
	 * @return Serializer
	 * 
	 * Método para serializar, ou seja, transformar em json, um objeto no response.
	 * 
	 * Nesse método podemos definir se a serialização terá ou não uma raiz.
	 * 
	 */
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