<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">DANH SÁCH ĐƠN HÀNG</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng danh sách đơn hàng
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN KHÁCH HÀNG</th>
                                        <th>EMAIL KHÁCH HÀNG</th>
                                        <th>SĐT KHÁCH HÀNG</th>
                                        <th>ĐỊA CHỈ KHÁCH HÀNG</th>
                                        <th>LỜI NHẮN KHÁCH HÀNG</th>
                                        <th>TÌNH TRẠNG ĐƠN HÀNG</th>
                                        <th>CHI TIẾT ĐƠN HÀNG</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listorder}" var="listorder">
                                    <tr class="odd gradeX" id="row_${listorder.orderID}">
                                    
                                        <td>${listorder.customername}</td>
                                        <td>${listorder.customeremail}</td>
                                        <td>${listorder.customerphone}</td>
                                        <td>${listorder.customeraddress}</td>
                                        <td>${listorder.customermessage}</td>
                                        <td>${listorder.orderstatus}</td>
                                        <td>
                                        <a href="orderDetail?orderID=${listorder.orderID}"><button class="btn btn-primary btn-xs">Xem chi tiết</button></a>                        
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