package cn.iocoder.yudao.module.trade.convert.order;

import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.member.api.address.dto.AddressRespDTO;
import cn.iocoder.yudao.module.product.api.sku.dto.ProductSkuRespDTO;
import cn.iocoder.yudao.module.promotion.api.price.dto.PriceCalculateReqDTO;
import cn.iocoder.yudao.module.promotion.api.price.dto.PriceCalculateRespDTO;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.AppTradeOrderCreateReqVO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderDO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderItemDO;
import cn.iocoder.yudao.module.trade.enums.order.TradeOrderItemRefundStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;

@Mapper
public interface TradeOrderConvert {

    TradeOrderConvert INSTANCE = Mappers.getMapper(TradeOrderConvert.class);

    @Mappings({
            @Mapping(source = "createReqVO.couponId", target = "couponId"),
            @Mapping(target = "remark", ignore = true),
            @Mapping(source = "createReqVO.remark", target = "userRemark"),
            @Mapping(source = "address.name", target = "receiverName"),
            @Mapping(source = "address.mobile", target = "receiverMobile"),
            @Mapping(source = "address.areaId", target = "receiverAreaId"),
            @Mapping(source = "address.postCode", target = "receiverPostCode"),
            @Mapping(source = "address.detailAddress", target = "receiverDetailAddress"),
    })
    TradeOrderDO convert(Long userId, String userIp, AppTradeOrderCreateReqVO createReqVO,
                         PriceCalculateRespDTO.Order order, AddressRespDTO address);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "sku.spuId", target = "spuId"),
    })
    TradeOrderItemDO convert(PriceCalculateRespDTO.OrderItem orderItem, ProductSkuRespDTO sku);

    default List<TradeOrderItemDO> convertList(TradeOrderDO tradeOrderDO,
                                               List<PriceCalculateRespDTO.OrderItem> orderItems, List<ProductSkuRespDTO> skus) {
        Map<Long, ProductSkuRespDTO> skuMap = convertMap(skus, ProductSkuRespDTO::getId);
        return CollectionUtils.convertList(orderItems, orderItem -> {
            TradeOrderItemDO tradeOrderItemDO = convert(orderItem, skuMap.get(orderItem.getSkuId()));
            tradeOrderItemDO.setOrderId(tradeOrderDO.getId());
            tradeOrderItemDO.setUserId(tradeOrderDO.getUserId());
            tradeOrderItemDO.setRefundStatus(TradeOrderItemRefundStatusEnum.NONE.getStatus()).setRefundTotal(0); // 退款信息
//            tradeOrderItemDO.setCommented(false);
            return tradeOrderItemDO;
        });
    }

    @Mapping(source = "userId" , target = "userId")
    PriceCalculateReqDTO convert(AppTradeOrderCreateReqVO createReqVO, Long userId);

}