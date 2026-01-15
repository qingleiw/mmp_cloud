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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB023DiagInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB023DiagInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB023DiagInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB023DiagInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB023DiagInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B02-3 患者诊断记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB023DiagInfoServiceImpl implements IMmpNatdssB023DiagInfoService {

    private final MmpNatdssB023DiagInfoMapper baseMapper;

    /**
     * 查询B02-3 患者诊断记录
     *
     * @param id 主键
     * @return B02-3 患者诊断记录
     */
    @Override
    public MmpNatdssB023DiagInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B02-3 患者诊断记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B02-3 患者诊断记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB023DiagInfoVo> queryPageList(MmpNatdssB023DiagInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB023DiagInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB023DiagInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B02-3 患者诊断记录列表
     *
     * @param bo 查询条件
     * @return B02-3 患者诊断记录列表
     */
    @Override
    public List<MmpNatdssB023DiagInfoVo> queryList(MmpNatdssB023DiagInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB023DiagInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB023DiagInfo> buildQueryWrapper(MmpNatdssB023DiagInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB023DiagInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB023DiagInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB023DiagInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB023DiagInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB023DiagInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB023DiagInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB023DiagInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB023DiagInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB023DiagInfo::getVisitTimes, bo.getVisitTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB023DiagInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB023DiagInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB023DiagInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagId()), MmpNatdssB023DiagInfo::getDiagId, bo.getDiagId());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagSerialNumber()), MmpNatdssB023DiagInfo::getDiagSerialNumber, bo.getDiagSerialNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagType()), MmpNatdssB023DiagInfo::getDiagType, bo.getDiagType());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagCode()), MmpNatdssB023DiagInfo::getDiagCode, bo.getDiagCode());
        lqw.like(StringUtils.isNotBlank(bo.getDiagName()), MmpNatdssB023DiagInfo::getDiagName, bo.getDiagName());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagExplanation()), MmpNatdssB023DiagInfo::getDiagExplanation, bo.getDiagExplanation());
        lqw.eq(bo.getDiagDatetime() != null, MmpNatdssB023DiagInfo::getDiagDatetime, bo.getDiagDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getConfirmedDiagMark()), MmpNatdssB023DiagInfo::getConfirmedDiagMark, bo.getConfirmedDiagMark());
        lqw.eq(StringUtils.isNotBlank(bo.getMaindiagMark()), MmpNatdssB023DiagInfo::getMaindiagMark, bo.getMaindiagMark());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagDoctorNo()), MmpNatdssB023DiagInfo::getDiagDoctorNo, bo.getDiagDoctorNo());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB023DiagInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB023DiagInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB023DiagInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB023DiagInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB023DiagInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B02-3 患者诊断记录
     *
     * @param bo B02-3 患者诊断记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB023DiagInfoBo bo) {
        MmpNatdssB023DiagInfo add = MapstructUtils.convert(bo, MmpNatdssB023DiagInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B02-3 患者诊断记录
     *
     * @param bo B02-3 患者诊断记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB023DiagInfoBo bo) {
        MmpNatdssB023DiagInfo update = MapstructUtils.convert(bo, MmpNatdssB023DiagInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB023DiagInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B02-3 患者诊断记录信息
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
