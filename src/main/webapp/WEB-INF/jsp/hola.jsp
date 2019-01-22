<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
    <head>

        <!-- Access the bootstrap Css like this, 
                Spring boot will handle the resource mapping automcatically -->
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
         <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         
        <spring:url value="/js/mijs.js" var="springJs" />
        <script type="text/javascript" src="${springJs}"></script>
        <!-- 
        <spring:url value="/css/main.css" var="springCss" />
        
        <link href="${springCss}" rel="stylesheet" />
        -->
        <c:url value="/css/main.css" var="jstlCss" />
        <link href="${jstlCss}" rel="stylesheet" />

    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Tienda eCommerce</a>
                </div>
                 <div class="navbar-header">
                <a class="navbar-brand" href="/pedidos">Ver pedidos</a>
            </div>

            </div>
        </nav>

        <div class="container">

            <div class="starter-template">

                <h1>Realiza tu pedido</h1>
            </div>

            <div>
                <form:form modelAttribute="pedido" action="/pedidos/add" method="POST">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Ref.</th>                                
                                <th scope="col">Designación</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Unidades</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="prod" items="${productos}">
                                <tr>
                                    <th scope="row">${prod.id}</th>
                                    <td>${prod.designacion}</td>
                                    <td>${prod.precio}  Eu</td>
                                    <td>
                                        <input type="number" value="1" class="form-control">
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Volumen</td>
                                <td id="tdtotal">
                                    <form:input path="uds" class="form-control"  />

                                </td>
                            </tr>

                        </tbody>
                    </table> 
                    <div class="form-group row">
                        <form:label path="calle" class="col-sm-2 col-form-label">Direccion de envio</form:label>
                            <div class="col-sm-10">
                            <form:input path="calle" class="form-control"/>
                        </div>

                    </div>
                        <div class="form-group row">
                            <form:label path="empresa" class="col-sm-2 col-form-label">Tipo de transporte</form:label>
                            <div class="col-sm-10">
                            <form:select path="empresa" items="${tipostransportes}" class="form-control"/>
                        </div>

                    </div>
                    <button type="submit" class="btn  btn-primary">Realizar pedido</button>
                </form:form>

            </div>

        </div>


       

    </body>

</html>
