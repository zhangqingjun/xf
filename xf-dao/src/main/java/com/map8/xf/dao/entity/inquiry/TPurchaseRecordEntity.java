package com.map8.xf.dao.entity.inquiry;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangfei
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_purchase_record")
public class TPurchaseRecordEntity extends Model<TPurchaseRecordEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 产品编号
     */
    @TableField("product_id")
    private Integer productId;

    /**
     * 单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 数量
     */
    @TableField("quantity")
    private Integer quantity;

    /**
     * 总价
     */
    @TableField("sum")
    private BigDecimal sum;

    /**
     * 购买日期
     */
    @TableField("purchase_date")
    private LocalDateTime purchaseDate;

    /**
     * 备注
     */
    @TableField("note")
    private String note;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
