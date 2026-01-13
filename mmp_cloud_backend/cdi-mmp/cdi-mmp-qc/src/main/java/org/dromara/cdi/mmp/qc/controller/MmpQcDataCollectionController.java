package org.dromara.cdi.mmp.qc.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcDataCollectionVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcDataCollectionBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcDataCollectionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 数据采集记录
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qcDataCollection")
public class MmpQcDataCollectionController extends BaseController {

    private final IMmpQcDataCollectionService mmpQcDataCollectionService;

    /**
     * 查询数据采集记录列表
     */
    @SaCheckPermission("qc:qcDataCollection:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcDataCollectionVo> list(MmpQcDataCollectionBo bo, PageQuery pageQuery) {
        return mmpQcDataCollectionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出数据采集记录列表
     */
    @SaCheckPermission("qc:qcDataCollection:export")
    @Log(title = "数据采集记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcDataCollectionBo bo, HttpServletResponse response) {
        List<MmpQcDataCollectionVo> list = mmpQcDataCollectionService.queryList(bo);
        ExcelUtil.exportExcel(list, "数据采集记录", MmpQcDataCollectionVo.class, response);
    }

    /**
     * 获取数据采集记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qc:qcDataCollection:query")
    @GetMapping("/{id}")
    public R<MmpQcDataCollectionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcDataCollectionService.queryById(id));
    }

    /**
     * 新增数据采集记录
     */
    @SaCheckPermission("qc:qcDataCollection:add")
    @Log(title = "数据采集记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcDataCollectionBo bo) {
        return toAjax(mmpQcDataCollectionService.insertByBo(bo));
    }

    /**
     * 修改数据采集记录
     */
    @SaCheckPermission("qc:qcDataCollection:edit")
    @Log(title = "数据采集记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcDataCollectionBo bo) {
        return toAjax(mmpQcDataCollectionService.updateByBo(bo));
    }

    /**
     * 删除数据采集记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qc:qcDataCollection:remove")
    @Log(title = "数据采集记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcDataCollectionService.deleteWithValidByIds(List.of(ids), true));
    }
}
