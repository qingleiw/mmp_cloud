package org.dromara.cdi.mmp.natdss.controller;

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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB131OutpatientDiagAndMedrecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB131OutpatientDiagAndMedrecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB131OutpatientDiagAndMedrecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B13-1 门诊病历记录
 * 前端访问路由地址为:/natdss/natdssB131OutpatientDiagAndMedrecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB131OutpatientDiagAndMedrecord")
public class MmpNatdssB131OutpatientDiagAndMedrecordController extends BaseController {

    private final IMmpNatdssB131OutpatientDiagAndMedrecordService mmpNatdssB131OutpatientDiagAndMedrecordService;

    /**
     * 查询B13-1 门诊病历记录列表
     */
    @SaCheckPermission("natdss:natdssB131OutpatientDiagAndMedrecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB131OutpatientDiagAndMedrecordVo> list(MmpNatdssB131OutpatientDiagAndMedrecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB131OutpatientDiagAndMedrecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B13-1 门诊病历记录列表
     */
    @SaCheckPermission("natdss:natdssB131OutpatientDiagAndMedrecord:export")
    @Log(title = "B13-1 门诊病历记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB131OutpatientDiagAndMedrecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB131OutpatientDiagAndMedrecordVo> list = mmpNatdssB131OutpatientDiagAndMedrecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B13-1 门诊病历记录", MmpNatdssB131OutpatientDiagAndMedrecordVo.class, response);
    }

    /**
     * 获取B13-1 门诊病历记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB131OutpatientDiagAndMedrecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB131OutpatientDiagAndMedrecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB131OutpatientDiagAndMedrecordService.queryById(id));
    }

    /**
     * 新增B13-1 门诊病历记录
     */
    @SaCheckPermission("natdss:natdssB131OutpatientDiagAndMedrecord:add")
    @Log(title = "B13-1 门诊病历记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB131OutpatientDiagAndMedrecordBo bo) {
        return toAjax(mmpNatdssB131OutpatientDiagAndMedrecordService.insertByBo(bo));
    }

    /**
     * 修改B13-1 门诊病历记录
     */
    @SaCheckPermission("natdss:natdssB131OutpatientDiagAndMedrecord:edit")
    @Log(title = "B13-1 门诊病历记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB131OutpatientDiagAndMedrecordBo bo) {
        return toAjax(mmpNatdssB131OutpatientDiagAndMedrecordService.updateByBo(bo));
    }

    /**
     * 删除B13-1 门诊病历记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB131OutpatientDiagAndMedrecord:remove")
    @Log(title = "B13-1 门诊病历记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB131OutpatientDiagAndMedrecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
