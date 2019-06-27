package com.JCEX.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.JCEX.pojo.TrackMsg;
import com.JCEX.pojo.Wishztb;

@Repository
public interface Wishtrack {
     public List<TrackMsg> selectWishtrack(String waybillnumber);
     public Wishztb selectWishStatus(String waybillnumber);
}
