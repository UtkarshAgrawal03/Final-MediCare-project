package com.medicare.medserver.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicare.medserver.modules.Cart;
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
	@Query(value="select * from Cart  where user_id=:userid and product_id=:productid",nativeQuery=true)
	public Cart userandproductid(@Param("userid") int userid,@Param("productid") int productid);
	@Query(value="select * from Cart  where user_id=:userid ",nativeQuery=true)
	public List<Cart> findByUserid(int userid);

}
