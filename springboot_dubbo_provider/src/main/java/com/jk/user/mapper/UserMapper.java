package com.jk.user.mapper;

import com.jk.user.model.CmsUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    CmsUser queryCmsUser(@Param("cmsUserName") String cmsUserName);

    void addCmsUser(CmsUser cmsUser);

    CmsUser queryForgetPwd(@Param("cmsUserName") String cmsUserName);

    void updatePwd(CmsUser cmsUser);
}
