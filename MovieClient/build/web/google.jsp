<%-- 
    Document   : google
    Created on : 2015-8-15, 19:24:09
    Author     : AI
--%>

<%@page import="entity.Google"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Google Result</title>
    </head>
    <body>
        <%
            List<Google> google = (List<Google>) request.getAttribute("google");
        %>
        <ol>
            <c:forEach var="google" items="${google}">

                <li>
                    <dl>
                        <dt> <a href="<c:out value="${google.getLink()}"/>"> <c:out value="${google.getTitle()}"/></a></dt>
                        <dd>
                            <c:out value="${google.getSnippet()}"/> 
                        </dd>
                    </dl>
                </li>
            </c:forEach>
        </ol>

    </body>
</html>
