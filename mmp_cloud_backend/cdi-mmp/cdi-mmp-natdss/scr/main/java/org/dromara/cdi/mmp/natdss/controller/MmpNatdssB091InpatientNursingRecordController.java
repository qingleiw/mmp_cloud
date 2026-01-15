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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB091InpatientNursingRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB091InpatientNursingRecordBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB091InpatientNursingRecordService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B09-1 住院护理记录
 * 前端访问路由地址为:/natdss/natdssB091InpatientNursingRecord
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB091InpatientNursingRecord")
public class MmpNatdssB091InpatientNursingRecordController extends BaseController {

    private final IMmpNatdssB091InpatientNursingRecordService mmpNatdssB091InpatientNursingRecordService;

    /**
     * 查询B09-1 住院护理记录列表
     */
    @SaCheckPermission("natdss:natdssB091InpatientNursingRecord:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB091InpatientNursingRecordVo> list(MmpNatdssB091InpatientNursingRecordBo bo, PageQuery pageQuery) {
        return mmpNatdssB091InpatientNursingRecordService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B09-1 住院护理记录列表
     */
    @SaCheckPermission("natdss:natdssB091InpatientNursingRecord:export")
    @Log(title = "B09-1 住院护理记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB091InpatientNursingRecordBo bo, HttpServletResponse response) {
        List<MmpNatdssB091InpatientNursingRecordVo> list = mmpNatdssB091InpatientNursingRecordService.queryList(bo);
        ExcelUtil.exportExcel(list, "B09-1 住院护理记录", MmpNatdssB091InpatientNursingRecordVo.class, response);
    }

    /**
     * 获取B09-1 住院护理记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB091InpatientNursingRecord:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB091InpatientNursingRecordVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB091InpatientNursingRecordService.queryById(id));
    }

    /**
     * 新增B09-1 住院护理记录
     */
    @SaCheckPermission("natdss:natdssB091InpatientNursingRecord:add")
    @Log(title = "B09-1 住院护理记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB091InpatientNursingRecordBo bo) {
        return toAjax(mmpNatdssB091InpatientNursingRecordService.insertByBo(bo));
    }

    /**
     * 修改B09-1 住院护理记录
     */
    @SaCheckPermission("natdss:natdssB091InpatientNursingRecord:edit")
    @Log(title = "B09-1 住院护理记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB091InpatientNursingRecordBo bo) {
        return toAjax(mmpNatdssB091InpatientNursingRecordService.updateByBo(bo));
    }

    /**
     * 删除B09-1 住院护理记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB091InpatientNursingRecord:remove")
    @Log(title = "B09-1 住院护理记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB091InpatientNursingRecordService.deleteWithValidByIds(List.of(ids), true));
    }
}
