<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">DANH MỤC MÁY ẢNH</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng danh mục sản phẩm
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                        	<a href="/MQ-SHOP/createCategory">Thêm Danh Mục</a>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN DANH MỤC</th>
                                        <th>MÔ TẢ</th>
                                        <th>NGÀY TẠO</th>
                                        <th>NGƯỜI TẠO</th>
                                        <th>NGÀY CẬP NHẬT</th>
                                        <th>NGƯỜI CẬP NHẬT</th>
                                        <th>SỬA</th>
                                        <th>XÓA</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${categoryList}" var="category">
                                    <tr class="odd gradeX" id="row_${category.categoryID}">
                                    
                                        <td>${category.namecategory}</td>
                                        <td>${category.descriptioncategory}</td>
                                        <td>${category.createddate}</td>
                                        <td>${category.createdby}</td>
                                        <td>${category.updateddate}</td>
                                        <td>${category.updatedby}</td>
                                        <td><a href="editCategory?categoryID=${category.categoryID}"><button>Sửa</button></a></td>
                                        <td><a href="deleteCategory?categoryID=${category.categoryID}"><button>Xóa</button></a></td>
                                       
                                        
                                    </tr>
 								 </c:forEach>
 								 
 								  
                                </tbody>
                               
                            </table>
                            <!-- /.table-responsive -->
                            
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