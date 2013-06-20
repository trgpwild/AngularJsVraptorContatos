ContatoController = (function() {

	"use strict";
	
	var root = '/contato/';
	var model = 'contato';
	var list = 'contatoList';
	var emptyObj = {"id":0, "nome":'', "endereco":''};
	
	function ContatoController() {}

	ContatoController.prototype.read = function($scope, $location, ContatoResource) {
		masterRead($scope, $location, ContatoResource, list);
	}

	ContatoController.prototype.create = function($scope, $location, ContatoResource) {
		masterCreate($scope, $location, ContatoResource, model, root, emptyObj);
	}

	ContatoController.prototype.update = function($scope, $routeParams, $window, $location, ContatoResource) {
		masterUpdate($scope, $routeParams, $window, $location, ContatoResource, model, root);
	}

	return ContatoController;
  
})();

var contatoController = new ContatoController();