package com.valtech.assignment.Jdbc.components;

public interface OrderSummaryDAO {
	void createOrderSummary(OrderSummary ordSum);
	void deleteOrderSummary(int id);

	void updateOrderSummary(OrderSummary ordSum);

}
