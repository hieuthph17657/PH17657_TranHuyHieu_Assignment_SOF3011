<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="row bg-white pt-3">
            
      <div class="col-3"></div>
      <div class="col-6">
          <div class="card text-center mb-3" >
            <form class="card-body  ms-5 me-5" method="POST" action="/PH17657_TranHuyHieu_Assignment_SOF3011/login">
                  <div class="row">
                  <p>Xin chào! Mời đăng nhập</p>
                  </div>
                  <div class="row mt-3">
                      <input type="email" name="email" class="form-control" placeholder="Nhập Email" required maxlength="25">
                  </div>
                  <div class="row mt-3">
                      <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required maxlength="25">
                  </div>
                  <div class="row mt-3">
                      <div class="col-5"></div>
                      <a class="col-7 text-decoration-none" href="#">Quên mật khẩu?</a>
                      
                  </div>
                  <div class="row mt-4">
                      <button class="btn btn-danger">Đăng nhập</button>
                  </div>
                  <div class="row mt-3">
                      <p>Nếu bạn chưa có tài khoản?
                      <a class="text-decoration-none" href="dangky.html">Đăng ký ngay</a>
                      </p>
                  </div>
            </form>
            
          </div>
      </div>
      <div class="col-3"></div>
</div>
