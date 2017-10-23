<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">DANH SÁCH PHẢN HỒI</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng danh sách phản hồi
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                        	
                        	
                            <table width="100%"  class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN NGƯỜI DÙNG</th>
                                        <th>EMAIL NGƯỜI DÙNG</th>
                                        <th>NỘI DUNG PHẢN HỒI</th>
                                        <th>NGÀY PHẢN HỒI</th>
                                        
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listFB}" var="listfb">
                                    <tr class="odd gradeX" id="row_${listfb.feedbackID}">
                                    
                                        <td>${listfb.namefb}</td>
                                        <td>${listfb.emailfb}</td>
                                        <td>${listfb.contentfb}</td>
                                        <td>${listfb.createddate}</td>
                                      
                                        
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