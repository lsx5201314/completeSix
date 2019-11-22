package com.jk.comd.mapper;

import com.jk.comd.model.Adv;

import java.util.List;

public interface ComdMapper {

    List queryComdAll();

    List queryComp();

    List queryTelv();

    List queryBestSelling();

    List queryReTui();

    List queryWeek();

    List queryGoodComm();

    List queryHottesGoods();

    List<Adv> queryAdv();

    List queryType();

    List queryTypeTwo();

    List queryLb();
}
