package com.hiveview.service.impl;

import com.hiveview.dao.ICategoryDao;
import com.hiveview.dao.IClassAttributeDao;
import com.hiveview.entity.Attribute;
import com.hiveview.entity.Category;
import com.hiveview.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.LevelUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by hxq on 2017/3/13.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;
    @Autowired
    private IClassAttributeDao classAttributeDao;


    @Override
    public List<Category> getCategory(Category category) {
        return categoryDao.getList(category);
    }

    @Override
    public List<Category> getSonCategory(long parentId) {
        return categoryDao.getSonCategory(parentId);
    }

    @Override
    public Category getCategoryById(Long classId) {
        return categoryDao.selectByPrimaryKey(classId);
    }

    @Override
    public List<Attribute> getCategoryAttribute(long categoryId) {
        Attribute attribute = new Attribute();
        attribute.setClassId(categoryId);
        return classAttributeDao.getList(attribute);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryDao.updateByPrimaryKeySelective(category);
    }
    @Override
    public int updateByCode(Category category) {
        return categoryDao.updateByCode(category);
    }

    @Override
    public int deleteCategoryByCode(String code) {
        return categoryDao.deleteCategoryByCode(code);
    }

    @Override
    public void batchDelete(List<Long> ids) {
         categoryDao.batchDelete(ids);
    }

    @Override
    public Category getCategoryAndAttr(long id) {
        Category category = new Category();
        category.setId(id);
        List<Category> categories = categoryDao.getCategoryAndAttr(category);
        Category result = Optional.ofNullable(categories).filter(c -> c.size() > 0).map(c1 -> c1.get(0)).orElse(null);
        return result;
    }

    @Override
    public void updateCategoryAndAttr(Category category) {
        categoryDao.updateByPrimaryKeySelective(category);
        List<Attribute> attrs = category.getAttributes();
        if (CollectionUtils.isNotEmpty(attrs)) {
            List<Attribute> isNoNullData = attrs.stream().filter(attribute -> StringUtils.isNotEmpty(attribute.getName())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(isNoNullData)) {
                classAttributeDao.deleteByClassId(isNoNullData.get(0).getClassId());
                classAttributeDao.batchSaveAttr(isNoNullData);
            }
        }
    }

    @Override
    public void saveCategory(Category category) {
        category.setAddTime(new Date());
        categoryDao.insertSelective(category);
        String code;
        if (category.getLevel() == LevelUtil.ONE_LEVEL.getVal()) {
            code = category.getId() + "-";
        } else {
            code = category.getParentCode()+category.getId() + "-";
        }
        category.setCode(code);
        categoryDao.updateByPrimaryKeySelective(category);
    }

}
