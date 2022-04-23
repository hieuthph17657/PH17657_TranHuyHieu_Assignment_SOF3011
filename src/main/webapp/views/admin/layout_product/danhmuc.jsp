<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div class="row">
		<div class="col-9">
			
			<div class="card" style="width: 18rem;">
			  <div class="card-header">
			    Danh sách
			  </div>
			  <c:forEach items="${ dscate }" var="cate">
			  <ul class="list-group list-group-flush">
			    <li class="list-group-item" name="danhsach"><a class="text-decoration-none text-dark" 
			    href="/PH17657_TranHuyHieu_Assignment_SOF3011/layout_product/index1?id=${cate.id}">${cate.ten}
			    </a></li>
			  </ul>
			  </c:forEach>
			</div>
			
		</div>
		<div class="col-3">
			
		</div>
	</div>