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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB121OutpatientInfoBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB121OutpatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB121OutpatientInfo;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB121OutpatientInfoMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB121OutpatientInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B12-1 门诊患者信息Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB121OutpatientInfoServiceImpl implements IMmpNatdssB121OutpatientInfoService {

    private final MmpNatdssB121OutpatientInfoMapper baseMapper;

    /**
     * 查询B12-1 门诊患者信息
     *
     * @param id 主键
     * @return B12-1 门诊患者信息
     */
    @Override
    public MmpNatdssB121OutpatientInfoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B12-1 门诊患者信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B12-1 门诊患者信息分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB121OutpatientInfoVo> queryPageList(MmpNatdssB121OutpatientInfoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB121OutpatientInfo> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB121OutpatientInfoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B12-1 门诊患者信息列表
     *
     * @param bo 查询条件
     * @return B12-1 门诊患者信息列表
     */
    @Override
    public List<MmpNatdssB121OutpatientInfoVo> queryList(MmpNatdssB121OutpatientInfoBo bo) {
        LambdaQueryWrapper<MmpNatdssB121OutpatientInfo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB121OutpatientInfo> buildQueryWrapper(MmpNatdssB121OutpatientInfoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB121OutpatientInfo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB121OutpatientInfo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB121OutpatientInfo::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB121OutpatientInfo::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB121OutpatientInfo::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB121OutpatientInfo::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB121OutpatientInfo::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(bo.getVisitTimes() != null, MmpNatdssB121OutpatientInfo::getVisitTimes, bo.getVisitTimes());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB121OutpatientInfo::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisSn()), MmpNatdssB121OutpatientInfo::getRegisSn, bo.getRegisSn());
        lqw.eq(bo.getRegisDatetime() != null, MmpNatdssB121OutpatientInfo::getRegisDatetime, bo.getRegisDatetime());
        lqw.eq(bo.getVisitDatetime() != null, MmpNatdssB121OutpatientInfo::getVisitDatetime, bo.getVisitDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getFirstVisitMark()), MmpNatdssB121OutpatientInfo::getFirstVisitMark, bo.getFirstVisitMark());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisMethodCode()), MmpNatdssB121OutpatientInfo::getRegisMethodCode, bo.getRegisMethodCode());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisMethod()), MmpNatdssB121OutpatientInfo::getRegisMethod, bo.getRegisMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisTypeCode()), MmpNatdssB121OutpatientInfo::getRegisTypeCode, bo.getRegisTypeCode());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisType()), MmpNatdssB121OutpatientInfo::getRegisType, bo.getRegisType());
        lqw.eq(bo.getRegisChargePrice() != null, MmpNatdssB121OutpatientInfo::getRegisChargePrice, bo.getRegisChargePrice());
        lqw.eq(bo.getRegisPaidPrice() != null, MmpNatdssB121OutpatientInfo::getRegisPaidPrice, bo.getRegisPaidPrice());
        lqw.eq(StringUtils.isNotBlank(bo.getRegisDeptCode()), MmpNatdssB121OutpatientInfo::getRegisDeptCode, bo.getRegisDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getRegisDeptName()), MmpNatdssB121OutpatientInfo::getRegisDeptName, bo.getRegisDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitDoctorNo()), MmpNatdssB121OutpatientInfo::getVisitDoctorNo, bo.getVisitDoctorNo());
        lqw.eq(StringUtils.isNotBlank(bo.getTechnicalTitle()), MmpNatdssB121OutpatientInfo::getTechnicalTitle, bo.getTechnicalTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getJobTitle()), MmpNatdssB121OutpatientInfo::getJobTitle, bo.getJobTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB121OutpatientInfo::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB121OutpatientInfo::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB121OutpatientInfo::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB121OutpatientInfo::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB121OutpatientInfo::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B12-1 门诊患者信息
     *
     * @param bo B12-1 门诊患者信息
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB121OutpatientInfoBo bo) {
        MmpNatdssB121OutpatientInfo add = MapstructUtils.convert(bo, MmpNatdssB121OutpatientInfo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B12-1 门诊患者信息
     *
     * @param bo B12-1 门诊患者信息
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB121OutpatientInfoBo bo) {
        MmpNatdssB121OutpatientInfo update = MapstructUtils.convert(bo, MmpNatdssB121OutpatientInfo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB121OutpatientInfo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B12-1 门诊患者信息信息
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
