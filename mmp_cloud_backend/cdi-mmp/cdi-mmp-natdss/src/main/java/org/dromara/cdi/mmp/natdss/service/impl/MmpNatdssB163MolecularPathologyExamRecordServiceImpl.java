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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB163MolecularPathologyExamRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB163MolecularPathologyExamRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB163MolecularPathologyExamRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB163MolecularPathologyExamRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB163MolecularPathologyExamRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B163 分子病理检测记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB163MolecularPathologyExamRecordServiceImpl implements IMmpNatdssB163MolecularPathologyExamRecordService {

    private final MmpNatdssB163MolecularPathologyExamRecordMapper baseMapper;

    /**
     * 查询B163 分子病理检测记录
     *
     * @param id 主键
     * @return B163 分子病理检测记录
     */
    @Override
    public MmpNatdssB163MolecularPathologyExamRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B163 分子病理检测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B163 分子病理检测记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB163MolecularPathologyExamRecordVo> queryPageList(MmpNatdssB163MolecularPathologyExamRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB163MolecularPathologyExamRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB163MolecularPathologyExamRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B163 分子病理检测记录列表
     *
     * @param bo 查询条件
     * @return B163 分子病理检测记录列表
     */
    @Override
    public List<MmpNatdssB163MolecularPathologyExamRecordVo> queryList(MmpNatdssB163MolecularPathologyExamRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB163MolecularPathologyExamRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB163MolecularPathologyExamRecord> buildQueryWrapper(MmpNatdssB163MolecularPathologyExamRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB163MolecularPathologyExamRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB163MolecularPathologyExamRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB163MolecularPathologyExamRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB163MolecularPathologyExamRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB163MolecularPathologyExamRecord::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB163MolecularPathologyExamRecord::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB163MolecularPathologyExamRecord::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB163MolecularPathologyExamRecord::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB163MolecularPathologyExamRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB163MolecularPathologyExamRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB163MolecularPathologyExamRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB163MolecularPathologyExamRecord::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB163MolecularPathologyExamRecord::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpNatdssB163MolecularPathologyExamRecord::getAge, bo.getAge());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB163MolecularPathologyExamRecord::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNatdssB163MolecularPathologyExamRecord::getApplyNo, bo.getApplyNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOrderSn()), MmpNatdssB163MolecularPathologyExamRecord::getOrderSn, bo.getOrderSn());
        lqw.eq(bo.getApplyDatetime() != null, MmpNatdssB163MolecularPathologyExamRecord::getApplyDatetime, bo.getApplyDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getMolPathoNo()), MmpNatdssB163MolecularPathologyExamRecord::getMolPathoNo, bo.getMolPathoNo());
        lqw.eq(StringUtils.isNotBlank(bo.getLabSn()), MmpNatdssB163MolecularPathologyExamRecord::getLabSn, bo.getLabSn());
        lqw.eq(bo.getExamDatetime() != null, MmpNatdssB163MolecularPathologyExamRecord::getExamDatetime, bo.getExamDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getSampleNo()), MmpNatdssB163MolecularPathologyExamRecord::getSampleNo, bo.getSampleNo());
        lqw.eq(StringUtils.isNotBlank(bo.getSampleType()), MmpNatdssB163MolecularPathologyExamRecord::getSampleType, bo.getSampleType());
        lqw.eq(StringUtils.isNotBlank(bo.getTestPlatform()), MmpNatdssB163MolecularPathologyExamRecord::getTestPlatform, bo.getTestPlatform());
        lqw.eq(StringUtils.isNotBlank(bo.getTestItem()), MmpNatdssB163MolecularPathologyExamRecord::getTestItem, bo.getTestItem());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethod()), MmpNatdssB163MolecularPathologyExamRecord::getTestMethod, bo.getTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getTestContent()), MmpNatdssB163MolecularPathologyExamRecord::getTestContent, bo.getTestContent());
        lqw.eq(StringUtils.isNotBlank(bo.getTestResult()), MmpNatdssB163MolecularPathologyExamRecord::getTestResult, bo.getTestResult());
        lqw.eq(StringUtils.isNotBlank(bo.getReportNo()), MmpNatdssB163MolecularPathologyExamRecord::getReportNo, bo.getReportNo());
        lqw.eq(bo.getReportDatetime() != null, MmpNatdssB163MolecularPathologyExamRecord::getReportDatetime, bo.getReportDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getTestExon()), MmpNatdssB163MolecularPathologyExamRecord::getTestExon, bo.getTestExon());
        lqw.eq(StringUtils.isNotBlank(bo.getTestLocus()), MmpNatdssB163MolecularPathologyExamRecord::getTestLocus, bo.getTestLocus());
        lqw.eq(StringUtils.isNotBlank(bo.getTestGene()), MmpNatdssB163MolecularPathologyExamRecord::getTestGene, bo.getTestGene());
        lqw.eq(StringUtils.isNotBlank(bo.getTranscript()), MmpNatdssB163MolecularPathologyExamRecord::getTranscript, bo.getTranscript());
        lqw.eq(StringUtils.isNotBlank(bo.getNucleAlt()), MmpNatdssB163MolecularPathologyExamRecord::getNucleAlt, bo.getNucleAlt());
        lqw.eq(StringUtils.isNotBlank(bo.getAminoAcidAlt()), MmpNatdssB163MolecularPathologyExamRecord::getAminoAcidAlt, bo.getAminoAcidAlt());
        lqw.eq(StringUtils.isNotBlank(bo.getMutAbundance()), MmpNatdssB163MolecularPathologyExamRecord::getMutAbundance, bo.getMutAbundance());
        lqw.eq(StringUtils.isNotBlank(bo.getVariationType()), MmpNatdssB163MolecularPathologyExamRecord::getVariationType, bo.getVariationType());
        lqw.eq(StringUtils.isNotBlank(bo.getMutInterpretation()), MmpNatdssB163MolecularPathologyExamRecord::getMutInterpretation, bo.getMutInterpretation());
        lqw.eq(StringUtils.isNotBlank(bo.getGenoType()), MmpNatdssB163MolecularPathologyExamRecord::getGenoType, bo.getGenoType());
        lqw.eq(StringUtils.isNotBlank(bo.getSamplingSite()), MmpNatdssB163MolecularPathologyExamRecord::getSamplingSite, bo.getSamplingSite());
        lqw.eq(StringUtils.isNotBlank(bo.getGeneSequencingDepth()), MmpNatdssB163MolecularPathologyExamRecord::getGeneSequencingDepth, bo.getGeneSequencingDepth());
        lqw.eq(StringUtils.isNotBlank(bo.getTmb()), MmpNatdssB163MolecularPathologyExamRecord::getTmb, bo.getTmb());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB163MolecularPathologyExamRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB163MolecularPathologyExamRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB163MolecularPathologyExamRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB163MolecularPathologyExamRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB163MolecularPathologyExamRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B163 分子病理检测记录
     *
     * @param bo B163 分子病理检测记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB163MolecularPathologyExamRecordBo bo) {
        MmpNatdssB163MolecularPathologyExamRecord add = MapstructUtils.convert(bo, MmpNatdssB163MolecularPathologyExamRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B163 分子病理检测记录
     *
     * @param bo B163 分子病理检测记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB163MolecularPathologyExamRecordBo bo) {
        MmpNatdssB163MolecularPathologyExamRecord update = MapstructUtils.convert(bo, MmpNatdssB163MolecularPathologyExamRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB163MolecularPathologyExamRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B163 分子病理检测记录信息
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
