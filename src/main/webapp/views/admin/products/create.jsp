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
		action="/PH17657_TranHuyHieu_Assignment_SOF3011/products/store">
		<div class="row col-12">
			<label class="col-2">Tên</label>
			<input class="col-7" type="text" name="ten"  />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Số lượng</label>
			<input class="col-7" type="number" name="soLuong" />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Đơn giá</label>
			<input class="col-7" type="number" name="donGia"  />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Màu sắc</label>
			<input class="col-7" type="text" name="mauSac" />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Image</label>
			<input class="col-7" type="file" name="img" />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Kích thước</label>
			<input class="col-7" type="number" name="kichThuoc" />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Category</label>
			<select class="col-7" name="category_id">
			<c:forEach items="${ dsCate }" var="cate">
				<option value="${cate.id}">
					${cate.ten}
				</option>
			</c:forEach>
			</select>
		</div>
		</br>
		<div class="">
			<button class="btn btn-success">Thêm</button>
			<button type="reset" class="btn btn-warning">Xóa form</button>
		</div>
	</form>