package com.jk.collect.service;

import com.jk.collect.model.Collect;
import com.jk.goods.model.Commodity;
import com.jk.order.model.TOrder;
import com.jk.talk.model.Talk;

import java.util.List;

/**
 * @ClassName CollectService
 * @Description
 * @Author
 * @Date 2019/11/22 10:47
 * @Version V1.0
 **/
public interface CollectService {
    List<Collect> queryCollect(Integer id);

    void deleteCollect(Integer id);

    void addCollect(Integer commodityId,Integer id);

    List<TOrder> myOrder(Integer cmsUserId);

    List<Commodity> detailed(String id);

    Talk addTalk(Integer id, Integer cmsUserId);

    void addTalk2(Integer userid,Integer id, String talkinfo);

    Collect queryCollectByCommodityId(Integer commodityId);

    void deleteCollectAll(Integer commodityId, Integer cmsUserId);
}
