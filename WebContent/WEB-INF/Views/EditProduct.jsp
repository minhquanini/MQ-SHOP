<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <jsp:include page="import_top.jsp"></jsp:include>
    <jsp:include page="top_menu.jsp"></jsp:include>
    
    <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Chỉnh Sửa Sản Phẩm</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Nhập vào các thông tin chỉnh sửa của sản phẩm
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                	<p style="color: red;">${errorString}</p>
                                	
                                	
                                    <form role="form" method="POST" action="doEditProduct" enctype="multipart/form-data">
                                    
                                     
                                    <input type="hidden" name="productID" value="${product.productID}" />
                                   
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>Tên Sản Phẩm</label>
                                            <input class="form-control" name="nameproduct" value="${product.nameproduct}">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Danh Mục Sản Phẩm</label>
                                            <select class="form-control" name="categoryID">                   
                                            <c:forEach items="${listcat}" var="category">
                                            	<option value="${category.categoryID}" ${category.categoryID == product.categoryID ? 'selected="selected"' : ''}>${category.namecategory}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Nhãn Hiệu Sản Phẩm</label>
                                            <select class="form-control" name="brandID">
                                            <c:forEach items="${listbrand}" var="brand">
                                            	<option value="${brand.brandID}" ${brand.brandID == product.brandID ? 'selected="selected"' : ''}>${brand.namebrand}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        
                                        
                                        
                                        <div class="form-group">
                                            <label>Giá Nhập Sản Phẩm</label>
                                            <input class="form-control" name="originalprice" value="${product.originalprice}"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Giá Bán Sản Phẩm</label>
                                            <input class="form-control" name="price" value="${product.price}"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Giá Khuyến Mãi Sản Phẩm</label>
                                            <input class="form-control" name="promotionprice" value="${product.promotionprice}"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Số Lượng Sản Phẩm</label>
                                            <input class="form-control" name="quantity" value="${product.quantity}"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Thời Gian Bảo Hành Sản Phẩm</label>
                                            <input class="form-control" name="warranty" value="${product.warranty}"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Mô Tả Sản Phẩm</label>
                                            <input class="form-control" name="descriptionproduct" value="${product.descriptionproduct}"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Nội Dung Giới Thiệu Sản Phẩm</label>
                                            <textarea class="form-control" name="contentproduct" rows="4" >${product.contentproduct}</textarea>
                                        </div>
                                        
                                        </div>
                                        
                                        <div class="col-lg-6">
                                         
                                        <c:forEach items="${listavm}" var="listavm">
                                   	    <input type="hidden" name="attributeID" value="${listavm.attributeID}" />
                                        <div class="form-group">  
                                            <label>${listavm.nameattribute}</label>
                                        	<input class="form-control" name="value" value="${listavm.value}"></input>
                                        </div>
                                        </c:forEach>
                                        <div class="form-group">
                                            <label>Hình Ảnh Cho Sản Phẩm</label>
                                            <input type="file" name="image">
                                        </div>
                                        </div>
                                          
                                        <button type="submit" class="btn btn-primary">Lưu chỉnh sửa</button>
                                       
                                    </form>
                                     <a href="/MQ-SHOP/product"><button class="btn btn-default">Hủy bỏ</button></a>
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