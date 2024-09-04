<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    
</head>
<body>
    <jsp:include page="componentes/header.jsp"></jsp:include>
    <div class="container">
        <div class="login-container">
            <h1>Registrar</h1>
            <form action="<%=request.getContextPath()%>/Registrar/registro" method="post">
                <input type="text" name="usuario" placeholder="Usuario" required>
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Contraseña" required>
                <button type="submit">Registrar</button>
                <button type="button" onclick="window.location.href='<%=request.getContextPath()%>/Login'">Login</button>
                <c:if test="${not empty errorMessage}">
                    <p class="error">${errorMessage}</p>
                </c:if>
            </form>
        </div>
    </div>
    <jsp:include page="componentes/footer.jsp"></jsp:include>
    
</body>
</html>