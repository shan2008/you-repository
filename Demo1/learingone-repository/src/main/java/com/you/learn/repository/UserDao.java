package com.you.learn.repository;

import com.you.learn.entity.UserEntity;

/**
 * Created by syou on 2017/7/4.
 */
public interface UserDao {

    void saveUser(UserEntity userEntity);
}
