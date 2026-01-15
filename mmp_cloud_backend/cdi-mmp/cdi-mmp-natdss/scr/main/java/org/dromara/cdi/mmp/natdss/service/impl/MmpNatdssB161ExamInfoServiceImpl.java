package org.dromara.cdi.mmp.natdss.service.impl;

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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB161ExamInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB161ExamInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB161ExamInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB161ExamInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB161ExamInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B16-1 常规检查记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB161ExamInfoServiceImpl implements IMmpNatdssB161ExamInfoService {

    private final MmpNatdssB161ExamInfoMapper baseMapper;

    /**
     * 查询B16-1 常规检查记录
     *
     * @param id 主键
     * @return B16-1 常规检查记录
     */
    @Override
    public MmpNatdssB161ExamInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B16-1 常规检查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B16-1 常规检查记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB161ExamInfoVo> queryPageList(MmpNatdssB161ExamInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB161ExamInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB161ExamInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B16-1 常规检查记录列表
     *
     * @param bo 查询条件
     * @return B16-1 常规检查记录列表
     */
    @Override
    public List<MmpNatdssB161ExamInfoVo> queryList(MmpNatdssB161ExamInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB161ExamInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB161ExamInfo> buildQueryWrapper(MmpNatdssB161ExamInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB161ExamInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB161ExamInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB161ExamInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB161ExamInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB161ExamInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB161ExamInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB161ExamInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB161ExamInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB161ExamInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB161ExamInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB161ExamInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB161ExamInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB161ExamInfo::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB161ExamInfo::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB161ExamInfo::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyDeptCode()), MmpNatdssB161ExamInfo::getApplyDeptCode, bo.getApplyDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getApplyDeptName()), MmpNatdssB161ExamInfo::getApplyDeptName, bo.getApplyDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getExamSn()), MmpNatdssB161ExamInfo::getExamSn, bo.getExamSn());
        lqw.eq(bo.getExamDatetime() != null, MmpNatdssB161ExamInfo::getExamDatetime, bo.getExamDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getExamType()), MmpNatdssB161ExamInfo::getExamType, bo.getExamType());
        lqw.eq(StringUtils.isNotBlank(bo.getExamItemType()), MmpNatdssB161ExamInfo::getExamItemType, bo.getExamItemType());
        lqw.eq(StringUtils.isNotBlank(bo.getExamItemCode()), MmpNatdssB161ExamInfo::getExamItemCode, bo.getExamItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getExamItemName()), MmpNatdssB161ExamInfo::getExamItemName, bo.getExamItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getExamSites()), MmpNatdssB161ExamInfo::getExamSites, bo.getExamSites());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB161ExamInfo::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB161ExamInfo::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getReportDeptCode()), MmpNatdssB161ExamInfo::getReportDeptCode, bo.getReportDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getReportDeptName()), MmpNatdssB161ExamInfo::getReportDeptName, bo.getReportDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getExamDiagDescription()), MmpNatdssB161ExamInfo::getExamDiagDescription, bo.getExamDiagDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getExamDiagConclusion()), MmpNatdssB161ExamInfo::getExamDiagConclusion, bo.getExamDiagConclusion());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB161ExamInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB161ExamInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB161ExamInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB161ExamInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB161ExamInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B16-1 常规检查记录
     *
     * @param bo B16-1 常规检查记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB161ExamInfoBo bo) {
        MmpNatdssB161ExamInfo add = MapstructUtils.convert(bo, MmpNatdssB161ExamInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B16-1 常规检查记录
     *
     * @param bo B16-1 常规检查记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB161ExamInfoBo bo) {
        MmpNatdssB161ExamInfo update = MapstructUtils.convert(bo, MmpNatdssB161ExamInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB161ExamInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B16-1 常规检查记录信息
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
