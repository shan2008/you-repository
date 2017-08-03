package com.you.learn.repository.impl;

import com.you.learn.entity.UserEntity;
import com.you.learn.repository.UserDao;

/**
 * Created by syou on 2017/7/4.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(UserEntity userEntity) {
        System.out.println("*****保存用户*****");
    }
}
