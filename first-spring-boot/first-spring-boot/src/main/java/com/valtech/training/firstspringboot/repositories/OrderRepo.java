package com.valtech.training.firstspringboot.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.firstspringboot.entities.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
    @Query(value="SELECT o from ORDER o where o.itemCounter=?1")
	List<Order> findAllByItemCounter(int itemCounter);
	List<Order> findAllByItemCounterGreaterThan(int itemCounter);
	List<Order> findAllByItemAndItemCounter(String item,int itemCounter);
	int countByItem(String item);
}
