<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="kwinta.gringotts.entities.Vault" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gringott's Bank</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h2>Welcome, <%= request.getAttribute("username") %>!</h2>
    <p>These are details about your account</p>

    <!-- Main Golden Box containing transactions -->
    <div class="vaults-main-box">
        
        <div class="vault-container">
        <%-- Transaction boxes --%>
            <div class="vault-box">
                <h3>Wizard Identification Number</h3>
                <p><%= request.getAttribute("userId") %></p>
            </div>
            <%
            int totalGal = 0;
            int totalSic = 0;
            int totalKnt = 0;

            List<Vault> vaults = (List<Vault>) request.getAttribute("vaults");

            if (vaults != null && !vaults.isEmpty())
            {
                for (Vault vault : vaults)
                {
                    totalGal += vault.getGalleon();
                    totalSic += vault.getSickle();
                    totalKnt += vault.getKnut();
                }
            }
            %>
            <div class="vault-box">
                <h3>Total wealth</h3>
                <p><%= totalGal %> Galleons, <%= totalSic %> Sickles and <%= totalKnt %> Knuts</p>
            </div>
        </div>
    
        <div class="form-container">
            <form action="/delete-account" method="get">
                <input type="hidden" name="userId" value="<%= request.getAttribute("userId") %>">
                <input type="submit" class="button" value="Delete Account">
            </form>
            <form action="/go-back" method="get">
                <input type="hidden" name="userId" value="<%= request.getAttribute("userId") %>">
                <input type="submit" class="button" value="Back">
            </form>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
