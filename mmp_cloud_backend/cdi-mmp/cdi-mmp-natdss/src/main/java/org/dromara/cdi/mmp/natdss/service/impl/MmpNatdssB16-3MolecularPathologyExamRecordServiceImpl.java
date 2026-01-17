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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB16-3MolecularPathologyExamRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB16-3MolecularPathologyExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB16-3MolecularPathologyExamRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB16-3MolecularPathologyExamRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB16-3MolecularPathologyExamRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B16-3 分子病理检测记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB16-3MolecularPathologyExamRecordServiceImpl implements IMmpNatdssB16-3MolecularPathologyExamRecordService {

    private final MmpNatdssB16-3MolecularPathologyExamRecordMapper baseMapper;

    /**
     * 查询B16-3 分子病理检测记录
     *
     * @param id 主键
     * @return B16-3 分子病理检测记录
     */
    @Override
    public MmpNatdssB16-3MolecularPathologyExamRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B16-3 分子病理检测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B16-3 分子病理检测记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB16-3MolecularPathologyExamRecordVo> queryPageList(MmpNatdssB16-3MolecularPathologyExamRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB16-3MolecularPathologyExamRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB16-3MolecularPathologyExamRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B16-3 分子病理检测记录列表
     *
     * @param bo 查询条件
     * @return B16-3 分子病理检测记录列表
     */
    @Override
    public List<MmpNatdssB16-3MolecularPathologyExamRecordVo> queryList(MmpNatdssB16-3MolecularPathologyExamRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB16-3MolecularPathologyExamRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB16-3MolecularPathologyExamRecord> buildQueryWrapper(MmpNatdssB16-3MolecularPathologyExamRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB16-3MolecularPathologyExamRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB16-3MolecularPathologyExamRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB16-3MolecularPathologyExamRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB16-3MolecularPathologyExamRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB16-3MolecularPathologyExamRecord::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB16-3MolecularPathologyExamRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB16-3MolecularPathologyExamRecord::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB16-3MolecularPathologyExamRecord::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getAge, bo.getAge());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB16-3MolecularPathologyExamRecord::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getMolPathoNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getMolPathoNo, bo.getMolPathoNo());
        lqw.eq(StringUtils.isNotBlank(bo.getLabSn()), MmpNatdssB16-3MolecularPathologyExamRecord::getLabSn, bo.getLabSn());
        lqw.eq(bo.getExamDatetime() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getExamDatetime, bo.getExamDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getSampleNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getSampleNo, bo.getSampleNo());
        lqw.eq(StringUtils.isNotBlank(bo.getSampleType()), MmpNatdssB16-3MolecularPathologyExamRecord::getSampleType, bo.getSampleType());
        lqw.eq(StringUtils.isNotBlank(bo.getTestPlatform()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestPlatform, bo.getTestPlatform());
        lqw.eq(StringUtils.isNotBlank(bo.getTestItem()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestItem, bo.getTestItem());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethod()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestMethod, bo.getTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getTestContent()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestContent, bo.getTestContent());
        lqw.eq(StringUtils.isNotBlank(bo.getTestResult()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestResult, bo.getTestResult());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB16-3MolecularPathologyExamRecord::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getTestExon()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestExon, bo.getTestExon());
        lqw.eq(StringUtils.isNotBlank(bo.getTestLocus()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestLocus, bo.getTestLocus());
        lqw.eq(StringUtils.isNotBlank(bo.getTestGene()), MmpNatdssB16-3MolecularPathologyExamRecord::getTestGene, bo.getTestGene());
        lqw.eq(StringUtils.isNotBlank(bo.getTranscript()), MmpNatdssB16-3MolecularPathologyExamRecord::getTranscript, bo.getTranscript());
        lqw.eq(StringUtils.isNotBlank(bo.getNucleAlt()), MmpNatdssB16-3MolecularPathologyExamRecord::getNucleAlt, bo.getNucleAlt());
        lqw.eq(StringUtils.isNotBlank(bo.getAminoAcidAlt()), MmpNatdssB16-3MolecularPathologyExamRecord::getAminoAcidAlt, bo.getAminoAcidAlt());
        lqw.eq(StringUtils.isNotBlank(bo.getMutAbundance()), MmpNatdssB16-3MolecularPathologyExamRecord::getMutAbundance, bo.getMutAbundance());
        lqw.eq(StringUtils.isNotBlank(bo.getVariationType()), MmpNatdssB16-3MolecularPathologyExamRecord::getVariationType, bo.getVariationType());
        lqw.eq(StringUtils.isNotBlank(bo.getMutInterpretation()), MmpNatdssB16-3MolecularPathologyExamRecord::getMutInterpretation, bo.getMutInterpretation());
        lqw.eq(StringUtils.isNotBlank(bo.getGenoType()), MmpNatdssB16-3MolecularPathologyExamRecord::getGenoType, bo.getGenoType());
        lqw.eq(StringUtils.isNotBlank(bo.getSamplingSite()), MmpNatdssB16-3MolecularPathologyExamRecord::getSamplingSite, bo.getSamplingSite());
        lqw.eq(StringUtils.isNotBlank(bo.getGeneSequencingDepth()), MmpNatdssB16-3MolecularPathologyExamRecord::getGeneSequencingDepth, bo.getGeneSequencingDepth());
        lqw.eq(StringUtils.isNotBlank(bo.getTmb()), MmpNatdssB16-3MolecularPathologyExamRecord::getTmb, bo.getTmb());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB16-3MolecularPathologyExamRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB16-3MolecularPathologyExamRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB16-3MolecularPathologyExamRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B16-3 分子病理检测记录
     *
     * @param bo B16-3 分子病理检测记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB16-3MolecularPathologyExamRecordBo bo) {
        MmpNatdssB16-3MolecularPathologyExamRecord add = MapstructUtils.convert(bo, MmpNatdssB16-3MolecularPathologyExamRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B16-3 分子病理检测记录
     *
     * @param bo B16-3 分子病理检测记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB16-3MolecularPathologyExamRecordBo bo) {
        MmpNatdssB16-3MolecularPathologyExamRecord update = MapstructUtils.convert(bo, MmpNatdssB16-3MolecularPathologyExamRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB16-3MolecularPathologyExamRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B16-3 分子病理检测记录信息
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
