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
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcManualDataBo;
import org.dromara.cdi.mmp.qc.domain.vo.MmpQcManualDataVo;
import org.dromara.cdi.mmp.qc.domain.MmpQcManualData;
import org.dromara.cdi.mmp.qc.mapper.MmpQcManualDataMapper;
import org.dromara.cdi.mmp.qc.service.IMmpQcManualDataService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 人工补录数据Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQcManualDataServiceImpl implements IMmpQcManualDataService {

    private final MmpQcManualDataMapper baseMapper;

    /**
     * 查询人工补录数据
     *
     * @param id 主键
     * @return 人工补录数据
     */
    @Override
    public MmpQcManualDataVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询人工补录数据列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 人工补录数据分页列表
     */
    @Override
    public TableDataInfo<MmpQcManualDataVo> queryPageList(MmpQcManualDataBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQcManualData> lqw = buildQueryWrapper(bo);
        Page<MmpQcManualDataVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的人工补录数据列表
     *
     * @param bo 查询条件
     * @return 人工补录数据列表
     */
    @Override
    public List<MmpQcManualDataVo> queryList(MmpQcManualDataBo bo) {
        LambdaQueryWrapper<MmpQcManualData> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQcManualData> buildQueryWrapper(MmpQcManualDataBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQcManualData> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQcManualData::getId);
        lqw.eq(bo.getIndicatorId() != null, MmpQcManualData::getIndicatorId, bo.getIndicatorId());
        lqw.eq(bo.getPatientId() != null, MmpQcManualData::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitNo()), MmpQcManualData::getVisitNo, bo.getVisitNo());
        lqw.eq(StringUtils.isNotBlank(bo.getDataType()), MmpQcManualData::getDataType, bo.getDataType());
        lqw.eq(StringUtils.isNotBlank(bo.getDataField()), MmpQcManualData::getDataField, bo.getDataField());
        lqw.eq(StringUtils.isNotBlank(bo.getDataValue()), MmpQcManualData::getDataValue, bo.getDataValue());
        lqw.eq(bo.getDataDate() != null, MmpQcManualData::getDataDate, bo.getDataDate());
        lqw.eq(StringUtils.isNotBlank(bo.getOperationType()), MmpQcManualData::getOperationType, bo.getOperationType());
        lqw.eq(StringUtils.isNotBlank(bo.getOriginalValue()), MmpQcManualData::getOriginalValue, bo.getOriginalValue());
        lqw.eq(StringUtils.isNotBlank(bo.getModifyReason()), MmpQcManualData::getModifyReason, bo.getModifyReason());
        lqw.eq(bo.getDelFlag() != null, MmpQcManualData::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增人工补录数据
     *
     * @param bo 人工补录数据
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQcManualDataBo bo) {
        MmpQcManualData add = MapstructUtils.convert(bo, MmpQcManualData.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改人工补录数据
     *
     * @param bo 人工补录数据
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQcManualDataBo bo) {
        MmpQcManualData update = MapstructUtils.convert(bo, MmpQcManualData.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQcManualData entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除人工补录数据信息
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
