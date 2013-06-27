var AppName = 'Contatos';

var limit = 10;

var baseUrl = '/' + AppName;
var homePage = '/' + AppName + '/';
var loginUrl = '/' + AppName + '/authentication/login/';
var logoutUrl = '/' + AppName + '/authentication/logout/';

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
		resizable : false,
		width : 200
	});
};