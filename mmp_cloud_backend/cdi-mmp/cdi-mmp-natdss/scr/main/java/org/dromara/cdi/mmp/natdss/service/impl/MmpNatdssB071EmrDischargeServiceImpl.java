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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB071EmrDischargeBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB071EmrDischargeVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB071EmrDischarge;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB071EmrDischargeMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB071EmrDischargeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B07-1 出院记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB071EmrDischargeServiceImpl implements IMmpNatdssB071EmrDischargeService {

    private final MmpNatdssB071EmrDischargeMapper baseMapper;

    /**
     * 查询B07-1 出院记录
     *
     * @param id 主键
     * @return B07-1 出院记录
     */
    @Override
    public MmpNatdssB071EmrDischargeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B07-1 出院记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B07-1 出院记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB071EmrDischargeVo> queryPageList(MmpNatdssB071EmrDischargeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB071EmrDischarge> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB071EmrDischargeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B07-1 出院记录列表
     *
     * @param bo 查询条件
     * @return B07-1 出院记录列表
     */
    @Override
    public List<MmpNatdssB071EmrDischargeVo> queryList(MmpNatdssB071EmrDischargeBo bo) {
        LambdaQueryWrapper<MmpNatdssB071EmrDischarge> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB071EmrDischarge> buildQueryWrapper(MmpNatdssB071EmrDischargeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB071EmrDischarge> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB071EmrDischarge::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB071EmrDischarge::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB071EmrDischarge::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB071EmrDischarge::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB071EmrDischarge::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB071EmrDischarge::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordSn()), MmpNatdssB071EmrDischarge::getRecordSn, bo.getRecordSn());
        lqw.eq(bo.getRecordDatetime() != null, MmpNatdssB071EmrDischarge::getRecordDatetime, bo.getRecordDatetime());
        lqw.eq(bo.getAdmissionDatetime() != null, MmpNatdssB071EmrDischarge::getAdmissionDatetime, bo.getAdmissionDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeOrder()), MmpNatdssB071EmrDischarge::getDischargeOrder, bo.getDischargeOrder());
        lqw.eq(bo.getDischargeDatetime() != null, MmpNatdssB071EmrDischarge::getDischargeDatetime, bo.getDischargeDatetime());
        lqw.eq(bo.getLengthOfStay() != null, MmpNatdssB071EmrDischarge::getLengthOfStay, bo.getLengthOfStay());
        lqw.eq(StringUtils.isNotBlank(bo.getKpsScore()), MmpNatdssB071EmrDischarge::getKpsScore, bo.getKpsScore());
        lqw.eq(StringUtils.isNotBlank(bo.getEcogScore()), MmpNatdssB071EmrDischarge::getEcogScore, bo.getEcogScore());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordText()), MmpNatdssB071EmrDischarge::getRecordText, bo.getRecordText());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionCondition()), MmpNatdssB071EmrDischarge::getAdmissionCondition, bo.getAdmissionCondition());
        lqw.eq(StringUtils.isNotBlank(bo.getTreatmentInfo()), MmpNatdssB071EmrDischarge::getTreatmentInfo, bo.getTreatmentInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeCondition()), MmpNatdssB071EmrDischarge::getDischargeCondition, bo.getDischargeCondition());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionMaindiagCode1()), MmpNatdssB071EmrDischarge::getAdmissionMaindiagCode1, bo.getAdmissionMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionMaindiagName1()), MmpNatdssB071EmrDischarge::getAdmissionMaindiagName1, bo.getAdmissionMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode2()), MmpNatdssB071EmrDischarge::getAdmissionDiagCode2, bo.getAdmissionDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName2()), MmpNatdssB071EmrDischarge::getAdmissionDiagName2, bo.getAdmissionDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode3()), MmpNatdssB071EmrDischarge::getAdmissionDiagCode3, bo.getAdmissionDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName3()), MmpNatdssB071EmrDischarge::getAdmissionDiagName3, bo.getAdmissionDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode4()), MmpNatdssB071EmrDischarge::getAdmissionDiagCode4, bo.getAdmissionDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName4()), MmpNatdssB071EmrDischarge::getAdmissionDiagName4, bo.getAdmissionDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode5()), MmpNatdssB071EmrDischarge::getAdmissionDiagCode5, bo.getAdmissionDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName5()), MmpNatdssB071EmrDischarge::getAdmissionDiagName5, bo.getAdmissionDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCoden()), MmpNatdssB071EmrDischarge::getAdmissionDiagCoden, bo.getAdmissionDiagCoden());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagNamen()), MmpNatdssB071EmrDischarge::getAdmissionDiagNamen, bo.getAdmissionDiagNamen());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeMaindiagCode1()), MmpNatdssB071EmrDischarge::getDischargeMaindiagCode1, bo.getDischargeMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeMaindiagName1()), MmpNatdssB071EmrDischarge::getDischargeMaindiagName1, bo.getDischargeMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagCode2()), MmpNatdssB071EmrDischarge::getDischargeDiagCode2, bo.getDischargeDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagName2()), MmpNatdssB071EmrDischarge::getDischargeDiagName2, bo.getDischargeDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagCode3()), MmpNatdssB071EmrDischarge::getDischargeDiagCode3, bo.getDischargeDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagName3()), MmpNatdssB071EmrDischarge::getDischargeDiagName3, bo.getDischargeDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagCode4()), MmpNatdssB071EmrDischarge::getDischargeDiagCode4, bo.getDischargeDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagName4()), MmpNatdssB071EmrDischarge::getDischargeDiagName4, bo.getDischargeDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagCode5()), MmpNatdssB071EmrDischarge::getDischargeDiagCode5, bo.getDischargeDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagName5()), MmpNatdssB071EmrDischarge::getDischargeDiagName5, bo.getDischargeDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagCoden()), MmpNatdssB071EmrDischarge::getDischargeDiagCoden, bo.getDischargeDiagCoden());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDiagNamen()), MmpNatdssB071EmrDischarge::getDischargeDiagNamen, bo.getDischargeDiagNamen());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB071EmrDischarge::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB071EmrDischarge::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB071EmrDischarge::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB071EmrDischarge::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB071EmrDischarge::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B07-1 出院记录
     *
     * @param bo B07-1 出院记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB071EmrDischargeBo bo) {
        MmpNatdssB071EmrDischarge add = MapstructUtils.convert(bo, MmpNatdssB071EmrDischarge.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B07-1 出院记录
     *
     * @param bo B07-1 出院记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB071EmrDischargeBo bo) {
        MmpNatdssB071EmrDischarge update = MapstructUtils.convert(bo, MmpNatdssB071EmrDischarge.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB071EmrDischarge entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B07-1 出院记录信息
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
