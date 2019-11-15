package com.jk.user.service;

import com.jk.user.model.CmsUser;

public interface UserService {

    CmsUser queryCmsUser(String cmsUserName);

    void addCmsUser(CmsUser cmsUser);
}
