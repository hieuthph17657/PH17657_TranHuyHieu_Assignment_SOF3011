<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:if test="${!empty sessionScope.message2 }">
	<div class="alert alert-success">
		${sessionScope.message2}
		<c:remove var="message2" scope="session"/>
	</div>
</c:if>
<c:if test="${!empty sessionScope.error2 }">
	<div class="alert alert-danger">
		${sessionScope.error2}
		<c:remove var="error2" scope="session"/>
	</div>
</c:if>
<table class="table">
		<thead class="table-dark">
			<th>Tên</th>
		    <th>Số lượng</th>
		    <th>Đơn giá</th>
		    <th>Màu sắc</th>
		    <th>Kích thước</th>
		    <th>Địa chỉ</th>
		    <th>SĐT</th>
		    <th>UserId</th>
		    <th>Categoryid</th>
		    <th>Tổng tiền</th>
		    <th>Trạng thái</th>
		</thead>
		<tbody>
			<c:forEach items="${ cart }" var="cart">
				<tr>
					<td>${cart.ten }</td>
				    <td>${cart.soLuong }</td>
				    <td>${cart.donGia }</td>
				    <td>${cart.mauSac }</td>
				    <td>${cart.kichThuoc }</td>
				    <td>${cart.diaChi }</td>
				    <td>${cart.sdt }</td>
				    <td>${cart.userId }</td>
				    <td>${cart.categoryId }</td>
				    <td>${cart.tongTien}</td>
					<td>${cart.trangThai== 0?"Chưa đặt":cart.trangThai== 1?"Chờ xác nhận":cart.trangThai== 2?"Đã xác nhận":cart.trangThai== 3?"Đã nhận hàng":"Đã hủy"}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>