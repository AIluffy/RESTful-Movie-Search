<%-- 
    Document   : baidu
    Created on : 2015-8-15, 20:07:07
    Author     : AI
--%>

<%@page import="entity.Baidu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Picture</title>
        <style>
            div.img
            {
                margin:3px;
                border:1px solid #bebebe;
                height:auto;
                width:auto;
                float:left;
                text-align:center;
            }
            div.img img
            {
                display:inline;
                margin:3px;
                border:1px solid #bebebe;
            }
            div.img a:hover img
            {
                border:1px solid #333333;
            }
            div.desc
            {
                text-align:center;
                font-weight:normal;
                width:150px;
                font-size:12px;
                margin:10px 5px 10px 5px;
            }
        </style>

    </head>
    <body>
        <%
            List<Baidu> baidu = (List<Baidu>) request.getAttribute("baidu");
        %>     
        <c:forEach var="pic" items="${baidu}">
            <div class="img">
                <a target="_blank" href="<c:out value="${pic.getHoverURL()}"/>">
                    <img src="<c:out value="${pic.getHoverURL()}"/>" alt="Baidu" width="160" height="160"/>
                </a>
            </div>         
        </c:forEach>
    </body>
</html>
