<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portingo | Digital Asset Marketplace</title>
<link rel="shortcut icon" type="image/x-icon" href="1676232223.ico">
<link rel="stylesheet" type="text/css" href="review.css">
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
    
    
<div class="container">
        <h1>Please Review Before Paying</h1>
        <form action="execute_Payment" method="post">
            <table>
                <!-- Transaction Details -->
                <tr>
                    <td colspan="2"><b>Transaction Details:</b></td>
                    <td>
                        <input type="hidden" name="paymentId" value="${param.paymentId}" />
                        <input type="hidden" name="PayerID" value="${param.PayerID}" />
                    </td>
                </tr>
                <tr>
                    <td>Domain:</td>
                    <td>${transaction.description}</td>
                </tr>
                <tr>
                    <td>Subtotal:</td>
                    <td>${transaction.amount.details.subtotal} USD</td>
                </tr>
                <tr>
                    <td>Shipping:</td>
                    <td>${transaction.amount.details.shipping} USD</td>
                </tr>
                <tr>
                    <td>Tax:</td>
                    <td>${transaction.amount.details.tax} USD</td>
                </tr>
                <tr>
                    <td>Total:</td>
                    <td>${transaction.amount.total} USD</td>
                </tr>

                <!-- Payer Information -->
                <tr><td><br/></td></tr>
                <tr>
                    <td colspan="2"><b>Payer Information:</b></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td>${payer.firstName}</td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td>${payer.lastName}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${payer.email}</td>
                </tr>

                <!-- Shipping Address -->
                <tr><td><br/></td></tr>
                <tr>
                    <td colspan="2"><b>Shipping Address:</b></td>
                </tr>
                <tr>
                    <td>Recipient Name:</td>
                    <td>${shippingAddress.recipientName}</td>
                </tr>
                <tr>
                    <td>Line 1:</td>
                    <td>${shippingAddress.line1}</td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td>${shippingAddress.city}</td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td>${shippingAddress.state}</td>
                </tr>
                <tr>
                    <td>Country Code:</td>
                    <td>${shippingAddress.countryCode}</td>
                </tr>
                <tr>
                    <td>Postal Code:</td>
                    <td>${shippingAddress.postalCode}</td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Pay Now" class="button-29"/>
                    </td>
                </tr>    
            </table>
        </form>
    </div>
</body>
</html>