<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="import_top.jsp"></jsp:include>
    <jsp:include page="top_menu.jsp"></jsp:include>
    
    <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Chỉnh Sửa Danh Mục</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Nhập vào danh mục chỉnh sửa
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                	<p style="color: red;">${errorString}</p>
                                    <form role="form" method="POST" action="doEditCategory">
                                    	<input type="hidden" name="categoryID" value= "${category.categoryID}" />
                                        <div class="form-group">
                                            <label>Tên danh mục</label>
                                            <input class="form-control" type="text" name="namecategory" value="${category.namecategory}">
                                        </div>
                                    
                                        <div class="form-group">
                                            <label>Mô tả danh mục</label>
                                             
                                            <textarea class="form-control" type="text" name="descriptioncategory" rows="3">${category.descriptioncategory}</textarea>
                                       		 
                                       		 <!--  
                                       		 <input class="form-control" type="text" name="descriptioncategory" rows="3" value="${category.descriptioncategory}">
                                     		  -->
                                        </div>
                                        
                                        
                                        <button type="submit" class="btn btn-primary">Lưu chỉnh sửa</button>
                                        <a href="/MQ-SHOP/category"><button class="btn btn-default">Hủy bỏ</button></a>
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