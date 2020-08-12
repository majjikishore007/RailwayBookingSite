<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/checkout.css">
    <title>Globetortin.com</title>
</head>

        <nav class="nav" >
             <header>
	            <h1>Globetortin.com</h1>
            </header>
        </nav>
<body>
      <br><br>
     <c:forEach var="train" items="${train}">
        <nav class="info"> 
            <ul >
            <li class="bar">Name:${train.name}</li>
            <li class="bar">TrainNumber:${train.id}</li>
            <li class="bar">From:${train.from}</li>
            <li class="bar">To:${train.to}</li>
            <li class="bar">ArrivalTime:${train.arrivalTime}</li>
            <li class="bar">DepartureTime:${train.departureTime}</li>
            <li class="fare">Fare :Rs ${train.fare}</li>
        </ul>  
    </nav>
      
    
      
    <form action="<%=request.getContextPath()%>/checkOutController/confirm?tid=${train.id}" class="booking" method="post">
        <h1>enter your details</h1>
        <input type="email" name="email" id="email"  class="foo" placeholder="emai" required>
        <br><br>
        <input type="text"  name="username"  class="foo" placeholder="username" required>
        <br><br>
        <input type="phoneNumber" name="phonenumber" class="foo" placeholder="PhoneNumber" required>
        <br><br>
         <input type="password" name="password" class="foo" placeholder="password" required>
        <br><br>
        <button>submit</button>
    </form>
     </c:forEach>   
</body>
</html>