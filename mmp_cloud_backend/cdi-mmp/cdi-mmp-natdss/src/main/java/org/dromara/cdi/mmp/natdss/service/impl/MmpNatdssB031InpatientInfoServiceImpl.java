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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB031InpatientInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB031InpatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB031InpatientInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB031InpatientInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB031InpatientInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B03-1 住院患者信息Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB031InpatientInfoServiceImpl implements IMmpNatdssB031InpatientInfoService {

    private final MmpNatdssB031InpatientInfoMapper baseMapper;

    /**
     * 查询B03-1 住院患者信息
     *
     * @param id 主键
     * @return B03-1 住院患者信息
     */
    @Override
    public MmpNatdssB031InpatientInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B03-1 住院患者信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B03-1 住院患者信息分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB031InpatientInfoVo> queryPageList(MmpNatdssB031InpatientInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB031InpatientInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB031InpatientInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B03-1 住院患者信息列表
     *
     * @param bo 查询条件
     * @return B03-1 住院患者信息列表
     */
    @Override
    public List<MmpNatdssB031InpatientInfoVo> queryList(MmpNatdssB031InpatientInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB031InpatientInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB031InpatientInfo> buildQueryWrapper(MmpNatdssB031InpatientInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB031InpatientInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB031InpatientInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB031InpatientInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB031InpatientInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB031InpatientInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB031InpatientInfo::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB031InpatientInfo::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB031InpatientInfo::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB031InpatientInfo::getName, bo.getName());
        lqw.eq(bo.getAdmissionDatetime() != null, MmpNatdssB031InpatientInfo::getAdmissionDatetime, bo.getAdmissionDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentDeptCode()), MmpNatdssB031InpatientInfo::getCurrentDeptCode, bo.getCurrentDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getCurrentDeptName()), MmpNatdssB031InpatientInfo::getCurrentDeptName, bo.getCurrentDeptName());
        lqw.like(StringUtils.isNotBlank(bo.getCurrentWardName()), MmpNatdssB031InpatientInfo::getCurrentWardName, bo.getCurrentWardName());
        lqw.like(StringUtils.isNotBlank(bo.getCurrentBedName()), MmpNatdssB031InpatientInfo::getCurrentBedName, bo.getCurrentBedName());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitDoctorNo()), MmpNatdssB031InpatientInfo::getVisitDoctorNo, bo.getVisitDoctorNo());
        lqw.eq(bo.getDischargeDatetime() != null, MmpNatdssB031InpatientInfo::getDischargeDatetime, bo.getDischargeDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getDischargeDeptCode()), MmpNatdssB031InpatientInfo::getDischargeDeptCode, bo.getDischargeDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getDischargeDeptName()), MmpNatdssB031InpatientInfo::getDischargeDeptName, bo.getDischargeDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB031InpatientInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB031InpatientInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB031InpatientInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB031InpatientInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB031InpatientInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B03-1 住院患者信息
     *
     * @param bo B03-1 住院患者信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB031InpatientInfoBo bo) {
        MmpNatdssB031InpatientInfo add = MapstructUtils.convert(bo, MmpNatdssB031InpatientInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B03-1 住院患者信息
     *
     * @param bo B03-1 住院患者信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB031InpatientInfoBo bo) {
        MmpNatdssB031InpatientInfo update = MapstructUtils.convert(bo, MmpNatdssB031InpatientInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB031InpatientInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B03-1 住院患者信息信息
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
