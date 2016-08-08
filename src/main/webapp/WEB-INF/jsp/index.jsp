<%@page import="java.util.List"%>
<%@page import="com.jax.seer2tools.entity.PetDictionary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Index</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Seer2Tools</a>
			</div>
			<!--         <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">登录</a></li>
          </ul>
        </div> -->
		</div>
	</nav>

	<div style="height: 100px"></div>
	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">精灵信息查询工具</h1>
			<p class="lead blog-description">最详细的精灵信息查询工具</p>

		</div>
		<div class="row">
			<div class="col-sm-8 blog-main">
				<div style="float: right;">
					<input type="text" class="form-control" id="queryText"
						style="width: 120px; display: inline-block">
					<button class="btn btn-success" id="query">搜索</button>
				</div>
				<div style="float: right;">
					<select id="select" class="form-control"
						style="display: inline-block;">
						<option>-按属性搜索-</option>
						<option>普通</option>
						<option>草</option>
						<option>水</option>
						<option>火</option>
						<option>风</option>
						<option>虫</option>
						<option>飞行</option>
						<option>电</option>
						<option>地面</option>
						<option>冰</option>
						<option>超能</option>
						<option>光</option>
						<option>暗影</option>
						<option>战斗</option>
						<option>龙</option>
						<option>沙漠</option>
						<option>神秘</option>
						<option>特质</option>
						<option>基佬王</option>
						<option>上古</option>
						<option>圣灵</option>
					</select>
				</div>

				<c:if test="${PetSize != 0}">
					<table class="table table-striped">
						<th>
						<td>名字</td>
						<td>属性</td>
						</th>
						<c:forEach items="${PetInfo}" var="pet">
							<tr>
								<td>${pet.id }</td>
								<td><a
									href="${pageContext.request.contextPath}/monsterinfo/info/${ pet.id }">${pet.defName }</a></td>
								<td>${pet.type }</td>
							</tr>
						</c:forEach>
					</table>
					<nav>
						<ul class="pager">
							<c:if test="${PageNum!=1}">
								<li><a
									href="${pageContext.request.contextPath}/monsterinfo/
													<c:if test="${defName != null }">
														queryName/${ defName}/
													</c:if>
													<c:if test="${Type != null }">
														queryType/${ Type}/
													</c:if>
													${ PageNum-1 }">Previous</a></li>
							</c:if>
							<c:if test="${PageNum==1}">
								<li class="disabled"><a>Previous</a></li>
							</c:if>


							<!-- 下一页 -->
							<c:if test="${PageNum != EndPageNum }">
								<li><a
									href="${pageContext.request.contextPath}/monsterinfo/
													<c:if test="${defName != null }">
														queryName/${ defName}/
													</c:if>
													<c:if test="${Type != null }">
														queryType/${ Type}/
													</c:if>
													
													${ PageNum+1 }">Next</a></li>
							</c:if>
							<c:if test="${PageNum == EndPageNum }">
								<li class="disabled"><a>Next</a></li>
							</c:if>
						</ul>
					</nav>
				</c:if>
				<c:if test="${PetSize == 0}">
					找不到精灵了~
				</c:if>
			</div>
			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module">
					<h4>联系我</h4>
					<ol class="list-unstyled">
						<li><a href="https://github.com/JaxXu">GitHub</a></li>
						<li><a href="http://weibo.com/topjsz">WeiBo</a></li>
						<li><b><a href="https://github.com/JaxXu/Seer2Tools/issues">提建议</a></b></li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<footer class="blog-footer">
		<hr>
		<p align="center">Powered by Jax</p>
	</footer>
	<script type="text/javascript">
		if ('${Type}' == '') {
			$("#select").val('-按属性搜索-');
		} else {
			$("#select").val('${Type}');
		}
		$("#query")
				.click(
						function() {
							var str = $("#queryText").val();
							if ($.trim(str) != "") {
								location.href = "${pageContext.request.contextPath}/monsterinfo/queryName/"
										+ $.trim(str);
							}
						});
		$("#select")
				.change(
						function() {
							var str = $("#select").val();
							location.href = "${pageContext.request.contextPath}/monsterinfo/queryType/"
									+ str;
						});
	</script>
</body>
</html>