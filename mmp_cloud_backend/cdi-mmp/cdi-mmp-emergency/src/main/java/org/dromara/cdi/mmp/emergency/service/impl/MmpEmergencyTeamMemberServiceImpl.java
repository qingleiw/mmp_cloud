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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyTeamMemberBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyTeamMemberVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyTeamMember;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyTeamMemberMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyTeamMemberService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 应急队伍成员Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyTeamMemberServiceImpl implements IMmpEmergencyTeamMemberService {

    private final MmpEmergencyTeamMemberMapper baseMapper;

    /**
     * 查询应急队伍成员
     *
     * @param id 主键
     * @return 应急队伍成员
     */
    @Override
    public MmpEmergencyTeamMemberVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询应急队伍成员列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 应急队伍成员分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyTeamMemberVo> queryPageList(MmpEmergencyTeamMemberBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyTeamMember> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyTeamMemberVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的应急队伍成员列表
     *
     * @param bo 查询条件
     * @return 应急队伍成员列表
     */
    @Override
    public List<MmpEmergencyTeamMemberVo> queryList(MmpEmergencyTeamMemberBo bo) {
        LambdaQueryWrapper<MmpEmergencyTeamMember> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyTeamMember> buildQueryWrapper(MmpEmergencyTeamMemberBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyTeamMember> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyTeamMember::getId);
        lqw.like(StringUtils.isNotBlank(bo.getMemberName()), MmpEmergencyTeamMember::getMemberName, bo.getMemberName());
        lqw.eq(StringUtils.isNotBlank(bo.getMemberType()), MmpEmergencyTeamMember::getMemberType, bo.getMemberType());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpEmergencyTeamMember::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getPosition()), MmpEmergencyTeamMember::getPosition, bo.getPosition());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialty()), MmpEmergencyTeamMember::getSpecialty, bo.getSpecialty());
        lqw.eq(StringUtils.isNotBlank(bo.getContactInfo()), MmpEmergencyTeamMember::getContactInfo, bo.getContactInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getEmergencyContact()), MmpEmergencyTeamMember::getEmergencyContact, bo.getEmergencyContact());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyTeamMember::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增应急队伍成员
     *
     * @param bo 应急队伍成员
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyTeamMemberBo bo) {
        MmpEmergencyTeamMember add = MapstructUtils.convert(bo, MmpEmergencyTeamMember.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改应急队伍成员
     *
     * @param bo 应急队伍成员
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyTeamMemberBo bo) {
        MmpEmergencyTeamMember update = MapstructUtils.convert(bo, MmpEmergencyTeamMember.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyTeamMember entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除应急队伍成员信息
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
