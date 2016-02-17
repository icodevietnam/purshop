<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="<c:url value='/resources/assets/vendors/bootstrap/dist/css/bootstrap.min.css'/>"
    rel="stylesheet">
<link href="<c:url value='/resources/assets/vendors/fontawesome/css/font-awesome.min.css'/>"
    rel="stylesheet">
<link href="<c:url value='/resources/assets/vendors/animatecss/index.css'/>"
    rel="stylesheet">
<link href="<c:url value='/resources/assets/vendors/bootstrap-switch/dist/css/bootstrap3/bootstrap-switch.min.css'/>"
    rel="stylesheet">
</head>
<body>
<div class="app-container">
        <div class="row content-container">
        	<tiles:insertAttribute name="header" />
        	<tiles:insertAttribute name="navigation" />
            <!-- Main Content -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                	<tiles:insertAttribute name="body" />
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />
</div>
<script data-main="<c:url value='/resources/assets/main'/>" src="<c:url value='/resources/assets/vendors/requirejs/require.js'/>"></script>
</body>
</html>