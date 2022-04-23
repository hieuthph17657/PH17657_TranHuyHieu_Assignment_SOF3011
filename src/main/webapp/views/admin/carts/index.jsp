<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<c:if test="${!empty sessionScope.message3 }">
	<div class="alert alert-success">
		${sessionScope.message3}
		<c:remove var="message" scope="session"/>
	</div>
</c:if>
<c:if test="${!empty sessionScope.error3 }">
	<div class="alert alert-danger">
		${sessionScope.error3}
		<c:remove var="error" scope="session"/>
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
		    <th>Số điện thoại</th>
		    <th>UserId</th>
		    <th>Categoryid</th>
		    <th>Tổng tiền</th>
		    <th>Trạng thái</th>
		    <th colspan="2">Thao tác</th>
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
					<td>
						<a href="/PH17657_TranHuyHieu_Assignment_SOF3011/carts/xacnhan?id=${cart.id}" 
						class="btn btn-primary">
						Xác nhận
						</a>
					</td>
					<td>
						<a class="btn btn-danger" href="/PH17657_TranHuyHieu_Assignment_SOF3011/carts/huy?id=${cart.id}" >
							Hủy 
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>