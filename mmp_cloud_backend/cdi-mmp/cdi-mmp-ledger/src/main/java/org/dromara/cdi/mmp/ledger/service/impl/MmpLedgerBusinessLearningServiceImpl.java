package org.dromara.cdi.mmp.ledger.service.impl;

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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpLedgerBusinessLearningBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpLedgerBusinessLearningVo;
import org.dromara.cdi.mmp.ledger.domain.MmpLedgerBusinessLearning;
import org.dromara.cdi.mmp.ledger.mapper.MmpLedgerBusinessLearningMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpLedgerBusinessLearningService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 业务学习记录本Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpLedgerBusinessLearningServiceImpl implements IMmpLedgerBusinessLearningService {

    private final MmpLedgerBusinessLearningMapper baseMapper;

    /**
     * 查询业务学习记录本
     *
     * @param id 主键
     * @return 业务学习记录本
     */
    @Override
    public MmpLedgerBusinessLearningVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询业务学习记录本列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 业务学习记录本分页列表
     */
    @Override
    public TableDataInfo<MmpLedgerBusinessLearningVo> queryPageList(MmpLedgerBusinessLearningBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpLedgerBusinessLearning> lqw = buildQueryWrapper(bo);
        Page<MmpLedgerBusinessLearningVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的业务学习记录本列表
     *
     * @param bo 查询条件
     * @return 业务学习记录本列表
     */
    @Override
    public List<MmpLedgerBusinessLearningVo> queryList(MmpLedgerBusinessLearningBo bo) {
        LambdaQueryWrapper<MmpLedgerBusinessLearning> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpLedgerBusinessLearning> buildQueryWrapper(MmpLedgerBusinessLearningBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpLedgerBusinessLearning> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpLedgerBusinessLearning::getId);
        lqw.eq(bo.getLearningDate() != null, MmpLedgerBusinessLearning::getLearningDate, bo.getLearningDate());
        lqw.eq(StringUtils.isNotBlank(bo.getLearningTopic()), MmpLedgerBusinessLearning::getLearningTopic, bo.getLearningTopic());
        lqw.eq(StringUtils.isNotBlank(bo.getLearningType()), MmpLedgerBusinessLearning::getLearningType, bo.getLearningType());
        lqw.eq(StringUtils.isNotBlank(bo.getOrganizer()), MmpLedgerBusinessLearning::getOrganizer, bo.getOrganizer());
        lqw.eq(StringUtils.isNotBlank(bo.getParticipants()), MmpLedgerBusinessLearning::getParticipants, bo.getParticipants());
        lqw.eq(StringUtils.isNotBlank(bo.getLearningContent()), MmpLedgerBusinessLearning::getLearningContent, bo.getLearningContent());
        lqw.eq(bo.getLearningHours() != null, MmpLedgerBusinessLearning::getLearningHours, bo.getLearningHours());
        lqw.eq(StringUtils.isNotBlank(bo.getInstructor()), MmpLedgerBusinessLearning::getInstructor, bo.getInstructor());
        lqw.eq(StringUtils.isNotBlank(bo.getEvaluationResults()), MmpLedgerBusinessLearning::getEvaluationResults, bo.getEvaluationResults());
        lqw.eq(StringUtils.isNotBlank(bo.getAttachments()), MmpLedgerBusinessLearning::getAttachments, bo.getAttachments());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpLedgerBusinessLearning::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增业务学习记录本
     *
     * @param bo 业务学习记录本
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpLedgerBusinessLearningBo bo) {
        MmpLedgerBusinessLearning add = MapstructUtils.convert(bo, MmpLedgerBusinessLearning.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改业务学习记录本
     *
     * @param bo 业务学习记录本
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpLedgerBusinessLearningBo bo) {
        MmpLedgerBusinessLearning update = MapstructUtils.convert(bo, MmpLedgerBusinessLearning.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpLedgerBusinessLearning entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除业务学习记录本信息
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
