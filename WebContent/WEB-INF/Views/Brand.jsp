<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">NHÃN HIỆU MÁY ẢNH</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng nhãn hiệu sản phẩm
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                        	<a href="/MQ-SHOP/createBrand">Thêm nhãn Hiệu</a>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN NHÃN HIỆU</th>
                                        <th>MÔ TẢ</th>
                                        <th>ẢNH NHÃN HIỆU</th>
                                        <th>NGÀY TẠO</th>
                                        <th>NGƯỜI TẠO</th>
                                        <th>NGÀY CẬP NHẬT</th>
                                        <th>NGƯỜI CẬP NHẬT</th>
                                        <th width="100"></th>

                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listBrand}" var="brand">
                                    <tr class="odd gradeX" id="row_${brand.brandID}">
                                    
                                        <td>${brand.namebrand}</td>
                                        <td>${brand.descriptionbrand}</td>   
                                    <!-- 	<td>${brand.image}</td>     -->
                                   		<td><img src="${brand.image}" width="100" height="100"></td>                   
                                        <td width="100">${brand.createddate}</td>
                                        <td width="90">${brand.createdby}</td>
                                        <td width="100">${brand.updateddate}</td>
                                        <td width="90">${brand.updatedby}</td>
                                        <td>
                                        <a href="editBrand?brandID=${brand.brandID}"><button type="button" class="btn btn-primary btn-xs" text-align="left">Sửa</button></a>
                                         | 
                                        <a href="deleteBrand?brandID=${brand.brandID}"><button type="button" class="btn btn-danger btn-xs" text-align="right">Xóa</button></a>
                                      
                                        </td>
                                       
                                        
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