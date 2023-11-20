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
public class CustomerDAOImpl implements CustomerDAO {
	
	
	
	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

			Customer c = new Customer();
			c.setCustId(rs.getInt(1));
			c.setAddress(rs.getString(2));
			c.setName(rs.getString(3));
			c.setPhno(4);
			return c;

		}

	}
	
@Autowired
DataSource dataSource;
	
	
	
	
	@Override
	public long count() {
		
		String countQry = "SELECT COUNT(cust_Id) FROM CUSTOMER";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void deleteCustomer(int id) {
		String deleteQry="DELETE FROM Customer WHERE cust_Id=?";
		new JdbcTemplate(dataSource).update(deleteQry,id);
	}

	@Override
	public void updateCustomer(Customer cust) {
		String updateQry="UPDATE CUSTOMER SET cust_id=?,address=?,name=?,phno=? WHERE cust_Id=?";
		new JdbcTemplate(dataSource).update(updateQry,cust.getCustId(),cust.getAddress(),cust.getName(),cust.getPhno());
		
	}

	@Override
	public void createCustomer(Customer cust) {
		String createQry="INSERT INTO CUSTOMER(CUST_ID,ADDRESS,NAME,PHNO) values(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,cust.getCustId(),cust.getAddress(),cust.getName(),cust.getPhno());
		
	}

	

	@Override
	public List<Customer> getAllCustomers() {
		String selectAllQry = "SELECT CUST_ID,ADDRESS,NAME,PHNO FROM CUSTOMER";

		return new JdbcTemplate(dataSource).query(selectAllQry, new CustomerRowMapper());
	}

	@Override
	public Customer getCustomer(int id) {
		String selectQry = "SELECT CUST_ID,ADDRESS,NAME,PHNO FROM CUSTOMER WHERE Cust_ID=?" + id;
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new CustomerRowMapper());
	}
//	public static void main(String[] args) {
//		CustomerDAO customer=new CustomerDAOImpl();
//		customer.createCustomer(new Customer(1,"Banglore","abc",5667886));
//		
//	}
	
	
	
	
	

}
