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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB081InpatientSurgicalRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB081InpatientSurgicalRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB081InpatientSurgicalRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB081InpatientSurgicalRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB081InpatientSurgicalRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B08-1 住院手术记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB081InpatientSurgicalRecordServiceImpl implements IMmpNatdssB081InpatientSurgicalRecordService {

    private final MmpNatdssB081InpatientSurgicalRecordMapper baseMapper;

    /**
     * 查询B08-1 住院手术记录
     *
     * @param id 主键
     * @return B08-1 住院手术记录
     */
    @Override
    public MmpNatdssB081InpatientSurgicalRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B08-1 住院手术记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B08-1 住院手术记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB081InpatientSurgicalRecordVo> queryPageList(MmpNatdssB081InpatientSurgicalRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB081InpatientSurgicalRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB081InpatientSurgicalRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B08-1 住院手术记录列表
     *
     * @param bo 查询条件
     * @return B08-1 住院手术记录列表
     */
    @Override
    public List<MmpNatdssB081InpatientSurgicalRecordVo> queryList(MmpNatdssB081InpatientSurgicalRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB081InpatientSurgicalRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB081InpatientSurgicalRecord> buildQueryWrapper(MmpNatdssB081InpatientSurgicalRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB081InpatientSurgicalRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB081InpatientSurgicalRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB081InpatientSurgicalRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB081InpatientSurgicalRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB081InpatientSurgicalRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB081InpatientSurgicalRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB081InpatientSurgicalRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordSn()), MmpNatdssB081InpatientSurgicalRecord::getRecordSn, bo.getRecordSn());
        lqw.eq(bo.getRecordDatetime() != null, MmpNatdssB081InpatientSurgicalRecord::getRecordDatetime, bo.getRecordDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeonNo()), MmpNatdssB081InpatientSurgicalRecord::getSurgeonNo, bo.getSurgeonNo());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnicalTitle()), MmpNatdssB081InpatientSurgicalRecord::getTechnicalTitle, bo.getTechnicalTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getJobTitle()), MmpNatdssB081InpatientSurgicalRecord::getJobTitle, bo.getJobTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getExecutiveDeptCode()), MmpNatdssB081InpatientSurgicalRecord::getExecutiveDeptCode, bo.getExecutiveDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getExecutiveDeptName()), MmpNatdssB081InpatientSurgicalRecord::getExecutiveDeptName, bo.getExecutiveDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryCode()), MmpNatdssB081InpatientSurgicalRecord::getSurgeryCode, bo.getSurgeryCode());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpNatdssB081InpatientSurgicalRecord::getSurgeryName, bo.getSurgeryName());
        lqw.eq(bo.getStartDatetime() != null, MmpNatdssB081InpatientSurgicalRecord::getStartDatetime, bo.getStartDatetime());
        lqw.eq(bo.getFinishDatetime() != null, MmpNatdssB081InpatientSurgicalRecord::getFinishDatetime, bo.getFinishDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getIncisionType()), MmpNatdssB081InpatientSurgicalRecord::getIncisionType, bo.getIncisionType());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryLevel()), MmpNatdssB081InpatientSurgicalRecord::getSurgeryLevel, bo.getSurgeryLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgicalApproach()), MmpNatdssB081InpatientSurgicalRecord::getSurgicalApproach, bo.getSurgicalApproach());
        lqw.eq(StringUtils.isNotBlank(bo.getPreventiveAntibioticMark()), MmpNatdssB081InpatientSurgicalRecord::getPreventiveAntibioticMark, bo.getPreventiveAntibioticMark());
        lqw.eq(StringUtils.isNotBlank(bo.getProceduresDescription()), MmpNatdssB081InpatientSurgicalRecord::getProceduresDescription, bo.getProceduresDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getAsaSurgeonNo()), MmpNatdssB081InpatientSurgicalRecord::getAsaSurgeonNo, bo.getAsaSurgeonNo());
        lqw.eq(StringUtils.isNotBlank(bo.getAsaTechnicalTitle()), MmpNatdssB081InpatientSurgicalRecord::getAsaTechnicalTitle, bo.getAsaTechnicalTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getAsaJobTitle()), MmpNatdssB081InpatientSurgicalRecord::getAsaJobTitle, bo.getAsaJobTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getAnesthesiaTypeCode()), MmpNatdssB081InpatientSurgicalRecord::getAnesthesiaTypeCode, bo.getAnesthesiaTypeCode());
        lqw.eq(StringUtils.isNotBlank(bo.getAnesthesiaType()), MmpNatdssB081InpatientSurgicalRecord::getAnesthesiaType, bo.getAnesthesiaType());
        lqw.eq(StringUtils.isNotBlank(bo.getAsaPhysicalStatus()), MmpNatdssB081InpatientSurgicalRecord::getAsaPhysicalStatus, bo.getAsaPhysicalStatus());
        lqw.eq(bo.getAnesthesiaStartTime() != null, MmpNatdssB081InpatientSurgicalRecord::getAnesthesiaStartTime, bo.getAnesthesiaStartTime());
        lqw.eq(bo.getAnesthesiaEndTime() != null, MmpNatdssB081InpatientSurgicalRecord::getAnesthesiaEndTime, bo.getAnesthesiaEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getIntakeVolume()), MmpNatdssB081InpatientSurgicalRecord::getIntakeVolume, bo.getIntakeVolume());
        lqw.eq(StringUtils.isNotBlank(bo.getOutputVolume()), MmpNatdssB081InpatientSurgicalRecord::getOutputVolume, bo.getOutputVolume());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodTransAbo()), MmpNatdssB081InpatientSurgicalRecord::getBloodTransAbo, bo.getBloodTransAbo());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodTransRh()), MmpNatdssB081InpatientSurgicalRecord::getBloodTransRh, bo.getBloodTransRh());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodTransComponentCode()), MmpNatdssB081InpatientSurgicalRecord::getBloodTransComponentCode, bo.getBloodTransComponentCode());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodTransComponent()), MmpNatdssB081InpatientSurgicalRecord::getBloodTransComponent, bo.getBloodTransComponent());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodTransVolume()), MmpNatdssB081InpatientSurgicalRecord::getBloodTransVolume, bo.getBloodTransVolume());
        lqw.eq(StringUtils.isNotBlank(bo.getBloodLossVolume()), MmpNatdssB081InpatientSurgicalRecord::getBloodLossVolume, bo.getBloodLossVolume());
        lqw.eq(StringUtils.isNotBlank(bo.getUrineVolume()), MmpNatdssB081InpatientSurgicalRecord::getUrineVolume, bo.getUrineVolume());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryMaindiagCode1()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryMaindiagCode1, bo.getPresurgeryMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryMaindiagName1()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryMaindiagName1, bo.getPresurgeryMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagCode2()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagCode2, bo.getPresurgeryDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagName2()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagName2, bo.getPresurgeryDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagCode3()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagCode3, bo.getPresurgeryDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagName3()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagName3, bo.getPresurgeryDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagCode4()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagCode4, bo.getPresurgeryDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagName4()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagName4, bo.getPresurgeryDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagCode5()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagCode5, bo.getPresurgeryDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getPresurgeryDiagName5()), MmpNatdssB081InpatientSurgicalRecord::getPresurgeryDiagName5, bo.getPresurgeryDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryMaindiagCode1()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryMaindiagCode1, bo.getIntrasurgeryMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryMaindiagName1()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryMaindiagName1, bo.getIntrasurgeryMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagCode2()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagCode2, bo.getIntrasurgeryDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagName2()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagName2, bo.getIntrasurgeryDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagCode3()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagCode3, bo.getIntrasurgeryDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagName3()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagName3, bo.getIntrasurgeryDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagCode4()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagCode4, bo.getIntrasurgeryDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagName4()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagName4, bo.getIntrasurgeryDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagCode5()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagCode5, bo.getIntrasurgeryDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getIntrasurgeryDiagName5()), MmpNatdssB081InpatientSurgicalRecord::getIntrasurgeryDiagName5, bo.getIntrasurgeryDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryMaindiagCode1()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryMaindiagCode1, bo.getPostsurgeryMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryMaindiagName1()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryMaindiagName1, bo.getPostsurgeryMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagCode2()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagCode2, bo.getPostsurgeryDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagName2()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagName2, bo.getPostsurgeryDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagCode3()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagCode3, bo.getPostsurgeryDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagName3()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagName3, bo.getPostsurgeryDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagCode4()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagCode4, bo.getPostsurgeryDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagName4()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagName4, bo.getPostsurgeryDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagCode5()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagCode5, bo.getPostsurgeryDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getPostsurgeryDiagName5()), MmpNatdssB081InpatientSurgicalRecord::getPostsurgeryDiagName5, bo.getPostsurgeryDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB081InpatientSurgicalRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB081InpatientSurgicalRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB081InpatientSurgicalRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB081InpatientSurgicalRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB081InpatientSurgicalRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B08-1 住院手术记录
     *
     * @param bo B08-1 住院手术记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB081InpatientSurgicalRecordBo bo) {
        MmpNatdssB081InpatientSurgicalRecord add = MapstructUtils.convert(bo, MmpNatdssB081InpatientSurgicalRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B08-1 住院手术记录
     *
     * @param bo B08-1 住院手术记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB081InpatientSurgicalRecordBo bo) {
        MmpNatdssB081InpatientSurgicalRecord update = MapstructUtils.convert(bo, MmpNatdssB081InpatientSurgicalRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB081InpatientSurgicalRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B08-1 住院手术记录信息
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
