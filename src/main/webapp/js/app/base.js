var limit = 10;

var baseUrl = './';
var loginUrl = baseUrl + 'authentication/login/';
var logoutUrl = baseUrl + 'authentication/logout/';

var languageDefault = "pt-BR";

function string(val) {
	return "" + val + "";
}

window.alert = function(message) {
	$(document.createElement('div')).attr({
		title : 'Warning',
		'class' : 'alert'
	}).html(message).dialog({
		buttons : {
			OK : function() {
				$(this).remove();
			}
		},
		close : function() {
			$(this).remove();
		},
		draggable : true,
		modal : true,
		resizable : false
	});
};