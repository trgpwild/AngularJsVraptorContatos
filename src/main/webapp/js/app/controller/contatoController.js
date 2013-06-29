ContatoController = (function() {

	"use strict";
	
	var root = '/contato/';
	var emptyObj = {contato: {"id":0, "nome":'', "endereco":''}};
	
	function ContatoController() {}

	ContatoController.prototype.read = function($scope, $location, ContatoResource) {
		masterRead($scope, $location, ContatoResource);
	};
	ContatoController.prototype.read.$inject = ['$scope', '$location', 'ContatoResource'];

	ContatoController.prototype.create = function($scope, $location, ContatoResource) {
		masterCreate($scope, $location, ContatoResource, root, emptyObj);
	};
	ContatoController.prototype.create.$inject = ['$scope', '$location', 'ContatoResource'];

	ContatoController.prototype.update = function($scope, $routeParams, $window, $location, ContatoResource) {
		masterUpdate($scope, $routeParams, $window, $location, ContatoResource, root);
	};
	ContatoController.prototype.update.$inject = ['$scope', '$routeParams', '$window', '$location', 'ContatoResource'];

	return ContatoController;
  
})();

var contatoController = new ContatoController();