'use_strict';
angular.module('ui.i18n', []).factory('localize', ['$http', '$rootScope', '$location', '$window', function($http, $rootScope, $location, $window) {
var localize = {
    language : $window.navigator.userLanguage || $window.navigator.language,
    dictionary : undefined,
    resourceFileLoaded : false,
    successCallback : function (data) {
        localize.dictionary = data;
        localize.resourceFileLoaded = true;
        $rootScope.$broadcast('localizeResourcesUpdates');
    },
    initLocalizedResources : function () {
    	var languageParam = $location.search()['language'];
    	if (languageParam) localize.language = languageParam;
        var url = 'i18n/' + localize.language + '.json';
        $http({ method:"GET", url:url, cache:false })
            .success(localize.successCallback)
            .error(function () {
                var url = 'i18n/' + languageDefault + '.json';
                $http({ method:"GET", url:url, cache:false }).success(localize.successCallback);
            });
    },
    getLocalizedString : function (value, parameters) {
    	var placeholders = [];
    	if (parameters) placeholders = parameters.split(',');
        var translated = '!NO_TRANSLATION!';
        if (!localize.resourceFileLoaded) {
            localize.initLocalizedResources();
            localize.resourceFileLoaded = true;
            return translated;
        }
        if ( typeof localize.dictionary === "object" ) {
            var log_untranslated = false;
            var translate = function(value, placeholders) {
                placeholders = placeholders || null;
                var translated = localize.dictionary[value];
                if (translated === undefined) {
                    if (log_untranslated == true)
                    {
                        //  Log untranslated value
                    }
                    return module_replace(value, placeholders);
                }
                return module_replace(translated, placeholders);
            };
            var result = translate(value, placeholders);
            if ( (translated !== null) && (translated != undefined) ) {
                translated = result;
            }
        } else {

        }
        return translated;
    }
};
return localize;
}])
.filter('i18n', ['localize', function (localize) {
	return function (input, parameters) {
		return localize.getLocalizedString(input, parameters);
	};
}])
.directive('i18n', ['localize', function(localize, parameters) {
	return {
		restrict : "EAC",
		link : function (scope, elm, attrs) {
			var tag = localize.getLocalizedString(attrs.i18n);
			if( (tag !== null) && (tag !== undefined) && (tag !== '') ) {
				elm.append(tag);
			}
		}
	}
}]);
function module_replace(value,placeholders) {
	try {
		return sprintf(value,placeholders);
	} catch (e) {
		return value;
	}
}