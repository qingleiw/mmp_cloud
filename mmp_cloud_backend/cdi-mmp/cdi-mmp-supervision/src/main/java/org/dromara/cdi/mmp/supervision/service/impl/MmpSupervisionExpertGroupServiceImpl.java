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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionExpertGroupBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionExpertGroupVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionExpertGroup;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionExpertGroupMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionExpertGroupService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 专家组Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionExpertGroupServiceImpl implements IMmpSupervisionExpertGroupService {

    private final MmpSupervisionExpertGroupMapper baseMapper;

    /**
     * 查询专家组
     *
     * @param id 主键
     * @return 专家组
     */
    @Override
    public MmpSupervisionExpertGroupVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询专家组列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 专家组分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionExpertGroupVo> queryPageList(MmpSupervisionExpertGroupBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionExpertGroup> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionExpertGroupVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的专家组列表
     *
     * @param bo 查询条件
     * @return 专家组列表
     */
    @Override
    public List<MmpSupervisionExpertGroupVo> queryList(MmpSupervisionExpertGroupBo bo) {
        LambdaQueryWrapper<MmpSupervisionExpertGroup> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionExpertGroup> buildQueryWrapper(MmpSupervisionExpertGroupBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionExpertGroup> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionExpertGroup::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getGroupCode()), MmpSupervisionExpertGroup::getGroupCode, bo.getGroupCode());
        lqw.like(StringUtils.isNotBlank(bo.getGroupName()), MmpSupervisionExpertGroup::getGroupName, bo.getGroupName());
        lqw.eq(StringUtils.isNotBlank(bo.getGroupType()), MmpSupervisionExpertGroup::getGroupType, bo.getGroupType());
        lqw.eq(StringUtils.isNotBlank(bo.getSpecialty()), MmpSupervisionExpertGroup::getSpecialty, bo.getSpecialty());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpSupervisionExpertGroup::getDescription, bo.getDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionExpertGroup::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增专家组
     *
     * @param bo 专家组
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionExpertGroupBo bo) {
        MmpSupervisionExpertGroup add = MapstructUtils.convert(bo, MmpSupervisionExpertGroup.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改专家组
     *
     * @param bo 专家组
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionExpertGroupBo bo) {
        MmpSupervisionExpertGroup update = MapstructUtils.convert(bo, MmpSupervisionExpertGroup.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionExpertGroup entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除专家组信息
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
