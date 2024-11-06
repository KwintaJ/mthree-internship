<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gringott's Bank</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Register as a new Wizard</h1>
    <div class="form-container">
        <form action="/new-user" method="post">
            <label for="username">Wizard's full name:</label><br>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Secret key:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" class="button" value="Register">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
