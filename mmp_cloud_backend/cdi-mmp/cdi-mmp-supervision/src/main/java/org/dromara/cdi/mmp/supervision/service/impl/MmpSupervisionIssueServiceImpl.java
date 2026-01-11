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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionIssueBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionIssueVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionIssue;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionIssueMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionIssueService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督导问题Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionIssueServiceImpl implements IMmpSupervisionIssueService {

    private final MmpSupervisionIssueMapper baseMapper;

    /**
     * 查询督导问题
     *
     * @param id 主键
     * @return 督导问题
     */
    @Override
    public MmpSupervisionIssueVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督导问题列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督导问题分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionIssueVo> queryPageList(MmpSupervisionIssueBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionIssue> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionIssueVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督导问题列表
     *
     * @param bo 查询条件
     * @return 督导问题列表
     */
    @Override
    public List<MmpSupervisionIssueVo> queryList(MmpSupervisionIssueBo bo) {
        LambdaQueryWrapper<MmpSupervisionIssue> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionIssue> buildQueryWrapper(MmpSupervisionIssueBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionIssue> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionIssue::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getIssueType()), MmpSupervisionIssue::getIssueType, bo.getIssueType());
        lqw.eq(StringUtils.isNotBlank(bo.getIssueDescription()), MmpSupervisionIssue::getIssueDescription, bo.getIssueDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getSeverity()), MmpSupervisionIssue::getSeverity, bo.getSeverity());
        lqw.eq(StringUtils.isNotBlank(bo.getResponsiblePerson()), MmpSupervisionIssue::getResponsiblePerson, bo.getResponsiblePerson());
        lqw.eq(bo.getRectificationDeadline() != null, MmpSupervisionIssue::getRectificationDeadline, bo.getRectificationDeadline());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionIssue::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督导问题
     *
     * @param bo 督导问题
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionIssueBo bo) {
        MmpSupervisionIssue add = MapstructUtils.convert(bo, MmpSupervisionIssue.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督导问题
     *
     * @param bo 督导问题
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionIssueBo bo) {
        MmpSupervisionIssue update = MapstructUtils.convert(bo, MmpSupervisionIssue.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionIssue entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督导问题信息
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
