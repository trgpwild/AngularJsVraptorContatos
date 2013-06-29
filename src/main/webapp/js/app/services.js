var angularContatosServices = angular.module('rest.service', ['ngResource']);

var configUrl = function(model) {
	return baseUrl + model + '/:param1/:param2';
}

var params = function() {
	return {'param1': '', 'param2': ''};
}

var values = function() {
	return {'update': {'method': 'PUT'}};
}

angularContatosServices.factory('UsuarioResource', function($resource) {
	var api = $resource(configUrl('usuarios'), params(), values());
    return api;
});

angularContatosServices.factory('PerfilResource', function($resource) {
	var api = $resource(configUrl('perfis'), params(), values());
    return api;
});

angularContatosServices.factory('ContatoResource', function($resource) {
	var api = $resource(configUrl('contatos'), params(), values());
    return api;
});

angularContatosServices.factory('TarefaResource', function($resource) {
	var api = $resource(configUrl('tarefas'), params(), values());
    return api;
});