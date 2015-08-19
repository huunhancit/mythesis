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
<title>Kế Hoạch</title>
<style>
body {
	background-color: #E6FFE6;
}
</style>
</head>
<body>
	<div class="container">
		<!--header  -->
		<div class="row" id="header">
			<div class="col-md-12">
				<p id="ms">
					<a href="${pageContext.request.contextPath }/logout"><button
							type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-log-out"></span> Thoát
						</button></a><br> <a href="${pageContext.request.contextPath }/showhome"><button
							type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-home"></span> Trang chủ
						</button></a><br> ${sessionScope.hoten } (${sessionScope.ms })
				</p>
				<img alt="This is banner"
					src="<c:url value="/resources/image/banner.png" />">
			</div>
		</div>
		<!-- ket thuc header  -->
		<!-- noi dung trang ke hoach  -->
		<br>
		<!-- menu  -->
		<div class="row ">
			<div class="col-md-12 font-menu">
				<ul class="nav nav-tabs">
					<li class="cl"><a
						href="${pageContext.request.contextPath }/kehoach">Xem kế
							hoạch toàn khóa</a></li>
					<li class="cl active"><a
						href="${pageContext.request.contextPath }/importdanhsachlop">Import
							danh sach lớp </a></li>
				</ul>
			</div>
		</div>
		<br>
		<!-- ket thuc menu  -->
		<!-- bang hoc phan  -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>Import danh sách lớp học phần</center>
					</div>
					<!-- body ke hoach  -->
					<div class="panel-body" id="kehoach">
						<form action="importdanhsachlop" method="post"
							enctype="multipart/form-data">
							<div align="right">
								<span class="btn btn-default btn-file"><input type="file"
									name="filelop" /></span> <input type="submit" value="Import"
									class="btn btn-primary">
							</div>
						</form>
					</div>
					<!-- ket thuc body ke hoach  -->
				</div>
			</div>
		</div>
		<!-- ket thuc bang hoc phan  -->
		<!-- ket thuc noi dung ke hoach -->
		<hr id="hrr">
		<!-- Panel footer  -->
		<div class="row" id="footer">
			<div class="col-md-12">
				<center>
					<p>
						Trường Đại học Cần Thơ (Can Tho University)<br> Khu II, đường
						3/2, P. Xuân Khánh, Q. Ninh Kiều, TP. Cần Thơ.<br> Điện
						thoại: (84-0710) 3832663 - (84-0710) 3838474; Fax: (84-0710)
						3838474; Email: dhct@ctu.edu.vn.
					</p>
				</center>
			</div>
		</div>
	</div>
	${status }
	<!-- key thuc panel footer  -->
</body>
</html>