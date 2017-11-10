<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="vendor" value="/resources/vendor" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>    

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LearningCAFE - ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/scrolling-nav.css" rel="stylesheet">

  </head>

  <body id="page-top">
   <div class="container">
    <!-- Navigation -->
   <%@include file="./shared/navbar.jsp" %>
   
    <!-- body content -->
    <c:if test="${userClickHome == true }">
    <%@include file="home.jsp" %>
    </c:if>
    <c:if test="${userClickTutorials == true }">
    <%@include file="tutorials.jsp" %>
    </c:if>
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>
</div>
    <!-- Bootstrap core JavaScript -->
    <script src="${vendor}/jquery/jquery.min.js"></script>
    <script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="${vendor}/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom JavaScript for this theme -->
    <script src="${js}/scrolling-nav.js"></script>

  </body>

</html>
