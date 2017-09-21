<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">THUỘC TÍNH MÁY ẢNH</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng thuộc tính sản phẩm
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                        	<a href="/MQ-SHOP/createAttribute">Thêm thuộc tính</a>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN THUỘC TÍNH</th>
                                        <th></th>
                                        
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listAttribute}" var="attribute">
                                    <tr class="odd gradeX" id="row_${attribute.attributeID}">
                                    
                                        <td>${attribute.nameattribute}</td>  
                                        <td>   
                                        <a href="deleteAttribute?attributeID=${attribute.attributeID}"><button type="button" class="btn btn-danger btn-md">Xóa</button></a>
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