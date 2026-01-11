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
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcIndicatorCollectionConfigVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcIndicatorCollectionConfigBo;
import org.dromara.cdi.mmp.qc.service.IMmpQcIndicatorCollectionConfigService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 质控指标数据采集配置
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/qcIndicatorCollectionConfig")
public class MmpQcIndicatorCollectionConfigController extends BaseController {

    private final IMmpQcIndicatorCollectionConfigService mmpQcIndicatorCollectionConfigService;

    /**
     * 查询质控指标数据采集配置列表
     */
    @SaCheckPermission("system:qcIndicatorCollectionConfig:list")
    @GetMapping("/list")
    public TableDataInfo<MmpQcIndicatorCollectionConfigVo> list(MmpQcIndicatorCollectionConfigBo bo, PageQuery pageQuery) {
        return mmpQcIndicatorCollectionConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出质控指标数据采集配置列表
     */
    @SaCheckPermission("system:qcIndicatorCollectionConfig:export")
    @Log(title = "质控指标数据采集配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpQcIndicatorCollectionConfigBo bo, HttpServletResponse response) {
        List<MmpQcIndicatorCollectionConfigVo> list = mmpQcIndicatorCollectionConfigService.queryList(bo);
        ExcelUtil.exportExcel(list, "质控指标数据采集配置", MmpQcIndicatorCollectionConfigVo.class, response);
    }

    /**
     * 获取质控指标数据采集配置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:qcIndicatorCollectionConfig:query")
    @GetMapping("/{id}")
    public R<MmpQcIndicatorCollectionConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpQcIndicatorCollectionConfigService.queryById(id));
    }

    /**
     * 新增质控指标数据采集配置
     */
    @SaCheckPermission("system:qcIndicatorCollectionConfig:add")
    @Log(title = "质控指标数据采集配置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpQcIndicatorCollectionConfigBo bo) {
        return toAjax(mmpQcIndicatorCollectionConfigService.insertByBo(bo));
    }

    /**
     * 修改质控指标数据采集配置
     */
    @SaCheckPermission("system:qcIndicatorCollectionConfig:edit")
    @Log(title = "质控指标数据采集配置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpQcIndicatorCollectionConfigBo bo) {
        return toAjax(mmpQcIndicatorCollectionConfigService.updateByBo(bo));
    }

    /**
     * 删除质控指标数据采集配置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:qcIndicatorCollectionConfig:remove")
    @Log(title = "质控指标数据采集配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpQcIndicatorCollectionConfigService.deleteWithValidByIds(List.of(ids), true));
    }
}
