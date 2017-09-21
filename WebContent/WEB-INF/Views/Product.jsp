<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">DANH SÁCH SẢN PHẨM</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng danh sách sản phẩm
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                        	<a href="/MQ-SHOP/createProduct">Thêm Sản Phẩm</a>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN SẢN PHẨM</th>
                                        <th>DANH MỤC</th>
                                        <th>NHÃN HIỆU</th>
                                        <th>ẢNH</th>
                                        <th>GIÁ NHẬP</th>
                                        <th>GIÁ BÁN</th>
                                        <th>GIÁ KHUYẾN MÃI</th>
                                        <th>SỐ LƯỢNG</th>
                                        <th>BẢO HÀNH</th>
                                        <th>MÔ TẢ</th>
                                        <th></th>
                                     <!--    <th>MÔ TẢ CHI TIẾT</th>--> 
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listpca}" var="listpca">
                                    <tr class="odd gradeX" id="row_${listpca.productID}">
                                    
                                        <td>${listpca.nameproduct}</td>
                                        <td>${listpca.namecategory}</td>
                                        <td>${listpca.namebrand}</td>
                                        <td><img src="${listpca.imageproduct}" width="100" height="100"></td>   
                                        <td>${listpca.originalprice}</td>
                                        <td>${listpca.price}</td>
                                        <td width="60">${listpca.promotionprice}</td>
                                        <td width="60">${listpca.quantity}</td>
                                        <td width="60">${listpca.warranty}</td>
                                        <td>${listpca.descriptionproduct}</td>
                                      <!--    <td>${product.contentproduct}</td>  -->
                                        <td>
                                        <a href="editProduct?productID=${listpca.productID}"><button type="button" class="btn btn-primary btn-xs" text-align="left">Sửa</button></a>
                                          
                                        <a href="deleteProduct?productID=${listpca.productID}"><button type="button" class="btn btn-danger btn-xs" text-align="right">Xóa</button></a>
                                      
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