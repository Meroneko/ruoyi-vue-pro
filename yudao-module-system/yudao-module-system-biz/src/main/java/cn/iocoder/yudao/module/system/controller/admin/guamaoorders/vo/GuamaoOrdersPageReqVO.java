package cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 订单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GuamaoOrdersPageReqVO extends PageParam {

    @Schema(description = "订单日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] orderTime;

    @Schema(description = "用户id")
    private String userId;

    @Schema(description = "平台订单号")
    private String orderId;

    @Schema(description = "平台")
    private String platform;

    @Schema(description = "商品名")
    private String itemName;

    @Schema(description = "岛内发送方式")
    private String deliveryMethod;

    @Schema(description = "发货地")
    private String deliveryFrom;

    @Schema(description = "发货所需日数")
    private String costDays;

    @Schema(description = "是否到付")
    private Boolean freightCollect;

    @Schema(description = "是否发货（0未发货 1已发货）")
    private Boolean delivered;

    @Schema(description = "发货日（检查运输状态的日期）")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDate[] shippedDate;

    @Schema(description = "追跡番号")
    private String trackingNumber;

    @Schema(description = "警告")
    private Boolean alert;

    @Schema(description = "订单状态", example = "2")
    private Boolean status;

    @Schema(description = "入库编号", example = "30908")
    private String storageId;

    @Schema(description = "卖家姓名", example = "李四")
    private String sellerName;

    @Schema(description = "卖家主页链接", example = "https://www.iocoder.cn")
    private String sellerUrl;

    @Schema(description = "头图链接", example = "https://www.iocoder.cn")
    private String headImgUrl;

    @Schema(description = "入库日")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] arrivalDate;

    @Schema(description = "入库重量")
    private Long arrvialWeight;

    @Schema(description = "货架号")
    private Integer shelfNo;

    @Schema(description = "离岛批次号", example = "3221")
    private String dispatchId;

    @Schema(description = "离岛日")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] dispatchDate;

    @Schema(description = "离岛运单号")
    private String dispatchTrkNo;

    @Schema(description = "国内运单号")
    private String domesticTrackNumber;

    @Schema(description = "是否确认收货（0未确认 1已确认）")
    private Boolean confirmed;

    @Schema(description = "确认收货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] confirmedTime;

    @Schema(description = "商品价格JPY", example = "16841")
    private BigDecimal itemPrice;

    @Schema(description = "切煤汇率")
    private BigDecimal tradeRate;

    @Schema(description = "应收RMB")
    private BigDecimal receiRmb;

    @Schema(description = "实收RMB")
    private BigDecimal paidRmb;

    @Schema(description = "收款方式")
    private String receiMethod;

    @Schema(description = "支付方式")
    private String paymentMethod;

    @Schema(description = "利润rmb")
    private String profitRmb;

    @Schema(description = "利润jpy")
    private String profitJpy;

    @Schema(description = "是否取消（0 未取消 1 已取消）")
    private Boolean cancelled;

    @Schema(description = "备注")
    private String note;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}