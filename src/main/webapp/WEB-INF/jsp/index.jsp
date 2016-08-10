<%@page import="java.util.List"%>
<%@page import="com.jax.seer2tools.entity.PetDictionary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>精灵信息查询工具-最详细的精灵信息查询工具</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 100px"></div>
	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">精灵信息查询工具</h1>
			<p class="lead blog-description">最详细的精灵信息查询工具，只有想不到，没有查不到~</p>

		</div>
		<div class="row">
			<div class="col-sm-8 blog-main">
				<div style="float: right;">
					<form class="form-inline"
						action="${pageContext.request.contextPath}/monsterinfo/query"
						method="get">
						<div class="form-group">
							<label for="type">属性</label> <select id="type"
								class="form-control" name="type" style="display: inline-block;">
								<option value="" selected="selected">全部</option>
								<option value="1">普通</option>
								<option value="2">草</option>
								<option value="3">水</option>
								<option value="4">火</option>
								<option value="5">风</option>
								<option value="6">虫</option>
								<option value="7">飞行</option>
								<option value="8">电</option>
								<option value="9">地面</option>
								<option value="10">冰</option>
								<option value="11">超能</option>
								<option value="12">光</option>
								<option value="13">暗影</option>
								<option value="14">战斗</option>
								<option value="15">龙</option>
								<option value="16">沙漠</option>
								<option value="17">神秘</option>
								<option value="18">特质</option>
								<option value="19">基佬王</option>
								<option value="20">上古</option>
								<option value="21">圣灵</option>
							</select>
						</div>
						<div class="form-group">
							<label for="star">星级</label> <select id="star"
								class="form-control" name="star" style="display: inline-block;">
								<option value="" selected="selected">全部</option>
								<option value="1">❤</option>
								<option value="2">❤❤</option>
								<option value="3">❤❤❤</option>
								<option value="4">❤❤❤❤</option>
								<option value="5">❤❤❤❤❤</option>
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
							<th>星级</th>
						</tr>
						<c:forEach items="${PetInfo}" var="pet">
							<tr>
								<td>${pet.id }</td>
								<td><a
									href="${pageContext.request.contextPath}/monsterinfo/info/${ pet.id }">
										${pet.defName }
										<c:if test="${pet.isNew != 0 }">
											<span class="label label-success">New</span>
										</c:if>
									</a>
								</td>
								<td name="types">${pet.type }</td>
								<td name="stars">${pet.star }</td>
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
		<c:if test="${ !empty defName && !empty type && !empty star}">
				/query?defName=${defName}&type=${type}&
		</c:if> 
		<c:if test="${ !empty defName || !empty type || !empty star}">
			/query?
			<c:if test="${ !empty defName}">
				defName=${defName}&
			</c:if>
			<c:if test="${ !empty type}">
				type=${type}&
			</c:if>
			<c:if test="${ !empty star}">
				star=${star}&
			</c:if>
		</c:if> 
		<c:if test="${ empty defName && empty type && empty star}">
			?
		</c:if>
	</b>

	<script type="text/javascript">
		if ('${type}' != '') {
			$("#type").val('${type}');
		}
		if ('${star}' != '') {
			$("#star").val('${star}');
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
		
		function Type() {
			items = document.getElementsByName("types");
			for (var int = 0; int < items.length; int++) {
				var element = items[int];
				var te = element.innerText;
				switch (te) {
				case '1':
					te = '普通';
					break;
				case '2':
					te = '草';
					break;
				case '3':
					te = '水';
					break;
				case '4':
					te = '火';
					break;
				case '5':
					te = '风';
					break;
				case '6':
					te = '虫';
					break;
				case '7':
					te = '飞行';
					break;
				case '8':
					te = '电';
					break;
				case '9':
					te = '地面';
					break;
				case '10':
					te = '冰';
					break;
				case '11':
					te = '超能';
					break;
				case '12':
					te = '光';
					break;
				case '13':
					te = '暗影';
					break;
				case '14':
					te = '战斗';
					break;
				case '15':
					te = '龙';
					break;
				case '16':
					te = '沙漠';
					break;
				case '17':
					te = '神秘';
					break;
				case '18':
					te = '特质';
					break;
				case '19':
					te = '基佬王';
					break;
				case '20':
					te = '上古';
					break;
				case '21':
					te = '圣灵';
					break;
				default:
					te = '未知';
					break;
				}
				element.innerText = te;
			}
		}
		Type();
		function Star() {
			items = document.getElementsByName("stars");
			for (var i = 0; i < items.length; i++) {
				var element = items[i];
				var te = "";
				if (element.innerText=="0") {
					te="未知";
				}
				for (var j = 0; j < element.innerText; j++) {
					te+="❤";
				}
				element.innerText = te;
			}
		}
		Star();
	</script>
</body>
</html>