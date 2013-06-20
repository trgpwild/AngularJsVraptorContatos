PerfilController = (function() {

	"use strict";
	
	var root = '/perfil/';
	var model = 'perfil';
	var list = 'perfilList';
	var emptyObj = {perfil: {"id":0, "authority":''}};
	
	function PerfilController() {}

	PerfilController.prototype.read = function($scope, $location, PerfilResource) {
		masterRead($scope, $location, PerfilResource, list);
	}

	PerfilController.prototype.create = function($scope, $location, PerfilResource) {
		masterCreate($scope, $location, PerfilResource, model, root, emptyObj);
	}

	PerfilController.prototype.update = function($scope, $routeParams, $window, $location, PerfilResource) {
		masterUpdate($scope, $routeParams, $window, $location, PerfilResource, model, root);
	}

	return PerfilController;
  
})();

var perfilController = new PerfilController();