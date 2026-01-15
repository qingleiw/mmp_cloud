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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB181RadInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB181RadInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB181RadInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB181RadInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB181RadInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B18-1 临床放疗记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB181RadInfoServiceImpl implements IMmpNatdssB181RadInfoService {

    private final MmpNatdssB181RadInfoMapper baseMapper;

    /**
     * 查询B18-1 临床放疗记录
     *
     * @param id 主键
     * @return B18-1 临床放疗记录
     */
    @Override
    public MmpNatdssB181RadInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B18-1 临床放疗记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B18-1 临床放疗记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB181RadInfoVo> queryPageList(MmpNatdssB181RadInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB181RadInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB181RadInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B18-1 临床放疗记录列表
     *
     * @param bo 查询条件
     * @return B18-1 临床放疗记录列表
     */
    @Override
    public List<MmpNatdssB181RadInfoVo> queryList(MmpNatdssB181RadInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB181RadInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB181RadInfo> buildQueryWrapper(MmpNatdssB181RadInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB181RadInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB181RadInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB181RadInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB181RadInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB181RadInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB181RadInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB181RadInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB181RadInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB181RadInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB181RadInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB181RadInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB181RadInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB181RadInfo::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpNatdssB181RadInfo::getAge, bo.getAge());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB181RadInfo::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getRadioSn()), MmpNatdssB181RadInfo::getRadioSn, bo.getRadioSn());
        lqw.eq(StringUtils.isNotBlank(bo.getCourseSn()), MmpNatdssB181RadInfo::getCourseSn, bo.getCourseSn());
        lqw.eq(bo.getRadioStartTime() != null, MmpNatdssB181RadInfo::getRadioStartTime, bo.getRadioStartTime());
        lqw.eq(bo.getRadioEndTime() != null, MmpNatdssB181RadInfo::getRadioEndTime, bo.getRadioEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getRadioTech()), MmpNatdssB181RadInfo::getRadioTech, bo.getRadioTech());
        lqw.eq(StringUtils.isNotBlank(bo.getRadioSite()), MmpNatdssB181RadInfo::getRadioSite, bo.getRadioSite());
        lqw.eq(StringUtils.isNotBlank(bo.getTargetVolume()), MmpNatdssB181RadInfo::getTargetVolume, bo.getTargetVolume());
        lqw.eq(bo.getPresDays() != null, MmpNatdssB181RadInfo::getPresDays, bo.getPresDays());
        lqw.eq(StringUtils.isNotBlank(bo.getPresTotalDose()), MmpNatdssB181RadInfo::getPresTotalDose, bo.getPresTotalDose());
        lqw.eq(bo.getPresRadioCount() != null, MmpNatdssB181RadInfo::getPresRadioCount, bo.getPresRadioCount());
        lqw.eq(StringUtils.isNotBlank(bo.getRadioSingleDose()), MmpNatdssB181RadInfo::getRadioSingleDose, bo.getRadioSingleDose());
        lqw.eq(StringUtils.isNotBlank(bo.getSynChemoMark()), MmpNatdssB181RadInfo::getSynChemoMark, bo.getSynChemoMark());
        lqw.eq(StringUtils.isNotBlank(bo.getSynChemoScheme()), MmpNatdssB181RadInfo::getSynChemoScheme, bo.getSynChemoScheme());
        lqw.eq(StringUtils.isNotBlank(bo.getSynOtherSchemeMark()), MmpNatdssB181RadInfo::getSynOtherSchemeMark, bo.getSynOtherSchemeMark());
        lqw.eq(StringUtils.isNotBlank(bo.getSynOtherScheme()), MmpNatdssB181RadInfo::getSynOtherScheme, bo.getSynOtherScheme());
        lqw.eq(bo.getEffectEvalTime() != null, MmpNatdssB181RadInfo::getEffectEvalTime, bo.getEffectEvalTime());
        lqw.eq(StringUtils.isNotBlank(bo.getEffectEval()), MmpNatdssB181RadInfo::getEffectEval, bo.getEffectEval());
        lqw.eq(StringUtils.isNotBlank(bo.getAdverseDrugReaction()), MmpNatdssB181RadInfo::getAdverseDrugReaction, bo.getAdverseDrugReaction());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB181RadInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB181RadInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB181RadInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getTherapeuticPurposes()), MmpNatdssB181RadInfo::getTherapeuticPurposes, bo.getTherapeuticPurposes());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB181RadInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB181RadInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B18-1 临床放疗记录
     *
     * @param bo B18-1 临床放疗记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB181RadInfoBo bo) {
        MmpNatdssB181RadInfo add = MapstructUtils.convert(bo, MmpNatdssB181RadInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B18-1 临床放疗记录
     *
     * @param bo B18-1 临床放疗记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB181RadInfoBo bo) {
        MmpNatdssB181RadInfo update = MapstructUtils.convert(bo, MmpNatdssB181RadInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB181RadInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B18-1 临床放疗记录信息
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
