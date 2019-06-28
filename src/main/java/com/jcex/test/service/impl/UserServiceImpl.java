package com.jcex.test.service.impl;

import com.jcex.test.dao.mysqlMapper.UserRepository;
import com.jcex.test.dao.sqlserverMapper.CustomInterface;
import com.jcex.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepository")
    UserRepository userRepository;
    @Autowired
    @Qualifier("customInterface")
    CustomInterface customInterface;

    public String selectcustomerreferencenumber(String waybillnumber){
        String selectcustomerreferencenumber = userRepository.selectcustomerreferencenumber(waybillnumber);
        return selectcustomerreferencenumber;
    }

    public String selectcustomerid(String name) {
        String selectcustomerid = customInterface.selectcustomerid(name);
        return selectcustomerid;
    }


//    @Transactional
//    public User saveUser(String name,Integer age, String address){
//        User user = new User(name, age, address);
//        return userRepository.save(user);
//    }
}
