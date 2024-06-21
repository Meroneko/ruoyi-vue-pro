package cn.iocoder.yudao.module.system.service.guamaoorders;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.guamaoorders.GuamaoOrdersDO;
import cn.iocoder.yudao.module.system.dal.mysql.guamaoorders.GuamaoOrdersMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link GuamaoOrdersServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(GuamaoOrdersServiceImpl.class)
public class GuamaoOrdersServiceImplTest extends BaseDbUnitTest {

    @Resource
    private GuamaoOrdersServiceImpl guamaoOrdersService;

    @Resource
    private GuamaoOrdersMapper guamaoOrdersMapper;

    @Test
    public void testCreateGuamaoOrders_success() {
        // 准备参数
        GuamaoOrdersSaveReqVO createReqVO = randomPojo(GuamaoOrdersSaveReqVO.class).setId(null);

        // 调用
        Long guamaoOrdersId = guamaoOrdersService.createGuamaoOrders(createReqVO);
        // 断言
        assertNotNull(guamaoOrdersId);
        // 校验记录的属性是否正确
        GuamaoOrdersDO guamaoOrders = guamaoOrdersMapper.selectById(guamaoOrdersId);
        assertPojoEquals(createReqVO, guamaoOrders, "id");
    }

    @Test
    public void testUpdateGuamaoOrders_success() {
        // mock 数据
        GuamaoOrdersDO dbGuamaoOrders = randomPojo(GuamaoOrdersDO.class);
        guamaoOrdersMapper.insert(dbGuamaoOrders);// @Sql: 先插入出一条存在的数据
        // 准备参数
        GuamaoOrdersSaveReqVO updateReqVO = randomPojo(GuamaoOrdersSaveReqVO.class, o -> {
            o.setId(dbGuamaoOrders.getId()); // 设置更新的 ID
        });

        // 调用
        guamaoOrdersService.updateGuamaoOrders(updateReqVO);
        // 校验是否更新正确
        GuamaoOrdersDO guamaoOrders = guamaoOrdersMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, guamaoOrders);
    }

    @Test
    public void testUpdateGuamaoOrders_notExists() {
        // 准备参数
        GuamaoOrdersSaveReqVO updateReqVO = randomPojo(GuamaoOrdersSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> guamaoOrdersService.updateGuamaoOrders(updateReqVO), GUAMAO_ORDERS_NOT_EXISTS);
    }

    @Test
    public void testDeleteGuamaoOrders_success() {
        // mock 数据
        GuamaoOrdersDO dbGuamaoOrders = randomPojo(GuamaoOrdersDO.class);
        guamaoOrdersMapper.insert(dbGuamaoOrders);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbGuamaoOrders.getId();

        // 调用
        guamaoOrdersService.deleteGuamaoOrders(id);
       // 校验数据不存在了
       assertNull(guamaoOrdersMapper.selectById(id));
    }

    @Test
    public void testDeleteGuamaoOrders_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> guamaoOrdersService.deleteGuamaoOrders(id), GUAMAO_ORDERS_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetGuamaoOrdersPage() {
       // mock 数据
       GuamaoOrdersDO dbGuamaoOrders = randomPojo(GuamaoOrdersDO.class, o -> { // 等会查询到
           o.setOrderTime(null);
           o.setUserId(null);
           o.setOrderId(null);
           o.setPlatform(null);
           o.setItemName(null);
           o.setDeliveryMethod(null);
           o.setDeliveryFrom(null);
           o.setCostDays(null);
           o.setFreightCollect(null);
           o.setDelivered(null);
           o.setShippedDate(null);
           o.setTrackingNumber(null);
           o.setAlert(null);
           o.setStatus(null);
           o.setStorageId(null);
           o.setSellerName(null);
           o.setSellerUrl(null);
           o.setHeadImgUrl(null);
           o.setArrivalDate(null);
           o.setArrvialWeight(null);
           o.setShelfNo(null);
           o.setDispatchId(null);
           o.setDispatchDate(null);
           o.setDispatchTrkNo(null);
           o.setDomesticTrackNumber(null);
           o.setConfirmed(null);
           o.setConfirmedTime(null);
           o.setItemPrice(null);
           o.setTradeRate(null);
           o.setReceiRmb(null);
           o.setPaidRmb(null);
           o.setReceiMethod(null);
           o.setPaymentMethod(null);
           o.setProfitRmb(null);
           o.setProfitJpy(null);
           o.setCancelled(null);
           o.setNote(null);
           o.setCreateTime(null);
       });
       guamaoOrdersMapper.insert(dbGuamaoOrders);
       // 测试 orderTime 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setOrderTime(null)));
       // 测试 userId 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setUserId(null)));
       // 测试 orderId 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setOrderId(null)));
       // 测试 platform 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setPlatform(null)));
       // 测试 itemName 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setItemName(null)));
       // 测试 deliveryMethod 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDeliveryMethod(null)));
       // 测试 deliveryFrom 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDeliveryFrom(null)));
       // 测试 costDays 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setCostDays(null)));
       // 测试 freightCollect 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setFreightCollect(null)));
       // 测试 delivered 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDelivered(null)));
       // 测试 shippedDate 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setShippedDate(null)));
       // 测试 trackingNumber 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setTrackingNumber(null)));
       // 测试 alert 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setAlert(null)));
       // 测试 status 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setStatus(null)));
       // 测试 storageId 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setStorageId(null)));
       // 测试 sellerName 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setSellerName(null)));
       // 测试 sellerUrl 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setSellerUrl(null)));
       // 测试 headImgUrl 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setHeadImgUrl(null)));
       // 测试 arrivalDate 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setArrivalDate(null)));
       // 测试 arrvialWeight 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setArrvialWeight(null)));
       // 测试 shelfNo 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setShelfNo(null)));
       // 测试 dispatchId 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDispatchId(null)));
       // 测试 dispatchDate 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDispatchDate(null)));
       // 测试 dispatchTrkNo 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDispatchTrkNo(null)));
       // 测试 domesticTrackNumber 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setDomesticTrackNumber(null)));
       // 测试 confirmed 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setConfirmed(null)));
       // 测试 confirmedTime 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setConfirmedTime(null)));
       // 测试 itemPrice 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setItemPrice(null)));
       // 测试 tradeRate 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setTradeRate(null)));
       // 测试 receiRmb 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setReceiRmb(null)));
       // 测试 paidRmb 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setPaidRmb(null)));
       // 测试 receiMethod 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setReceiMethod(null)));
       // 测试 paymentMethod 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setPaymentMethod(null)));
       // 测试 profitRmb 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setProfitRmb(null)));
       // 测试 profitJpy 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setProfitJpy(null)));
       // 测试 cancelled 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setCancelled(null)));
       // 测试 note 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setNote(null)));
       // 测试 createTime 不匹配
       guamaoOrdersMapper.insert(cloneIgnoreId(dbGuamaoOrders, o -> o.setCreateTime(null)));
       // 准备参数
       GuamaoOrdersPageReqVO reqVO = new GuamaoOrdersPageReqVO();
       reqVO.setOrderTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setUserId(null);
       reqVO.setOrderId(null);
       reqVO.setPlatform(null);
       reqVO.setItemName(null);
       reqVO.setDeliveryMethod(null);
       reqVO.setDeliveryFrom(null);
       reqVO.setCostDays(null);
       reqVO.setFreightCollect(null);
       reqVO.setDelivered(null);
       reqVO.setShippedDate(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setTrackingNumber(null);
       reqVO.setAlert(null);
       reqVO.setStatus(null);
       reqVO.setStorageId(null);
       reqVO.setSellerName(null);
       reqVO.setSellerUrl(null);
       reqVO.setHeadImgUrl(null);
       reqVO.setArrivalDate(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setArrvialWeight(null);
       reqVO.setShelfNo(null);
       reqVO.setDispatchId(null);
       reqVO.setDispatchDate(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setDispatchTrkNo(null);
       reqVO.setDomesticTrackNumber(null);
       reqVO.setConfirmed(null);
       reqVO.setConfirmedTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setItemPrice(null);
       reqVO.setTradeRate(null);
       reqVO.setReceiRmb(null);
       reqVO.setPaidRmb(null);
       reqVO.setReceiMethod(null);
       reqVO.setPaymentMethod(null);
       reqVO.setProfitRmb(null);
       reqVO.setProfitJpy(null);
       reqVO.setCancelled(null);
       reqVO.setNote(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<GuamaoOrdersDO> pageResult = guamaoOrdersService.getGuamaoOrdersPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbGuamaoOrders, pageResult.getList().get(0));
    }

}