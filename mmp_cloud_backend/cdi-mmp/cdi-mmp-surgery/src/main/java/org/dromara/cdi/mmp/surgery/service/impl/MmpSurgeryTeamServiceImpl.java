package org.dromara.cdi.mmp.surgery.service.impl;

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
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryTeamBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryTeamVo;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryTeam;
import org.dromara.cdi.mmp.surgery.mapper.MmpSurgeryTeamMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryTeamService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 手术团队Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryTeamServiceImpl implements IMmpSurgeryTeamService {

    private final MmpSurgeryTeamMapper baseMapper;

    /**
     * 查询手术团队
     *
     * @param id 主键
     * @return 手术团队
     */
    @Override
    public MmpSurgeryTeamVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询手术团队列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术团队分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryTeamVo> queryPageList(MmpSurgeryTeamBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryTeam> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryTeamVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的手术团队列表
     *
     * @param bo 查询条件
     * @return 手术团队列表
     */
    @Override
    public List<MmpSurgeryTeamVo> queryList(MmpSurgeryTeamBo bo) {
        LambdaQueryWrapper<MmpSurgeryTeam> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryTeam> buildQueryWrapper(MmpSurgeryTeamBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryTeam> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryTeam::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpSurgeryTeam::getDoctorName, bo.getDoctorName());
        lqw.eq(StringUtils.isNotBlank(bo.getRoleType()), MmpSurgeryTeam::getRoleType, bo.getRoleType());
        lqw.eq(bo.getQualificationVerify() != null, MmpSurgeryTeam::getQualificationVerify, bo.getQualificationVerify());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpSurgeryTeam::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增手术团队
     *
     * @param bo 手术团队
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryTeamBo bo) {
        MmpSurgeryTeam add = MapstructUtils.convert(bo, MmpSurgeryTeam.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改手术团队
     *
     * @param bo 手术团队
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryTeamBo bo) {
        MmpSurgeryTeam update = MapstructUtils.convert(bo, MmpSurgeryTeam.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryTeam entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除手术团队信息
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
