<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
</head>
<body>
<header>
	    <nav>
	        <div class="logo">
	         <a href="<%=request.getContextPath()%>/index.jsp">
	         	<img alt="logo" src="<%=request.getContextPath()%>/images/logo.png" 
	         		width="50" height="50">
	         </a>
	        </div>
	        <ul>
	            <li><a href="#about">Sobre Nosotros</a></li>
	            <li><a href="#services">Servicios</a></li>
	            <li><a href="#contact">Contacto</a></li>
	            <li><a href="<%=request.getContextPath()%>/Login/login">Login</a></li>
	        </ul>
	    </nav>
	</header>
</body>
</html>