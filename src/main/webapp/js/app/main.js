var App = angular.module('AngularJsContatosApp', ['rest.service','ui.bootstrap','ui.date','localization']);

App.config(['$routeProvider','$httpProvider',function($routeProvider, $httpProvider) {
	
	$routeProvider
		
		.when('/', {controller: homeController, templateUrl:'view/index.html'})
		
		.when('/usuario/', {controller: usuarioController.read, templateUrl:'view/usuario/list.html'})
		.when('/usuario/new', {controller: usuarioController.create, templateUrl:'view/usuario/form.html'})
		.when('/usuario/edit/:id', {controller: usuarioController.update, templateUrl:'view/usuario/form.html'})

		.when('/contato/', {controller: contatoController.read, templateUrl:'view/contato/list.html'})
		.when('/contato/new', {controller: contatoController.create, templateUrl:'view/contato/form.html'})
		.when('/contato/edit/:id', {controller: contatoController.update, templateUrl:'view/contato/form.html'})
		
		.when('/perfil/', {controller: perfilController.read, templateUrl:'view/perfil/list.html'})
		.when('/perfil/new', {controller: perfilController.create, templateUrl:'view/perfil/form.html'})
		.when('/perfil/edit/:id', {controller: perfilController.update, templateUrl:'view/perfil/form.html'})

		.when('/tarefa/', {controller: tarefaController.read, templateUrl:'view/tarefa/list.html'})
		.when('/tarefa/new', {controller: tarefaController.create, templateUrl:'view/tarefa/form.html'})
		.when('/tarefa/edit/:id', {controller: tarefaController.update, templateUrl:'view/tarefa/form.html'})

		.otherwise({redirectTo:'/'});
	
	$httpProvider.responseInterceptors.push('httpInterceptor');
		
}]);

App.factory('httpInterceptor', ['$q','$window', function ($q, $window) {
	return function (promise) {
		return promise.then(function (response) {
			try {
				if (response.data.authenticated == false) {
					$('#loginModal').modal('show');
					return $q.reject(response);
				} else {
					return response;
				}
			} catch (e) {
				alert(e.message);
			}
		}, function (response) {
			return $q.reject(response);
		});
	};
}]);