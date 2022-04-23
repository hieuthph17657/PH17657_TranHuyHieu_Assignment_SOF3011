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
<h2>
	<fmt:formatDate value="${ now }"
		pattern="dd/MM/yyyy" />
</h2>

<c:if test="${ empty ds }">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<a href="/PH17657_TranHuyHieu_Assignment_SOF3011/users/create" class="btn btn-success">Thêm</a>
<c:if test="${ !empty ds }">
	<table class="table">
		<thead class="table-dark">
			<th>Họ tên</th>
			<th>Giới tính</th>
			<th>SĐT</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th>Avatar</th>
			<th>Vai trò</th>
			<th colspan="2">Thao tác</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="user">
				<tr>
					<td>${ user.hoTen }</td>
					<td>
					<c:choose>
						<c:when test="${ user.gioiTinh == 1 }">Nam</c:when>
						<c:when test="${ user.gioiTinh == 0 }">Nữ</c:when>
						<c:otherwise> - </c:otherwise>
					</c:choose>
					</td>
					<td>${ user.sdt }</td>
					<td>${ user.email }</td>
					<td>${ user.diaChi }</td>
					<td>${ user.avatar }</td>
					<td>
					<c:choose>
						<c:when test="${ user.role == 1 }">Admin</c:when>
						<c:when test="${ user.role == 0 }">Custom</c:when>
						<c:otherwise> - </c:otherwise>
					</c:choose>
					</td>
					<td>
						<a
							href="/PH17657_TranHuyHieu_Assignment_SOF3011/users/edit?id=${ user.id }"
							class="btn btn-primary">
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
					        <a class="btn btn-primary" href="/PH17657_TranHuyHieu_Assignment_SOF3011/users/delete?id=${ user.id }">Xóa</a>
					      </div>
					    </div>
					  </div>
					</div>
			</c:forEach>
		</tbody>
	</table>
</c:if>
