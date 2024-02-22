package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //组装成父子树形结构
        //1级分类
        List<CategoryEntity> level1Menus = entities.stream().
                filter(entity -> entity.getParentCid() == 0).
                map(entity -> {
                    entity.setChildren(getChildren(entity, entities));
                    return entity;
                }).
                sorted((entity1, entity2) ->
                        (entity1.getSort() == null ? 0 : entity1.getSort()) -
                                (entity2.getSort() == null ? 0 : entity2.getSort())).
                collect(Collectors.toList());
        return level1Menus;
    }
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(entity -> entity.getParentCid().equals(root.getCatId())).
                map(entity -> {
                    entity.setChildren(getChildren(entity, all));
                    return entity;
                }).sorted((entity1, entity2) ->
                        (entity1.getSort() == null ? 0 : entity1.getSort()) -
                                (entity2.getSort() == null ? 0 : entity2.getSort())).
                collect(Collectors.toList());
        return children;
    }

}