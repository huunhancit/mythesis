<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet" type="text/css" />
<title>Danh Sách Học Phần</title>
<style>
body {
	background-color: #D1FFD1;
}

#footer {
	background-color: #D1FFD1;
}
</style>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<center>
				<h3 class="panel-title">Danh sách lóp học phần: ${mahocphan }</h3>
			</center>
		</div>
		<div class="panel-body">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>STT</th>
						<th>Mã lớp học phần</th>
						<th>Sĩ số</th>
						<th>Sĩ số còn lại</th>
						<th>Chọn lớp học phần</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${ds }" varStatus="theCount">
						<tr>
							<td>${theCount.index + 1}</td>
							<td>${i.malophocphan }</td>
							<td>${i.siso }</td>
							<td>${i.sisoconlai }</td>
							<td>
								<form
									action="${pageContext.request.contextPath }/thaydoilop/${mahocphan }/${malophocphancu }/${i.malophocphan }"
									method="get" id="for1">
									<input type="submit" value="Chọn học phần"
										class="btn btn-block btn-success btn-xs">
								</form>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5">Tổng số : ${tslop } học phần</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	${ja }
<!-- 	onclick="CloseAndRefresh();" -->
</body>
<script type="text/javascript">
	function CloseAndRefresh() {
		window.onunload = refreshParent;
		function refreshParent() {
			window.opener.location.reload();
			window.close();
		}
	}
</script>
</html>