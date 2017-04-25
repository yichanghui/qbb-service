package com.hiveview.service;

import com.hiveview.entity.Attribute;
import com.hiveview.entity.Category;

import java.util.List;

/**
 * Created by hxq on 2017/3/13.
 */
public interface ICategoryService {

    /**
     * 获得所有的一级类目
     * @return
     */
    List<Category> getCategory(Category category);

    /**
     * 获得子类目
     * @param parentId
     * @return
     */
    List<Category> getSonCategory(long parentId);

    List<Category> getListByCode(String code);

    Category getCategoryById(Long classId);

    /**
     * 获得类目属性
     * @param l
     * @return
     */
    List<Attribute> getCategoryAttribute(long categoryId);

    int updateCategory(Category category);

    int updateByCode(Category category);

    int deleteCategoryByCode(String code);

    void batchDelete(List<Long> ids);

    /**
     * 获得类目和他的属性
     * @param id 类目id
     * @return
     */
    Category getCategoryAndAttr(long id);

    /**
     * 修改类目和属性
     * @param category
     */
    void updateCategoryAndAttr(Category category);

    void saveCategory(Category category);

    Category getCategoryByCode(String classCode);

    Category getCategoryByIdAndType(Long categoryId, int type);
}
