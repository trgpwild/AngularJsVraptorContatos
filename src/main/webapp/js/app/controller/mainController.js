var MainController = function ($scope, $http, $location) {

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
	
	$scope.language = function(language) {
		window.location.href="#?language="+language;
		window.location.reload();
	}

};
MainController.$inject = ['$scope', '$http', '$location'];