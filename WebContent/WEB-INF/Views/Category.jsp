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
                        	<div class="col-lg-6">
                        	<a href="/MQ-SHOP/createCategory"><button class="btn btn-success">Thêm danh mục</button></a>
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
                                        
                                        <th>TÊN DANH MỤC</th>
                                        <th>MÔ TẢ</th>
                                        <th>NGÀY TẠO</th>
                                        <th>NGƯỜI TẠO</th>
                                        <th>NGÀY CẬP NHẬT</th>
                                        <th>NGƯỜI CẬP NHẬT</th>
                                        <th  width="90"></th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                
                                <c:forEach items="${categoryList}" var="category">
                                    <tr class="odd gradeX" id="row_${category.categoryID}">
                                    
                                        <td>${category.namecategory}</td>
                                        <td>${category.descriptioncategory}</td>
                                        <td   width="100">${category.createddate}</td>
                                        <td>${category.createdby}</td>
                                        <td>${category.updateddate}</td>
                                        <td   width="80">${category.updatedby}</td>
                                        <td>
                                        <a href="editCategory?categoryID=${category.categoryID}"><button class="btn btn-primary btn-xs">Sửa</button></a>
                                        
                                        <a href="deleteCategory?categoryID=${category.categoryID}"><button class="btn btn-danger btn-xs">Xóa</button></a>
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