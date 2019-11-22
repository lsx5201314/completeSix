package com.jk.collect.mapper;

import com.jk.collect.model.Collect;
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
}
