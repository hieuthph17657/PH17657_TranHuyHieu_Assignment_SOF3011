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
		action="/PH17657_TranHuyHieu_Assignment_SOF3011/products/update?id=${product.id }">
		<div class="row col-12">
			<label class="col-2">Tên</label>
			<input class="col-7" type="text" name="ten" value="${product.ten}" />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Số lượng</label>
			<input class="col-7" type="number" name="soLuong" value="${product.soLuong}"/>
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Đơn giá</label>
			<input class="col-7" type="number" name="donGia" value="${product.donGia}" />
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Màu sắc</label>
			<input class="col-7" type="text" name="mauSac" value="${product.mauSac}"/>
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Image</label>
			<input class="col-7" type="file" name="img" value="/PH17657_TranHuyHieu_Assignment_SOF3011/Anh/+${product.img}"/>
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Kích thước</label>
			<input class="col-7" type="number" name="kichThuoc" value="${product.kichThuoc}"/>
		</div>
		</br>
		<div class="row col-12">
			<label class="col-2">Category</label>
			<select class="col-7" name="category_id">
			<c:forEach items="${ dsCate }" var="cate">
				<option ${ product.category.id == cate.id ? "selected" : "" } value="${cate.id}">
					${cate.ten}
				</option>
			</c:forEach>
			</select>
		</div>
		</br>
		<div class="">
			<button class="btn btn-success">Sửa</button>
			<button type="reset" class="btn btn-warning">Xóa form</button>
		</div>
	</form>