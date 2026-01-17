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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB051EmrAdmissionBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB051EmrAdmissionVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB051EmrAdmission;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB051EmrAdmissionMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB051EmrAdmissionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B05-1 入院记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB051EmrAdmissionServiceImpl implements IMmpNatdssB051EmrAdmissionService {

    private final MmpNatdssB051EmrAdmissionMapper baseMapper;

    /**
     * 查询B05-1 入院记录
     *
     * @param id 主键
     * @return B05-1 入院记录
     */
    @Override
    public MmpNatdssB051EmrAdmissionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B05-1 入院记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B05-1 入院记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB051EmrAdmissionVo> queryPageList(MmpNatdssB051EmrAdmissionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB051EmrAdmission> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB051EmrAdmissionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B05-1 入院记录列表
     *
     * @param bo 查询条件
     * @return B05-1 入院记录列表
     */
    @Override
    public List<MmpNatdssB051EmrAdmissionVo> queryList(MmpNatdssB051EmrAdmissionBo bo) {
        LambdaQueryWrapper<MmpNatdssB051EmrAdmission> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB051EmrAdmission> buildQueryWrapper(MmpNatdssB051EmrAdmissionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB051EmrAdmission> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB051EmrAdmission::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB051EmrAdmission::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB051EmrAdmission::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB051EmrAdmission::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB051EmrAdmission::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB051EmrAdmission::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordSn()), MmpNatdssB051EmrAdmission::getRecordSn, bo.getRecordSn());
        lqw.eq(bo.getRecordDatetime() != null, MmpNatdssB051EmrAdmission::getRecordDatetime, bo.getRecordDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getKpsScore()), MmpNatdssB051EmrAdmission::getKpsScore, bo.getKpsScore());
        lqw.eq(StringUtils.isNotBlank(bo.getEcogScore()), MmpNatdssB051EmrAdmission::getEcogScore, bo.getEcogScore());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordText()), MmpNatdssB051EmrAdmission::getRecordText, bo.getRecordText());
        lqw.eq(StringUtils.isNotBlank(bo.getChiefComplaint()), MmpNatdssB051EmrAdmission::getChiefComplaint, bo.getChiefComplaint());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentMedhistory()), MmpNatdssB051EmrAdmission::getCurrentMedhistory, bo.getCurrentMedhistory());
        lqw.eq(StringUtils.isNotBlank(bo.getPastMedhistory()), MmpNatdssB051EmrAdmission::getPastMedhistory, bo.getPastMedhistory());
        lqw.eq(StringUtils.isNotBlank(bo.getPersonalMedhistory()), MmpNatdssB051EmrAdmission::getPersonalMedhistory, bo.getPersonalMedhistory());
        lqw.eq(StringUtils.isNotBlank(bo.getFamilyHistory()), MmpNatdssB051EmrAdmission::getFamilyHistory, bo.getFamilyHistory());
        lqw.eq(StringUtils.isNotBlank(bo.getMarriageBirthHistory()), MmpNatdssB051EmrAdmission::getMarriageBirthHistory, bo.getMarriageBirthHistory());
        lqw.eq(StringUtils.isNotBlank(bo.getMenstrualHistory()), MmpNatdssB051EmrAdmission::getMenstrualHistory, bo.getMenstrualHistory());
        lqw.eq(StringUtils.isNotBlank(bo.getSystolicPressure()), MmpNatdssB051EmrAdmission::getSystolicPressure, bo.getSystolicPressure());
        lqw.eq(StringUtils.isNotBlank(bo.getDiastolicPressure()), MmpNatdssB051EmrAdmission::getDiastolicPressure, bo.getDiastolicPressure());
        lqw.eq(StringUtils.isNotBlank(bo.getRespiratoryRate()), MmpNatdssB051EmrAdmission::getRespiratoryRate, bo.getRespiratoryRate());
        lqw.eq(StringUtils.isNotBlank(bo.getBodyTemperature()), MmpNatdssB051EmrAdmission::getBodyTemperature, bo.getBodyTemperature());
        lqw.eq(StringUtils.isNotBlank(bo.getHeartRate()), MmpNatdssB051EmrAdmission::getHeartRate, bo.getHeartRate());
        lqw.eq(StringUtils.isNotBlank(bo.getHeight()), MmpNatdssB051EmrAdmission::getHeight, bo.getHeight());
        lqw.eq(StringUtils.isNotBlank(bo.getWeight()), MmpNatdssB051EmrAdmission::getWeight, bo.getWeight());
        lqw.eq(StringUtils.isNotBlank(bo.getBodySurfaceArea()), MmpNatdssB051EmrAdmission::getBodySurfaceArea, bo.getBodySurfaceArea());
        lqw.eq(StringUtils.isNotBlank(bo.getPhysicalExam()), MmpNatdssB051EmrAdmission::getPhysicalExam, bo.getPhysicalExam());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialExam()), MmpNatdssB051EmrAdmission::getSpecialExam, bo.getSpecialExam());
        lqw.eq(StringUtils.isNotBlank(bo.getAuxiliaryExam()), MmpNatdssB051EmrAdmission::getAuxiliaryExam, bo.getAuxiliaryExam());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionMaindiagCode1()), MmpNatdssB051EmrAdmission::getAdmissionMaindiagCode1, bo.getAdmissionMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionMaindiagName1()), MmpNatdssB051EmrAdmission::getAdmissionMaindiagName1, bo.getAdmissionMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode2()), MmpNatdssB051EmrAdmission::getAdmissionDiagCode2, bo.getAdmissionDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName2()), MmpNatdssB051EmrAdmission::getAdmissionDiagName2, bo.getAdmissionDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode3()), MmpNatdssB051EmrAdmission::getAdmissionDiagCode3, bo.getAdmissionDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName3()), MmpNatdssB051EmrAdmission::getAdmissionDiagName3, bo.getAdmissionDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode4()), MmpNatdssB051EmrAdmission::getAdmissionDiagCode4, bo.getAdmissionDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName4()), MmpNatdssB051EmrAdmission::getAdmissionDiagName4, bo.getAdmissionDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCode5()), MmpNatdssB051EmrAdmission::getAdmissionDiagCode5, bo.getAdmissionDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagName5()), MmpNatdssB051EmrAdmission::getAdmissionDiagName5, bo.getAdmissionDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagCoden()), MmpNatdssB051EmrAdmission::getAdmissionDiagCoden, bo.getAdmissionDiagCoden());
        lqw.eq(StringUtils.isNotBlank(bo.getAdmissionDiagNamen()), MmpNatdssB051EmrAdmission::getAdmissionDiagNamen, bo.getAdmissionDiagNamen());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB051EmrAdmission::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB051EmrAdmission::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB051EmrAdmission::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB051EmrAdmission::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB051EmrAdmission::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B05-1 入院记录
     *
     * @param bo B05-1 入院记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB051EmrAdmissionBo bo) {
        MmpNatdssB051EmrAdmission add = MapstructUtils.convert(bo, MmpNatdssB051EmrAdmission.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B05-1 入院记录
     *
     * @param bo B05-1 入院记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB051EmrAdmissionBo bo) {
        MmpNatdssB051EmrAdmission update = MapstructUtils.convert(bo, MmpNatdssB051EmrAdmission.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB051EmrAdmission entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B05-1 入院记录信息
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
