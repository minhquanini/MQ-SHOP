<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="import_top.jsp"></jsp:include>
    <jsp:include page="top_menu.jsp"></jsp:include>
    
    <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Thêm Nhãn Hiệu Sản Phẩm</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Tạo tài khoản cho Admin mới
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                	<p style="color: red;">${errorString}</p>
                                    <form role="form" method="POST" action="doCreateAdmin">
                                        <div class="form-group">
                                            <label>Tên Tài Khoản</label>
                                            <input class="form-control" name="username" placeholder="Nhập vào tên tài khoản">
                                        </div>
                                        <div class="form-group">
                                            <label>Mật khẩu</label>
                                            <input class="form-control" name="password" placeholder="Nhập vào password" type="password"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Xác nhận mật khẩu</label>
                                            <input class="form-control" name="repassword" placeholder="Nhập lại password" type="password"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Họ và Tên</label>
                                            <input class="form-control" name="fullname" placeholder="Nhập vào tên tài khoản">
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input class="form-control" name="email" placeholder="Nhập vào email" type="email">
                                        </div>
                                       <div class="form-group">
                                            <label>Số điện thoại</label>
                                            <input class="form-control" name="phone" placeholder="Nhập vào số điện thoại">
                                        </div>
                                        <div class="form-group">
                                            <label>Ngày sinh</label>
                                            <input class="form-control" name="birthday" type="date">
                                        </div>
                                        <div class="form-group">
                                            <label>Địa chỉ</label>
                                            <input class="form-control" name="address" placeholder="Nhập vào địa chỉ">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Tạo tài khoản</button>
                                        
                                    </form>
                                    <a href="/MQ-SHOP/accout"><button class="btn btn-default">Hủy bỏ</button></a>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    
    
    
    
	<jsp:include page="import_bottom.jsp"></jsp:include>