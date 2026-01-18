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
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamQuestionBo;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamQuestionVo;
import org.dromara.cdi.mmp.exam.domain.MmpExamQuestion;
import org.dromara.cdi.mmp.exam.mapper.MmpExamQuestionMapper;
import org.dromara.cdi.mmp.exam.service.IMmpExamQuestionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质考核题库Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpExamQuestionServiceImpl implements IMmpExamQuestionService {

    private final MmpExamQuestionMapper baseMapper;

    /**
     * 查询资质考核题库
     *
     * @param id 主键
     * @return 资质考核题库
     */
    @Override
    public MmpExamQuestionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质考核题库列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考核题库分页列表
     */
    @Override
    public TableDataInfo<MmpExamQuestionVo> queryPageList(MmpExamQuestionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpExamQuestion> lqw = buildQueryWrapper(bo);
        Page<MmpExamQuestionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质考核题库列表
     *
     * @param bo 查询条件
     * @return 资质考核题库列表
     */
    @Override
    public List<MmpExamQuestionVo> queryList(MmpExamQuestionBo bo) {
        LambdaQueryWrapper<MmpExamQuestion> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpExamQuestion> buildQueryWrapper(MmpExamQuestionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpExamQuestion> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpExamQuestion::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionCode()), MmpExamQuestion::getQuestionCode, bo.getQuestionCode());
        lqw.eq(bo.getQualificationId() != null, MmpExamQuestion::getQualificationId, bo.getQualificationId());
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionType()), MmpExamQuestion::getQuestionType, bo.getQuestionType());
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionContent()), MmpExamQuestion::getQuestionContent, bo.getQuestionContent());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionA()), MmpExamQuestion::getOptionA, bo.getOptionA());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionB()), MmpExamQuestion::getOptionB, bo.getOptionB());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionC()), MmpExamQuestion::getOptionC, bo.getOptionC());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionD()), MmpExamQuestion::getOptionD, bo.getOptionD());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionE()), MmpExamQuestion::getOptionE, bo.getOptionE());
        lqw.eq(StringUtils.isNotBlank(bo.getCorrectAnswer()), MmpExamQuestion::getCorrectAnswer, bo.getCorrectAnswer());
        lqw.eq(StringUtils.isNotBlank(bo.getAnswerAnalysis()), MmpExamQuestion::getAnswerAnalysis, bo.getAnswerAnalysis());
        lqw.eq(bo.getDifficultyLevel() != null, MmpExamQuestion::getDifficultyLevel, bo.getDifficultyLevel());
        lqw.eq(bo.getScore() != null, MmpExamQuestion::getScore, bo.getScore());
        lqw.eq(bo.getIsEnabled() != null, MmpExamQuestion::getIsEnabled, bo.getIsEnabled());
        return lqw;
    }

    /**
     * 新增资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpExamQuestionBo bo) {
        MmpExamQuestion add = MapstructUtils.convert(bo, MmpExamQuestion.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpExamQuestionBo bo) {
        MmpExamQuestion update = MapstructUtils.convert(bo, MmpExamQuestion.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpExamQuestion entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质考核题库信息
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
