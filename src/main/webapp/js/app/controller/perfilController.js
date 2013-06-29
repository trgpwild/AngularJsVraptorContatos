PerfilController = (function() {

	"use strict";
	
	var root = '/perfil/';
	var emptyObj = {perfil: {"id":0, "authority":''}};
	
	function PerfilController() {}

	PerfilController.prototype.read = function($scope, $location, PerfilResource) {
		masterRead($scope, $location, PerfilResource);
	};
	PerfilController.prototype.read.$inject = ['$scope', '$location', 'PerfilResource'];

	PerfilController.prototype.create = function($scope, $location, PerfilResource) {
		masterCreate($scope, $location, PerfilResource, root, emptyObj);
	};
	PerfilController.prototype.create.$inject = ['$scope', '$location', 'PerfilResource'];

	PerfilController.prototype.update = function($scope, $routeParams, $window, $location, PerfilResource) {
		masterUpdate($scope, $routeParams, $window, $location, PerfilResource, root);
	};
	PerfilController.prototype.update.$inject = ['$scope', '$routeParams', '$window', '$location', 'PerfilResource'];

	return PerfilController;

})();

var perfilController = new PerfilController();