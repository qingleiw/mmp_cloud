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
import org.dromara.cdi.mmp.exam.domain.bo.MmpExamArrangementBo;
import org.dromara.cdi.mmp.exam.domain.vo.MmpExamArrangementVo;
import org.dromara.cdi.mmp.exam.domain.MmpExamArrangement;
import org.dromara.cdi.mmp.exam.mapper.MmpExamArrangementMapper;
import org.dromara.cdi.mmp.exam.service.IMmpExamArrangementService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质考试安排Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpExamArrangementServiceImpl implements IMmpExamArrangementService {

    private final MmpExamArrangementMapper baseMapper;

    /**
     * 查询资质考试安排
     *
     * @param id 主键
     * @return 资质考试安排
     */
    @Override
    public MmpExamArrangementVo queryById(Long id){
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
    public TableDataInfo<MmpExamArrangementVo> queryPageList(MmpExamArrangementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpExamArrangement> lqw = buildQueryWrapper(bo);
        Page<MmpExamArrangementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质考试安排列表
     *
     * @param bo 查询条件
     * @return 资质考试安排列表
     */
    @Override
    public List<MmpExamArrangementVo> queryList(MmpExamArrangementBo bo) {
        LambdaQueryWrapper<MmpExamArrangement> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpExamArrangement> buildQueryWrapper(MmpExamArrangementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpExamArrangement> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpExamArrangement::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getExamCode()), MmpExamArrangement::getExamCode, bo.getExamCode());
        lqw.like(StringUtils.isNotBlank(bo.getExamName()), MmpExamArrangement::getExamName, bo.getExamName());
        lqw.eq(bo.getPaperId() != null, MmpExamArrangement::getPaperId, bo.getPaperId());
        lqw.eq(bo.getQualificationId() != null, MmpExamArrangement::getQualificationId, bo.getQualificationId());
        lqw.eq(bo.getExamStartTime() != null, MmpExamArrangement::getExamStartTime, bo.getExamStartTime());
        lqw.eq(bo.getExamEndTime() != null, MmpExamArrangement::getExamEndTime, bo.getExamEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getExamineeIds()), MmpExamArrangement::getExamineeIds, bo.getExamineeIds());
        lqw.eq(StringUtils.isNotBlank(bo.getExamStatus()), MmpExamArrangement::getExamStatus, bo.getExamStatus());
        return lqw;
    }

    /**
     * 新增资质考试安排
     *
     * @param bo 资质考试安排
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpExamArrangementBo bo) {
        MmpExamArrangement add = MapstructUtils.convert(bo, MmpExamArrangement.class);
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
    public Boolean updateByBo(MmpExamArrangementBo bo) {
        MmpExamArrangement update = MapstructUtils.convert(bo, MmpExamArrangement.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpExamArrangement entity){
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
