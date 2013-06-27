var angularContatosServices = angular.module('rest.service', ['ngResource']);

var configUrl = function (model) {
	return baseUrl + '/' + model + '/:param1/:param2';
}

angularContatosServices.factory('UsuarioResource', function($resource) {
	var api = $resource(configUrl('usuarios'), {'param1': '', 'param2': ''}, {'update': {'method': 'PUT'}});
    return api;
});

angularContatosServices.factory('PerfilResource', function($resource) {
	var api = $resource(configUrl('perfis'), {'param1': '', 'param2': ''}, {'update': {'method': 'PUT'}});
    return api;
});

angularContatosServices.factory('ContatoResource', function($resource) {
	var api = $resource(configUrl('contatos'), {'param1': '', 'param2': ''}, {'update': {'method': 'PUT'}});
    return api;
});

angularContatosServices.factory('TarefaResource', function($resource) {
	var api = $resource(configUrl('tarefas'), {'param1': '', 'param2': ''}, {'update': {'method': 'PUT'}});
    return api;
});