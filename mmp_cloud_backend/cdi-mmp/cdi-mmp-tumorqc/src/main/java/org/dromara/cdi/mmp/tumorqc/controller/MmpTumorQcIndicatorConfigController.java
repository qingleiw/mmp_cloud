package org.dromara.cdi.mmp.tumorqc.controller;

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
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorConfigVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorConfigBo;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcIndicatorConfigService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 肿瘤质控指标配置
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/tumorQcIndicatorConfig")
public class MmpTumorQcIndicatorConfigController extends BaseController {

    private final IMmpTumorQcIndicatorConfigService mmpTumorQcIndicatorConfigService;

    /**
     * 查询肿瘤质控指标配置列表
     */
    @SaCheckPermission("system:tumorQcIndicatorConfig:list")
    @GetMapping("/list")
    public TableDataInfo<MmpTumorQcIndicatorConfigVo> list(MmpTumorQcIndicatorConfigBo bo, PageQuery pageQuery) {
        return mmpTumorQcIndicatorConfigService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出肿瘤质控指标配置列表
     */
    @SaCheckPermission("system:tumorQcIndicatorConfig:export")
    @Log(title = "肿瘤质控指标配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpTumorQcIndicatorConfigBo bo, HttpServletResponse response) {
        List<MmpTumorQcIndicatorConfigVo> list = mmpTumorQcIndicatorConfigService.queryList(bo);
        ExcelUtil.exportExcel(list, "肿瘤质控指标配置", MmpTumorQcIndicatorConfigVo.class, response);
    }

    /**
     * 获取肿瘤质控指标配置详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:tumorQcIndicatorConfig:query")
    @GetMapping("/{id}")
    public R<MmpTumorQcIndicatorConfigVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpTumorQcIndicatorConfigService.queryById(id));
    }

    /**
     * 新增肿瘤质控指标配置
     */
    @SaCheckPermission("system:tumorQcIndicatorConfig:add")
    @Log(title = "肿瘤质控指标配置", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpTumorQcIndicatorConfigBo bo) {
        return toAjax(mmpTumorQcIndicatorConfigService.insertByBo(bo));
    }

    /**
     * 修改肿瘤质控指标配置
     */
    @SaCheckPermission("system:tumorQcIndicatorConfig:edit")
    @Log(title = "肿瘤质控指标配置", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpTumorQcIndicatorConfigBo bo) {
        return toAjax(mmpTumorQcIndicatorConfigService.updateByBo(bo));
    }

    /**
     * 删除肿瘤质控指标配置
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:tumorQcIndicatorConfig:remove")
    @Log(title = "肿瘤质控指标配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpTumorQcIndicatorConfigService.deleteWithValidByIds(List.of(ids), true));
    }
}
