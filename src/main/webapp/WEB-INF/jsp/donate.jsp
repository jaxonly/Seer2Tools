<%@page import="java.util.List"%>
<%@page import="com.jax.seer2tools.entity.PetDictionary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script
	src="${pageContext.request.contextPath}/js/jquery-3.1.0.slim.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>详细信息</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 100px"></div>
	<div class="container">
		<div class="blog-header">
			<div class="page-header">
				<h1>捐赠名单</h1>
			</div>
			<p class="lead blog-description">在此记录捐赠人名单，谢谢你们的捐赠</p>
		</div>
		<div class="row">
			<div class="col-sm-8 blog-main">
				<table class="table">
					<tr>
						<td>捐赠人</td>
						<td>捐赠金额</td>
					</tr>
					<c:forEach items="${donates }" var="donate">
						<tr>
							<td>${donate.name}</td>
							<td>${donate.money}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<jsp:include page="callMe.jsp"></jsp:include>
			<!-- /.blog-sidebar -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>