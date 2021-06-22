<%--
  Created by IntelliJ IDEA.
  User: sushilkarki
  Date: 6/17/21
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="css.jsp" />
    <title>Customer</title>
</head>
<body>
<div class = "container">
    <jsp:include page="navbar.jsp" />
    <%--<a href="${pageContext.servletContext.contextPath}/customer?action=listPage">View CustomerList</a> --%>

    <div class="row">
        <div class="col-md-4">
            <h4><em>Customer SignUp</em></h4>
            <hr>
            <form action="${pageContext.servletContext.contextPath}/customer?action=save" method="post">
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Full Name" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text" class="form-control" id="password" name="password" placeholder="Password" required>
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Address" required>
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Enter email" required>
                </div>

                <div class="form-group">
                    <label for="mobileNumber">Mobile Number</label>
                    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber" placeholder="Mobile Number" required>
                </div>
                <br>
                <div class="form-group">
                    <label>Gender</label>
                    <input type="radio" name = "gender" value="MALE" checked>MALE
                    <input type="radio" name = "gender" value="FEMALE">FEMALE
                    <input type="radio" name = "gender" value="OTHER">OTHER
                </div>

                <br>
                <button type="submit" class="btn btn-primary">SignUp</button>
            </form>

            <span style = "color: mediumpurple">${message}</span>

        </div>
        <div class="col-md-8">
        <h4><em>Customer List</em></h4>
        <hr>
           <c:forEach var="name" items="${customerList}">
               <h3>${name}</h3>
           </c:forEach>
        </div>
    </div>



</div>


</body>
</html>
