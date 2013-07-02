var MainController = function ($scope, $http, $location, localize) {

	$scope.login = function () {

		$http.post(loginUrl, {usuario: {
			username : $('#user').val(),
			password : $('#pass').val()
	    }}).success(function(data) {
			if (data.authenticated) {
				$location.path(baseUrl);
				$('#loginModal').modal('hide');
			} else {
				$('#loginModal').modal('hide');
				alert(data.message);
			}
		});
		
	}
	
	$scope.logout = function(){
		$http.get(logoutUrl).success(function(data) {
			if (data.authenticated == false) {
				$location.path(baseUrl);
			} else {
				alert(data.message);
			}
		});
	}
	
	$scope.setLocale = function(language) {
		localize.setLanguage(language);
	}

};
MainController.$inject = ['$scope', '$http', '$location', 'localize'];