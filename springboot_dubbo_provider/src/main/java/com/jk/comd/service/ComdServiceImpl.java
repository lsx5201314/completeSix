package com.jk.comd.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.comd.mapper.ComdMapper;
import com.jk.comd.model.Adv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jk.utils.Commfig.*;


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
        List list=new ArrayList();
        String key=COMPKEY;
        if(redisTemplate.hasKey(key)){
            list = redisTemplate.opsForList().range(key,0,-1);
        }else{
            list=comdMapper.queryComp();
            redisTemplate.opsForList().leftPush(key,list);
            redisTemplate.expire(key,10, TimeUnit.DAYS);
        }
        return list;
    }

    @Override
    public List queryTelv() {
        List list = comdMapper.queryTelv();
        String key=TELEVKEY;
        if(redisTemplate.hasKey(key)){
            list = redisTemplate.opsForList().range(key,0,-1);
        }else{
            list=comdMapper.queryTelv();
            redisTemplate.opsForList().leftPush(key,list);
            redisTemplate.expire(key,10,TimeUnit.DAYS);
        }
        return list;
    }

    @Override
    public List queryBestSelling() {
        return comdMapper.queryBestSelling();
    }

    @Override
    public List queryReTui() {
        List list = new ArrayList();
        String key=HOSTKEY;
        if(redisTemplate.hasKey(key)){
            list=redisTemplate.opsForList().range(key,0,-1);
        }else{
            list = comdMapper.queryReTui();
            redisTemplate.opsForList().leftPush(key,list);
            redisTemplate.expire(key,1,TimeUnit.DAYS);
        }
        return list;
    }

    @Override
    public List queryWeek() {
        List list = new ArrayList();
        String key=WEEKKEY;
        if(redisTemplate.hasKey(key)){
            list=redisTemplate.opsForList().range(key,0,-1);
        }else{
            list=comdMapper.queryWeek();
            redisTemplate.opsForList().leftPush(key,list);
            redisTemplate.expire(key,7,TimeUnit.DAYS);
        }
        return list;
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
        List<Adv> list=new ArrayList<>();
        String key=ADVKEY;
        redisTemplate.delete(key);
        if (redisTemplate.hasKey(key)) {
            list=redisTemplate.opsForList().range(key,0,-1);
        }else{
            list=comdMapper.queryAdv();
            redisTemplate.opsForList().leftPush(key,list);
            redisTemplate.expire(key,15, TimeUnit.DAYS);
        }
        return list;
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
        List list = new ArrayList<>();
        String key=LBTKEY;
        if(redisTemplate.hasKey(key)){
            list=redisTemplate.opsForList().range(key,0,-1);
        }else{
            list = comdMapper.queryLb();
            redisTemplate.opsForList().leftPush(key,list);
            redisTemplate.expire(key,15,TimeUnit.DAYS);
        }
        return list;
    }
}
