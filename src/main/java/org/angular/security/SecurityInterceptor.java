package org.angular.security;

import java.util.ArrayList;
import java.util.List;

import org.angular.entity.Perfil;
import org.angular.entity.Usuario;
import org.angular.security.entity.Login;
import org.angular.security.entity.SecurityResponse;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

@Intercepts
public class SecurityInterceptor implements Interceptor {

	private Login login;
	
	private Result result;
	
	public SecurityInterceptor(Result result, Login login) {
		this.result = result;
		this.login = login;
	}
	
	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object instance) throws InterceptionException {
		boolean authenticated = false;
		String[] rolesArr = null;
		try {
			rolesArr = method.getMethod().getAnnotation(SecRole.class).roles();
		} catch (Exception e) {
			rolesArr = method.getResource().getType().getAnnotation(SecRole.class).roles();
		}
		List<String> roles = new ArrayList<String>();
		for (String role : rolesArr) roles.add(role);
		if (roles != null && roles.size() > 0) {
			Usuario u = login.getUsuario();
			if (u != null) {
				for (Perfil perfil : u.getPerfis()) {
					if (roles.contains(perfil.getAuthority())) {
						authenticated = true;
					} else {
						authenticated = false;
					}
				}
			} else {
				authenticated = false;
			}
		}
		if (authenticated) {
			stack.next(method, instance);
		} else {
			result.use(Results.json()).withoutRoot().from(new SecurityResponse(authenticated, "")).recursive().serialize();
		}
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return method.getMethod().isAnnotationPresent(SecRole.class)
			|| method.getResource().getType().isAnnotationPresent(SecRole.class);
	}

}