package org.dromara.cdi.mmp.tumorqc.service.impl;

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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorDetailBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorDetailVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcIndicatorDetail;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcIndicatorDetailMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcIndicatorDetailService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 质控指标明细数据Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcIndicatorDetailServiceImpl implements IMmpTumorQcIndicatorDetailService {

    private final MmpTumorQcIndicatorDetailMapper baseMapper;

    /**
     * 查询质控指标明细数据
     *
     * @param id 主键
     * @return 质控指标明细数据
     */
    @Override
    public MmpTumorQcIndicatorDetailVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询质控指标明细数据列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质控指标明细数据分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcIndicatorDetailVo> queryPageList(MmpTumorQcIndicatorDetailBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcIndicatorDetail> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcIndicatorDetailVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的质控指标明细数据列表
     *
     * @param bo 查询条件
     * @return 质控指标明细数据列表
     */
    @Override
    public List<MmpTumorQcIndicatorDetailVo> queryList(MmpTumorQcIndicatorDetailBo bo) {
        LambdaQueryWrapper<MmpTumorQcIndicatorDetail> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcIndicatorDetail> buildQueryWrapper(MmpTumorQcIndicatorDetailBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcIndicatorDetail> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcIndicatorDetail::getId);
        lqw.eq(bo.getRecordId() != null, MmpTumorQcIndicatorDetail::getRecordId, bo.getRecordId());
        lqw.eq(bo.getIndicatorId() != null, MmpTumorQcIndicatorDetail::getIndicatorId, bo.getIndicatorId());
        lqw.eq(bo.getPatientId() != null, MmpTumorQcIndicatorDetail::getPatientId, bo.getPatientId());
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpTumorQcIndicatorDetail::getPatientName, bo.getPatientName());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitNo()), MmpTumorQcIndicatorDetail::getVisitNo, bo.getVisitNo());
        lqw.eq(StringUtils.isNotBlank(bo.getDiagnosis()), MmpTumorQcIndicatorDetail::getDiagnosis, bo.getDiagnosis());
        lqw.eq(StringUtils.isNotBlank(bo.getIndicatorResult()), MmpTumorQcIndicatorDetail::getIndicatorResult, bo.getIndicatorResult());
        lqw.eq(StringUtils.isNotBlank(bo.getResultDescription()), MmpTumorQcIndicatorDetail::getResultDescription, bo.getResultDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getRelatedData()), MmpTumorQcIndicatorDetail::getRelatedData, bo.getRelatedData());
        return lqw;
    }

    /**
     * 新增质控指标明细数据
     *
     * @param bo 质控指标明细数据
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcIndicatorDetailBo bo) {
        MmpTumorQcIndicatorDetail add = MapstructUtils.convert(bo, MmpTumorQcIndicatorDetail.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改质控指标明细数据
     *
     * @param bo 质控指标明细数据
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcIndicatorDetailBo bo) {
        MmpTumorQcIndicatorDetail update = MapstructUtils.convert(bo, MmpTumorQcIndicatorDetail.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcIndicatorDetail entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除质控指标明细数据信息
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
