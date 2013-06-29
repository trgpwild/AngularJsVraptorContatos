TarefaController = (function() {

	"use strict";
	
	var root = '/tarefa/';
	var emptyObj = {tarefa: {"id":0, "nome":'', "dataExecucao":''}};
	
	function TarefaController() {}

	TarefaController.prototype.read = function($scope, $location, TarefaResource) {
		masterRead($scope, $location, TarefaResource);
	};
	TarefaController.prototype.read.$inject = ['$scope', '$location', 'TarefaResource'];

	TarefaController.prototype.create = function($scope, $location, TarefaResource, UsuarioResource) {
		UsuarioResource.query(function (res) { $scope.usuarios = res; });
		masterCreate($scope, $location, TarefaResource, root, emptyObj);
	};
	TarefaController.prototype.create.$inject = ['$scope', '$location', 'TarefaResource', 'UsuarioResource'];

	TarefaController.prototype.update = function($scope, $routeParams, $window, $location, TarefaResource, UsuarioResource) {
		masterUpdate($scope, $routeParams, $window, $location, TarefaResource, root, function(action) {
			if (action == 'get') {
				var usel = $scope.model.tarefa.usuario;
				UsuarioResource.query(function (res) {
					$scope.usuarios = res;
					$.each(res, function(index, item){
						if (usel.id == item.id) {
							$scope.model.tarefa.usuario = item;
						}
					});
				});
			}
		});
	};
	TarefaController.prototype.update.$inject = ['$scope', '$routeParams', '$window', '$location', 'TarefaResource', 'UsuarioResource'];

	return TarefaController;
  
})();
var tarefaController = new TarefaController();