package org.dromara.cdi.mmp.radiation.service.impl;

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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationEquipmentInspectionBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationEquipmentInspectionVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationEquipmentInspection;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationEquipmentInspectionMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationEquipmentInspectionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 放射设备检测记录Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationEquipmentInspectionServiceImpl implements IMmpRadiationEquipmentInspectionService {

    private final MmpRadiationEquipmentInspectionMapper baseMapper;

    /**
     * 查询放射设备检测记录
     *
     * @param id 主键
     * @return 放射设备检测记录
     */
    @Override
    public MmpRadiationEquipmentInspectionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询放射设备检测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 放射设备检测记录分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationEquipmentInspectionVo> queryPageList(MmpRadiationEquipmentInspectionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationEquipmentInspection> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationEquipmentInspectionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的放射设备检测记录列表
     *
     * @param bo 查询条件
     * @return 放射设备检测记录列表
     */
    @Override
    public List<MmpRadiationEquipmentInspectionVo> queryList(MmpRadiationEquipmentInspectionBo bo) {
        LambdaQueryWrapper<MmpRadiationEquipmentInspection> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationEquipmentInspection> buildQueryWrapper(MmpRadiationEquipmentInspectionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationEquipmentInspection> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationEquipmentInspection::getId);
        lqw.eq(bo.getInspectionDate() != null, MmpRadiationEquipmentInspection::getInspectionDate, bo.getInspectionDate());
        lqw.eq(StringUtils.isNotBlank(bo.getInspectionAgency()), MmpRadiationEquipmentInspection::getInspectionAgency, bo.getInspectionAgency());
        lqw.like(StringUtils.isNotBlank(bo.getInspectorName()), MmpRadiationEquipmentInspection::getInspectorName, bo.getInspectorName());
        lqw.eq(StringUtils.isNotBlank(bo.getInspectionResult()), MmpRadiationEquipmentInspection::getInspectionResult, bo.getInspectionResult());
        lqw.eq(StringUtils.isNotBlank(bo.getInspectionReport()), MmpRadiationEquipmentInspection::getInspectionReport, bo.getInspectionReport());
        lqw.eq(bo.getNextInspectionDate() != null, MmpRadiationEquipmentInspection::getNextInspectionDate, bo.getNextInspectionDate());
        return lqw;
    }

    /**
     * 新增放射设备检测记录
     *
     * @param bo 放射设备检测记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationEquipmentInspectionBo bo) {
        MmpRadiationEquipmentInspection add = MapstructUtils.convert(bo, MmpRadiationEquipmentInspection.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改放射设备检测记录
     *
     * @param bo 放射设备检测记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationEquipmentInspectionBo bo) {
        MmpRadiationEquipmentInspection update = MapstructUtils.convert(bo, MmpRadiationEquipmentInspection.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationEquipmentInspection entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除放射设备检测记录信息
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
