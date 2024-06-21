package cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 订单新增/修改 Request VO")
@Data
public class GuamaoOrdersSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "订单日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "订单日期不能为空")
    private LocalDateTime orderTime;

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "用户id不能为空")
    private String userId;

    @Schema(description = "平台订单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "平台订单号不能为空")
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

    @Schema(description = "是否发货（0未发货 1已发货）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否发货（0未发货 1已发货）不能为空")
    private Boolean delivered;

    @Schema(description = "发货日（检查运输状态的日期）")
    private LocalDate shippedDate;

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
    private LocalDateTime arrivalDate;

    @Schema(description = "入库重量")
    private Long arrvialWeight;

    @Schema(description = "货架号")
    private Integer shelfNo;

    @Schema(description = "离岛批次号", example = "3221")
    private String dispatchId;

    @Schema(description = "离岛日")
    private LocalDateTime dispatchDate;

    @Schema(description = "离岛运单号")
    private String dispatchTrkNo;

    @Schema(description = "国内运单号")
    private String domesticTrackNumber;

    @Schema(description = "是否确认收货（0未确认 1已确认）", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否确认收货（0未确认 1已确认）不能为空")
    private Boolean confirmed;

    @Schema(description = "确认收货时间")
    private LocalDateTime confirmedTime;

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

}