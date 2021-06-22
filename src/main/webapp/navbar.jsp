<%--
  Created by IntelliJ IDEA.
  User: sushilkarki
  Date: 6/17/21
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.servletContext.contextPath}/">HomePage</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.servletContext.contextPath}/customer?action=landingPage">Customer</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.servletContext.contextPath}/product">Product</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="${pageContext.servletContext.contextPath}/sales">Sales</a>
      </li>
    </ul>
  </div>
</nav>
</body>
</html>
