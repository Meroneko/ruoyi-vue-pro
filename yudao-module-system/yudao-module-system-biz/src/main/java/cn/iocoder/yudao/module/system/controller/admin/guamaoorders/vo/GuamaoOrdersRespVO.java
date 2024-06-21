package cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 订单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GuamaoOrdersRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "订单日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("订单日期")
    private LocalDateTime orderTime;

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("用户id")
    private String userId;

    @Schema(description = "平台订单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("平台订单号")
    private String orderId;

    @Schema(description = "平台")
    @ExcelProperty(value = "平台", converter = DictConvert.class)
    @DictFormat("platform_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String platform;

    @Schema(description = "商品名")
    @ExcelProperty("商品名")
    private String itemName;

    @Schema(description = "岛内发送方式")
    @ExcelProperty(value = "岛内发送方式", converter = DictConvert.class)
    @DictFormat("delivery_method") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String deliveryMethod;

    @Schema(description = "发货地")
    @ExcelProperty(value = "发货地", converter = DictConvert.class)
    @DictFormat("japan_district") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String deliveryFrom;

    @Schema(description = "发货所需日数")
    @ExcelProperty(value = "发货所需日数", converter = DictConvert.class)
    @DictFormat("cost_days_type") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String costDays;

    @Schema(description = "是否到付")
    @ExcelProperty(value = "是否到付", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean freightCollect;

    @Schema(description = "是否发货（0未发货 1已发货）", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "是否发货（0未发货 1已发货）", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean delivered;

    @Schema(description = "发货日（检查运输状态的日期）")
    @ExcelProperty("发货日（检查运输状态的日期）")
    private LocalDate shippedDate;

    @Schema(description = "追跡番号")
    @ExcelProperty("追跡番号")
    private String trackingNumber;

    @Schema(description = "警告")
    @ExcelProperty(value = "警告", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean alert;

    @Schema(description = "订单状态", example = "2")
    @ExcelProperty(value = "订单状态", converter = DictConvert.class)
    @DictFormat("order_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean status;

    @Schema(description = "入库编号", example = "30908")
    @ExcelProperty("入库编号")
    private String storageId;

    @Schema(description = "卖家姓名", example = "李四")
    @ExcelProperty("卖家姓名")
    private String sellerName;

    @Schema(description = "卖家主页链接", example = "https://www.iocoder.cn")
    @ExcelProperty("卖家主页链接")
    private String sellerUrl;

    @Schema(description = "头图链接", example = "https://www.iocoder.cn")
    @ExcelProperty("头图链接")
    private String headImgUrl;

    @Schema(description = "入库日")
    @ExcelProperty("入库日")
    private LocalDateTime arrivalDate;

    @Schema(description = "入库重量")
    @ExcelProperty("入库重量")
    private Long arrvialWeight;

    @Schema(description = "货架号")
    @ExcelProperty("货架号")
    private Integer shelfNo;

    @Schema(description = "离岛批次号", example = "3221")
    @ExcelProperty("离岛批次号")
    private String dispatchId;

    @Schema(description = "离岛日")
    @ExcelProperty("离岛日")
    private LocalDateTime dispatchDate;

    @Schema(description = "离岛运单号")
    @ExcelProperty("离岛运单号")
    private String dispatchTrkNo;

    @Schema(description = "国内运单号")
    @ExcelProperty("国内运单号")
    private String domesticTrackNumber;

    @Schema(description = "是否确认收货（0未确认 1已确认）", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "是否确认收货（0未确认 1已确认）", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean confirmed;

    @Schema(description = "确认收货时间")
    @ExcelProperty("确认收货时间")
    private LocalDateTime confirmedTime;

    @Schema(description = "商品价格JPY", example = "16841")
    @ExcelProperty("商品价格JPY")
    private BigDecimal itemPrice;

    @Schema(description = "切煤汇率")
    @ExcelProperty("切煤汇率")
    private BigDecimal tradeRate;

    @Schema(description = "应收RMB")
    @ExcelProperty("应收RMB")
    private BigDecimal receiRmb;

    @Schema(description = "实收RMB")
    @ExcelProperty("实收RMB")
    private BigDecimal paidRmb;

    @Schema(description = "收款方式")
    @ExcelProperty("收款方式")
    private String receiMethod;

    @Schema(description = "支付方式")
    @ExcelProperty("支付方式")
    private String paymentMethod;

    @Schema(description = "利润rmb")
    @ExcelProperty("利润rmb")
    private String profitRmb;

    @Schema(description = "利润jpy")
    @ExcelProperty("利润jpy")
    private String profitJpy;

    @Schema(description = "是否取消（0 未取消 1 已取消）")
    @ExcelProperty(value = "是否取消（0 未取消 1 已取消）", converter = DictConvert.class)
    @DictFormat("infra_boolean_string") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Boolean cancelled;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String note;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}