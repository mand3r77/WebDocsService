/**
 * 
 */
// Shorthand for $( document ).ready()
$(function() {

	$("#legSaveSelect").change(function(){
		var custName = $("#legSaveOpt").data("custname");
		var whseName = $("#legSaveOpt").data("whsename");
		var saveName = $("#legSaveOpt").data("savename");
		var testList = $("#newTest");
		
		for(String data:testList){
			
		};
		var test = $("#test").val();
		$("#legacyCustomer").text(custName);
		
		$("#legacyWarehouse").text(whseName);
		console.log(testList);
		alert(testList);

	})
 
   
});

function checkData(){
	alert('called');
}
function showData(){
	var username = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	
	alert(username + ":" + password);
}
