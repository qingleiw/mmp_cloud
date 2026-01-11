package org.dromara.cdi.mmp.qc.service.impl;

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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcIndicatorFactorBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcIndicatorFactorVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcIndicatorFactor;
import org.dromara.cdi.mmp.qc.mapper.MmpQcIndicatorFactorMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcIndicatorFactorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 指标计算因子Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcIndicatorFactorServiceImpl implements IMmpQcIndicatorFactorService {

    private final MmpQcIndicatorFactorMapper baseMapper;

    /**
     * 查询指标计算因子
     *
     * @param id 主键
     * @return 指标计算因子
     */
    @Override
    public MmpQcIndicatorFactorVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询指标计算因子列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 指标计算因子分页列表
     */
    @Override
    public TableDataInfo<MmpQcIndicatorFactorVo> queryPageList(MmpQcIndicatorFactorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcIndicatorFactor> lqw = buildQueryWrapper(bo);
        Page<MmpQcIndicatorFactorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的指标计算因子列表
     *
     * @param bo 查询条件
     * @return 指标计算因子列表
     */
    @Override
    public List<MmpQcIndicatorFactorVo> queryList(MmpQcIndicatorFactorBo bo) {
        LambdaQueryWrapper<MmpQcIndicatorFactor> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcIndicatorFactor> buildQueryWrapper(MmpQcIndicatorFactorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcIndicatorFactor> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcIndicatorFactor::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getFactorType()), MmpQcIndicatorFactor::getFactorType, bo.getFactorType());
        lqw.like(StringUtils.isNotBlank(bo.getFactorName()), MmpQcIndicatorFactor::getFactorName, bo.getFactorName());
        lqw.eq(StringUtils.isNotBlank(bo.getFactorCode()), MmpQcIndicatorFactor::getFactorCode, bo.getFactorCode());
        lqw.eq(StringUtils.isNotBlank(bo.getDescription()), MmpQcIndicatorFactor::getDescription, bo.getDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getDataSource()), MmpQcIndicatorFactor::getDataSource, bo.getDataSource());
        lqw.eq(bo.getSortOrder() != null, MmpQcIndicatorFactor::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getDelFlag() != null, MmpQcIndicatorFactor::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增指标计算因子
     *
     * @param bo 指标计算因子
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcIndicatorFactorBo bo) {
        MmpQcIndicatorFactor add = MapstructUtils.convert(bo, MmpQcIndicatorFactor.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改指标计算因子
     *
     * @param bo 指标计算因子
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcIndicatorFactorBo bo) {
        MmpQcIndicatorFactor update = MapstructUtils.convert(bo, MmpQcIndicatorFactor.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcIndicatorFactor entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除指标计算因子信息
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
