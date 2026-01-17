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
import org.dromara.cdi.mmp.exam.domain.bo.MmpQualificationExamQuestionBo;
import org.dromara.cdi.mmp.exam.domain.vo.MmpQualificationExamQuestionVo;
import org.dromara.cdi.mmp.exam.domain.MmpQualificationExamQuestion;
import org.dromara.cdi.mmp.exam.mapper.MmpQualificationExamQuestionMapper;
import org.dromara.cdi.mmp.exam.service.IMmpQualificationExamQuestionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质考核题库Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationExamQuestionServiceImpl implements IMmpQualificationExamQuestionService {

    private final MmpQualificationExamQuestionMapper baseMapper;

    /**
     * 查询资质考核题库
     *
     * @param id 主键
     * @return 资质考核题库
     */
    @Override
    public MmpQualificationExamQuestionVo queryById(Long id){
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
    public TableDataInfo<MmpQualificationExamQuestionVo> queryPageList(MmpQualificationExamQuestionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationExamQuestion> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationExamQuestionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质考核题库列表
     *
     * @param bo 查询条件
     * @return 资质考核题库列表
     */
    @Override
    public List<MmpQualificationExamQuestionVo> queryList(MmpQualificationExamQuestionBo bo) {
        LambdaQueryWrapper<MmpQualificationExamQuestion> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationExamQuestion> buildQueryWrapper(MmpQualificationExamQuestionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationExamQuestion> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationExamQuestion::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionCode()), MmpQualificationExamQuestion::getQuestionCode, bo.getQuestionCode());
        lqw.eq(bo.getQualificationId() != null, MmpQualificationExamQuestion::getQualificationId, bo.getQualificationId());
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionType()), MmpQualificationExamQuestion::getQuestionType, bo.getQuestionType());
        lqw.eq(StringUtils.isNotBlank(bo.getQuestionContent()), MmpQualificationExamQuestion::getQuestionContent, bo.getQuestionContent());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionA()), MmpQualificationExamQuestion::getOptionA, bo.getOptionA());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionB()), MmpQualificationExamQuestion::getOptionB, bo.getOptionB());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionC()), MmpQualificationExamQuestion::getOptionC, bo.getOptionC());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionD()), MmpQualificationExamQuestion::getOptionD, bo.getOptionD());
        lqw.eq(StringUtils.isNotBlank(bo.getOptionE()), MmpQualificationExamQuestion::getOptionE, bo.getOptionE());
        lqw.eq(StringUtils.isNotBlank(bo.getCorrectAnswer()), MmpQualificationExamQuestion::getCorrectAnswer, bo.getCorrectAnswer());
        lqw.eq(StringUtils.isNotBlank(bo.getAnswerAnalysis()), MmpQualificationExamQuestion::getAnswerAnalysis, bo.getAnswerAnalysis());
        lqw.eq(bo.getDifficultyLevel() != null, MmpQualificationExamQuestion::getDifficultyLevel, bo.getDifficultyLevel());
        lqw.eq(bo.getScore() != null, MmpQualificationExamQuestion::getScore, bo.getScore());
        lqw.eq(bo.getIsEnabled() != null, MmpQualificationExamQuestion::getIsEnabled, bo.getIsEnabled());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationExamQuestion::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质考核题库
     *
     * @param bo 资质考核题库
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationExamQuestionBo bo) {
        MmpQualificationExamQuestion add = MapstructUtils.convert(bo, MmpQualificationExamQuestion.class);
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
    public Boolean updateByBo(MmpQualificationExamQuestionBo bo) {
        MmpQualificationExamQuestion update = MapstructUtils.convert(bo, MmpQualificationExamQuestion.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationExamQuestion entity){
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
