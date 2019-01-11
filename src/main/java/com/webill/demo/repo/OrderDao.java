package com.webill.demo.repo;

import com.webill.demo.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Orders,Integer> {

//    @Query(nativeQuery = true, value = "SELECT * FROM `order` WHERE sname = :arg1  AND age = :arg2 ")
//    List<Orders> getAllBills(@Param("arg1") String weid, @Param("arg2") Integer ag);

//    List<Orders> findAllByWechat_id(String wechatid);
}
