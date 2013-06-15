package org.angular.controller;

import java.util.Date;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class HelloController {
	
    @Get
    @Path("/hello")
    public String index() {
        return new Date().toString();
    }

}
