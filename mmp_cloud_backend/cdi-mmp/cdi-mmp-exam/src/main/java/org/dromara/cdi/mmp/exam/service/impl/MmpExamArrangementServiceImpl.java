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
import org.dromara.cdi.mmp.exam.domain.bo.MmpQualificationExamArrangementBo;
import org.dromara.cdi.mmp.exam.domain.vo.MmpQualificationExamArrangementVo;
import org.dromara.cdi.mmp.exam.domain.MmpQualificationExamArrangement;
import org.dromara.cdi.mmp.exam.mapper.MmpQualificationExamArrangementMapper;
import org.dromara.cdi.mmp.exam.service.IMmpQualificationExamArrangementService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质考试安排Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationExamArrangementServiceImpl implements IMmpQualificationExamArrangementService {

    private final MmpQualificationExamArrangementMapper baseMapper;

    /**
     * 查询资质考试安排
     *
     * @param id 主键
     * @return 资质考试安排
     */
    @Override
    public MmpQualificationExamArrangementVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质考试安排列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质考试安排分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationExamArrangementVo> queryPageList(MmpQualificationExamArrangementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationExamArrangement> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationExamArrangementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质考试安排列表
     *
     * @param bo 查询条件
     * @return 资质考试安排列表
     */
    @Override
    public List<MmpQualificationExamArrangementVo> queryList(MmpQualificationExamArrangementBo bo) {
        LambdaQueryWrapper<MmpQualificationExamArrangement> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationExamArrangement> buildQueryWrapper(MmpQualificationExamArrangementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationExamArrangement> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationExamArrangement::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getExamCode()), MmpQualificationExamArrangement::getExamCode, bo.getExamCode());
        lqw.like(StringUtils.isNotBlank(bo.getExamName()), MmpQualificationExamArrangement::getExamName, bo.getExamName());
        lqw.eq(bo.getPaperId() != null, MmpQualificationExamArrangement::getPaperId, bo.getPaperId());
        lqw.eq(bo.getQualificationId() != null, MmpQualificationExamArrangement::getQualificationId, bo.getQualificationId());
        lqw.eq(bo.getExamStartTime() != null, MmpQualificationExamArrangement::getExamStartTime, bo.getExamStartTime());
        lqw.eq(bo.getExamEndTime() != null, MmpQualificationExamArrangement::getExamEndTime, bo.getExamEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getExamineeIds()), MmpQualificationExamArrangement::getExamineeIds, bo.getExamineeIds());
        lqw.eq(StringUtils.isNotBlank(bo.getExamStatus()), MmpQualificationExamArrangement::getExamStatus, bo.getExamStatus());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationExamArrangement::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationExamArrangementBo bo) {
        MmpQualificationExamArrangement add = MapstructUtils.convert(bo, MmpQualificationExamArrangement.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationExamArrangementBo bo) {
        MmpQualificationExamArrangement update = MapstructUtils.convert(bo, MmpQualificationExamArrangement.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationExamArrangement entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质考试安排信息
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
