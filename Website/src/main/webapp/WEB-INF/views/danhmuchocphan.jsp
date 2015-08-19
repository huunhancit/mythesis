<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-1.9.1.js" />'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/bootstrap.js" />'></script>
<title>Danh mục học phần</title>
<style>
body {
	background-color: #D1FFD1;
}

#footer {
	background-color: #D1FFD1;
}

.panel-bg {
	background-color: #dff0d8;
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
					<li class="active cl"><a
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
		<!-- danh muc hoc phan  -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title" align="center">Danh mục học phần</h3>
			</div>
			<div class="panel-bg">
				<form action="searchdm" method="post">
					<!-- table comboxbox -->
					<div id="table1" align="center">
						<table>
							<tr>
								<td><label id="label1">Năm học</label></td>
								<td><select name="namhoc">
										<option value="2011-2012">2011-2012</option>
										<option value="2012-2013">2012-2013</option>
										<option value="2013-2014">2013-2014</option>
										<option value="2014-2015" selected="selected">2014-2015</option>
								</select></td>
								<td><b id="label1">Học kỳ</b></td>
								<td><select name="hocky">
										<option value="1">1</option>
										<option value="2" selected="selected">2</option>
										<option value="Hè">Hè</option>
								</select></td>
							</tr>
						</table>
					</div>
					<div align="center">
						<table>
							<tr>
								<td><b id="label1">Mã học phần</b></td>
								<td><input type="text" placeholder="Nhập mã học phần" name="search"></td>
								<td>&nbsp;&nbsp;&nbsp;<input type="submit" value="Tìm kiếm"
									class="btn btn-primary btn-xs"></td>
							</tr>
						</table>
					</div>
					<!-- tket thuc text box tim kiem -->
				</form>
			</div>
			<div class="panel panel-success">
				<div class="panel-heading" align="center">Danh sách lớp học
					phần</div>
				<div class="panel panel-success">
					<table class="table">
						<tr align="center" bgcolor="#dff0d8">
							<td><label>Mã học phần: </label>
								&nbsp;&nbsp;${hocphan.mahocphan }</td>
							<td><label>Tên học phần: </label>&nbsp;&nbsp;${hocphan.tenhocphan }</td>
							<td><label>Số tín chỉ:</label>&nbsp;&nbsp;${hocphan.sotc }</td>
						</tr>
					</table>
				</div>
				<div class="panel-body" align="center">
					<table class="table table-bordered" style="width: 80%;">
						<thead>
							<tr bgcolor="">
								<th width="60px">STT</th>
								<th>Mã lớp HP</th>
								<th>Sĩ số</th>
								<th>Sĩ số còn lại</th>
								<th>Thời khóa biểu</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="a1" items="${lop }" varStatus="theCount">
								<tr>
									<td>${theCount.index + 1}</td>
									<td>${a1.malophocphan }</td>
									<td>${a1.siso }</td>
									<td>${a1.sisoconlai }</td>
									<td>
										<button class="btn btn-primary btn-xs" data-toggle="modal"
											data-target="#btn${theCount.index + 1 }">Xem chi
											tiết</button>
									</td>
									<td>
										<div class="modal fade" id="btn${theCount.index + 1 }"
											tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel" align="center">Thời
															khóa biểu - Mã lớp học phần: ${a1.malophocphan }</h4>
													</div>
													<div class="modal-body">
														<c:forEach var="j" items="${a1.dothoc }">
															<table class="table table-bordered">
																<thead>
																	<tr>
																		<th colspan="4"><p align="center">${j.tendot }
																				- Tuần học : ${j.tuanhoc }</p></th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td align="center" width="70">STT</td>
																		<td align="center">Thứ</td>
																		<td align="center">Tiết</td>
																		<td align="center">Phòng học</td>
																	</tr>
																	<c:forEach var="e" items="${j.buoi }"
																		varStatus="count1">
																		<tr>
																			<td align="center">${count1.index + 1 }</td>
																			<td align="center">${e.thu }</td>
																			<td align="center">${e.tiet }</td>
																			<td align="center">${e.phong }</td>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</c:forEach>

													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">Close</button>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
							<tr><td colspan="6"><b>Tổng số lớp học phần: ${size }</b></td></tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<!-- ket thuc danh muc hoc phan  -->
		<!-- Panel footer  -->
		<div class="panel-footer" id="footer" align="center">
			<p>
				Trường Đại học Cần Thơ (Can Tho University)<br> Khu II, đường
				3/2, P. Xuân Khánh, Q. Ninh Kiều, TP. Cần Thơ.<br> Điện thoại:
				(84-0710) 3832663 - (84-0710) 3838474; Fax: (84-0710) 3838474;
				Email: dhct@ctu.edu.vn.
			</p>
		</div>
		<!-- key thuc panel footer  -->
	</div>

</body>
</html>