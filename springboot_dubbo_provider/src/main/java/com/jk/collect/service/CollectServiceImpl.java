package com.jk.collect.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.collect.mapper.CollectMapper;
import com.jk.collect.model.Collect;
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
}
