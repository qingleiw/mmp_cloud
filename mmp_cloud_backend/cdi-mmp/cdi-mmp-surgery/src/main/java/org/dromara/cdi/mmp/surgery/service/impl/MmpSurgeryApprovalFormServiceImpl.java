package org.dromara.cdi.mmp.surgery.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryApprovalFormBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryApprovalFormVo;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryApprovalForm;
import org.dromara.cdi.mmp.surgery.mapper.MmpSurgeryApprovalFormMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryApprovalFormService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 重大手术审批报告单Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryApprovalFormServiceImpl implements IMmpSurgeryApprovalFormService {

    private final MmpSurgeryApprovalFormMapper baseMapper;

    /**
     * 查询重大手术审批报告单
     *
     * @param id 主键
     * @return 重大手术审批报告单
     */
    @Override
    public MmpSurgeryApprovalFormVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询重大手术审批报告单列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 重大手术审批报告单分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryApprovalFormVo> queryPageList(MmpSurgeryApprovalFormBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryApprovalForm> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryApprovalFormVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的重大手术审批报告单列表
     *
     * @param bo 查询条件
     * @return 重大手术审批报告单列表
     */
    @Override
    public List<MmpSurgeryApprovalFormVo> queryList(MmpSurgeryApprovalFormBo bo) {
        LambdaQueryWrapper<MmpSurgeryApprovalForm> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryApprovalForm> buildQueryWrapper(MmpSurgeryApprovalFormBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryApprovalForm> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryApprovalForm::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDeptName()), MmpSurgeryApprovalForm::getDeptName, bo.getDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getReportDate()), MmpSurgeryApprovalForm::getReportDate, bo.getReportDate());
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpSurgeryApprovalForm::getPatientName, bo.getPatientName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpSurgeryApprovalForm::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpSurgeryApprovalForm::getAge, bo.getAge());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalNumber()), MmpSurgeryApprovalForm::getHospitalNumber, bo.getHospitalNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getPreoperativeDiagnosis()), MmpSurgeryApprovalForm::getPreoperativeDiagnosis, bo.getPreoperativeDiagnosis());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpSurgeryApprovalForm::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryLevel()), MmpSurgeryApprovalForm::getSurgeryLevel, bo.getSurgeryLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getAnesthesiaMethod()), MmpSurgeryApprovalForm::getAnesthesiaMethod, bo.getAnesthesiaMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeon()), MmpSurgeryApprovalForm::getSurgeon, bo.getSurgeon());
        lqw.eq(StringUtils.isNotBlank(bo.getAssistant()), MmpSurgeryApprovalForm::getAssistant, bo.getAssistant());
        lqw.eq(StringUtils.isNotBlank(bo.getDiscussionResult()), MmpSurgeryApprovalForm::getDiscussionResult, bo.getDiscussionResult());
        lqw.eq(StringUtils.isNotBlank(bo.getReportingPhysician()), MmpSurgeryApprovalForm::getReportingPhysician, bo.getReportingPhysician());
        lqw.eq(StringUtils.isNotBlank(bo.getReportingDate()), MmpSurgeryApprovalForm::getReportingDate, bo.getReportingDate());
        lqw.eq(StringUtils.isNotBlank(bo.getInformedConsent()), MmpSurgeryApprovalForm::getInformedConsent, bo.getInformedConsent());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartmentDirector()), MmpSurgeryApprovalForm::getDepartmentDirector, bo.getDepartmentDirector());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartmentDate()), MmpSurgeryApprovalForm::getDepartmentDate, bo.getDepartmentDate());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalDirector()), MmpSurgeryApprovalForm::getMedicalDirector, bo.getMedicalDirector());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSurgeryApprovalForm::getStatus, bo.getStatus());
        lqw.eq(bo.getDelFlag() != null, MmpSurgeryApprovalForm::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增重大手术审批报告单
     *
     * @param bo 重大手术审批报告单
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryApprovalFormBo bo) {
        MmpSurgeryApprovalForm add = MapstructUtils.convert(bo, MmpSurgeryApprovalForm.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改重大手术审批报告单
     *
     * @param bo 重大手术审批报告单
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryApprovalFormBo bo) {
        MmpSurgeryApprovalForm update = MapstructUtils.convert(bo, MmpSurgeryApprovalForm.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryApprovalForm entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除重大手术审批报告单信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
