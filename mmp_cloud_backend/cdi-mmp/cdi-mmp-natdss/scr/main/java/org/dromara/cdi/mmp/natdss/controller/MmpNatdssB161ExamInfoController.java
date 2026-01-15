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
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB161ExamInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB161ExamInfoBo;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB161ExamInfoService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * B16-1 常规检查记录
 * 前端访问路由地址为:/natdss/natdssB161ExamInfo
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/natdssB161ExamInfo")
public class MmpNatdssB161ExamInfoController extends BaseController {

    private final IMmpNatdssB161ExamInfoService mmpNatdssB161ExamInfoService;

    /**
     * 查询B16-1 常规检查记录列表
     */
    @SaCheckPermission("natdss:natdssB161ExamInfo:list")
    @GetMapping("/list")
    public TableDataInfo<MmpNatdssB161ExamInfoVo> list(MmpNatdssB161ExamInfoBo bo, PageQuery pageQuery) {
        return mmpNatdssB161ExamInfoService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出B16-1 常规检查记录列表
     */
    @SaCheckPermission("natdss:natdssB161ExamInfo:export")
    @Log(title = "B16-1 常规检查记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpNatdssB161ExamInfoBo bo, HttpServletResponse response) {
        List<MmpNatdssB161ExamInfoVo> list = mmpNatdssB161ExamInfoService.queryList(bo);
        ExcelUtil.exportExcel(list, "B16-1 常规检查记录", MmpNatdssB161ExamInfoVo.class, response);
    }

    /**
     * 获取B16-1 常规检查记录详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("natdss:natdssB161ExamInfo:query")
    @GetMapping("/{id}")
    public R<MmpNatdssB161ExamInfoVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(mmpNatdssB161ExamInfoService.queryById(id));
    }

    /**
     * 新增B16-1 常规检查记录
     */
    @SaCheckPermission("natdss:natdssB161ExamInfo:add")
    @Log(title = "B16-1 常规检查记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpNatdssB161ExamInfoBo bo) {
        return toAjax(mmpNatdssB161ExamInfoService.insertByBo(bo));
    }

    /**
     * 修改B16-1 常规检查记录
     */
    @SaCheckPermission("natdss:natdssB161ExamInfo:edit")
    @Log(title = "B16-1 常规检查记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpNatdssB161ExamInfoBo bo) {
        return toAjax(mmpNatdssB161ExamInfoService.updateByBo(bo));
    }

    /**
     * 删除B16-1 常规检查记录
     *
     * @param ids 主键串
     */
    @SaCheckPermission("natdss:natdssB161ExamInfo:remove")
    @Log(title = "B16-1 常规检查记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable("ids") Long[] ids) {
        return toAjax(mmpNatdssB161ExamInfoService.deleteWithValidByIds(List.of(ids), true));
    }
}
