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
<title>Đăng ký học phần</title>
</head>
<style>
body {
	background-color: #E6FFE6;
}

.tdb {
	font-weight: bold;
}
</style>
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
		<!-- menu  -->
		<div class="row ">
			<div class="col-md-12 font-menu">
				<ul class="nav nav-tabs">
					<li class="active cl"><a
						href="${pageContext.request.contextPath }/dkhp">Thông tin sinh
							viên</a></li>
					<li class="cl"><a
						href="${pageContext.request.contextPath }/danhmuchocphan">Danh
							mục học phần </a></li>
					<li class="cl"><a href="#">Quy định</a></li>
					<li class="cl"><a
						href="${pageContext.request.contextPath }/dangkyhocphan">Đăng
							ký học phần</a></li>
					<li class="cl"><a
						href="${pageContext.request.contextPath }/thoikhoabieu">Thời
							khóa biểu </a></li>
				</ul>
			</div>
		</div>
		<br>
		<!-- ket thuc menu  -->
		<!-- Thong tin sinh vien -->
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>
							<h3 class="panel-title">Thông tin sinh viên</h3>
						</center>
					</div>
					<div class="panel-body">
						<table class="table table-condensed table-hover">
							<tbody>
								<tr>
									<td width="150px" class="tdb">Mã số sinh viên:</td>
									<td>${sv.mssv }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Họ tên:</td>
									<td>${sv.hoten }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Địa chỉ:</td>
									<td>${sv.diachi }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Giới tính:</td>
									<td>${sv.gioitinh }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Ngày sinh:</td>
									<td>${sv.ngaysinh }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Lớp:</td>
									<td>${sv.lop  }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Khóa học:</td>
									<td>${sv.khoahoc }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Ngành học:</td>
									<td>${sv.nganhhoc }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb">Khoa:</td>
									<td>${sv.khoa }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- Panel footer  -->
		<div class="panel-footer" id="footer">
			<center>
				<p>
					Trường Đại học Cần Thơ (Can Tho University)<br> Khu II, đường
					3/2, P. Xuân Khánh, Q. Ninh Kiều, TP. Cần Thơ.<br> Điện thoại:
					(84-0710) 3832663 - (84-0710) 3838474; Fax: (84-0710) 3838474;
					Email: dhct@ctu.edu.vn.
				</p>
			</center>
		</div>
		<!-- key thuc panel footer  -->
	</div>
</body>
</html>