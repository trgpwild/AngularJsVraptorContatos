var INTEGER_REGEXP = /^\-?\d*$/;
App.directive('integer', function() {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			ctrl.$parsers.unshift(function(viewValue) {
				if (INTEGER_REGEXP.test(viewValue)) {
					ctrl.$setValidity('integer', true);
					return viewValue;
				} else {
					ctrl.$setValidity('integer', false);
					return undefined;
				}
			});
		}
	};
});

App.directive('passwordValidate', function() {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			ctrl.$parsers.unshift(function(viewValue) {

				scope.pwdValidLength = (viewValue
						&& viewValue.length >= 8 ? 'valid'
						: undefined);
				scope.pwdHasLetter = (viewValue && /[A-z]/
						.test(viewValue)) ? 'valid'
						: undefined;
				scope.pwdHasNumber = (viewValue && /\d/
						.test(viewValue)) ? 'valid'
						: undefined;

				if (scope.pwdValidLength
						&& scope.pwdHasLetter
						&& scope.pwdHasNumber) {
					ctrl.$setValidity('pwd', true);
					return viewValue;
				} else {
					ctrl.$setValidity('pwd', false);
					return undefined;
				}

			});
		}
	};
});

App.directive('ngEnter', function() {
	return function(scope, element, attrs) {
		element.bind("keydown keypress", function(event) {
			if(event.which == 13) {
				scope.$apply(function(){
					scope.$eval(attrs.ngEnter);
				});
				event.preventDefault();
			}
		});
	};
});

App.directive('doScroll', function() {
	return function(scope, elm, attr) {
		var raw = elm[0];
		elm.bind('scroll', function() {
			if (raw.scrollTop + raw.offsetHeight >= raw.scrollHeight) {
				scope.$apply(attr.doScroll);
			}
		});
	};
});