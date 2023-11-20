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
public class ItemsDAOImpl implements ItemsDAO{

	public class ItemsRowMapper implements RowMapper<Items> {

		@Override
		public Items mapRow(ResultSet rs, int rowNum) throws SQLException {

			

			Items i = new Items();
			i.setItemid(rs.getInt(1));
			i.setCompId(rs.getInt(2));
			i.setItemDesc(rs.getString(3));
			i.setUnitPrice(rs.getInt(4));
			return i;

		}

	}
	
	
	
	
	@Autowired
	DataSource dataSource;
	@Override
	public long count() {
		String countQry = "SELECT COUNT(itemid) FROM ITEMS";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	@Override
	public void deleteItem(int id) {
		String deleteQry="DELETE FROM ITEMS WHERE itemid=?";
		new JdbcTemplate(dataSource).update(deleteQry,id);		
	}

	@Override
	public void updateItem(Items item) {
		String updateQry="UPDATE ITEMS SET itemid=?,comp_Id=?,item_desc=?,unit_price=? WHERE itemid=?";
		new JdbcTemplate(dataSource).update(updateQry,item.getItemid(),item.getCompId(),item.getItemDesc(),item.getUnitPrice(),item.getItemid());		
	}

	@Override
	public void createItem(Items item) {
		String createQry="INSERT INTO ITEMS(ITEMID,COMP_ID,ITEM_DESC,UNIT_PRICE) values(?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry,item.getItemid(),item.getCompId(),item.getItemDesc(),item.getUnitPrice());
				
	}

	@Override
	public List<Items> getAllItems() {
		String selectAllQry = "SELECT ITEMID,COMP_ID,ITEM_DESC,UNIT_PRICE FROM Items";

		return new JdbcTemplate(dataSource).query(selectAllQry, new ItemsRowMapper());
	}

	@Override
	public Items getItem(int id) {
		String selectQry = "SELECT ITEMID,COMP_ID,ITEM_DESC,UNIT_PRICE FROM EMPLOYEE WHERE ITEMID=?" + id;
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new ItemsRowMapper());
	}
	

}
