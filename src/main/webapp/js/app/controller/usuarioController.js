UsuarioController = (function() {

	"use strict";
	
	var root = '/usuario/';
	var model = 'usuario';
	var list = 'usuarioList';
	var emptyObj = {
		"id":0,
		"username":"",
		"password":"",
		"email":"",
		"ativo":true,
		"tries":0,
		"accountNonExpired":false,
		"accountNonLocked":false,
		"credentialsNonExpired":false,
		"enabled":false,
		"authorities":[]
	};
	
	function UsuarioController() {}

	UsuarioController.prototype.read = function($scope, $location, UsuarioResource) {
		masterRead($scope, $location, UsuarioResource, list);
	}

	UsuarioController.prototype.create = function($scope, $location, UsuarioResource, PerfilResource) {
		PerfilResource.query(function (res) { $scope.roles = res; });
		masterCreate($scope, $location, UsuarioResource, model, root, emptyObj);
	}

	UsuarioController.prototype.update = function($scope, $routeParams, $window, $location, UsuarioResource, PerfilResource) {
		masterUpdate($scope, $routeParams, $window, $location, UsuarioResource, model, root, function(action) {
			if (action == 'get') {
				$scope.usuario.password = '';
				var perfisSel = $scope[model].authorities;
				PerfilResource.query(function (res) {
					$scope.roles = res;
					$scope[model].authorities = new Array();
					$.each(res, function(iRes, itemRes){
						$.each(perfisSel, function(iPSel, itemPSel){
							if (itemPSel.id == itemRes.id) {
								$scope[model].authorities.push(itemRes);
							}
						});
					});
				});
			}
		});
	}

	return UsuarioController;
  
})();

var usuarioController = new UsuarioController();