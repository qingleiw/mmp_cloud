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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcInspectionBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcInspectionVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcInspection;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcInspectionMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcInspectionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 肿瘤质控检查Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcInspectionServiceImpl implements IMmpTumorQcInspectionService {

    private final MmpTumorQcInspectionMapper baseMapper;

    /**
     * 查询肿瘤质控检查
     *
     * @param id 主键
     * @return 肿瘤质控检查
     */
    @Override
    public MmpTumorQcInspectionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询肿瘤质控检查列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控检查分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcInspectionVo> queryPageList(MmpTumorQcInspectionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcInspection> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcInspectionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的肿瘤质控检查列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控检查列表
     */
    @Override
    public List<MmpTumorQcInspectionVo> queryList(MmpTumorQcInspectionBo bo) {
        LambdaQueryWrapper<MmpTumorQcInspection> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcInspection> buildQueryWrapper(MmpTumorQcInspectionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcInspection> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcInspection::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getInspectionCode()), MmpTumorQcInspection::getInspectionCode, bo.getInspectionCode());
        lqw.eq(bo.getInspectionDate() != null, MmpTumorQcInspection::getInspectionDate, bo.getInspectionDate());
        lqw.like(StringUtils.isNotBlank(bo.getInspectorName()), MmpTumorQcInspection::getInspectorName, bo.getInspectorName());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpTumorQcInspection::getDepartmentName, bo.getDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getInspectionType()), MmpTumorQcInspection::getInspectionType, bo.getInspectionType());
        lqw.eq(StringUtils.isNotBlank(bo.getInspectionResult()), MmpTumorQcInspection::getInspectionResult, bo.getInspectionResult());
        lqw.eq(StringUtils.isNotBlank(bo.getProblemDescription()), MmpTumorQcInspection::getProblemDescription, bo.getProblemDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getSuggestion()), MmpTumorQcInspection::getSuggestion, bo.getSuggestion());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpTumorQcInspection::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpTumorQcInspection::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增肿瘤质控检查
     *
     * @param bo 肿瘤质控检查
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcInspectionBo bo) {
        MmpTumorQcInspection add = MapstructUtils.convert(bo, MmpTumorQcInspection.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改肿瘤质控检查
     *
     * @param bo 肿瘤质控检查
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcInspectionBo bo) {
        MmpTumorQcInspection update = MapstructUtils.convert(bo, MmpTumorQcInspection.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcInspection entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除肿瘤质控检查信息
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
