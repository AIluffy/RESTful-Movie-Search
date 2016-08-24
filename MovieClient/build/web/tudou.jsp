<%-- 
    Document   : tudou
    Created on : 2015-8-15, 20:30:12
    Author     : AI
--%>

<%@page import="entity.Tudou"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tudou</title>
    </head>
    <body>
        <% List<Tudou> tudou = (List<Tudou>) request.getAttribute("tudou");
        %>
        
        <c:forEach var="tudous" items="${tudou}">
            <p>"<c:out value="${tudous.getTitle()}"/>"</p>
            <embed src="<c:out value="${tudous.getOuterPlayerUrl()}"/>" />
            
        </c:forEach>
    </body>
</html>
