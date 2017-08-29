<html>
<title>Fruit Picker Page</title>
<head>
	<h1> Pick a Fruit!</h1>
</head>
<body>
	<form action="/favFruit" method="POST">
		<p>What's your favorite?</p>
		<#list fruits as a fruit>
			<p>
				<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
			</p>
		</#list>
		<input type="submit" value="SUBMIT">
	</form>	
</body>
</html>
