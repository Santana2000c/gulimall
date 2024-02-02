package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OmsOrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wangguangtao
 * @email wgt@gmail.com
 * @date 2024-01-23 15:46:03
 */
@Mapper
public interface OmsOrderDao extends BaseMapper<OmsOrderEntity> {
	
}
