package com.jk.comd.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.comd.mapper.ComdMapper;
import com.jk.comd.model.Adv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.jk.utils.Commfig.PHONEKEY;


/**
 * @ClassName ComdServiceImpl
 * @Deacription TODO
 * @Author 原国庆
 * @Date 2019/11/18 15:09
 * @Version 1.0
 **/
@Service(version = "1.0")
public class ComdServiceImpl implements ComdService{

    @Autowired
    private ComdMapper comdMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List queryComdAll() {
        List arrayList = new ArrayList();
        String key=PHONEKEY;
        if(redisTemplate.hasKey(key)){
            arrayList = redisTemplate.opsForList().range(key,0,-1);
        }else{
            arrayList=comdMapper.queryComdAll();
            redisTemplate.opsForList().leftPush(key,arrayList);
        }
        return arrayList;
    }


    @Override
    public List queryComp() {
        return comdMapper.queryComp();
    }

    @Override
    public List queryTelv() {
        return comdMapper.queryTelv();
    }

    @Override
    public List queryBestSelling() {
        return comdMapper.queryBestSelling();
    }

    @Override
    public List queryReTui() {
        return comdMapper.queryReTui();
    }

    @Override
    public List queryWeek() {
        return comdMapper.queryWeek();
    }

    @Override
    public List queryGoodComm() {
        return comdMapper.queryGoodComm();
    }

    @Override
    public List queryHottesGoods() {
        return comdMapper.queryHottesGoods();
    }

    @Override
    public List<Adv> queryAdv() {
        return comdMapper.queryAdv();
    }

    @Override
    public List queryType() {
        return comdMapper.queryType();
    }

    @Override
    public List queryTypeTwo() {
        List list = comdMapper.queryTypeTwo();
        return list;
    }

    @Override
    public List queryLb() {
        return comdMapper.queryLb();
    }
}
