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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB131OutpatientDiagAndMedrecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB131OutpatientDiagAndMedrecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB131OutpatientDiagAndMedrecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB131OutpatientDiagAndMedrecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB131OutpatientDiagAndMedrecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B13-1 门诊病历记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB131OutpatientDiagAndMedrecordServiceImpl implements IMmpNatdssB131OutpatientDiagAndMedrecordService {

    private final MmpNatdssB131OutpatientDiagAndMedrecordMapper baseMapper;

    /**
     * 查询B13-1 门诊病历记录
     *
     * @param id 主键
     * @return B13-1 门诊病历记录
     */
    @Override
    public MmpNatdssB131OutpatientDiagAndMedrecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B13-1 门诊病历记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B13-1 门诊病历记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB131OutpatientDiagAndMedrecordVo> queryPageList(MmpNatdssB131OutpatientDiagAndMedrecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB131OutpatientDiagAndMedrecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB131OutpatientDiagAndMedrecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B13-1 门诊病历记录列表
     *
     * @param bo 查询条件
     * @return B13-1 门诊病历记录列表
     */
    @Override
    public List<MmpNatdssB131OutpatientDiagAndMedrecordVo> queryList(MmpNatdssB131OutpatientDiagAndMedrecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB131OutpatientDiagAndMedrecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB131OutpatientDiagAndMedrecord> buildQueryWrapper(MmpNatdssB131OutpatientDiagAndMedrecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB131OutpatientDiagAndMedrecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB131OutpatientDiagAndMedrecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB131OutpatientDiagAndMedrecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB131OutpatientDiagAndMedrecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB131OutpatientDiagAndMedrecord::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB131OutpatientDiagAndMedrecord::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB131OutpatientDiagAndMedrecord::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getVisitTimes, bo.getVisitTimes());
        lqw.eq(bo.getVisitDatetime() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getVisitDatetime, bo.getVisitDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordSn()), MmpNatdssB131OutpatientDiagAndMedrecord::getRecordSn, bo.getRecordSn());
        lqw.eq(bo.getRecordDatetime() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getRecordDatetime, bo.getRecordDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordText()), MmpNatdssB131OutpatientDiagAndMedrecord::getRecordText, bo.getRecordText());
        lqw.eq(StringUtils.isNotBlank(bo.getTreatmentInfo()), MmpNatdssB131OutpatientDiagAndMedrecord::getTreatmentInfo, bo.getTreatmentInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getOperationInfo()), MmpNatdssB131OutpatientDiagAndMedrecord::getOperationInfo, bo.getOperationInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getChiefComplaint()), MmpNatdssB131OutpatientDiagAndMedrecord::getChiefComplaint, bo.getChiefComplaint());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentMedhistory()), MmpNatdssB131OutpatientDiagAndMedrecord::getCurrentMedhistory, bo.getCurrentMedhistory());
        lqw.eq(StringUtils.isNotBlank(bo.getPastMedhistory()), MmpNatdssB131OutpatientDiagAndMedrecord::getPastMedhistory, bo.getPastMedhistory());
        lqw.eq(StringUtils.isNotBlank(bo.getPersonalMedhistory()), MmpNatdssB131OutpatientDiagAndMedrecord::getPersonalMedhistory, bo.getPersonalMedhistory());
        lqw.eq(StringUtils.isNotBlank(bo.getFamilyHistory()), MmpNatdssB131OutpatientDiagAndMedrecord::getFamilyHistory, bo.getFamilyHistory());
        lqw.eq(StringUtils.isNotBlank(bo.getMarriageBirthHistory()), MmpNatdssB131OutpatientDiagAndMedrecord::getMarriageBirthHistory, bo.getMarriageBirthHistory());
        lqw.eq(StringUtils.isNotBlank(bo.getMenstrualHistory()), MmpNatdssB131OutpatientDiagAndMedrecord::getMenstrualHistory, bo.getMenstrualHistory());
        lqw.eq(StringUtils.isNotBlank(bo.getPhysicalExam()), MmpNatdssB131OutpatientDiagAndMedrecord::getPhysicalExam, bo.getPhysicalExam());
        lqw.like(StringUtils.isNotBlank(bo.getTcmDiseaseName()), MmpNatdssB131OutpatientDiagAndMedrecord::getTcmDiseaseName, bo.getTcmDiseaseName());
        lqw.like(StringUtils.isNotBlank(bo.getTcmSyndromeName()), MmpNatdssB131OutpatientDiagAndMedrecord::getTcmSyndromeName, bo.getTcmSyndromeName());
        lqw.eq(bo.getDiagnoseDatetime() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getDiagnoseDatetime, bo.getDiagnoseDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getMaindiagCode1()), MmpNatdssB131OutpatientDiagAndMedrecord::getMaindiagCode1, bo.getMaindiagCode1());
        lqw.eq(StringUtils.isNotBlank(bo.getMaindiagName1()), MmpNatdssB131OutpatientDiagAndMedrecord::getMaindiagName1, bo.getMaindiagName1());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode2()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode2, bo.getDiagCode2());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName2()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName2, bo.getDiagName2());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode3()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode3, bo.getDiagCode3());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName3()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName3, bo.getDiagName3());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode4()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode4, bo.getDiagCode4());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName4()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName4, bo.getDiagName4());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode5()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode5, bo.getDiagCode5());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName5()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName5, bo.getDiagName5());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode6()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode6, bo.getDiagCode6());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName6()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName6, bo.getDiagName6());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode7()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode7, bo.getDiagCode7());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName7()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName7, bo.getDiagName7());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode8()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode8, bo.getDiagCode8());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName8()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName8, bo.getDiagName8());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode9()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode9, bo.getDiagCode9());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName9()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName9, bo.getDiagName9());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode10()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCode10, bo.getDiagCode10());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagName10()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagName10, bo.getDiagName10());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCoden()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagCoden, bo.getDiagCoden());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagNamen()), MmpNatdssB131OutpatientDiagAndMedrecord::getDiagNamen, bo.getDiagNamen());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB131OutpatientDiagAndMedrecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB131OutpatientDiagAndMedrecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB131OutpatientDiagAndMedrecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B13-1 门诊病历记录
     *
     * @param bo B13-1 门诊病历记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB131OutpatientDiagAndMedrecordBo bo) {
        MmpNatdssB131OutpatientDiagAndMedrecord add = MapstructUtils.convert(bo, MmpNatdssB131OutpatientDiagAndMedrecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B13-1 门诊病历记录
     *
     * @param bo B13-1 门诊病历记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB131OutpatientDiagAndMedrecordBo bo) {
        MmpNatdssB131OutpatientDiagAndMedrecord update = MapstructUtils.convert(bo, MmpNatdssB131OutpatientDiagAndMedrecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB131OutpatientDiagAndMedrecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B13-1 门诊病历记录信息
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
