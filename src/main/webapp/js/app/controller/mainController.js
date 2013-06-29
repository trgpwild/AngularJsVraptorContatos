var MainController = function ($scope, $location) {

	$scope.login = function () {
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: loginUrl,
			data: JSON.stringify({usuario: {
				username : $('#user').val(),
				password : $('#pass').val()
		    }}),
			dataType: 'json',
			success : function(data){
				if (data.authenticated) {
					window.location.href = baseUrl;
				} else {
					$('#loginModal').modal('hide');
					alert(data.message);
				}
			}
		});
	}
	
	$scope.logout = function(){
		$.ajax({
			type: "GET",
			url: logoutUrl,
			dataType: 'json',
			success : function(data){
				if (data.authenticated == false) {
					window.location.href = baseUrl;
				} else {
					alert(data.message);
				}
			}
		});
	}
	
	$scope.language = function(language) {
		window.location.href="#?language="+language;
		window.location.reload();
	}

};