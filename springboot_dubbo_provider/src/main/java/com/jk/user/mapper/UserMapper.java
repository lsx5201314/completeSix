package com.jk.user.mapper;

import com.jk.user.model.CmsUser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /** @Author 原国庆
     * @Description: 用户登录验证
     * @Param: [cmsUserName]
     * @Return: com.jk.user.model.CmsUser
     * @Create: 2019/11/14 20:51
     */
    CmsUser queryCmsUser(@Param("cmsUserName") String cmsUserName);

    void addCmsUser(CmsUser cmsUser);
}
