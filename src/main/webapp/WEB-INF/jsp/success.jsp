<%-- 
    Document   : success
    Created on : 18-ene-2019, 19:42:21
    Author     : thepu
--%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Listado de pedidos</title>
        <link rel="stylesheet" type="text/css" href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
        <script type="text/javascript" src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Tienda eCommerce</a>
                </div>
                <div class="navbar-header">
                    <a class="navbar-brand" href="/pedidos">Ver pedidos</a>
                </div>

            </div>
        </nav>
        <div class="container">
            <h1>Listado de pedidos en curso</h1>
            <div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Direccion</th>
                            <th>Envio</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ped" items="${pedidos}">
                            <tr>
                                <td>${ped.id}</td>
                                <td>${ped.calle}</td>
                                <td>${ped.empresa}</td>
                                <td>${ped.estado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

