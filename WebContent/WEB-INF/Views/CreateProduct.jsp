<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <jsp:include page="import_top.jsp"></jsp:include>
    <jsp:include page="top_menu.jsp"></jsp:include>
    
    <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Thêm Sản Phẩm</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Nhập vào các thông tin của sản phẩm
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                	<p style="color: red;">${errorString}</p>
                                    <form role="form" method="POST" action="doCreateProduct" enctype="multipart/form-data">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>Tên Sản Phẩm</label>
                                            <input class="form-control" name="nameproduct" placeholder="Nhập vào tên sản phẩm">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Danh Mục Sản Phẩm</label>
                                            <select class="form-control" name="categoryID">
                                            <c:forEach items="${listcat}" var="category">
                                            	<option id="${category.categoryID}" value="${category.categoryID}">${category.namecategory}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Nhãn Hiệu Sản Phẩm</label>
                                            <select class="form-control" name="brandID">
                                            <c:forEach items="${listbrand}" var="brand">
                                            	<option id="${brand.brandID}" value="${brand.brandID}">${brand.namebrand}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Giá Nhập Sản Phẩm</label>
                                            <input class="form-control" name="originalprice" placeholder="Nhập vào giá nhập của sản phẩm"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Giá Bán Sản Phẩm</label>
                                            <input class="form-control" name="price" placeholder="Nhập vào giá bán của sản phẩm"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Giá Khuyến Mãi Sản Phẩm</label>
                                            <input class="form-control" name="promotionprice" placeholder="Nhập vào giá khuyến mãi của sản phẩm"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Số Lượng Sản Phẩm</label>
                                            <input class="form-control" name="quantity" placeholder="Nhập vào số lượng của sản phẩm"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Thời Gian Bảo Hành Sản Phẩm</label>
                                            <input class="form-control" name="warranty" placeholder="Nhập vào thời gian bảo hành của sản phẩm"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Mô Tả Sản Phẩm</label>
                                            <input class="form-control" name="descriptionproduct" placeholder="Nhập vào mô tả của sản phẩm"></input>
                                        </div>
                                        <div class="form-group">
                                            <label>Nội Dung Giới Thiệu Sản Phẩm</label>
                                            <textarea class="form-control" name="contentproduct" rows="18" placeholder="Nhập vào nội dung giới thiệu sản phẩm"></textarea>
                                        </div>
                                        
                                        </div>
                                        <div class="col-lg-6">
                                        <c:forEach items="${listatt}" var="listatt">
                                        <input type="hidden" name="attributeID" value="${listatt.attributeID}" />
                                        <div class="form-group">                        
                                        	<label>${listatt.nameattribute}</label>
                                        	<input class="form-control" name="value" placeholder="Nhập vào ${listatt.nameattribute}"></input>
                                        </div>
                                        </c:forEach>
                                        <div class="form-group">
                                            <label>Hình Ảnh Cho Sản Phẩm</label>
                                            <input type="file" name="image">
                                        </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Thêm</button>
                                       
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