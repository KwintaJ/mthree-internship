<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gringott's Bank</title>
    <style>
        body {
            font-family: 'Trebuchet MS', sans-serif;
            background-color: #353535; /* Dark grey background */
            color: #f0e68c; /* Gold color for text */
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #B90E0A; /* Dark red */
        }
        .button {
            background-color: #B90E0A; /* Dark red */
            color: #f0e68c; /* Gold */
            border: none;
            padding: 15px 30px;
            margin: 10px;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
            text-decoration: none; /* Remove underline from links */
        }
        .button:hover {
            background-color: #A52A2A; /* Lighter dark red on hover */
            transition: background-color 0.3s ease;
        }
        footer {
            margin-top: 200px;
            font-size: 14px;
            color: #ccc; /* Light grey for footer text */
        }
    </style>
</head>
<body>
    <h1>Login failed!</h1>
    <p>Please try again or register new Wizard</p>
    <br>
    <a href="/home" class="button">Home</a>

    <footer>
        <p>&copy; 2024 Jan Kwinta.</p>
    </footer>
</body>
</html>
