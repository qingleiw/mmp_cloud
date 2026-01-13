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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcManualDataVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcManualDataBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcManualDataService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 人工补录数据
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/qcManualData")
public class MmpQcManualDataController extends BaseController {

    private final IMmpQcManualDataService mmpQcManualDataService;

    /**
     * 查询人工补录数据列表
     */
    @SaCheckPermission("qc:qcManualData:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcManualDataVo> list(MmpQcManualDataBo bo, PageQuery pageQuery) {
        return mmpQcManualDataService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出人工补录数据列表
     */
    @SaCheckPermission("qc:qcManualData:export")
    @Log(title = "人工补录数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcManualDataBo bo, HttpServletResponse response) {
        List<MmpQcManualDataVo> list = mmpQcManualDataService.queryList(bo);
        ExcelUtil.exportExcel(list, "人工补录数据", MmpQcManualDataVo.class, response);
    }

    /**
     * 获取人工补录数据详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("qc:qcManualData:query")
    @GetMapping("/{id}")
    public R<MmpQcManualDataVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcManualDataService.queryById(id));
    }

    /**
     * 新增人工补录数据
     */
    @SaCheckPermission("qc:qcManualData:add")
    @Log(title = "人工补录数据", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcManualDataBo bo) {
        return toAjax(mmpQcManualDataService.insertByBo(bo));
    }

    /**
     * 修改人工补录数据
     */
    @SaCheckPermission("qc:qcManualData:edit")
    @Log(title = "人工补录数据", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcManualDataBo bo) {
        return toAjax(mmpQcManualDataService.updateByBo(bo));
    }

    /**
     * 删除人工补录数据
     *
     * @param ids 主键串
     */
    @SaCheckPermission("qc:qcManualData:remove")
    @Log(title = "人工补录数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcManualDataService.deleteWithValidByIds(List.of(ids), true));
    }
}
