<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="kwinta.gringotts.entities.Vault" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gringott's Bank</title>
    <script>
        // Function to toggle the visibility of the menu
        function toggleMenu(vaultId)
        {
            const menu = document.getElementById("menu-" + vaultId);
            if (menu.style.display === "none" || menu.style.display === "")
            {
                menu.style.display = "block";
            }
            else
            {
                menu.style.display = "none";
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Welcome, <%= request.getAttribute("username") %>!</h1>
    <p>You are successfully logged in.</p>

    <!-- Upper Red Box with User Options -->
    <div class="user-options-box">
        <a href="/home" class="button">Sign Out</a>
        <a href="/home" class="button">Wizarding Account Settings</a>
        <a href="/home" class="button">Gringott's Account Details</a>
    </div>

    <!-- Main Golden Box containing Vaults -->
    <div class="vaults-main-box">
        <h2>Your Vaults</h2>
        
        <div class="vault-container">
        <%-- Vault boxes with slide-down menus --%>
        <%
            List<Vault> vaults = (List<Vault>) request.getAttribute("vaults");
            if (vaults != null && !vaults.isEmpty())
            {
                for (Vault vault : vaults)
                {
        %>
            <div class="vault-box" onclick="toggleMenu(<%= vault.getVaultNum() %>)">
                <h3>Vault Number <%= vault.getVaultNum() %></h3>
                <p>Galleons: <%= vault.getGalleon() %></p>
                <p>Sickles: <%= vault.getSickle() %></p>
                <p>Knuts: <%= vault.getKnut() %></p>
                
                <!-- Slide-down menu for each vault -->
                <div id="menu-<%= vault.getVaultNum() %>" class="vault-menu">
                    <button onclick="location.href='/transfer-page/<%= vault.getVaultNum() %>'">Transfer</button>
                    <button onclick="location.href='/simplify-vault/<%= vault.getWizard() %>/<%= vault.getVaultNum() %>'">Simplify</button>
                    <button onclick="location.href='/exchange/<%= vault.getVaultNum() %>'">Exchange to GBP</button>
                </div>
            </div>
        <%
                }
            }
            else
            {
        %>
            <div class="vault-box">
                <h3>No vaults found for this user.</h3>
            </div>
        <% 
            } 

            // Conditionally display the "Claim New Vault" box
            if (vaults.size() < 3)
            { 
        %>
        <form action="${pageContext.request.contextPath}/new-vault/<%= request.getAttribute("userId") %>" method="post" id="claimVaultForm">
            <input type="hidden" name="_method" value="put">
            <div class="claim-box" onclick="document.getElementById('claimVaultForm').submit();">
                Claim New Vault
            </div>
        </form>
        <% } %>
        </div>

    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
