package com.map8.xf.dao.entity.inquiry;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_product")
public class TProductEntity extends Model<TProductEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品名称
     */
    @TableField("product_name")
    private String productName;

    /**
     * 库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 版本号
     */
    @TableField("version")
    private Integer version;

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
