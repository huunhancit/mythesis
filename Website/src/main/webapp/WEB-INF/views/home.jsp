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
<title>Login</title>
<style>
body {
	background-color: #E6FFE6;
}

.tdb {
	font-weight: bold;
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

		<!-- noi dung  -->
		<div class="row">
			<!-- columm thong tin sinh vien -->

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
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Mã số sinh viên:</td>
									<td bgcolor="#E0EBEB">${sv.mssv }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Họ tên:</td>
									<td bgcolor="#E0EBEB">${sv.hoten }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Địa chỉ:</td>
									<td bgcolor="#E0EBEB">${sv.diachi }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Giới tính:</td>
									<td bgcolor="#E0EBEB">${sv.gioitinh }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Ngày sinh:</td>
									<td bgcolor="#E0EBEB">${sv.ngaysinh }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Lớp:</td>
									<td bgcolor="#E0EBEB">${sv.lop  }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Khóa học:</td>
									<td bgcolor="#E0EBEB">${sv.khoahoc }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Ngành học:</td>
									<td bgcolor="#E0EBEB">${sv.nganhhoc }</td>
								</tr>
								<tr>
									<td width="150px" class="tdb" bgcolor="#E0EBEB">Khoa:</td>
									<td bgcolor="#E0EBEB">${sv.khoa }</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- ket thuc columm thong tin sinh vien -->
			<!-- columm menu  -->
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>
							<h3 class="panel-title">Menu</h3>
						</center>
					</div>
					<div class="panel-body">
						<!-- dong menu  -->
						<!--dong 1 -->
						<div class="row">
							<div class="col-md-6">
								<center>
									<a href="${pageContext.request.contextPath }/kehoach"> <span><img
											src="<c:url value="/resources/image/khht.gif"/>"></span></a><br>
									<b>Kế hoạch</b>
								</center>
							</div>
							<div class="col-md-6">
								<center>
									<a href="${pageContext.request.contextPath }/dkhp"> <span><img
											src="<c:url value="/resources/image/dkhp.gif"/>"></span></a><br>
									<b> Đăng Ký Học Phần </b>
								</center>
							</div>
						</div>
						<!--ket thuc dong 1 -->
						<!-- dong 2 -->
						<div class="row">
							<div class="col-md-6">
								<center>
									<a href="#"> <span><img
											src="<c:url value="/resources/image/diem.gif"/>"></span></a><br>
									<b>Kết quả học tập</b>
								</center>
							</div>
							<br>
							<div class="col-md-6">
								<center>
									<a href="#"> <span><img
											src="<c:url value="/resources/image/kequa.gif"/>"></span></a><br>
									<b> Kết qủa tốt nghiệp </b>

								</center>
							</div>
						</div>
						<!-- ket thuc dong 2 -->
						<!-- dong 3 -->
						<div class="row">
							<div class="col-md-6">
								<center>
									<a href="#"> <span><img
											src="<c:url value="/resources/image/nckh.jpg"/>"></span></a><br>
									<b>Nghiên cứu khoa học</b>
								</center>
							</div>
							<br>
							<div class="col-md-6">
								<center>
									<a href="#"> <span><img
											src="<c:url value="/resources/image/ktx.png"/>"></span></a><br><br>
									<b> Ký túc xá </b>

								</center>
							</div>
						</div>
						<!-- ket thuc dong3 -->
					</div>
					<!-- ket thuc dong menu  -->
				</div>
			</div>
		</div>
		<!-- ket thuc columm menu -->
	</div>
	<!-- ket thuc noi dung -->
	<hr id="hrr">
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
</body>
</html>