package com.valtech.assignment.Jdbc.components;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class OrderSummaryImpl implements OrderSummaryDAO{
  @Autowired
  DataSource dataSource;

	
	
	
	@Override
	public void createOrderSummary(OrderSummary ordSum) {
		String createQry="INSERT INTO Order_Summary(Order_summary_id,item_id,order_id,quantity) values(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,ordSum.getOrderSummaryId(),ordSum.getItemId(),ordSum.getOrderId(),ordSum.getQuantity());
		
	}




	@Override
	public void deleteOrderSummary(int id) {
		String deleteQry = "DELETE FROM Orders WHERE order_summary_id=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
		
	}




	@Override
	public void updateOrderSummary(OrderSummary ordSum) {
		
		String updateQry = "UPDATE EMPLOYEE SET Order_summary_id=?,item_id=?,order_id=?,quantity=? WHERE Order_summary_id=?";
		new JdbcTemplate(dataSource).update(updateQry, ordSum.getOrderSummaryId(), ordSum.getItemId(),ordSum.getOrderId(),
				ordSum.getQuantity(),ordSum.getOrderSummaryId());	
		
	}

}
