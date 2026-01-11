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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionReviewBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionReviewVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionReview;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionReviewMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionReviewService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 整改复查Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionReviewServiceImpl implements IMmpSupervisionReviewService {

    private final MmpSupervisionReviewMapper baseMapper;

    /**
     * 查询整改复查
     *
     * @param id 主键
     * @return 整改复查
     */
    @Override
    public MmpSupervisionReviewVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询整改复查列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 整改复查分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionReviewVo> queryPageList(MmpSupervisionReviewBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionReview> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionReviewVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的整改复查列表
     *
     * @param bo 查询条件
     * @return 整改复查列表
     */
    @Override
    public List<MmpSupervisionReviewVo> queryList(MmpSupervisionReviewBo bo) {
        LambdaQueryWrapper<MmpSupervisionReview> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionReview> buildQueryWrapper(MmpSupervisionReviewBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionReview> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionReview::getId);
        lqw.eq(bo.getReviewDate() != null, MmpSupervisionReview::getReviewDate, bo.getReviewDate());
        lqw.eq(StringUtils.isNotBlank(bo.getReviewer()), MmpSupervisionReview::getReviewer, bo.getReviewer());
        lqw.eq(StringUtils.isNotBlank(bo.getReviewResult()), MmpSupervisionReview::getReviewResult, bo.getReviewResult());
        lqw.eq(StringUtils.isNotBlank(bo.getReviewOpinion()), MmpSupervisionReview::getReviewOpinion, bo.getReviewOpinion());
        lqw.eq(bo.getNextReviewDate() != null, MmpSupervisionReview::getNextReviewDate, bo.getNextReviewDate());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionReview::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增整改复查
     *
     * @param bo 整改复查
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionReviewBo bo) {
        MmpSupervisionReview add = MapstructUtils.convert(bo, MmpSupervisionReview.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改整改复查
     *
     * @param bo 整改复查
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionReviewBo bo) {
        MmpSupervisionReview update = MapstructUtils.convert(bo, MmpSupervisionReview.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionReview entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除整改复查信息
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
