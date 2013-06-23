package org.angular.repository;

import org.angular.application.Repository;
import org.angular.entity.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Long> {
	
	Usuario getByUsernameAndPassword(String username, String password);
	
}