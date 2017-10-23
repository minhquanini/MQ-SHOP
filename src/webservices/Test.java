package webservices;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;

import mqshop.beans.ATTRIBUTE_VALUES_MODEL;
import mqshop.beans.BRANDS;
import mqshop.beans.CATEGORIES;
import mqshop.beans.ORDERS;
import mqshop.beans.ORDER_DETAILS;
import mqshop.beans.PRODUCTS;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@Path("/webservice")
public class Test extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@GET
	@Path("/test")
	 @Produces(MediaType.APPLICATION_JSON)
	public List<USERS> getUser(Connection conn) throws ClassNotFoundException, IOException{
		
		//Connection conn=null;
		conn=connectDB.getConnection();
		
		List<USERS> list=null;
		try {
			list=DBUtils.queryUser(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CATEGORIES> getCategoryForAndroid(Connection conn) throws ClassNotFoundException, IOException, SQLException{
		conn=connectDB.getConnection();
		List<CATEGORIES> listCategory=null;
		
		listCategory=DBUtils.getCategory(conn);
		return listCategory;
	}
	
	@GET
	@Path("/brand")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BRANDS> getBrandForAndroid(Connection conn) throws ClassNotFoundException, IOException, SQLException{
		conn=connectDB.getConnection();
		List<BRANDS> listbrand=null;
		listbrand=DBUtils.queryBrand(conn);
		return listbrand;
	}
	
	@GET
	@Path("/productnew")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PRODUCTS> getProductNewestForAndroid(Connection conn) throws ClassNotFoundException, IOException, SQLException{
		conn=connectDB.getConnection();
		List<PRODUCTS> listproductnew=DBUtils.getProductNewest(conn);
		return listproductnew;
	}
	
	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PRODUCTS> getProductForAndroid(Connection conn) throws ClassNotFoundException, IOException, SQLException{
		conn=connectDB.getConnection();
		List<PRODUCTS> listproduct=DBUtils.queryProduct(conn);
		return listproduct;
	}
	
	@POST
	@Path("/productcategory")
	//@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public List<PRODUCTS> getProductbyCAT(@FormParam("categoryID") int categoryid,@Context HttpHeaders header, @Context HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException{
		Connection conn=connectDB.getConnection();
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		List<PRODUCTS> listproductbycatID=DBUtils.getProductbyCategory(conn, categoryid);
		
		return listproductbycatID;
	}
	
	@POST
	@Path("/productbrand")
	//@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public List<PRODUCTS> getProductbyBRD(@FormParam("brandID") int brandid,@Context HttpHeaders header, @Context HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException{
		Connection conn=connectDB.getConnection();
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		List<PRODUCTS> listproductbybrdID=DBUtils.getProductbyBrand(conn, brandid);
		
		return listproductbybrdID;
	}
	
	@POST
	@Path("/attribute")
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public List<ATTRIBUTE_VALUES_MODEL> getAttributebypdID(@FormParam("productID")int productid,@Context HttpHeaders header, @Context HttpServletResponse response) throws ClassNotFoundException, IOException, SQLException{
		Connection conn=connectDB.getConnection();
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		List<ATTRIBUTE_VALUES_MODEL> listatt=DBUtils.getValueAttribute(conn, productid);
		return listatt;
	}
	
	@POST
	@Path("/order")
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public int addOrder(@FormParam("customername")String customername, @FormParam("customeremail")String customeremail,
			@FormParam("customerphone")String customerphone, @FormParam("customeraddress")String customeraddress,
			@FormParam("total")Double total,@FormParam("paymentmethod")String paymentmethod) throws ClassNotFoundException, IOException, SQLException{
			Connection conn=connectDB.getConnection();
		//response.setHeader("Content-Type", "application/json; charset=utf-8");
		//List<ATTRIBUTE_VALUES_MODEL> listatt=DBUtils.getValueAttribute(conn, productid);
			
			ORDERS order=new ORDERS();
			order.setCustomername(customername);
			order.setCustomeremail(customeremail);
			order.setCustomerphone(customerphone);
			order.setCustomeraddress(customeraddress);
			order.setOrdertotal(total);
			order.setPaymentmethod(paymentmethod);
			order.setUserID(4);
			
			DBUtils.insertOrder(conn, order);
			
			int maxorderID=DBUtils.getMaxOrderID(conn);
			return maxorderID;
		
	}
	
	
	@POST
	@Path("/orderdetail")
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public int addOrderDetail(@FormParam("orderdetail") String listorderdetail) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
		int success=1;
		
		Connection conn=connectDB.getConnection();
		
		ObjectMapper mapper = new ObjectMapper();
		List<ORDER_DETAILS> participantJsonList = mapper.readValue(listorderdetail, new TypeReference<List<ORDER_DETAILS>>(){});
		for(ORDER_DETAILS detail:participantJsonList) {
			detail.getOrderID();
			detail.getProductID();
			detail.getQuantity();
			detail.getPrice();
			
			
			try {
				DBUtils.insertOrderDetail(conn, detail);
			} catch (SQLException e) {
			
				e.printStackTrace();
				success=0;
			}
			
		}
		return success;
	}
	
	@POST
	@Path("/token")
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public int getTokeninClient(@FormParam("token") String token,@FormParam("total") String total) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
		Stripe.apiKey="sk_test_36ZW1MAORn7GSmdRVro3hJZC";
		int success=1;
		System.out.println(token);
		System.out.println(total);
		
		//RequestOptions requestOptions = RequestOptions.builder().setApiKey("sk_test_36ZW1MAORn7GSmdRVro3hJZC").build();

		//Charge.retrieve("ch_1BFxrBIyNH6pS3LEyuCngbl6", requestOptions);
		
		try {
		
		Map<String, Object> params=new HashMap<String,Object>();
		//params.put("email", "minhquanmessi@gmail.com");
		params.put("source",token);
		Customer customer = Customer.create(params);
		
		
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", Integer.parseInt(total));
		chargeParams.put("currency", "usd");
		chargeParams.put("customer", customer.getId());
		chargeParams.put("description", "Test charge");
		Charge charge = Charge.create(chargeParams);
		}
		catch (Exception e) {
			success=0;
		}
		
		
		return success;
		
	}
	
}
