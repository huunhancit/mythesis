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
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Đăng ký hoc phần</title>
<style>
body {
	background-color: #D1FFD1;
}

#footer {
	background-color: #D1FFD1;
}

html {
	font-size: 100%;
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
					<li class="active cl"><a
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
		<!-- dang ky hoc phan  -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<center>
					<small>MSSV: &nbsp;${sessionScope.ms }&nbsp;-&nbsp;Họ
						tên:&nbsp;${sessionScope.hoten }</small>
				</center>
			</div>
			<div class="panel-default">
				<center>
					<font color="red"> Học kỳ: &nbsp;${sessionScope.hocky }&nbsp;-&nbsp;Năm
						học:&nbsp;${sessionScope.namhoc }</font>
				</center>
			</div>
			<center>
				<font color="red">${dkfail }</font> ${thongtindangky }
			</center>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<center>
									<small>Danh sách học phần theo kế hoạch - Học kỳ:
										${sessionScope.hocky } - Năm học: &nbsp;${sessionScope.namhoc }</small>
								</center>
							</div>
							<div class="panel-body" style='overflow: auto; height: 300px;'>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th align="center">STT</th>
											<th><center>Mã HP</center></th>
											<th>Tên học phần</th>
											<th><center>Số TC</center></th>
											<th><center>Chọn</center></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="i" items="${dshp }" varStatus="theCount">
											<tr>
												<td><center>${theCount.index + 1}</center></td>
												<td><center>${i.mahocphan }</center></td>
												<td>${i.tenhocphan }</td>
												<td><center>${i.sotc }</center></td>
												<td width="100px"><center>
														<c:choose>
															<c:when test="${i.trangthai =='1' }">
																<font color="red">Đã đăng ký</font>
															</c:when>
															<c:otherwise>
																<input type="radio" name="chon"
																	onclick="clickRadio('${i.mahocphan }');"
																	class="btn btn-xs btn-warning btn-block"
																	value="Xem lớp học phần">
															</c:otherwise>
														</c:choose>
													</center></td>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="4" align="right">Tổng số học phần:</td>
											<td>${tonghp }</td>
										</tr>
										<tr>
											<td colspan="4" align="right">Tổng số tín chi:</td>
											<td>${tongtc }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<!-- danh sach lop hoc phan  -->
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<center>
									<small>Danh sách lớp học phần : ${mahp }</small>
								</center>
							</div>
							<div class="panel-body" style='overflow: auto; height: 300px;'>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th><center>STT</center></th>
											<th><center>Mã HP</center></th>
											<th><center>Mã Lớp HP</center></th>
											<th>Sĩ số</th>
											<th>Sĩ số còn lại</th>
											<th><center>Đăng ký</center></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="i" items="${lop }" varStatus="theCount">
											<tr bgcolor="#CCFFFF">
												<td>${theCount.index + 1 }</td>
												<td>${i.mahocphan }</td>
												<td>${i.malophocphan }</td>
												<td>${i.siso }</td>
												<td>${i.sisoconlai }</td>
												<td><form
														action="${pageContext.request.contextPath }/dkhocphan/${i.mahocphan	}/${i.malophocphan }"
														method="post">
														<input type="submit" value="Đăng ký"
															class="btn btn-danger btn-xs btn-block">
													</form></td>
											<tr>
												<td colspan="6"><div>
														<table class="table table-bordered">
															<c:forEach var="j" items="${i.dothoc }">
																<tr>
																	<td colspan="4"><center>${j.tendot }-Tuần
																			học : ${j.tuanhoc }</center></td>
																</tr>

																<c:forEach var="j2" items="${j.buoi }">
																	<tr>
																		<td>Thứ: ${j2.thu }</td>
																		<td colspan="2">Tiết học: ${j2.tiet }</td>
																		<td colspan="2">Phòng học: ${j2.phong }</td>
																	</tr>
																</c:forEach>

															</c:forEach>
														</table>
													</div></td>
											</tr>
											<tr>
												<td colspan="6">Tổng số lớp học phần : ${size }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					${a }
				</div>
				<!--ket thuc class row  -->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<center>
									<small>Kết quả đăng ký học phần - Năm học:
										${sessionScope.namhoc } - Học kỳ: ${sessionScope.hocky }</small>
								</center>
							</div>
							<div class="panel-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>STT</th>
											<th><center>Mã Lớp HP</center></th>
											<th>Tên học phần</th>
											<th><center>Số tc</center></th>
											<th><center>Mã lớp học phần</center></th>
											<th><center>Lớp học phần</center></th>
											<th><center>Xóa</center></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="ma" items="${hocphandangky }"
											varStatus="theCount">
											<tr>
												<td width="40"><center>${theCount.index + 1}</center></td>
												<td width="180"><center>${ma.mahocphan }</center></td>
												<td>${ma.tenhocphan }</td>
												<td width="80"><center>${ma.sotc }</center></td>
												<td width="200"><center>${ma.malophocphan }</center></td>
												<td width="150"><input type="button" value="Thay Đổi"
													onclick="thaydoi('${ma.mahocphan}','${ma.malophocphan }'); "
													class="btn btn-xs btn-warning btn-block"></td>
												<td width="50">
													<form
														action="${pageContext.request.contextPath }/xoa/${ma.malophocphan }/${ma.mahocphan }"
														method="post">
														<input type="submit" value="Xóa"
															onclick="javascript:return xoaConfirm();"
															class="btn btn-xs btn-warning btn-block">
													</form>
												</td>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="6" align="right">Tổng số tín chỉ:</td>
											<td>${tongtcdk }</td>
										</tr>
										<tr>
											<td colspan="6" align="right">Tổng số học phần:</td>
											<td>${tonghpdk }</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ket thuc dang ky hoc phan  -->
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
<script type="text/javascript">
	function clickRadio(mahocphan) {
		window.location.href = "${pageContext.request.contextPath }/xem/"
				+ mahocphan;

	}
	var popup;
	function thaydoi(mahocphan, malophocphan) {
		popup = window.open("${pageContext.request.contextPath }/thaydoi/"
				+ mahocphan + "/" + malophocphan, "Popup",
				"width=600,height=300,scrollbars=1");
		popup.focus();
	}
	function xoaConfirm() {
		var res = confirm("Bạn có muốn xóa không");
		if (res) {
			return true;
		} else {
			return false;
		}
	}
</script>
</html>