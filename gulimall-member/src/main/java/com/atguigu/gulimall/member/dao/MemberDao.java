package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wangguangtao
 * @email wgt@gmail.com
 * @date 2024-01-23 15:37:57
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
