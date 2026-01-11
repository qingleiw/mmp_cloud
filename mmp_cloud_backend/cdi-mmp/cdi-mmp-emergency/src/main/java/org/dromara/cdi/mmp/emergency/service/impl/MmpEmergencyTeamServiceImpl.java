package org.dromara.cdi.mmp.emergency.service.impl;

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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyTeamBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyTeamVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyTeam;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyTeamMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyTeamService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 应急队伍Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyTeamServiceImpl implements IMmpEmergencyTeamService {

    private final MmpEmergencyTeamMapper baseMapper;

    /**
     * 查询应急队伍
     *
     * @param id 主键
     * @return 应急队伍
     */
    @Override
    public MmpEmergencyTeamVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询应急队伍列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急队伍分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyTeamVo> queryPageList(MmpEmergencyTeamBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyTeam> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyTeamVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的应急队伍列表
     *
     * @param bo 查询条件
     * @return 应急队伍列表
     */
    @Override
    public List<MmpEmergencyTeamVo> queryList(MmpEmergencyTeamBo bo) {
        LambdaQueryWrapper<MmpEmergencyTeam> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyTeam> buildQueryWrapper(MmpEmergencyTeamBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyTeam> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyTeam::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getTeamCode()), MmpEmergencyTeam::getTeamCode, bo.getTeamCode());
        lqw.like(StringUtils.isNotBlank(bo.getTeamName()), MmpEmergencyTeam::getTeamName, bo.getTeamName());
        lqw.eq(StringUtils.isNotBlank(bo.getTeamType()), MmpEmergencyTeam::getTeamType, bo.getTeamType());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialty()), MmpEmergencyTeam::getSpecialty, bo.getSpecialty());
        lqw.eq(StringUtils.isNotBlank(bo.getLeader()), MmpEmergencyTeam::getLeader, bo.getLeader());
        lqw.eq(StringUtils.isNotBlank(bo.getContactInfo()), MmpEmergencyTeam::getContactInfo, bo.getContactInfo());
        lqw.eq(bo.getMemberCount() != null, MmpEmergencyTeam::getMemberCount, bo.getMemberCount());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyTeam::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增应急队伍
     *
     * @param bo 应急队伍
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyTeamBo bo) {
        MmpEmergencyTeam add = MapstructUtils.convert(bo, MmpEmergencyTeam.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改应急队伍
     *
     * @param bo 应急队伍
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyTeamBo bo) {
        MmpEmergencyTeam update = MapstructUtils.convert(bo, MmpEmergencyTeam.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyTeam entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除应急队伍信息
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
