<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="kwinta.gringotts.entities.Transaction" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gringott's Bank</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>This is transaction history for Vault <%= request.getAttribute("vaultNum") %> </h1>

    <!-- Main Golden Box containing transactions -->
    <div class="vaults-main-box">
        <h2>Transactions:</h2>
        
        <div class="vault-container">
        <%-- Transaction boxes --%>
        <%
            List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
            if (transactions != null && !transactions.isEmpty())
            {
                for (Transaction t : transactions)
                {
        %>
            <div class="vault-box">
                <h3>Transaction Id: <%= t.getTransactionId() %></h3>
                <p>From vault <%= t.getFromVault() %></p>
                <p>To vault <%= t.getToVault() %></p>
                <p><%= t.getKnuts() / 493 %> Galleons, <%= (t.getKnuts() % 493) / 29 %> Sickles and <%= t.getKnuts() % 29 %> Knuts</p>
            </div>
        <%
                }
            }
            else
            {
        %>
            <div class="vault-box">
                <h3>No transactions regards this vault.</h3>
            </div>
        <% 
            } 
        %>

        </div>
    
        <div class="form-container">
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
