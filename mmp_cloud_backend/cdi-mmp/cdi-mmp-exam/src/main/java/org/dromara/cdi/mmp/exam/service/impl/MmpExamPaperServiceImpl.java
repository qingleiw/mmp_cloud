package org.dromara.cdi.mmp.exam.service.impl;

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
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamPaperBo;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamPaperVo;
import org.dromara.cdi.mmp.exam.domain.MmpExamPaper;
import org.dromara.cdi.mmp.exam.mapper.MmpExamPaperMapper;
import org.dromara.cdi.mmp.exam.service.IMmpExamPaperService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质考核试卷Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpExamPaperServiceImpl implements IMmpExamPaperService {

    private final MmpExamPaperMapper baseMapper;

    /**
     * 查询资质考核试卷
     *
     * @param id 主键
     * @return 资质考核试卷
     */
    @Override
    public MmpExamPaperVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质考核试卷列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考核试卷分页列表
     */
    @Override
    public TableDataInfo<MmpExamPaperVo> queryPageList(MmpExamPaperBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpExamPaper> lqw = buildQueryWrapper(bo);
        Page<MmpExamPaperVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质考核试卷列表
     *
     * @param bo 查询条件
     * @return 资质考核试卷列表
     */
    @Override
    public List<MmpExamPaperVo> queryList(MmpExamPaperBo bo) {
        LambdaQueryWrapper<MmpExamPaper> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpExamPaper> buildQueryWrapper(MmpExamPaperBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpExamPaper> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpExamPaper::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPaperCode()), MmpExamPaper::getPaperCode, bo.getPaperCode());
        lqw.like(StringUtils.isNotBlank(bo.getPaperName()), MmpExamPaper::getPaperName, bo.getPaperName());
        lqw.eq(bo.getQualificationId() != null, MmpExamPaper::getQualificationId, bo.getQualificationId());
        lqw.eq(bo.getTotalScore() != null, MmpExamPaper::getTotalScore, bo.getTotalScore());
        lqw.eq(bo.getPassScore() != null, MmpExamPaper::getPassScore, bo.getPassScore());
        lqw.eq(bo.getExamDuration() != null, MmpExamPaper::getExamDuration, bo.getExamDuration());
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionIds()), MmpExamPaper::getQuestionIds, bo.getQuestionIds());
        lqw.eq(bo.getIsRandom() != null, MmpExamPaper::getIsRandom, bo.getIsRandom());
        lqw.eq(StringUtils.isNotBlank(bo.getRandomRule()), MmpExamPaper::getRandomRule, bo.getRandomRule());
        lqw.eq(bo.getIsEnabled() != null, MmpExamPaper::getIsEnabled, bo.getIsEnabled());
        return lqw;
    }

    /**
     * 新增资质考核试卷
     *
     * @param bo 资质考核试卷
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpExamPaperBo bo) {
        MmpExamPaper add = MapstructUtils.convert(bo, MmpExamPaper.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质考核试卷
     *
     * @param bo 资质考核试卷
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpExamPaperBo bo) {
        MmpExamPaper update = MapstructUtils.convert(bo, MmpExamPaper.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpExamPaper entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质考核试卷信息
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
