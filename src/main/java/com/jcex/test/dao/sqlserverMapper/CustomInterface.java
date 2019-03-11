package com.jcex.test.dao.sqlserverMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("customInterface")
@Mapper
public interface CustomInterface {
    //TEST891904144326893
//    @Select("SELECT DISTINCT top 1 serviceGUID FROM customer_interface WHERE reference_number=#{reference_number}")
    String selectcustomerid(@Param("reference_number") String reference_number);
}
