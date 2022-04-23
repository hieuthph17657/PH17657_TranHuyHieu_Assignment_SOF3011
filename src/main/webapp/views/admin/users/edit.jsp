<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:if test="${!empty sessionScope.message }">
	<div class="alert alert-success">
		${sessionScope.message}
		<c:remove var="message" scope="session"/>
	</div>
</c:if>
<c:if test="${!empty sessionScope.error }">
	<div class="alert alert-danger">
		${sessionScope.error}
		<c:remove var="error" scope="session"/>
	</div>
</c:if>
<form method="POST"
	action="/PH17657_TranHuyHieu_Assignment_SOF3011/users/update?id=${ user.id }">
	<div class="row col-12">
		<label class="col-2">Họ tên</label>
		<input class="col-7" type="text" name="hoTen" value="${ user.hoTen }" />
	</div>
	</br>
	<div class="row col-12">
		<label class="col-2">Địa chỉ</label>
		<input class="col-7" type="text" name="diaChi" value="${ user.diaChi }" />
	</div>
	</br>
	<div class="row col-12">
		<label class="col-2">SĐT</label>
		<input class="col-7" type="text" name="sdt" value="${ user.sdt }" />
	</div>
	</br>
	<div class="row col-12">
		<label class="col-2">Email</label>
		<input class="col-7" type="email" name="email" value="${ user.email }" />
	</div>
	</br>
	<div class="row col-12">
		<label class="col-2">Password</label>
		<input class="col-7" type="password" name="password" value="${ user.password }"/>
	</div>
	</br>
	<div class="row col-12">
		<label class="col-2">Avatar</label>
		<input class="col-7" type="file" name="avatar" value="/PH17657_TranHuyHieu_Assignment_SOF3011/Anh/+${user.avatar}"/>
	</div>
	</br>
	<div class="row col-12">
		<label class="col-2">Giới tính</label>
		<div class="col-7">
			<input type="radio" name="gioiTinh" value="1"
			${ user.gioiTinh == 1 ? "checked" : "" }/>
			<label >Nam</label>
			<input type="radio" name="gioiTinh" value="0"
				${ user.gioiTinh == 0 ? "checked" : "" }/>
			<label >Nữ</label>
		</div>
	</div>
	</br>
	<div class="">
		<button class="btn btn-success">Cập nhật</button>
		<button type="reset" class="btn btn-warning">Xóa form</button>
	</div>
</form>