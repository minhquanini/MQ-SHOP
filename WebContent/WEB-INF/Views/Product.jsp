<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="java.text.DecimalFormat" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
                        	<div class="col-lg-6">
                        	<a href="/MQ-SHOP/createProduct"><button class="btn btn-success">Thêm sản phẩm</button></a>
                        	</div>
                        	<div class="col-lg-6">
	                         <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Nhập tên muốn tìm kiếm...." 
	                         	style="
							    margin-bottom: 10px;
								">
                           	 </div>
                            <table width="100%" id="myTable" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN SẢN PHẨM</th>
                                        <th>DANH MỤC</th>
                                        <th>NHÃN HIỆU</th>
                                        <th>ẢNH</th>
                                    <!--     <th>GIÁ NHẬP</th> -->
                                        <th>GIÁ BÁN</th>
                                        <th>GIÁ KHUYẾN MÃI</th>
                                        <th>SỐ LƯỢNG</th>
                                        <th>BẢO HÀNH</th>
                                        <th>MÔ TẢ</th>
                                        <th width="50"></th>
                                     <!--    <th>MÔ TẢ CHI TIẾT</th>--> 
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listpca}" var="listpca">
                                    <tr class="odd gradeX" id="row_${listpca.productID}">
                                    
                                        <td width="100">${listpca.nameproduct}</td>
                                        <td width="120">${listpca.namecategory}</td>
                                        <td width="80">${listpca.namebrand}</td>
                                        <td width="80"><img src="${listpca.imageproduct}" width="100" height="100"></td>   
                                    <!--     <td width="80">${listpca.originalprice}</td> 
                                        <td width="140">${listpca.price}</td>-->
                                         <td width="100">
                                         
                                         <fmt:formatNumber type ="number" 
        								 maxFractionDigits = "3" value="${listpca.price}" />
                                         </td>
                                        <td width="100">
                                         
                                         <fmt:formatNumber type ="number" 
        								 maxFractionDigits = "3" value="${listpca.promotionprice}" />
                                         </td>
                                        <td width="50">${listpca.quantity}</td>
                                        <td width="60">${listpca.warranty}</td>
                                        <td  width="140">${listpca.descriptionproduct}</td>
                                      <!--    <td>${product.contentproduct}</td>  -->
                                        <td>
                                        <a href="editProduct?productID=${listpca.productID}"><button type="button" class="btn btn-primary btn-xs" text-align="left">Sửa</button></a>
                                         <br> 
                                         <br>
                                        <a href="deleteProduct?productID=${listpca.productID}"><button type="button" class="btn btn-danger btn-xs" text-align="right">Xóa</button></a>
                                      
                                        </td>
                                        
                                    </tr>
 								 </c:forEach>
 								 
 								  
                                </tbody>
                               
                            </table>
                            <!-- /.table-responsive -->
                            <script>
								function myFunction() {
								  var input, filter, table, tr, td, i;
								  input = document.getElementById("myInput");
								  filter = input.value.toUpperCase();
								  table = document.getElementById("myTable");
								  tr = table.getElementsByTagName("tr");
								  for (i = 0; i < tr.length; i++) {
								    td = tr[i].getElementsByTagName("td")[0];
								    if (td) {
								      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
								        tr[i].style.display = "";
								      } else {
								        tr[i].style.display = "none";
								      }
								    }       
								  }
								}
								</script>
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