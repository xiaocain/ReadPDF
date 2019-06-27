package com.JCEX.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JCEX.dao.Wishtrack;
import com.JCEX.pojo.TrackMsg;
import com.JCEX.pojo.WishWaybillnumer;
import com.JCEX.pojo.Wishztb;
import com.JCEX.service.WishTrackService;
@Service
@Transactional
public class WishTrackImpl implements WishTrackService {
    @Autowired
	private Wishtrack wishtrack;
	
	public WishWaybillnumer Wishtrack(String waybillnumber) {
		
		List<TrackMsg> selectWishtrack = wishtrack.selectWishtrack(waybillnumber);
		int jccode_one=0;
		try{
			jccode_one = wishtrack.selectWishStatus(waybillnumber).getJccode_one();
		}catch(NullPointerException ex){
			
		}
		
		WishWaybillnumer wishWaybillnumer = new WishWaybillnumer();
		String destination_countrycode="";
		for (int i=0;i<selectWishtrack.size();i++) {
			destination_countrycode = selectWishtrack.get(i).getDestination_countrycode();
			if(selectWishtrack.get(i).getShippingstatus().equals("DELIVERED")){
				if(jccode_one==10){
					wishWaybillnumer.setWaybillnumber(waybillnumber);
					wishWaybillnumer.setCountry(destination_countrycode);
					wishWaybillnumer.setMessage("系统签收推送无问题");
					return wishWaybillnumer;
				}else{
					wishWaybillnumer.setWaybillnumber(waybillnumber);
					wishWaybillnumer.setCountry(destination_countrycode);
					wishWaybillnumer.setMessage("系统已签收但是无推送");
					return wishWaybillnumer;
				}
			}
			continue;
		}
		wishWaybillnumer.setWaybillnumber(waybillnumber);
		wishWaybillnumer.setCountry(destination_countrycode);
		wishWaybillnumer.setMessage("系统无签收");
		return wishWaybillnumer;
	}

}
