ContatoController = (function() {

	"use strict";
	
	var root = '/contato/';
	var emptyObj = {contato: {"id":0, "nome":'', "endereco":''}};
	
	function ContatoController() {}

	ContatoController.prototype.read = function($scope, $location, ContatoResource) {
		masterRead($scope, $location, ContatoResource);
	}

	ContatoController.prototype.create = function($scope, $location, ContatoResource) {
		masterCreate($scope, $location, ContatoResource, root, emptyObj);
	}

	ContatoController.prototype.update = function($scope, $routeParams, $window, $location, ContatoResource) {
		masterUpdate($scope, $routeParams, $window, $location, ContatoResource, root);
	}

	return ContatoController;
  
})();

var contatoController = new ContatoController();