var LoginController = function ($scope) {

	$scope.authenticate = function () {
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "api/login?ajax=true",
			data: JSON.stringify({
				user : $('#user').val(),
				pass : $('#pass').val()
		    }),
			dataType: 'json',
			success : function(data){
				if (data.message == 'success') {
					window.location.href = homePage;
				} else {
					alert(data.message);
				}
			}
		});
	}

};