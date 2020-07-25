package com.map8.xf.dao.mapper.inquiry;

import com.map8.xf.dao.entity.inquiry.TProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangfei
 * @since 2020-07-25
 */

@Mapper
public interface TProductMapper extends BaseMapper<TProductEntity> {

    /** 获取产品
     * @param id
     * @return
     */
    public TProductEntity getProduct(Long id);

    /** 扣减库存
     * @param id
     * @param quantity
     * @return
     */
    public int decreaseProduct(@Param("id") Long id,@Param("quantity") int quantity);

}
