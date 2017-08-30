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
                            Nhập vào các thông tin nhãn hiệu của sản phẩm
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                	<p style="color: red;">${errorString}</p>
                                    <form role="form" method="POST" action="doCreateBrand" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>Tên Nhãn Hiệu</label>
                                            <input class="form-control" name="namebrand" placeholder="Nhập vào tên nhãn hiệu">
                                        </div>
                                    
                                        <div class="form-group">
                                            <label>Mô tả nhãn hiệu</label>
                                            <textarea class="form-control" name="descriptionbrand" rows="3" placeholder="Nhập vào mô tả của nhãn hiệu"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Hình ảnh cho nhãn hiệu</label>
                                            <input type="file" name="image">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Thêm</button>
                                        <a href="/MQ-SHOP/brand"><button class="btn btn-default">Hủy bỏ</button></a>
                                    </form>
                                    
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