package com.jk.collect.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.collect.mapper.CollectMapper;
import com.jk.collect.model.Collect;
import com.jk.goods.model.Commodity;
import com.jk.order.model.TOrder;
import com.jk.talk.model.Talk;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CollectServiceImpl
 * @Description
 * @Author
 * @Date 2019/11/22 10:59
 * @Version V1.0
 **/
@Service(version = "1.1")

public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public List<Collect> queryCollect(Integer id) {
        return collectMapper.queryCollect(id);
    }

    @Override
    public void deleteCollect(Integer id) {
        collectMapper.deleteCollect(id);
    }

    @Override
    public void addCollect(Integer commodityId,Integer id) {
        collectMapper.addCollect(id,commodityId);
    }

    @Override
    public List<TOrder> myOrder(Integer cmsUserId) {
        return collectMapper.myOrder(cmsUserId);
    }

    @Override
    public List<Commodity> detailed(Integer id) {
        return collectMapper.detailed(id);
    }

    @Override
    public Talk addTalk(Integer id, Integer cmsUserId) {
        return collectMapper.addTalk(id,cmsUserId);
    }

    @Override
    public void addTalk2(Integer userId,Integer id, String talkinfo) {
        collectMapper.addTalk2(userId,id,talkinfo);
    }

    @Override
    public Collect queryCollectByCommodityId(Integer commodityId) {
        return collectMapper.queryCollectByCommodityId(commodityId);
    }

    @Override
    public void deleteCollectAll(Integer commodityId, Integer cmsUserId) {
        collectMapper.deleteCollectAll(commodityId,cmsUserId);
    }
}
