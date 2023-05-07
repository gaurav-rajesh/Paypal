<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portingo | Digital Asset Marketplace</title>
<link rel="shortcut icon" type="image/x-icon" href="1676232223.ico">
<style type="text/css">
    table { border: 0; }
    table td { padding: 5px; }
</style>
<link rel="stylesheet" type="text/css" href="receipt.css">
</head>
<body>

<div class="top-container">
      
      <div class="logo">
        <img class="logo-img" src="portingologo.jpg" alt="logo-img"></div>
      
      <!-- Search bar -->
      <div class="search-container">
        <input type="text" placeholder="Search for your favourite asset here    ">
        <button>Go</button>
      </div>
      <div class="rightside">
        <span>50 VISITORS</span> 
        <span>HI, USER</span>
        <a href="#">MY ACCOUNT</a>
        <a href="#">LOGOUT</a>

      </div>
    </div>
    
    <!-- Navigation bar -->
    <div class="navbar">
      <a href="https://portingo.com/account/overview">ACCOUNT OVERVIEW</a>
      <a href="https://portingo.com/editors-choice">EDITOR'S CHOICE</a>
      <a href="https://portingo.com/watchlist">WATCH LIST</a>
      <a href="#">BUY ASSETS</a>
      <a href="#">SELL ASSETS</a>
      <a href="https://portingo.com/support">SUPPORT</a>
    </div>
    
    
<div align="center" class="container">
    <h1>Payment Successful.</h1>
    <br/>
    <h2>Receipt Details:</h2>
    <table>
        <tr>
            <td><b>Service Provider:</b></td>
            <td>Portingo.LLP</td>
        </tr>
        <tr>
            <td><b>Payer:</b></td>
            <td>${payer.firstName} ${payer.lastName}</td>      
        </tr>
        <tr>
            <td><b>Domain:</b></td>
            <td>${transaction.description}</td>
        </tr>
        <tr>
            <td><b>Subtotal:</b></td>
            <td>${transaction.amount.details.subtotal} USD</td>
        </tr>
        <tr>
            <td><b>Shipping:</b></td>
            <td>${transaction.amount.details.shipping} USD</td>
        </tr>
        <tr>
            <td><b>Tax:</b></td>
            <td>${transaction.amount.details.tax} USD</td>
        </tr>
        <tr>
            <td><b>Total:</b></td>
            <td>${transaction.amount.total} USD</td>
        </tr>                    
    </table>
    <form action="checkout.html" method="post">
    <input type="submit" value="Return to Home" class="button-29">
    </form>
</div>
</body>
</html>