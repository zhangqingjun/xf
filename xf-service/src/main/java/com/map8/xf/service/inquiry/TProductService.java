package com.map8.xf.service.inquiry;

import com.map8.xf.dao.entity.inquiry.TProductEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangfei
 * @since 2020-07-25
 */
public interface TProductService extends IService<TProductEntity> {


    /**
     * 处理购买业务
     *
     * @param userId
     * @param productId
     * @param quantity
     * @return
     */
    public Boolean purchase(Long userId, Long productId, int quantity);
}
