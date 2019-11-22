package com.jk.comd.service;

import com.jk.comd.model.Adv;
import com.jk.comd.model.Commodity;

import java.util.List;
import java.util.Map;

public interface ComdService {
    /** @Author 原国庆
     * @Description: 查询所有商品
     * @Param: [rows, page]
     * @Return: java.util.Map
     * @Create: 2019/11/18 16:34
     */
    List queryComdAll();



    /** @Author 原国庆
     * @Description:查询电脑热销前三
     * @Param: []
     * @Return: java.util.List<com.jk.comd.model.Commodity>
     * @Create: 2019/11/20 17:20
     */
    List queryComp();

    /** @Author 原国庆
     * @Description: 查询电视热销前三
     * @Param: []
     * @Return: java.util.List<com.jk.comd.model.Commodity>
     * @Create: 2019/11/20 17:26
     */
    List queryTelv();

    /** @Author 原国庆
     * @Description:查询最畅销
     * @Param: []
     * @Return: java.util.List<com.jk.comd.model.Commodity>
     * @Create: 2019/11/20 18:10
     */
    List queryBestSelling();

    /* @Author 原国庆
     * @Description:查询热推
     * @Param: []
     * @Return: java.util.List<com.jk.comd.model.Commodity>
     * @Create: 2019/11/20 19:00
     */
    List queryReTui();

    /** @Author 原国庆
     * @Description:查询周销售
     * @Param: []
     * @Return: java.util.List<com.jk.comd.model.Commodity>
     * @Create: 2019/11/20 20:10
     */
    List queryWeek();

    /** @Author 原国庆
     * @Description:好评产品
     * @Param: []
     * @Return: java.util.List
     * @Create: 2019/11/20 21:17
     */
    List queryGoodComm();

    /** @Author 原国庆
     * @Description:查询最热
     * @Param: []
     * @Return: java.util.List
     * @Create: 2019/11/20 21:54
     */
    List queryHottesGoods();

    /** @Author 原国庆
     * @Description:查询广告
     * @Param: []
     * @Return: java.util.List<com.jk.comd.model.Adv>
     * @Create: 2019/11/21 10:32
     */
    List<Adv> queryAdv();

    /** @Author 原国庆
     * @Description:所有小类
     * @Param: []
     * @Return: java.util.List
     * @Create: 2019/11/21 16:34
     */
    List queryType();


    /** @Author 原国庆
     * @Description:主搜索下面的类型
     * @Param: []
     * @Return: java.util.List
     * @Create: 2019/11/21 20:37
     */
    List queryTypeTwo();

    /** @Author 原国庆
     * @Description:大轮播图
     * @Param: []
     * @Return: java.util.List
     * @Create: 2019/11/22 10:33
     */
    List queryLb();
}