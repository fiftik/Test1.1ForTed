<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Device commander</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript">
function doAjaxPost() {  
	  // get the form values  
	  var keyword = $('#keyword').val();
	  $.ajax({  
	    type: "POST",  
	    url: "/Test1.1ForTed/OnOff.htm",  
	    data: "keyword=" + keyword,  
	    success: function(response){  
	      // we have the response  
	      $('#info').html(response);
	    },  
	    error: function(){  
	      alert('Some Error!');  
	    }  
	  });  
	}  
</script>
</head>
<body>
<h1>Turn on/off device</h1>
	<table>
		<tr><td>Enter keyword : </td><td> <input type="text" id="keyword"><br/></td></tr>
		<tr><td colspan="2"><input type="button" value="Turn on/off!" onclick="doAjaxPost()"><br/></td></tr>
		<tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
	</table>
</body>
</html>