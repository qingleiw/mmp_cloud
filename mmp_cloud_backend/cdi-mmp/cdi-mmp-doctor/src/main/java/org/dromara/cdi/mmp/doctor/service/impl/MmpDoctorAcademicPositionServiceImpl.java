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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorAcademicPositionBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorAcademicPositionVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorAcademicPosition;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorAcademicPositionMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorAcademicPositionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 学术任职Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorAcademicPositionServiceImpl implements IMmpDoctorAcademicPositionService {

    private final MmpDoctorAcademicPositionMapper baseMapper;

    /**
     * 查询学术任职
     *
     * @param id 主键
     * @return 学术任职
     */
    @Override
    public MmpDoctorAcademicPositionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询学术任职列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 学术任职分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorAcademicPositionVo> queryPageList(MmpDoctorAcademicPositionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorAcademicPosition> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorAcademicPositionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的学术任职列表
     *
     * @param bo 查询条件
     * @return 学术任职列表
     */
    @Override
    public List<MmpDoctorAcademicPositionVo> queryList(MmpDoctorAcademicPositionBo bo) {
        LambdaQueryWrapper<MmpDoctorAcademicPosition> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorAcademicPosition> buildQueryWrapper(MmpDoctorAcademicPositionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorAcademicPosition> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorAcademicPosition::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorAcademicPosition::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getOrganization()), MmpDoctorAcademicPosition::getOrganization, bo.getOrganization());
        lqw.eq(StringUtils.isNotBlank(bo.getPosition()), MmpDoctorAcademicPosition::getPosition, bo.getPosition());
        lqw.eq(StringUtils.isNotBlank(bo.getPositionLevel()), MmpDoctorAcademicPosition::getPositionLevel, bo.getPositionLevel());
        lqw.eq(bo.getStartDate() != null, MmpDoctorAcademicPosition::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpDoctorAcademicPosition::getEndDate, bo.getEndDate());
        lqw.eq(bo.getIsCurrent() != null, MmpDoctorAcademicPosition::getIsCurrent, bo.getIsCurrent());
        lqw.eq(StringUtils.isNotBlank(bo.getAppointmentUrl()), MmpDoctorAcademicPosition::getAppointmentUrl, bo.getAppointmentUrl());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorAcademicPosition::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增学术任职
     *
     * @param bo 学术任职
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorAcademicPositionBo bo) {
        MmpDoctorAcademicPosition add = MapstructUtils.convert(bo, MmpDoctorAcademicPosition.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改学术任职
     *
     * @param bo 学术任职
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorAcademicPositionBo bo) {
        MmpDoctorAcademicPosition update = MapstructUtils.convert(bo, MmpDoctorAcademicPosition.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorAcademicPosition entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除学术任职信息
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
