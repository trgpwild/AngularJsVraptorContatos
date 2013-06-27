'use_strict';
angular.module('ui.i18n', []).factory('localize', ['$http', '$rootScope', '$window', function($http, $rootScope, $window) {
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
        var url = 'i18n/' + localize.language + '.json';
        $http({ method:"GET", url:url, cache:false })
            .success(localize.successCallback)
            .error(function () {
                var url = 'i18n/default.json';
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
(function(e){function r(e){return Object.prototype.toString.call(e).slice(8,-1).toLowerCase()}function i(e,t){for(var n=[];t>0;n[--t]=e);return n.join("")}var t=function(){return t.cache.hasOwnProperty(arguments[0])||(t.cache[arguments[0]]=t.parse(arguments[0])),t.format.call(null,t.cache[arguments[0]],arguments)};t.format=function(e,n){var s=1,o=e.length,u="",a,f=[],l,c,h,p,d,v;for(l=0;l<o;l++){u=r(e[l]);if(u==="string")f.push(e[l]);else if(u==="array"){h=e[l];if(h[2]){a=n[s];for(c=0;c<h[2].length;c++){if(!a.hasOwnProperty(h[2][c]))throw t('[sprintf] property "%s" does not exist',h[2][c]);a=a[h[2][c]]}}else h[1]?a=n[h[1]]:a=n[s++];if(/[^s]/.test(h[8])&&r(a)!="number")throw t("[sprintf] expecting number but found %s",r(a));switch(h[8]){case"b":a=a.toString(2);break;case"c":a=String.fromCharCode(a);break;case"d":a=parseInt(a,10);break;case"e":a=h[7]?a.toExponential(h[7]):a.toExponential();break;case"f":a=h[7]?parseFloat(a).toFixed(h[7]):parseFloat(a);break;case"o":a=a.toString(8);break;case"s":a=(a=String(a))&&h[7]?a.substring(0,h[7]):a;break;case"u":a>>>=0;break;case"x":a=a.toString(16);break;case"X":a=a.toString(16).toUpperCase()}a=/[def]/.test(h[8])&&h[3]&&a>=0?"+"+a:a,d=h[4]?h[4]=="0"?"0":h[4].charAt(1):" ",v=h[6]-String(a).length,p=h[6]?i(d,v):"",f.push(h[5]?a+p:p+a)}}return f.join("")},t.cache={},t.parse=function(e){var t=e,n=[],r=[],i=0;while(t){if((n=/^[^\x25]+/.exec(t))!==null)r.push(n[0]);else if((n=/^\x25{2}/.exec(t))!==null)r.push("%");else{if((n=/^\x25(?:([1-9]\d*)\$|\(([^\)]+)\))?(\+)?(0|'[^$])?(-)?(\d+)?(?:\.(\d+))?([b-fosuxX])/.exec(t))===null)throw"[sprintf] huh?";if(n[2]){i|=1;var s=[],o=n[2],u=[];if((u=/^([a-z_][a-z_\d]*)/i.exec(o))===null)throw"[sprintf] huh?";s.push(u[1]);while((o=o.substring(u[0].length))!=="")if((u=/^\.([a-z_][a-z_\d]*)/i.exec(o))!==null)s.push(u[1]);else{if((u=/^\[(\d+)\]/.exec(o))===null)throw"[sprintf] huh?";s.push(u[1])}n[2]=s}else i|=2;if(i===3)throw"[sprintf] mixing positional and named placeholders is not (yet) supported";r.push(n)}t=t.substring(n[0].length)}return r};var n=function(e,n,r){return r=n.slice(0),r.splice(0,0,e),t.apply(null,r)};e.sprintf=t,e.vsprintf=n})(typeof exports!="undefined"?exports:window);