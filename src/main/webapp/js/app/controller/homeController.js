var homeController = function ($scope, $location, ContatoResource) {
	$scope.contatos = [];
	ContatoResource.query({param1: string(0), param2: 10}, function (res) {
		$.each(res, function(index, item) {
			$scope.contatos.push(item);
		});
	});
};
homeController.$inject = ['$scope', '$location', 'ContatoResource'];