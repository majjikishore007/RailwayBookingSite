<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bill.css">
    <title>Document</title>
</head>
<nav class="nav" >
    <header>
       <h1>Globetortin.com</h1>
   </header>
</nav>
<body>
    <h1 class="tc">your ticket  is confirmed</h1>
   
     
     
     
        <section>
         <c:forEach var="booking" items="${booking}">
            <ul>
                <li class="foo">Pnr Number:${booking.pnr} </li>
                <li class="foo">UserId: ${booking.userId}</li>
                <li class="foo">Train Number: ${booking.trainName}</li>
                 <li class="foo">Train Name : ${booking.trainNo}</li>
                <li class="foo">Source: ${booking.from}</li>
                <li class="foo">Destination:${booking.to}</li>
                <li class="foo">Fare:${booking.price}</li>
            </ul>
         </c:forEach>   
        </section>
        
</body>

</html>