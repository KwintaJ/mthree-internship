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
    <h1>Oops!</h1>
    <p>Specified vault does not belong to specified recipient.</p>
    <br>
    <a href="/home" class="button">Home</a>
    <a href="/sign-in" class="button">Sign In</a>
    <div class="form-container">
        <form action="/go-back" method="get">
            <input type="hidden" name="userId" value="<%= request.getAttribute("userId") %>">
            <input type="submit" class="button" value="Back">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
