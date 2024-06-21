package cn.iocoder.yudao.module.system.dal.dataobject.guamaoorders;

import lombok.*;

import java.time.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 订单 DO
 *
 * @author 芋道源码
 */
@TableName("system_guamao_orders")
@KeySequence("system_guamao_orders_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuamaoOrdersDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 订单日期
     */
    private LocalDateTime orderTime;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 平台订单号
     */
    private String orderId;
    /**
     * 平台
     *
     * 枚举 {@link TODO platform_type 对应的类}
     */
    private String platform;
    /**
     * 商品名
     */
    private String itemName;
    /**
     * 岛内发送方式
     *
     * 枚举 {@link TODO delivery_method 对应的类}
     */
    private String deliveryMethod;
    /**
     * 发货地
     *
     * 枚举 {@link TODO japan_district 对应的类}
     */
    private String deliveryFrom;
    /**
     * 发货所需日数
     *
     * 枚举 {@link TODO cost_days_type 对应的类}
     */
    private String costDays;
    /**
     * 是否到付
     *
     * 枚举 {@link TODO infra_boolean_string 对应的类}
     */
    private Boolean freightCollect;
    /**
     * 是否发货（0未发货 1已发货）
     *
     * 枚举 {@link TODO infra_boolean_string 对应的类}
     */
    private Boolean delivered;
    /**
     * 发货日（检查运输状态的日期）
     */
    private LocalDate shippedDate;
    /**
     * 追跡番号
     */
    private String trackingNumber;
    /**
     * 警告
     *
     * 枚举 {@link TODO infra_boolean_string 对应的类}
     */
    private Boolean alert;
    /**
     * 订单状态
     *
     * 枚举 {@link TODO order_status 对应的类}
     */
    private Boolean status;
    /**
     * 入库编号
     */
    private String storageId;
    /**
     * 卖家姓名
     */
    private String sellerName;
    /**
     * 卖家主页链接
     */
    private String sellerUrl;
    /**
     * 头图链接
     */
    private String headImgUrl;
    /**
     * 入库日
     */
    private LocalDateTime arrivalDate;
    /**
     * 入库重量
     */
    private Long arrvialWeight;
    /**
     * 货架号
     */
    private Integer shelfNo;
    /**
     * 离岛批次号
     */
    private String dispatchId;
    /**
     * 离岛日
     */
    private LocalDateTime dispatchDate;
    /**
     * 离岛运单号
     */
    private String dispatchTrkNo;
    /**
     * 国内运单号
     */
    private String domesticTrackNumber;
    /**
     * 是否确认收货（0未确认 1已确认）
     *
     * 枚举 {@link TODO infra_boolean_string 对应的类}
     */
    private Boolean confirmed;
    /**
     * 确认收货时间
     */
    private LocalDateTime confirmedTime;
    /**
     * 商品价格JPY
     */
    private BigDecimal itemPrice;
    /**
     * 切煤汇率
     */
    private BigDecimal tradeRate;
    /**
     * 应收RMB
     */
    private BigDecimal receiRmb;
    /**
     * 实收RMB
     */
    private BigDecimal paidRmb;
    /**
     * 收款方式
     */
    private String receiMethod;
    /**
     * 支付方式
     */
    private String paymentMethod;
    /**
     * 利润rmb
     */
    private String profitRmb;
    /**
     * 利润jpy
     */
    private String profitJpy;
    /**
     * 是否取消（0 未取消 1 已取消）
     *
     * 枚举 {@link TODO infra_boolean_string 对应的类}
     */
    private Boolean cancelled;
    /**
     * 备注
     */
    private String note;

}