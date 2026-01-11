package org.dromara.cdi.mmp.emergency.service.impl;

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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyMedicalSupportBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyMedicalSupportVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyMedicalSupport;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyMedicalSupportMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyMedicalSupportService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医疗保障资源Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyMedicalSupportServiceImpl implements IMmpEmergencyMedicalSupportService {

    private final MmpEmergencyMedicalSupportMapper baseMapper;

    /**
     * 查询医疗保障资源
     *
     * @param id 主键
     * @return 医疗保障资源
     */
    @Override
    public MmpEmergencyMedicalSupportVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医疗保障资源列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医疗保障资源分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyMedicalSupportVo> queryPageList(MmpEmergencyMedicalSupportBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyMedicalSupport> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyMedicalSupportVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医疗保障资源列表
     *
     * @param bo 查询条件
     * @return 医疗保障资源列表
     */
    @Override
    public List<MmpEmergencyMedicalSupportVo> queryList(MmpEmergencyMedicalSupportBo bo) {
        LambdaQueryWrapper<MmpEmergencyMedicalSupport> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyMedicalSupport> buildQueryWrapper(MmpEmergencyMedicalSupportBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyMedicalSupport> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyMedicalSupport::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getResourceCode()), MmpEmergencyMedicalSupport::getResourceCode, bo.getResourceCode());
        lqw.like(StringUtils.isNotBlank(bo.getResourceName()), MmpEmergencyMedicalSupport::getResourceName, bo.getResourceName());
        lqw.eq(StringUtils.isNotBlank(bo.getResourceType()), MmpEmergencyMedicalSupport::getResourceType, bo.getResourceType());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpEmergencyMedicalSupport::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getLocation()), MmpEmergencyMedicalSupport::getLocation, bo.getLocation());
        lqw.eq(bo.getQuantity() != null, MmpEmergencyMedicalSupport::getQuantity, bo.getQuantity());
        lqw.eq(StringUtils.isNotBlank(bo.getUnit()), MmpEmergencyMedicalSupport::getUnit, bo.getUnit());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson()), MmpEmergencyMedicalSupport::getContactPerson, bo.getContactPerson());
        lqw.eq(StringUtils.isNotBlank(bo.getContactInfo()), MmpEmergencyMedicalSupport::getContactInfo, bo.getContactInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpEmergencyMedicalSupport::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增医疗保障资源
     *
     * @param bo 医疗保障资源
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyMedicalSupportBo bo) {
        MmpEmergencyMedicalSupport add = MapstructUtils.convert(bo, MmpEmergencyMedicalSupport.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医疗保障资源
     *
     * @param bo 医疗保障资源
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyMedicalSupportBo bo) {
        MmpEmergencyMedicalSupport update = MapstructUtils.convert(bo, MmpEmergencyMedicalSupport.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyMedicalSupport entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医疗保障资源信息
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
