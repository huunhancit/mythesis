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
	background-color: #D1FFD1;
}

#footer {
	background-color: #D1FFD1;
}
</style>
</head>
<body>
	<div class="container">
		<!--header  -->
		<div class="row" id="header">
			<div class="col-md-12">
				<img alt="This is banner"
					src="<c:url value="/resources/image/banner.png" />">
			</div>
		</div>
		<!-- ket thuc header  -->

		<!-- noi dung  -->
		<div class="content">
			<div class="row">

				<div class="col-md-1"></div>
				<!-- form login -->
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong class="">Đăng Nhập</strong>
						</div>

						<div class="panel-body">
							<form:form commandName="student" action="checklogin"
								method="post">
								<div class="form-group">
									<label>Mã số đăng nhập</label>
									<form:input path="mssv" cssClass="form-control"
										placeholder="Nhập mã số đăng nhập" />
								</div>
								<div class="form-group">
									<label>Mật khẩu</label>
									<form:password path="password" cssClass="form-control"
										placeholder="Nhập mật khẩu" />
								</div>
								<center>
									<input type="submit" class="btn btn-success btn-block"
										value="Đăng Nhập">
								</center>
							</form:form>
							${fail }
						</div>
					</div>
				</div>
				<!--/ ket login form  -->


				<!-- panel thong bao -->
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<center>
								<strong class="">THÔNG BÁO MỚI NHẤT </strong>
							</center>
						</div>
						<div class="panel-body">
							<ol type="1">
								<li><a href="#">Thong bao 1 </a></li>
								<li><a href="#">Thong bao 1 </a></li>
								<li><a href="#">Thong bao 1 </a></li>
								<li><a href="#">Thong bao 1 </a></li>
								<li><a href="#">Thong bao 1 </a></li>
							</ol>
						</div>
					</div>
				</div>
				<!-- Ket thuc panel thong bao  -->
			</div>
		</div>
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
	</div>
</body>

</html>