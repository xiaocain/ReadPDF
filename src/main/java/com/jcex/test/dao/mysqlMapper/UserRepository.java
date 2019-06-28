package com.jcex.test.dao.mysqlMapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//继承JpaRepository可自动完成基本的数据库操作 自带方法 第一个参数是数据库数据对应的实体类 第二个参数是数据库实体类的主键类型

@Repository("userRepository")
@Mapper
public interface UserRepository {
//extends JpaRepository<User, Long>
//    @Query("select customer_reference_number FROM csd_order WHERE shipper_hawbcode=:waybillnumber")
//    @Select("select customer_reference_number from csd_order where shipper_hawbcode=#{waybillnumber}")
    String selectcustomerreferencenumber(@Param("waybillnumber") String waybillnumber);

}
