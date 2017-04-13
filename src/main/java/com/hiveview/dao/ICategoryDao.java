package com.hiveview.dao;

import com.hiveview.entity.Category;

import java.util.List;

public interface ICategoryDao extends  IBaseDao<Category>{
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getSonCategory(long parentId);

    /* 只查少部分内容 */
    List<Category> getListByCode(String code);

    int deleteCategoryByCode(String code);

    int batchDelete(List<Long> ids);

    List<Category> getCategoryAndAttr(Category category);

    int updateByCode(Category category);
}