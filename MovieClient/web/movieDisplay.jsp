<%-- 
    Document   : movieDisplay
    Created on : 2015-8-15, 15:41:18
    Author     : AI
--%>


<%@page import="entity.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Play</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="cover.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <%
                List<Movie> movies = (List<Movie>) request.getAttribute("movies");
            %>
            <c:forEach var="movie" items="${movies}">
                <div class="auto">
                    <div class="video">
                        <iframe style="width:1230px;height:768px;" src="<c:out value="${movie.getMlink()}"/>" frameborder="0"></iframe>
                    </div>
                    <div class="center-block">
                        <div class="pull-left">
                            <ul class="list-inline">
                                <li ><strong>Title:</strong> <u> <c:out value="${movie.getTitle()}"/> </u></li>
                                <li ><strong>Director:</strong> <u><c:out value="${movie.getDirector()}"/></u></li>
                                <li ><strong>Writer: </strong> <u><c:out value="${movie.getMwriter()}"/></u></li>
                                <li><strong>Cast: </strong> <u><c:out value="${movie.getStar()}"/> </u></li>
                            </ul>
                        </div>
                        <div class="pull-left">
                            <ul class="list-inline">
                                <li><strong>Genre: </strong> <u> <c:out value="${movie.getMtype()}"/> </u></li>
                                <li><strong>Country: </strong> <u><c:out value="${movie.getCountry()}"/> </u></li>
                                <li> <strong>Release:</strong> <u> <c:out value="${movie.getMrelease()}"/></u> </li>
                                <li> <strong>Language:</strong> <u><c:out value="${movie.getMlanguage()}"/> </u></li>
                                <li><strong>Length:</strong> <u> <c:out value="${movie.getMlength()}"/> </u></li>
                            </ul>
                        </div>
                            <div class="pull-left">
                                 <p><strong>Description: </strong> <u class="text-primary"> <c:out value="${movie.getDescription()}"/> </u></p>
                            </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
