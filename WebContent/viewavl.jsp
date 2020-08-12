<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/viewtrains.css">
<title>Globetortin.com</title>
<nav> <header>
<h1>Globetortin.com</h1>
</header> </nav>

</head>
<body>


	<section> <c:forEach var="train" items="${trains}">

		<ul>
			<li class="name">Name : ${train.name}</li>
			<li class="number">TrainNumber : ${train.id}</li>
			<br>
			<br>
			<div class="type">

				<button class="book">
					<a
						href="<%=request.getContextPath()%>/checkOutController/checkout?tid=${train.id}">book</a>
				</button>

			</div>
			</form>
		</ul>


		<br>
		<br>

	</c:forEach> </section>



</body>
</html>