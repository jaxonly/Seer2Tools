<%@page import="java.util.List"%>
<%@page import="com.jax.seer2tools.entity.PetDictionary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<style type="text/css">
@media (max-width: 768px) { 
  .minkd{
  	min-width:1px;
  }
}
@media (min-width: 768px) { 
  .minkd{
  	min-width:45px;
  }
}

@media (max-width: 768px) { 
  .minkds{
  	min-width:1px;
  }
}
@media (min-width: 768px) { 
  .minkds{
  	min-width:87px;
  }
}
</style>
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
				<h1>${mi.defName}
					<c:if test="${pd.isNew!=0 }">
						<span class="label label-success">New</span>
					</c:if>
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
							<c:if test="${mi.type!=null }">
								<tr>
									<td>属性</td>
									<td name="type">${mi.type }</td>
								</tr>
							</c:if>
							<c:if test="${mi.features!=null }">
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
							<c:if test="${mi.height!=null }">
								<tr>
									<td>身高</td>
									<td>${fn:split(mi.height,' ')[0]}cm-${fn:split(mi.height,' ')[1]}cm</td>
								<tr>
							</c:if>
							<c:if test="${mi.weight!=null }">
								<tr>
									<td>体重</td>
									<td>${fn:split(mi.weight,' ')[0]}kg-${fn:split(mi.weight,' ')[1]}kg</td>
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
									<td><c:if test="${mi.catchRat ==0}">
											不可捕捉
										</c:if> <c:if test="${mi.catchRat !=0}">
											${mi.catchRat }(1-255)
										</c:if></td>
								</tr>
							</c:if>
							<c:if test="${mi.gender!=null }">
								<tr>
									<td>雌雄比例</td>
									<td>${fn:replace(mi.gender, 
                                ' ', ':') }</td>
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
								<td>${mi.hp}</td>
								<td>${mi.atk+50}</td>
								<td>${mi.def+50}</td>
								<td>${mi.spAtk+50}</td>
								<td>${mi.spDef+50}</td>
								<td>${mi.spd+50}</td>
							</tr>
							<tr>
								<th>极限值</th>
								<td><fmt:formatNumber
										value="${( (mi.hp*2 + 120) * 100/100 + 100 + 10 + 255/4)
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
							<tr>
								<td colspan="7"><b>Tips:极限值不包括星魂加成</b></td>
							</tr>
						</table>
					</div>
				</div>






				<!-- 技能信息 -->
				<div class="panel panel-default">
					<div class="panel-heading">技能信息</div>
					<div class="panel-body" style="padding: 0px 0px 0px 0px">
						<table class="table">
							<tr>
								<th class="minkd" >等级</th>
								<th class="minkds">名字</th>
								<th class="minkd" >类别</th>
								<th class="minkd" >属性</th>
								<th class="minkd" >威力</th>
								<th class="minkd" >命中</th>
								<th class="minkd" >怒气</th>
								<th class="minkd" >描述</th>
							</tr>
							<c:forEach items="${Skills}" var="Skill">
								<tr>
									<c:if test="${Skill.learningLv > 100}">
										<td name="hideSkill">${Skill.skillId}</td>
									</c:if>
									<c:if test="${Skill.learningLv < 101}">
										<td>${Skill.learningLv}</td>
									</c:if>
									<td>${Skill.skill.name}</td>
									<td name="category">${Skill.skill.category}</td>
									<td name="type">${Skill.skill.type}</td>
									<td style="text-align: right">${Skill.skill.power}</td>
									<td style="text-align: right">${Skill.skill.accuracy}%</td>
									<td style="text-align: right">${Skill.skill.anger}</td>
									<td>${Skill.skill.tips}</td>
									<c:if test="${Skill.learningLv > 100}">
								</tr>
								<tr style="background-color: #fff5ee">
									<td colspan="8"><label>获得方法：</label><label
										name="hideSkillTips"></label></td>
								</tr>
								</c:if>
								<c:if test="${Skill.learningLv < 100}">
									</tr>
								</c:if>
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

		function HideMove() {
			/* http://localhost:8080/seer2tools/monsterinfo/HideMove/10260 */
			var ids = document.getElementsByName("hideSkill");
			var tips = document.getElementsByName("hideSkillTips");
			var xmlhttp = xmlhttp = new XMLHttpRequest();
			var url = "${pageContext.request.contextPath}/monsterinfo/HideMove/";
			var id = "";
			var s = "";
			for (var i = 0; i < ids.length; i++) {
				id = ids[i].innerHTML;
				s = url + id;
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						if (xmlhttp.responseText == "") {
							tips[i].innerHTML = "暂无记录"
						}else{
							tips[i].innerHTML = xmlhttp.responseText;
						}
						ids[i].innerHTML="隐藏";
					}
				}
				xmlhttp.open("GET",s,false);
				xmlhttp.send();
			}
		}
		Type();
		Category();
		HideMove();
	</script>
</body>
</html>