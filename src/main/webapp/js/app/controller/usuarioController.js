UsuarioController = (function() {

	"use strict";
	
	var root = '/usuario/';
	var emptyObj = {usuario: {
		"id":0,
		"username":"",
		"password":"",
		"email":"",
		"ativo":true,
		"tries":0,
		"perfis":[]
	}};
	
	function UsuarioController() {}

	UsuarioController.prototype.read = function($scope, $location, UsuarioResource) {
		masterRead($scope, $location, UsuarioResource);
	};
	UsuarioController.prototype.read.$inject = ['$scope', '$location', 'UsuarioResource'];

	UsuarioController.prototype.create = function($scope, $location, UsuarioResource, PerfilResource) {
		PerfilResource.query(function (res) { $scope.roles = res; });
		masterCreate($scope, $location, UsuarioResource, root, emptyObj);
	};
	UsuarioController.prototype.create.$inject = ['$scope', '$location', 'UsuarioResource', 'PerfilResource'];

	UsuarioController.prototype.update = function($scope, $routeParams, $window, $location, UsuarioResource, PerfilResource) {
		masterUpdate($scope, $routeParams, $window, $location, UsuarioResource, root, function(action) {
			if (action == 'get') {
				$scope.model.usuario.password = '';
				var perfisSel = $scope.model.usuario.perfis;
				PerfilResource.query(function (res) {
					$scope.roles = res;
					$scope.model.usuario.perfis = new Array();
					$.each(res, function(iRes, itemRes){
						$.each(perfisSel, function(iPSel, itemPSel){
							if (itemPSel.id == itemRes.id) {
								$scope.model.usuario.perfis.push(itemRes);
							}
						});
					});
				});
			}
		});
	};
	UsuarioController.prototype.update.$inject = ['$scope', '$routeParams', '$window', '$location', 'UsuarioResource', 'PerfilResource'];

	return UsuarioController;
  
})();

var usuarioController = new UsuarioController();