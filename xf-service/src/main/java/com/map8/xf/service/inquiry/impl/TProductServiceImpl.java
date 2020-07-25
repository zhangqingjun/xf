package com.map8.xf.service.inquiry.impl;

import com.map8.xf.dao.entity.inquiry.TProductEntity;
import com.map8.xf.dao.entity.inquiry.TPurchaseRecordEntity;
import com.map8.xf.dao.mapper.inquiry.TProductMapper;
import com.map8.xf.service.inquiry.TProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.map8.xf.service.inquiry.TPurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangfei
 * @since 2020-07-25
 */
@Service
public class TProductServiceImpl extends ServiceImpl<TProductMapper, TProductEntity> implements TProductService {


    @Resource
    private TPurchaseRecordService tPurchaseRecordService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean purchase(Long userId, Long productId, int quantity) {
        TProductEntity tProductEntity = this.baseMapper.getProduct(productId);
        if (tProductEntity.getStock() < quantity) {
            return false;
        }
        this.baseMapper.decreaseProduct(productId, quantity);
        TPurchaseRecordEntity tPurchaseRecordEntity = new TPurchaseRecordEntity();
        tPurchaseRecordEntity.setUserId(userId.intValue());
        tPurchaseRecordEntity.setProductId(tProductEntity.getId());
        tPurchaseRecordEntity.setQuantity(quantity);
        tPurchaseRecordEntity.setPrice(tProductEntity.getPrice());
        tPurchaseRecordEntity.setSum(tProductEntity.getPrice().multiply(new BigDecimal(quantity)));
        tPurchaseRecordEntity.setPurchaseDate(LocalDateTime.now());
        tPurchaseRecordEntity.setNote("购买日志,时间：" + System.currentTimeMillis());
        return tPurchaseRecordService.save(tPurchaseRecordEntity);
    }
}
