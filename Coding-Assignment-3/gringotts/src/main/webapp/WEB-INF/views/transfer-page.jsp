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
    <h1>Transfer gold to other Wizards</h1>
    <div class="form-container">
        <form action="/transfer-go" method="get">
            <label for="username">Recipients's full name:</label><br>
            <input type="text" id="recipient" name="recipient" required><br><br>
            <label for="password">Recipient's vault number:</label><br>
            <input type="text" id="v2" name="v2" required><br><br>
            <label for="password">How many Galleons:</label><br>
            <input type="text" id="gal" name="gal" required><br><br>
            <label for="password">How many Sickles:</label><br>
            <input type="text" id="sic" name="sic" required><br><br>
            <label for="password">How many Knuts:</label><br>
            <input type="text" id="knt" name="knt" required><br><br>
            <input type="hidden" name="userId" value="<%= request.getAttribute("userId") %>">
            <input type="hidden" name="v1" value="<%= request.getAttribute("vaultNum") %>">
            <input type="submit" class="button" value="Submit">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
