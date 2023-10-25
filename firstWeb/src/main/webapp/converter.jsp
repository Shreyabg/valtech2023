<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
    <title>Number System Converter</title>
</head>
<body>
    <h1>Number System Converter</h1>
    <form action="convert" method="post">
        <label for="input1">Number 1 (Decimal):</label>
        <input type="number" id="input1" name="number1" required><br>
        <label for="input2">Number 2 (Decimal):</label>
        <input type="number" id="input2" name="number2" required><br>
        <label for="system">Select Number System:</label>
        <select id="system" name="selectedSystem">
            <option value="binary">Binary</option>
            <option value="octal">Octal</option>
            <option value="hexadecimal">Hexadecimal</option>
            <option value="base64">Base64</option>
            <option value="dec">Decimal Converter</option>
           
        </select><br>
        <input type="submit" value="Convert">
    </form>
</body>
</html>