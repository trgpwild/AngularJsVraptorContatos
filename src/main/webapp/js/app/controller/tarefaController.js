TarefaController = (function() {

	"use strict";
	
	var root = '/tarefa/';
	var model = 'tarefa';
	var list = 'tarefaList';
	var emptyObj = {"id":0, "nome":'', "dataExecucao":''};
	
	function TarefaController() {}

	TarefaController.prototype.read = function($scope, $location, TarefaResource) {
		masterRead($scope, $location, TarefaResource, list);
	}

	TarefaController.prototype.create = function($scope, $location, TarefaResource, UsuarioResource) {
		UsuarioResource.query(function (res) { $scope.usuarios = res; });
		masterCreate($scope, $location, TarefaResource, model, root, emptyObj);
	}

	TarefaController.prototype.update = function($scope, $routeParams, $window, $location, TarefaResource, UsuarioResource) {
		masterUpdate($scope, $routeParams, $window, $location, TarefaResource, model, root, function(action) {
			if (action == 'get') {
				var usel = $scope[model].usuario;
				UsuarioResource.query(function (res) {
					$scope.usuarios = res;
					$.each(res, function(index, item){
						if (usel.id == item.id) {
							$scope[model].usuario = item;
						}
					});
				});
			}
		});
	}

	return TarefaController;
  
})();

var tarefaController = new TarefaController();