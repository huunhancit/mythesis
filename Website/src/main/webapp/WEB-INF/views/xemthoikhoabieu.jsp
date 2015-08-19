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
<script src="<c:url value="/resources/js/jquery.min.js" />">
	
</script>
<title>Thời khóa biểu</title>
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
					<li class="cl"><a
						href="${pageContext.request.contextPath }/dkhp">Thông tin sinh
							viên</a></li>
					<li class="cl"><a
						href="${pageContext.request.contextPath }/danhmuchocphan">Danh
							mục học phần </a></li>
					<li class="cl"><a href="#">Quy định</a></li>
					<li class="cl"><a
						href="${pageContext.request.contextPath }/dangkyhocphan">Đăng
							ký học phần</a></li>
					<li class="active cl"><a
						href="${pageContext.request.contextPath }/thoikhoabieu">Thời
							khóa biểu </a></li>
				</ul>
			</div>
		</div>
		<br>
		<!-- ket thuc menu  -->

		<!-- thoi khoa bieu  -->
		<!-- thanh dieu khien comnbox -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<center>
					<h3 class="panel-title">Thời khóa biểu</h3>
				</center>
			</div>

			<center>
				<div id="table1">
					<form action="xemthoikhoabieu" method="post">
						<table>
							<tr>
								<td><b id="label1">Năm học</b></td>
								<td><select id="idnamhoc" name="namhoc">
										<option value="2014-2015" selected="selected">2014 -
											2015</option>
										<option value="2013-2014">2013 - 2014</option>
										<option value="2012-2013">2012 - 2013</option>
										<option value="2011-2012">2011 - 2012</option>
								</select></td>
								<td><b id="label1">Năm học</b></td>
								<td><select id="idhocky" name="hocky">
										<option value="1">1</option>
										<option value="2" selected="selected">2</option>
										<option value="Hè">Hè</option>
								</select></td>
								<td>&nbsp;&nbsp;&nbsp;<input type="submit" value="Xem"
									class="btn btn-primary btn-xs"></td>
							</tr>
						</table>
					</form>
					<form action="xembytuan" method="post">
						<table>
							<tr>
								<td><b id="label1">Tuần học</b></td>
								<td><select name="tuan">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
								</select></td>
								<td>&nbsp;&nbsp;&nbsp;<input type="submit"
									value="Xem theo tuần" class="btn btn-primary btn-xs"></td>
							</tr>
						</table>
					</form>
				</div>
			</center>


			<!--  ket thuc thanh dieu khien comnbox -->
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="panel panel-success">
						<div class="panel-heading">
							<center>Thời khóa biểu - Học kỳ: ${sessionScope.hocky }
								- Năm học: ${sessionScope.namhoc }</center>
						</div>
						<div class="panel-body">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th width="40">STT</th>
										<th>Mã học phần</th>
										<th>Tên học phần</th>
										<th>Mã lớp học phần</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="i" items="${tkb }" varStatus="theCount">
										<tr bgcolor="#5C5CFF">
											<td>${theCount.index + 1}</td>
											<td>${i.mahocphan }</td>
											<td>${i.tenhocphan }</td>
											<td>${i.malophocphan }</td>
										</tr>
										<c:forEach var="j" items="${i.dothoc }" varStatus="theCount1">
											<tr>
												<td></td>
												<td colspan="3" bgcolor="#ADADFF">Tuần
													học&nbsp;:&nbsp;&nbsp;${j.tuanhoc }</td>
											</tr>
											<c:forEach var="j2" items="${j.buoi }" varStatus="theCount2">
												<tr>
													<td></td>
													<td>Thứ&nbsp;:&nbsp;${j2.thu }</td>
													<td>Tiết&nbsp;:&nbsp;${j2.tiet }</td>
													<td>Phòng&nbsp;:&nbsp;${j2.phong }</td>
												</tr>
											</c:forEach>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ket thuc thoi khoa bieu  -->

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