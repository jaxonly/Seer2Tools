<%@page import="java.util.List"%>
<%@page import="com.jax.seer2tools.entity.PetDictionary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	
%>
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
<title>Info</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 100px"></div>
	<div class="container">
		<div class="blog-header">
			<div class="page-header">
				<h1>${pd.defName}


					<c:if test="${mi.freeForbidden==0 }">
						<span class="label label-success">可放生</span>
					</c:if>

					<c:if test="${mi.ride!=0 }">
						<span class="label label-success">骑宠</span>
					</c:if>

				</h1>
			</div>
			<p class="lead blog-description">${pd.intro}</p>
		</div>
		<div class="row">
			<div class="col-sm-8 blog-main">


				<!-- 基本信息 -->
				<div class="panel panel-default">
					<div class="panel-heading">基本信息</div>
					<div class="panel-body" style="padding: 0px 0px 0px 0px">
						<table class="table table-striped">
							<c:if test="${pd.type!=null }">
								<tr>
									<td>属性</td>
									<td>${pd.type }</td>
								</tr>
							</c:if>
							<c:if test="${pd.features!=null }">
								<tr>
									<td>特性</td>
									<td>${pd.features }</td>
								<tr>
							</c:if>
							<c:if test="${pd.emblem.name!=null }">
								<tr>
									<td>纹章</td>
									<td>${pd.emblem.name }<br>${pd.emblem.tip }</td>
								<tr>
							</c:if>
							<c:if test="${pd.height!=null }">
								<tr>
									<td>身高</td>
									<td>${pd.height }</td>
								<tr>
							</c:if>
							<c:if test="${pd.weight!=null }">
								<tr>
									<td>体重</td>
									<td>${pd.weight }</td>
								<tr>
							</c:if>
							<c:if test="${pd.foundin!=null }">
								<tr>
									<td>获取方式</td>
									<td>${pd.foundin }</td>
								<tr>
							</c:if>
							<c:if test="${pd.chara!=null }">
								<tr>
									<td>推荐性格</td>
									<td>${pd.chara }</td>
								<tr>
							</c:if>
							<c:if test="${pd.charaPoint!=null }">
								<tr>
									<td>推荐属性加点</td>
									<td>${pd.charaPoint }</td>
								<tr>
							</c:if>
							<c:if test="${pd.recommendQuality!=null }">
								<tr>
									<td>推荐加点</td>
									<td>${pd.recommendQuality }</td>
								<tr>
							</c:if>
							<c:if test="${pd.recommendSkill!=null }">
								<tr>
									<td>推荐技能</td>
									<td>${pd.recommendSkill }</td>
								<tr>
							</c:if>
							<c:if test="${pd.changeTip!=null }">
								<tr>
									<td>变身提示</td>
									<td>${pd.changeTip }</td>
								<tr>
							</c:if>


							<c:if test="${mi.evolvesFromInfo.id!=0 }">
								<tr>
									<td>上一形态</td>
									<td><a
										href="${pageContext.request.contextPath}/monsterinfo/info/${ mi.evolvesFromInfo.id }">${mi.evolvesFromInfo.defName }</a></td>
								<tr>
							</c:if>
							<c:if test="${mi.evolvesToInfo.id!=0 }">
								<tr>
									<td>下一形态</td>
									<td><a
										href="${pageContext.request.contextPath}/monsterinfo/info/${ mi.evolvesToInfo.id }">${mi.evolvesToInfo.defName }</a></td>
								<tr>
								<tr>
									<td>进化下一形态等级</td>
									<td>${mi.evolvesLv}</td>
								<tr>
							</c:if>
						</table>
					</div>
				</div>

				<!-- 拓展信息 -->
				<div class="panel panel-default">
					<div class="panel-heading">拓展信息</div>
					<div class="panel-body" style="padding: 0px 0px 0px 0px">
						<table class="table table-striped">
							<c:if test="${mi.growthType!=null }">
								<tr>
									<td>成长类型</td>
									<td>${mi.growthType }</td>
								</tr>
							</c:if>
							<c:if test="${mi.yieldingExp!=null }">
								<tr>
									<td>被击败产生经验值</td>
									<td>${mi.yieldingExp }</td>
								</tr>
							</c:if>
							<c:if test="${mi.yieldingEv!=null }">
								<tr>
									<td>被击败产生学习力</td>
									<td>${mi.yieldingEv }</td>
								</tr>
							</c:if>
							<c:if test="${mi.catchRat!=null }">
								<tr>
									<td>捕捉率</td>
									<td>${mi.catchRat }</td>
								</tr>
							</c:if>
							<c:if test="${mi.gender!=null }">
								<tr>
									<td>雌雄比例</td>
									<td>${mi.gender }</td>
								</tr>
							</c:if>
							<c:if test="${mi.useNum!=null }">
								<tr>
									<td>同时上场精灵数</td>
									<td><c:if test="${mi.useNum == 0}">
											无限制
										</c:if> <c:if test="${mi.useNum != 0}">
											${mi.useNum }
										</c:if></td>
								</tr>
							</c:if>
						</table>
					</div>
				</div>


				<div class="panel panel-default">
					<div class="panel-heading">数值信息</div>
					<div class="panel-body" style="padding: 0px 0px 0px 0px">
						<table class="table table-striped">
							<tr>
								<th></th>
								<th>体力</th>
								<th>物攻</th>
								<th>物防</th>
								<th>特攻</th>
								<th>特防</th>
								<th>速度</th>
							</tr>
							<tr>
								<th>基础值</th>
								<td>${mi.hp}</td>
								<td>${mi.atk}</td>
								<td>${mi.def}</td>
								<td>${mi.spAtk}</td>
								<td>${mi.spDef}</td>
								<td>${mi.spd}</td>
							</tr>
							<tr>
								<th>种族值</th>
								<td>${mi.hp+50}</td>
								<td>${mi.atk+50}</td>
								<td>${mi.def+50}</td>
								<td>${mi.spAtk+50}</td>
								<td>${mi.spDef+50}</td>
								<td>${mi.spd+50}</td>
							</tr>
							<tr>
								<th>极限值</th>
								<td><fmt:formatNumber
										value="${( (mi.hp*2 + 120) * 100/100 + 100 + 10 + 255/4) *1.1
}"
										pattern="#" /></td>
								<td><fmt:formatNumber
										value="${( (mi.atk*2 + 120) * 100/100 + 100 + 10 + 255/4) *1.1
}"
										pattern="#" /></td>
								<td><fmt:formatNumber
										value="${( (mi.def*2 + 120) * 100/100 + 100 + 10 + 255/4) *1.1
}"
										pattern="#" /></td>
								<td><fmt:formatNumber
										value="${( (mi.spAtk*2 + 120) * 100/100 + 100 + 10 + 255/4) *1.1
}"
										pattern="#" /></td>
								<td><fmt:formatNumber
										value="${( (mi.spDef*2 + 120) * 100/100 + 100 + 10 + 255/4) *1.1
}"
										pattern="#" /></td>
								<td><fmt:formatNumber
										value="${( (mi.spd*2 + 120) * 100/100 + 100 + 10 + 255/4) *1.1
}"
										pattern="#" /></td>
							</tr>
						</table>
					</div>
				</div>






				<!-- 技能信息 -->
				<div class="panel panel-default">
					<div class="panel-heading">技能信息</div>
					<div class="panel-body" style="padding: 0px 0px 0px 0px">
						<table class="table table-striped">
							<tr>
								<th>等级</th>
								<th>名字</th>
								<th>类别</th>
								<th>属性</th>
								<th>威力</th>
								<th>命中</th>
								<th>怒气</th>
								<th>描述</th>
							</tr>
							<c:forEach items="${Skills}" var="Skill">
								<tr>
									<td><c:if test="${Skill.learningLv > 100}">
											隐藏技能
										</c:if> <c:if test="${Skill.learningLv < 101}">
											${Skill.learningLv}
										</c:if></td>
									<td>${Skill.skill.name}</td>
									<td name="category">${Skill.skill.category}</td>
									<td name="type">${Skill.skill.type}</td>
									<td>${Skill.skill.power}</td>
									<td>${Skill.skill.accuracy}%</td>
									<td>${Skill.skill.anger}</td>
									<td>${Skill.skill.tips}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<jsp:include page="callMe.jsp"></jsp:include>
			<!-- /.blog-sidebar -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		function Type() {
			items = document.getElementsByName("type");
			for (var int = 0; int < items.length; int++) {
				var element = items[int];
				var te = element.innerText;
				switch (te) {
				case '1':
					te = '普通';
					break;
				break;
			case '2':
				te = '草';
				break;
			break;
		case '3':
			te = '水';
			break;
		break;
	case '4':
		te = '火';
		break;
	break;
case '5':
	te = '风';
	break;
break;
case '6':
te = '虫';
break;
break;
case '7':
te = '飞行';
break;
break;
case '8':
te = '电';
break;
break;
case '9':
te = '地面';
break;
break;
case '10':
te = '冰';
break;
break;
case '11':
te = '超能';
break;
break;
case '12':
te = '光';
break;
break;
case '13':
te = '暗影';
break;
break;
case '14':
te = '战斗';
break;
break;
case '15':
te = '龙';
break;
break;
case '16':
te = '沙漠';
break;
break;
case '17':
te = '神秘';
break;
break;
case '18':
te = '特质';
break;
break;
case '19':
te = '基佬王';
break;
break;
case '20':
te = '上古';
break;
break;
case '21':
te = '圣灵';
break;
break;
default:
te = '未知';
break;
break;
}
element.innerText = te;
}
}

function Category() {
items = document.getElementsByName("category");
for (var int = 0; int < items.length; int++) {
var element = items[int];
var te = element.innerText;
switch (te) {
case '1':
te = '物理';
break;
case '2':
te = '特殊';
break;
case '4':
te = '属性';
break;
case '80':
te = '必杀';
break;
default:
te = '隐藏必杀';
break;
}
element.innerText = te;
}
}

Type();
Category();
	</script>
</body>
</html>