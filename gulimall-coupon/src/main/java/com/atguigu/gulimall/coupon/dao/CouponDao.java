package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wangguangtao
 * @email wgt@gmail.com
 * @date 2024-01-23 15:12:02
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
