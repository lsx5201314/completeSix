package com.jk.collect.mapper;

import com.jk.collect.model.Collect;
import com.jk.goods.model.Commodity;
import com.jk.order.model.TOrder;
import com.jk.talk.model.Talk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CollectMapper
 * @Description
 * @Author
 * @Date 2019/11/22 11:00
 * @Version V1.0
 **/
public interface CollectMapper {
    List<Collect> queryCollect(@Param("userId") Integer userId);

    void deleteCollect(@Param("id") Integer id);

    void addCollect(@Param("userId") Integer userId, @Param("commodityId") Integer commodityId);

    List<TOrder> myOrder(@Param("cmsUserId") Integer cmsUserId);

    List<Commodity> detailed(@Param("id") Integer id);

    Talk addTalk(@Param("id") Integer id,@Param("cmsUserId") Integer cmsUserId);

    void addTalk2(@Param("userid") Integer userid,@Param("id") Integer id, @Param("talkinfo") String talkinfo);

    Collect queryCollectByCommodityId(@Param("commodityId") Integer commodityId);

    void deleteCollectAll(@Param("commodityId") Integer commodityId,@Param("cmsUserId") Integer cmsUserId);
}
