package com.alexsanderalves.mylist.api.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.alexsanderalves.mylist.api.models.ShoppingListItem;


public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, String> {

	public ArrayList<ShoppingListItem> findAllByBelongsToList(String listId);
	
	@Modifying
	@Transactional
	@Query("update ShoppingListItem set price = :price, currency = :currency, price_date = :dateTime where id = :id")
	public void setItemPrice(@Param(value = "id") String id, 
			@Param(value = "price") BigDecimal price,
			@Param(value = "currency") String currency,
			@Param(value = "dateTime") long dateTime);
	
	@Modifying
	@Transactional
	@Query("update ShoppingListItem set countId = :countId where id = :id")
	public void markCountIn(@Param(value = "id") String id, 
			@Param(value = "countId") boolean countId);
	
	@Modifying
	@Transactional
	@Query("update ShoppingListItem set recurring = :recurring where id = :id")
	public void setRecurring(@Param(value = "id") String id, 
			@Param(value = "recurring") boolean recurring);
	
	@Modifying
	@Transactional
	@Query("update ShoppingListItem set quantity = :quantity where id = :id")
	public void setQuantity(@Param(value = "id") String id, 
			@Param(value = "quantity") int quantity);
	
}
