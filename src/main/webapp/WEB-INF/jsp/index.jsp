<%@page import="java.util.List"%>
<%@page import="com.jax.seer2tools.entity.PetDictionary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- 分页 -->
<script src="${pageContext.request.contextPath}/js/laypage.js"></script>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 100px"></div>
	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">精灵信息查询工具</h1>
			<p class="lead blog-description">最详细的精灵信息查询工具</p>

		</div>
		<div class="row">
			<div class="col-sm-8 blog-main">
				<div style="float: right;">
					<form class="form-inline" action="${pageContext.request.contextPath}/monsterinfo/query" method="get">
						<div class="form-group">
							<label for="type">属性</label> <select id="type"
								class="form-control" name="type" style="display: inline-block;">
								<option selected="selected">全部</option>
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
						<div class="form-group">
							<label for="defName">名字</label> <input type="text"
								class="form-control" id="defName" name="defName">
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
				</div>
				<c:if test="${PetSize != 0}">
					<table class="table table-striped">
						<tr>
							<th>编号</th>
							<th>名字</th>
							<th>属性</th>
						</tr>
						<c:forEach items="${PetInfo}" var="pet">
							<tr>
								<td>${pet.id }</td>
								<td><a
									href="${pageContext.request.contextPath}/monsterinfo/info/${ pet.id }">${pet.defName }</a></td>
								<td>${pet.type }</td>
							</tr>
						</c:forEach>
					</table>
					<!-- 分页容器 -->
					<div id="page" align="center"></div>
				</c:if>
				<c:if test="${PetSize == 0}">
					找不到精灵了~
				</c:if>
			</div>
			<jsp:include page="callMe.jsp"></jsp:include>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp"></jsp:include>

	<b id="url">
		 <c:if test="${defName != null && type !=null}">
							/query?defName=${defName}&type=${type }&
		</c:if> 
		<c:if test="${defName == null || type ==null}">
			<c:if test="${defName != null }">
				/query?defName=${ defName}&
			</c:if>
			<c:if test="${type != null }">
				/query?type=${type}&
			</c:if>
		</c:if>
		 <c:if test="${defName == null && type ==null}">
			?
		</c:if>
	</b>

	<script type="text/javascript">
		if ('${type}' != '') {
			$("#type").val('${type}');
		}
		$("#defName").val('${defName}');
		laypage({
		    cont: 'page',
		    pages: ${EndPageNum}, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
		    curr: ${PageNum},
		    skin: 'molv',
		    first: 1, //将首页显示为数字1,。若不显示，设置false即可
		    last: ${EndPageNum}, //将尾页显示为总页数。若不显示，设置false即可
		    prev: '<', //若不显示，设置false即可
		    next: '>', //若不显示，设置false即可
		    groups: 5, //连续显示分页数
		    jump: function(e, first){ //触发分页后的回调
		        if(!first){ //一定要加此判断，否则初始时会无限刷新
		            var str = $.trim($("#url").text());
		        	location.href = "${pageContext.request.contextPath}/monsterinfo"+$.trim(str)+"pageNum="+e.curr
		        }
		    }
		});
		$("#url").hide();
	</script>
</body>
</html>