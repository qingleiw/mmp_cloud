package org.dromara.cdi.mmp.doctor.service.impl;

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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorEducationBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorEducationVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorEducation;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorEducationMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorEducationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 教育经历Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorEducationServiceImpl implements IMmpDoctorEducationService {

    private final MmpDoctorEducationMapper baseMapper;

    /**
     * 查询教育经历
     *
     * @param id 主键
     * @return 教育经历
     */
    @Override
    public MmpDoctorEducationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询教育经历列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 教育经历分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorEducationVo> queryPageList(MmpDoctorEducationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorEducation> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorEducationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的教育经历列表
     *
     * @param bo 查询条件
     * @return 教育经历列表
     */
    @Override
    public List<MmpDoctorEducationVo> queryList(MmpDoctorEducationBo bo) {
        LambdaQueryWrapper<MmpDoctorEducation> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorEducation> buildQueryWrapper(MmpDoctorEducationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorEducation> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorEducation::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorEducation::getDoctorId, bo.getDoctorId());
        lqw.like(StringUtils.isNotBlank(bo.getSchoolName()), MmpDoctorEducation::getSchoolName, bo.getSchoolName());
        lqw.eq(StringUtils.isNotBlank(bo.getMajor()), MmpDoctorEducation::getMajor, bo.getMajor());
        lqw.eq(StringUtils.isNotBlank(bo.getEducationLevel()), MmpDoctorEducation::getEducationLevel, bo.getEducationLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getDegree()), MmpDoctorEducation::getDegree, bo.getDegree());
        lqw.eq(bo.getStartDate() != null, MmpDoctorEducation::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpDoctorEducation::getEndDate, bo.getEndDate());
        lqw.eq(bo.getIsFullTime() != null, MmpDoctorEducation::getIsFullTime, bo.getIsFullTime());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNo()), MmpDoctorEducation::getCertificateNo, bo.getCertificateNo());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateUrl()), MmpDoctorEducation::getCertificateUrl, bo.getCertificateUrl());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorEducation::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增教育经历
     *
     * @param bo 教育经历
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorEducationBo bo) {
        MmpDoctorEducation add = MapstructUtils.convert(bo, MmpDoctorEducation.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改教育经历
     *
     * @param bo 教育经历
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorEducationBo bo) {
        MmpDoctorEducation update = MapstructUtils.convert(bo, MmpDoctorEducation.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorEducation entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除教育经历信息
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
