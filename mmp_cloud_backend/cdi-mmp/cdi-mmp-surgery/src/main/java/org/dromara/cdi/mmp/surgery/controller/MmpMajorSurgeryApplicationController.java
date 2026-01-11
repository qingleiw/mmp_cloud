package org.dromara.cdi.mmp.surgery.controller;

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
import org.dromara.cdi.mmp.surgery.domain.vo.MmpMajorSurgeryApplicationVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpMajorSurgeryApplicationBo;
import org.dromara.cdi.mmp.surgery.service.IMmpMajorSurgeryApplicationService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 重大手术申请
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/majorSurgeryApplication")
public class MmpMajorSurgeryApplicationController extends BaseController {

    private final IMmpMajorSurgeryApplicationService mmpMajorSurgeryApplicationService;

    /**
     * 查询重大手术申请列表
     */
    @SaCheckPermission("system:majorSurgeryApplication:list")
    @GetMapping("/list")
    public TableDataInfo<MmpMajorSurgeryApplicationVo> list(MmpMajorSurgeryApplicationBo bo, PageQuery pageQuery) {
        return mmpMajorSurgeryApplicationService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出重大手术申请列表
     */
    @SaCheckPermission("system:majorSurgeryApplication:export")
    @Log(title = "重大手术申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MmpMajorSurgeryApplicationBo bo, HttpServletResponse response) {
        List<MmpMajorSurgeryApplicationVo> list = mmpMajorSurgeryApplicationService.queryList(bo);
        ExcelUtil.exportExcel(list, "重大手术申请", MmpMajorSurgeryApplicationVo.class, response);
    }

    /**
     * 获取重大手术申请详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:majorSurgeryApplication:query")
    @GetMapping("/{id}")
    public R<MmpMajorSurgeryApplicationVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(mmpMajorSurgeryApplicationService.queryById(id));
    }

    /**
     * 新增重大手术申请
     */
    @SaCheckPermission("system:majorSurgeryApplication:add")
    @Log(title = "重大手术申请", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MmpMajorSurgeryApplicationBo bo) {
        return toAjax(mmpMajorSurgeryApplicationService.insertByBo(bo));
    }

    /**
     * 修改重大手术申请
     */
    @SaCheckPermission("system:majorSurgeryApplication:edit")
    @Log(title = "重大手术申请", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MmpMajorSurgeryApplicationBo bo) {
        return toAjax(mmpMajorSurgeryApplicationService.updateByBo(bo));
    }

    /**
     * 删除重大手术申请
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:majorSurgeryApplication:remove")
    @Log(title = "重大手术申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(mmpMajorSurgeryApplicationService.deleteWithValidByIds(List.of(ids), true));
    }
}
