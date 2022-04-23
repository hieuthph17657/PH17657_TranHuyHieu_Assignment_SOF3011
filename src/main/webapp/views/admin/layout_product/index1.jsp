<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="row">
		<div class="col-9">
			<c:forEach items="${ ds }" var="product">
			<div class="card m-2" style="width: 18rem;">
			<img src="/PH17657_TranHuyHieu_Assignment_SOF3011/Anh/${product.img}" class="card-img-top">
			<div class="card-body">
			  <p class="card-text">${product.ten }</p>
			  <p class="card-text">${product.donGia } $</p>
			  <a href="/PH17657_TranHuyHieu_Assignment_SOF3011/layout_product/addgiohang?id=${product.id}" class="btn btn-primary">
						Thêm vào giỏ hàng
			  </a>
			</div>
			</div>
			</c:forEach>
		</div>
		<div class="col-3">
			
		</div>
	</div>
