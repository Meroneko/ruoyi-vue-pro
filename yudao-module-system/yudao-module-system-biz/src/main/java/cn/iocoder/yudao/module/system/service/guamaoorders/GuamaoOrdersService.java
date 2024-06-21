package cn.iocoder.yudao.module.system.service.guamaoorders;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.guamaoorders.GuamaoOrdersDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 订单 Service 接口
 *
 * @author 芋道源码
 */
public interface GuamaoOrdersService {

    /**
     * 创建订单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createGuamaoOrders(@Valid GuamaoOrdersSaveReqVO createReqVO);

    /**
     * 更新订单
     *
     * @param updateReqVO 更新信息
     */
    void updateGuamaoOrders(@Valid GuamaoOrdersSaveReqVO updateReqVO);

    /**
     * 删除订单
     *
     * @param id 编号
     */
    void deleteGuamaoOrders(Long id);

    /**
     * 获得订单
     *
     * @param id 编号
     * @return 订单
     */
    GuamaoOrdersDO getGuamaoOrders(Long id);

    /**
     * 获得订单分页
     *
     * @param pageReqVO 分页查询
     * @return 订单分页
     */
    PageResult<GuamaoOrdersDO> getGuamaoOrdersPage(GuamaoOrdersPageReqVO pageReqVO);

}