package cn.iocoder.yudao.module.system.service.guamaoorders;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.guamaoorders.GuamaoOrdersDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.guamaoorders.GuamaoOrdersMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 订单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GuamaoOrdersServiceImpl implements GuamaoOrdersService {

    @Resource
    private GuamaoOrdersMapper guamaoOrdersMapper;

    @Override
    public Long createGuamaoOrders(GuamaoOrdersSaveReqVO createReqVO) {
        // 插入
        GuamaoOrdersDO guamaoOrders = BeanUtils.toBean(createReqVO, GuamaoOrdersDO.class);
        guamaoOrdersMapper.insert(guamaoOrders);
        // 返回
        return guamaoOrders.getId();
    }

    @Override
    public void updateGuamaoOrders(GuamaoOrdersSaveReqVO updateReqVO) {
        // 校验存在
        validateGuamaoOrdersExists(updateReqVO.getId());
        // 更新
        GuamaoOrdersDO updateObj = BeanUtils.toBean(updateReqVO, GuamaoOrdersDO.class);
        guamaoOrdersMapper.updateById(updateObj);
    }

    @Override
    public void deleteGuamaoOrders(Long id) {
        // 校验存在
        validateGuamaoOrdersExists(id);
        // 删除
        guamaoOrdersMapper.deleteById(id);
    }

    private void validateGuamaoOrdersExists(Long id) {
        if (guamaoOrdersMapper.selectById(id) == null) {
            throw exception(GUAMAO_ORDERS_NOT_EXISTS);
        }
    }

    @Override
    public GuamaoOrdersDO getGuamaoOrders(Long id) {
        return guamaoOrdersMapper.selectById(id);
    }

    @Override
    public PageResult<GuamaoOrdersDO> getGuamaoOrdersPage(GuamaoOrdersPageReqVO pageReqVO) {
        return guamaoOrdersMapper.selectPage(pageReqVO);
    }

}