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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorWorkExperienceBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorWorkExperienceVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorWorkExperience;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorWorkExperienceMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorWorkExperienceService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 工作经历Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorWorkExperienceServiceImpl implements IMmpDoctorWorkExperienceService {

    private final MmpDoctorWorkExperienceMapper baseMapper;

    /**
     * 查询工作经历
     *
     * @param id 主键
     * @return 工作经历
     */
    @Override
    public MmpDoctorWorkExperienceVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询工作经历列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 工作经历分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorWorkExperienceVo> queryPageList(MmpDoctorWorkExperienceBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorWorkExperience> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorWorkExperienceVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的工作经历列表
     *
     * @param bo 查询条件
     * @return 工作经历列表
     */
    @Override
    public List<MmpDoctorWorkExperienceVo> queryList(MmpDoctorWorkExperienceBo bo) {
        LambdaQueryWrapper<MmpDoctorWorkExperience> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorWorkExperience> buildQueryWrapper(MmpDoctorWorkExperienceBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorWorkExperience> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorWorkExperience::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorWorkExperience::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getOrganization()), MmpDoctorWorkExperience::getOrganization, bo.getOrganization());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpDoctorWorkExperience::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getPosition()), MmpDoctorWorkExperience::getPosition, bo.getPosition());
        lqw.eq(bo.getStartDate() != null, MmpDoctorWorkExperience::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpDoctorWorkExperience::getEndDate, bo.getEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getJobDescription()), MmpDoctorWorkExperience::getJobDescription, bo.getJobDescription());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorWorkExperience::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增工作经历
     *
     * @param bo 工作经历
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorWorkExperienceBo bo) {
        MmpDoctorWorkExperience add = MapstructUtils.convert(bo, MmpDoctorWorkExperience.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改工作经历
     *
     * @param bo 工作经历
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorWorkExperienceBo bo) {
        MmpDoctorWorkExperience update = MapstructUtils.convert(bo, MmpDoctorWorkExperience.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorWorkExperience entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除工作经历信息
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
