package com.hiveview.service;

import com.hiveview.entity.Area;

import java.util.List;

/**
 * Created by hxq on 2017/3/13.
 */
public interface IAreaService {

    List<Area> getSonAreas(long parentId);

    List<Area> getAllOneLevel();

    Area getAreaByCode(String areaCode);
}
