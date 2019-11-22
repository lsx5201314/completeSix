package com.jk.collect.service;

import com.jk.collect.model.Collect;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CollectService
 * @Description
 * @Author
 * @Date 2019/11/22 10:47
 * @Version V1.0
 **/
public interface CollectService {
    List<Collect> queryCollect(HttpServletRequest request);

    void deleteCollect(Integer id);

    void addCollect(Integer commodityId,HttpServletRequest request);
}
