masterRead = function($scope, $location, Resource, list) {
	var start = 0;
	$scope[list] = [];
	$scope.load = function() {
		Resource.query({param1: string(start), param2: limit}, function (res) {
			$.each(res, function(index, item) {
				$scope[list].push(item);
				start++;
			});
		});
	}
	$scope.load();
}

masterCreate = function($scope, $location, Resource, model, root, emptyObj) {
	$scope[model] = new Resource(emptyObj);
	$scope.save = function() {
		$scope[model].$save(function(res) {
			$location.path(root);
		});
	}
}

masterUpdate = function($scope, $routeParams, $window, $location, Resource, model, root, actionUpdate) {
	
	Resource.get({param1: $routeParams.id}, function(res) {
		$scope[model] = res;
		if (actionUpdate) actionUpdate('get');
	});

	$scope.save = function() {
		$scope[model].$update({param1: $routeParams.id}, function(res) {
			if (actionUpdate) actionUpdate('save', $routeParams.id);
			$location.path(root);
		});
	}

	$scope.destroy = function() {
		var confirm = $window.confirm('Are you sure?');
		if(confirm) {
			$scope[model].$delete({param1: $routeParams.id}, function(res) {
				if (actionUpdate) actionUpdate('delete', $routeParams.id);
				$location.path(root);
			});
		}
	}
	
}
