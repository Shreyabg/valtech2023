package com.valtech.assignment.Jdbc.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;




@Component
public class OrdersDAOImpl implements OrdersDAO{

	public class OrdersRowMapper implements RowMapper<Orders> {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {

			// "SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE"

			Orders o = new Orders();
			o.setOrderId(rs.getInt(1));
			o.setCustId(rs.getInt(2));
			o.setDate(rs.getString(3));
			return o;

		}

	}
	
	
	
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public long count(int id) {
		String countQry = "SELECT COUNT(order_id) FROM Orders Where Cust_id=?";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class,id);		
	}

	@Override
	public void deleteOrder(int id) {
		
	}

	@Override
	public void updateOrder(Orders ord) {
		
	}

	@Override
	public void createOrder(Orders ord) {
		String createQry="INSERT INTO Orders(Order_id,cust_id,date) values(?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,ord.getOrderId(),ord.getCustId(),ord.getDate());
		
	}

	@Override
	public void saveOrder(Orders ord) {
		
	}

	@Override
	public List<Orders> getAllOrders() {
		String selectAllQry = "SELECT Order_id,cust_id,date FROM Orders";

		return new JdbcTemplate(dataSource).query(selectAllQry, new OrdersRowMapper());
	}

	@Override
	public Orders getOrder(int id) {
		
		
		String selectQry = "SELECT Order_id,cust_id,date FROM Orders WHERE ORDER_ID=?" + id;
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new OrdersRowMapper());
	}

	
}
