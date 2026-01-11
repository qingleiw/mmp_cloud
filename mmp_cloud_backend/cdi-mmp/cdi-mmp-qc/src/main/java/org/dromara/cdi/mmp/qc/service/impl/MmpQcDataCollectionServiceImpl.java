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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcDataCollectionBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcDataCollectionVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcDataCollection;
import org.dromara.cdi.mmp.qc.mapper.MmpQcDataCollectionMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcDataCollectionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 数据采集记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-30
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcDataCollectionServiceImpl implements IMmpQcDataCollectionService {

    private final MmpQcDataCollectionMapper baseMapper;

    /**
     * 查询数据采集记录
     *
     * @param id 主键
     * @return 数据采集记录
     */
    @Override
    public MmpQcDataCollectionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询数据采集记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 数据采集记录分页列表
     */
    @Override
    public TableDataInfo<MmpQcDataCollectionVo> queryPageList(MmpQcDataCollectionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcDataCollection> lqw = buildQueryWrapper(bo);
        Page<MmpQcDataCollectionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的数据采集记录列表
     *
     * @param bo 查询条件
     * @return 数据采集记录列表
     */
    @Override
    public List<MmpQcDataCollectionVo> queryList(MmpQcDataCollectionBo bo) {
        LambdaQueryWrapper<MmpQcDataCollection> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcDataCollection> buildQueryWrapper(MmpQcDataCollectionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcDataCollection> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcDataCollection::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getCollectionPeriod()), MmpQcDataCollection::getCollectionPeriod, bo.getCollectionPeriod());
        lqw.eq(bo.getCollectionYear() != null, MmpQcDataCollection::getCollectionYear, bo.getCollectionYear());
        lqw.eq(bo.getCollectionMonth() != null, MmpQcDataCollection::getCollectionMonth, bo.getCollectionMonth());
        lqw.eq(bo.getCollectionQuarter() != null, MmpQcDataCollection::getCollectionQuarter, bo.getCollectionQuarter());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpQcDataCollection::getDepartmentName, bo.getDepartmentName());
        lqw.eq(bo.getNumeratorValue() != null, MmpQcDataCollection::getNumeratorValue, bo.getNumeratorValue());
        lqw.eq(bo.getDenominatorValue() != null, MmpQcDataCollection::getDenominatorValue, bo.getDenominatorValue());
        lqw.eq(bo.getIndicatorValue() != null, MmpQcDataCollection::getIndicatorValue, bo.getIndicatorValue());
        lqw.eq(bo.getDataStatus() != null, MmpQcDataCollection::getDataStatus, bo.getDataStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getCollector()), MmpQcDataCollection::getCollector, bo.getCollector());
        lqw.eq(StringUtils.isNotBlank(bo.getReviewer()), MmpQcDataCollection::getReviewer, bo.getReviewer());
        lqw.eq(bo.getCollectionTime() != null, MmpQcDataCollection::getCollectionTime, bo.getCollectionTime());
        lqw.eq(bo.getReviewTime() != null, MmpQcDataCollection::getReviewTime, bo.getReviewTime());
        lqw.eq(bo.getDelFlag() != null, MmpQcDataCollection::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增数据采集记录
     *
     * @param bo 数据采集记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcDataCollectionBo bo) {
        MmpQcDataCollection add = MapstructUtils.convert(bo, MmpQcDataCollection.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改数据采集记录
     *
     * @param bo 数据采集记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcDataCollectionBo bo) {
        MmpQcDataCollection update = MapstructUtils.convert(bo, MmpQcDataCollection.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcDataCollection entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除数据采集记录信息
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
