package com.hiveview.service;

import com.hiveview.entity.NeedRecommend;

import java.util.List;

/**
 * Created by hxq on 2017/3/13.
 */
public interface INeedRecommendService {


    List<NeedRecommend> getNeedRecommendPage(NeedRecommend productRecommend);

    void updateRecommend(NeedRecommend productRecommend);

    void saveRecommend(NeedRecommend productRecommend);

    NeedRecommend getNeedRecommendByNId(long productId);
}
