<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">DANH SÁCH TÀI KHOẢN</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Bảng danh sách tài khoản
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<p style="color: red;">${errorString}</p>
                        	<div class="col-lg-6">
                        	<a href="/MQ-SHOP/createAdmin"><button class="btn btn-success">Thêm Admin</button></a>
                        	</div>
                        	<div class="col-lg-6">
	                         <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Nhập tên muốn tìm kiếm...." 
	                         	style="
							    margin-bottom: 10px;
								">
                           	 </div>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="myTable">
                                <thead>
                                    <tr>
                                        
                                        <th>TÊN TÀI KHOẢN</th>
                                        <th>HỌ VÀ TÊN</th>
                                        <th>EMAIL</th>
                                        <th>SỐ ĐIỆN THOẠI</th>
                                        <th>NGÀY SINH</th>
                                        <th>ĐỊA CHỈ</th>
                                        <th>QUYỀN</th>
                                        <th></th>
                                        
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${listuser}" var="listuser">
                                    <tr class="odd gradeX" id="row_${listuser.userID}">
                                    
                                        <td>${listuser.username}</td> 
                                        <td>${listuser.fullname}</td>  
                                        <td>${listuser.email}</td>  
                                        <td>${listuser.phone}</td>  
                                        <td>${listuser.birthday}</td>  
                                        <td>${listuser.address}</td> 
                                        <c:choose>
                                        	<c:when test="${listuser.isadmin == 1 }"> <td>Admin</td></c:when>
                                        	<c:otherwise><td>Khách hàng</td></c:otherwise>
                                        </c:choose>  
                                        <td>   
                                        <a href="deleteUser?userID=${listuser.userID}"><button type="button" class="btn btn-danger btn-md">Xóa</button></a>
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