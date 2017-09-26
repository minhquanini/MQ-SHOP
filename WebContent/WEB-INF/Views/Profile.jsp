<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="import_top.jsp"></jsp:include>
<jsp:include page="top_menu.jsp"></jsp:include>



<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header text-center">THÔNG TIN TÀI KHOẢN</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
      <div class="row">
      
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Tài khoản: ${user.username }</h3>
                        <div class="text-right">
                            <a href="/MQ-SHOP/editUser?userID=${user.userID}" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                        </div>     
            </div>
            <div class="panel-body">
              <div class="row">
                
                
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                    
                     
                    
                      <tr>
                        <td>Tên đầy đủ:</td>
                        <td>${user.fullname }</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>${user.email }</td>
                      </tr>
                      <tr>
                        <td>Số điện thoại:</td>
                        <td>${user.phone }</td>
                      </tr>
                      <tr>
                        <td>Ngày sinh:</td>
                        <td>${user.birthday }</td>
                      </tr>
                      <tr>
                        <td>Địa chỉ:</td>
                        <td>${user.address }</td>
                      </tr>
                     
                    </tbody>
                  </table>
					</div>
                </div>
              
              
            </div>
                 
            
          </div>
        </div>
      </div>
    </div>





<jsp:include page="import_bottom.jsp"></jsp:include>