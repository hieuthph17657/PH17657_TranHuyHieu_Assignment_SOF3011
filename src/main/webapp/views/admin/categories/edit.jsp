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
		action="/PH17657_TranHuyHieu_Assignment_SOF3011/categories/update?id=${category.id}">
		<div class="row col-12">
			<label class="col-2">Tên</label>
			<input class="col-7" type="text" name="ten" value="${category.ten }"/>
		</div>
		</br>
		<div>
			<label>Người tạo</label>
			<select name="user_id">
			<c:forEach items="${ dsUser }" var="user">
				<option ${ category.user.id == user.id ? "selected" : "" } value="${user.id}">
					${user.hoTen}
				</option>
			</c:forEach>
			</select>
		</div>
		<div class="">
			<button class="btn btn-success">Sửa</button>
			<button type="reset" class="btn btn-warning">Xóa form</button>
		</div>
	</form>