package com.jk.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.user.model.CmsUser;
import com.jk.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public CmsUser queryCmsUser(String cmsUserName) {
        return userMapper.queryCmsUser(cmsUserName);
    }

    @Override
    public void addCmsUser(CmsUser cmsUser) {
        userMapper.addCmsUser(cmsUser);
    }

    @Override
    public CmsUser queryForgetPwd(String cmsUserName) {
        return userMapper.queryForgetPwd(cmsUserName);
    }

    @Override
    public void updatePwd(CmsUser cmsUser) {
        userMapper.updatePwd(cmsUser);
    }
}
