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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseAlertBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseAlertVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationDoseAlert;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationDoseAlertMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationDoseAlertService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 剂量监测预警设置Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationDoseAlertServiceImpl implements IMmpRadiationDoseAlertService {

    private final MmpRadiationDoseAlertMapper baseMapper;

    /**
     * 查询剂量监测预警设置
     *
     * @param id 主键
     * @return 剂量监测预警设置
     */
    @Override
    public MmpRadiationDoseAlertVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询剂量监测预警设置列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 剂量监测预警设置分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationDoseAlertVo> queryPageList(MmpRadiationDoseAlertBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationDoseAlert> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationDoseAlertVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的剂量监测预警设置列表
     *
     * @param bo 查询条件
     * @return 剂量监测预警设置列表
     */
    @Override
    public List<MmpRadiationDoseAlertVo> queryList(MmpRadiationDoseAlertBo bo) {
        LambdaQueryWrapper<MmpRadiationDoseAlert> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationDoseAlert> buildQueryWrapper(MmpRadiationDoseAlertBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationDoseAlert> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationDoseAlert::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getAlertType()), MmpRadiationDoseAlert::getAlertType, bo.getAlertType());
        lqw.eq(bo.getThresholdValue() != null, MmpRadiationDoseAlert::getThresholdValue, bo.getThresholdValue());
        lqw.eq(StringUtils.isNotBlank(bo.getAlertLevel()), MmpRadiationDoseAlert::getAlertLevel, bo.getAlertLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getIsActive()), MmpRadiationDoseAlert::getIsActive, bo.getIsActive());
        return lqw;
    }

    /**
     * 新增剂量监测预警设置
     *
     * @param bo 剂量监测预警设置
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationDoseAlertBo bo) {
        MmpRadiationDoseAlert add = MapstructUtils.convert(bo, MmpRadiationDoseAlert.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改剂量监测预警设置
     *
     * @param bo 剂量监测预警设置
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationDoseAlertBo bo) {
        MmpRadiationDoseAlert update = MapstructUtils.convert(bo, MmpRadiationDoseAlert.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationDoseAlert entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除剂量监测预警设置信息
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
