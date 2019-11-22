package com.jk.user.service;

import com.jk.user.model.CmsUser;

public interface UserService {
    /** @Author 原国庆
     * @Description: 查询登录用户信息
     * @Param: [cmsUserName]
     * @Return: com.jk.user.model.CmsUser
     * @Create: 2019/11/18 15:00
     */
    CmsUser queryCmsUser(String cmsUserName);

    /** @Author 原国庆
     * @Description: 新增注册用户
     * @Param: [cmsUser]
     * @Return: void
     * @Create: 2019/11/18 15:01
     */
    void addCmsUser(CmsUser cmsUser);

    /** @Author 原国庆
     * @Description: 忘记密码查询
     * @Param: [cmsUserName]
     * @Return: com.jk.user.model.CmsUser
     * @Create: 2019/11/18 18:47 
     */
    CmsUser queryForgetPwd(String cmsUserName);

    /** @Author 原国庆
     * @Description: 修改密码
     * @Param: [cmsUser]
     * @Return: void
     * @Create: 2019/11/19 11:56
     */
    void updatePwd(CmsUser cmsUser);
}
