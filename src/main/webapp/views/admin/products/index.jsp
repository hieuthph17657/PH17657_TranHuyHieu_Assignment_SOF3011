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
<c:if test="${ empty ds }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>

<c:if test="${ !empty ds }">
<a href="/PH17657_TranHuyHieu_Assignment_SOF3011/products/create" class="btn btn-success">
						Thêm
						</a>
	<table class="table">
		<thead class="table-dark">
			<th>Tên</th>
		    <th>Số lượng</th>
		    <th>Đơn giá</th>
		    <th>Màu sắc</th>
		    <th>Kích thước</th>
		    <th>Image</th>
		    <th>Categoryid</th>
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="product">
				<tr>
					<td>${product.ten }</td>
				    <td>${product.soLuong }</td>
				    <td>${product.donGia }</td>
				    <td>${product.mauSac }</td>
				    <td>${product.kichThuoc }</td>
				    <td>${product.img }</td>
				    <td>${product.category.id }</td>
					<td>
						<a href="/PH17657_TranHuyHieu_Assignment_SOF3011/products/edit?id=${product.id}" class="btn btn-primary">
						Cập nhật
						</a>
					</td>
					<td>
							<a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
								Xóa
							</a>
						</td>
					</tr>
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Xác nhận xóa</h5>
					        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <p>Xác nhận xóa</p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					        <a class="btn btn-primary" href="/PH17657_TranHuyHieu_Assignment_SOF3011/products/delete?id=${product.id}">Xóa</a>
					      </div>
					    </div>
					  </div>
					</div>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
