package cn.iocoder.yudao.module.system.controller.admin.guamaoorders;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.module.system.controller.admin.guamaoorders.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.guamaoorders.GuamaoOrdersDO;
import cn.iocoder.yudao.module.system.service.guamaoorders.GuamaoOrdersService;

@Tag(name = "管理后台 - 订单")
@RestController
@RequestMapping("/system/guamao-orders")
@Validated
public class GuamaoOrdersController {

    @Resource
    private GuamaoOrdersService guamaoOrdersService;

    @PostMapping("/create")
    @Operation(summary = "创建订单")
    @PreAuthorize("@ss.hasPermission('system:guamao-orders:create')")
    public CommonResult<Long> createGuamaoOrders(@Valid @RequestBody GuamaoOrdersSaveReqVO createReqVO) {
        return success(guamaoOrdersService.createGuamaoOrders(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新订单")
    @PreAuthorize("@ss.hasPermission('system:guamao-orders:update')")
    public CommonResult<Boolean> updateGuamaoOrders(@Valid @RequestBody GuamaoOrdersSaveReqVO updateReqVO) {
        guamaoOrdersService.updateGuamaoOrders(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除订单")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:guamao-orders:delete')")
    public CommonResult<Boolean> deleteGuamaoOrders(@RequestParam("id") Long id) {
        guamaoOrdersService.deleteGuamaoOrders(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得订单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:guamao-orders:query')")
    public CommonResult<GuamaoOrdersRespVO> getGuamaoOrders(@RequestParam("id") Long id) {
        GuamaoOrdersDO guamaoOrders = guamaoOrdersService.getGuamaoOrders(id);
        return success(BeanUtils.toBean(guamaoOrders, GuamaoOrdersRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得订单分页")
    @PreAuthorize("@ss.hasPermission('system:guamao-orders:query')")
    public CommonResult<PageResult<GuamaoOrdersRespVO>> getGuamaoOrdersPage(@Valid GuamaoOrdersPageReqVO pageReqVO) {
        PageResult<GuamaoOrdersDO> pageResult = guamaoOrdersService.getGuamaoOrdersPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GuamaoOrdersRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出订单 Excel")
    @PreAuthorize("@ss.hasPermission('system:guamao-orders:export')")
    public void exportGuamaoOrdersExcel(@Valid GuamaoOrdersPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GuamaoOrdersDO> list = guamaoOrdersService.getGuamaoOrdersPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "订单.xls", "数据", GuamaoOrdersRespVO.class,
                        BeanUtils.toBean(list, GuamaoOrdersRespVO.class));
    }

}