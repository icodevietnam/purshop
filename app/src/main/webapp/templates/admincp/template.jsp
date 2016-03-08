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
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet" type="text/css">
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
</body>
</html>