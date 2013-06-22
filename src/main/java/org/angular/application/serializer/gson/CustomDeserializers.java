package org.angular.application.serializer.gson;

import br.com.caelum.vraptor.deserialization.DefaultDeserializers;
import br.com.caelum.vraptor.deserialization.Deserializer;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.Container;

@Component  
@ApplicationScoped  
public class CustomDeserializers extends DefaultDeserializers {  
   @Override  
   public Deserializer deserializerFor(String contentType, Container container) {  
      if ("application/json".equals(contentType)) {  
          return container.instanceFor(GsonDeserializer.class);  
      }  
      return super.deserializerFor(contentType, container);  
   }  
}