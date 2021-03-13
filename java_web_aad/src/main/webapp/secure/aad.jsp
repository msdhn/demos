<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AAD Secure Page</title>
</head>
<body>

	<h3>List of users registered in the tenant - ${tenant}</h3>
	<p>${users}</p>
	<br>
	<h3>Current user</h3>
	<table>
		<tr>
			<td>uniqueId:</td>
			<td>${userInfo.uniqueId}</td>
		</tr>
		<tr>
			<td>displayableId:</td>
			<td>${userInfo.displayableId}</td>
		</tr>
		<tr>
			<td>givenName:</td>
			<td>${userInfo.givenName}</td>
		</tr>
		<tr>
			<td>familyName:</td>
			<td>${userInfo.familyName}</td>
		</tr>
		<tr>
			<td>identityProvider:</td>
			<td>${userInfo.identityProvider}</td>
		</tr>
	</table>
	<br>
	<form action="/adal4jsample">
		<input type="submit" value="Home Page">
	</form>

</body>
</html>