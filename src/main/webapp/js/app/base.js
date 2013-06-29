/**
 * Configuration
 */
var limit = 10;
var languageDefault = "pt-BR";

/**
 * Setup
 */
var baseUrl = './';
var loginUrl = baseUrl + 'authentication/login/';
var logoutUrl = baseUrl + 'authentication/logout/';

/**
 * Basic Functions
 */

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