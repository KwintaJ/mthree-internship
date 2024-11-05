<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="kwinta.gringotts.entities.Vault" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - Gringott's Bank</title>
    <style>
        body
        {
            font-family: 'Trebuchet MS', sans-serif;
            background-color: #353535; /* Dark grey background */
            color: #f0e68c; /* Gold color for text */
            text-align: center;
            padding: 50px;
        }
        h1
        {
            color: #B90E0A; /* Dark red */
        }
        .vault-container
        {
            display: flex; /* Use flexbox to arrange boxes horizontally */
            flex-wrap: wrap; /* Allow wrapping to next line if necessary */
            justify-content: center; /* Center the boxes */
            gap: 20px; /* Space between boxes */
            padding: 20px 0; /* Padding around the container */
        }
        .vault-box
        {
            background-color: #555; /* Lighter grey for boxes */
            color: #fff;
            padding: 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 200px; /* Set width for the vault boxes */
            text-align: left; /* Align text to the left */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Add some shadow for depth */
        }
        .vault-box:hover
        {
            background-color: #666; /* Slightly lighter grey on hover */
        }
        footer
        {
            margin-top: 20px;
            font-size: 14px;
            color: #ccc; /* Light grey for footer text */
        }
    </style>
</head>
<body>
    <h1>Welcome, <%= request.getAttribute("username") %>!</h1>
    <p>You are successfully logged in as wizard <%= request.getAttribute("userId") %></p>

    <div class="vault-container">
        <%
            List<Vault> vaults = (List<Vault>)request.getAttribute("vaults");
            if (vaults != null && !vaults.isEmpty())
            {
                for (Vault vault : vaults)
                {
        %>
            <div class="vault-box" onclick="location.href='/vault/<%= vault.getVaultNum() %>'">
                <h3>Vault Number <%= vault.getVaultNum() %></h3>
                <p>Galleons: <%= vault.getGalleon() %></p>
                <p>Sickles: <%= vault.getSickle() %></p>
                <p>Knuts: <%= vault.getKnut() %></p>
            </div>
        <%
                }
            }
            else
            {
        %>
            <div class="vault-box">
                <h3>No vaults belong to you.</h3>
            </div>
        <%
            }
        %>
    </div>

    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
