package org.dromara.cdi.mmp.supervision.service.impl;

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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionExpertMemberBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionExpertMemberVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionExpertMember;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionExpertMemberMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionExpertMemberService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 专家组成员Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionExpertMemberServiceImpl implements IMmpSupervisionExpertMemberService {

    private final MmpSupervisionExpertMemberMapper baseMapper;

    /**
     * 查询专家组成员
     *
     * @param id 主键
     * @return 专家组成员
     */
    @Override
    public MmpSupervisionExpertMemberVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询专家组成员列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 专家组成员分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionExpertMemberVo> queryPageList(MmpSupervisionExpertMemberBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionExpertMember> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionExpertMemberVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的专家组成员列表
     *
     * @param bo 查询条件
     * @return 专家组成员列表
     */
    @Override
    public List<MmpSupervisionExpertMemberVo> queryList(MmpSupervisionExpertMemberBo bo) {
        LambdaQueryWrapper<MmpSupervisionExpertMember> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionExpertMember> buildQueryWrapper(MmpSupervisionExpertMemberBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionExpertMember> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionExpertMember::getId);
        lqw.like(StringUtils.isNotBlank(bo.getExpertName()), MmpSupervisionExpertMember::getExpertName, bo.getExpertName());
        lqw.eq(StringUtils.isNotBlank(bo.getExpertTitle()), MmpSupervisionExpertMember::getExpertTitle, bo.getExpertTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getHospital()), MmpSupervisionExpertMember::getHospital, bo.getHospital());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialty()), MmpSupervisionExpertMember::getSpecialty, bo.getSpecialty());
        lqw.eq(StringUtils.isNotBlank(bo.getContactInfo()), MmpSupervisionExpertMember::getContactInfo, bo.getContactInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionExpertMember::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增专家组成员
     *
     * @param bo 专家组成员
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionExpertMemberBo bo) {
        MmpSupervisionExpertMember add = MapstructUtils.convert(bo, MmpSupervisionExpertMember.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改专家组成员
     *
     * @param bo 专家组成员
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionExpertMemberBo bo) {
        MmpSupervisionExpertMember update = MapstructUtils.convert(bo, MmpSupervisionExpertMember.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionExpertMember entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除专家组成员信息
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
