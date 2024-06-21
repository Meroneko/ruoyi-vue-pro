package cn.iocoder.yudao.module.system.dal.mysql.guamaoorders;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.guamaoorders.GuamaoOrdersDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo.*;

/**
 * 订单 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GuamaoOrdersMapper extends BaseMapperX<GuamaoOrdersDO> {

    default PageResult<GuamaoOrdersDO> selectPage(GuamaoOrdersPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GuamaoOrdersDO>()
                .betweenIfPresent(GuamaoOrdersDO::getOrderTime, reqVO.getOrderTime())
                .eqIfPresent(GuamaoOrdersDO::getUserId, reqVO.getUserId())
                .eqIfPresent(GuamaoOrdersDO::getOrderId, reqVO.getOrderId())
                .eqIfPresent(GuamaoOrdersDO::getPlatform, reqVO.getPlatform())
                .likeIfPresent(GuamaoOrdersDO::getItemName, reqVO.getItemName())
                .eqIfPresent(GuamaoOrdersDO::getDeliveryMethod, reqVO.getDeliveryMethod())
                .eqIfPresent(GuamaoOrdersDO::getDeliveryFrom, reqVO.getDeliveryFrom())
                .eqIfPresent(GuamaoOrdersDO::getCostDays, reqVO.getCostDays())
                .eqIfPresent(GuamaoOrdersDO::getFreightCollect, reqVO.getFreightCollect())
                .eqIfPresent(GuamaoOrdersDO::getDelivered, reqVO.getDelivered())
                .betweenIfPresent(GuamaoOrdersDO::getShippedDate, reqVO.getShippedDate())
                .eqIfPresent(GuamaoOrdersDO::getTrackingNumber, reqVO.getTrackingNumber())
                .eqIfPresent(GuamaoOrdersDO::getAlert, reqVO.getAlert())
                .eqIfPresent(GuamaoOrdersDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GuamaoOrdersDO::getStorageId, reqVO.getStorageId())
                .likeIfPresent(GuamaoOrdersDO::getSellerName, reqVO.getSellerName())
                .eqIfPresent(GuamaoOrdersDO::getSellerUrl, reqVO.getSellerUrl())
                .eqIfPresent(GuamaoOrdersDO::getHeadImgUrl, reqVO.getHeadImgUrl())
                .betweenIfPresent(GuamaoOrdersDO::getArrivalDate, reqVO.getArrivalDate())
                .eqIfPresent(GuamaoOrdersDO::getArrvialWeight, reqVO.getArrvialWeight())
                .eqIfPresent(GuamaoOrdersDO::getShelfNo, reqVO.getShelfNo())
                .eqIfPresent(GuamaoOrdersDO::getDispatchId, reqVO.getDispatchId())
                .betweenIfPresent(GuamaoOrdersDO::getDispatchDate, reqVO.getDispatchDate())
                .eqIfPresent(GuamaoOrdersDO::getDispatchTrkNo, reqVO.getDispatchTrkNo())
                .eqIfPresent(GuamaoOrdersDO::getDomesticTrackNumber, reqVO.getDomesticTrackNumber())
                .eqIfPresent(GuamaoOrdersDO::getConfirmed, reqVO.getConfirmed())
                .betweenIfPresent(GuamaoOrdersDO::getConfirmedTime, reqVO.getConfirmedTime())
                .eqIfPresent(GuamaoOrdersDO::getItemPrice, reqVO.getItemPrice())
                .eqIfPresent(GuamaoOrdersDO::getTradeRate, reqVO.getTradeRate())
                .eqIfPresent(GuamaoOrdersDO::getReceiRmb, reqVO.getReceiRmb())
                .eqIfPresent(GuamaoOrdersDO::getPaidRmb, reqVO.getPaidRmb())
                .eqIfPresent(GuamaoOrdersDO::getReceiMethod, reqVO.getReceiMethod())
                .eqIfPresent(GuamaoOrdersDO::getPaymentMethod, reqVO.getPaymentMethod())
                .eqIfPresent(GuamaoOrdersDO::getProfitRmb, reqVO.getProfitRmb())
                .eqIfPresent(GuamaoOrdersDO::getProfitJpy, reqVO.getProfitJpy())
                .eqIfPresent(GuamaoOrdersDO::getCancelled, reqVO.getCancelled())
                .eqIfPresent(GuamaoOrdersDO::getNote, reqVO.getNote())
                .betweenIfPresent(GuamaoOrdersDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GuamaoOrdersDO::getId));
    }

}