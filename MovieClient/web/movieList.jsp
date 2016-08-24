<%-- 
    Document   : movieList
    Created on : 2015-8-15, 16:40:50
    Author     : AI
--%>

<%@page import="entity.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Result</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%
                List<Movie> results = (List<Movie>) request.getAttribute("results");
            %>
            <div><a href="add.html"><img class="img-circle" src="img/add.jpg" width="100px" height="100px"/></a></div>
            <div>
                <c:forEach var="movie" items="${results}">
                    <ul class="list-inline">
                        <dl class="dl-horizontal">                
                            <dt>         
                            <p style="float:left"><c:out value="${movie.getTitle()}"/></p>
                            </dt>
                            <dd>
                                <c:out value="${movie.getDescription()}"/>
                            </dd>
                            <div class="col-md-offset-11">
                                <button type="button"><a href="http://localhost:8080/MovieClient/SearchIDServlet?keywords=${movie.getId()}">View Moive</a></button>
                            </div> 
                        </dl>
                    </ul>
                </c:forEach>   
            </div>
        </div>
    </body>
</html>
