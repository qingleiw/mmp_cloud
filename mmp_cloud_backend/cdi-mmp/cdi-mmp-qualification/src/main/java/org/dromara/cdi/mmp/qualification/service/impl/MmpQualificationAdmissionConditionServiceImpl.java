package org.dromara.cdi.mmp.qualification.service.impl;

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
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationAdmissionConditionBo;
import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationAdmissionConditionVo;
import org.dromara.cdi.mmp.qualification.domain.MmpQualificationAdmissionCondition;
import org.dromara.cdi.mmp.qualification.mapper.MmpQualificationAdmissionConditionMapper;
import org.dromara.cdi.mmp.qualification.service.IMmpQualificationAdmissionConditionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 资质准入条件Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpQualificationAdmissionConditionServiceImpl implements IMmpQualificationAdmissionConditionService {

    private final MmpQualificationAdmissionConditionMapper baseMapper;

    /**
     * 查询资质准入条件
     *
     * @param id 主键
     * @return 资质准入条件
     */
    @Override
    public MmpQualificationAdmissionConditionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询资质准入条件列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质准入条件分页列表
     */
    @Override
    public TableDataInfo<MmpQualificationAdmissionConditionVo> queryPageList(MmpQualificationAdmissionConditionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpQualificationAdmissionCondition> lqw = buildQueryWrapper(bo);
        Page<MmpQualificationAdmissionConditionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的资质准入条件列表
     *
     * @param bo 查询条件
     * @return 资质准入条件列表
     */
    @Override
    public List<MmpQualificationAdmissionConditionVo> queryList(MmpQualificationAdmissionConditionBo bo) {
        LambdaQueryWrapper<MmpQualificationAdmissionCondition> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpQualificationAdmissionCondition> buildQueryWrapper(MmpQualificationAdmissionConditionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpQualificationAdmissionCondition> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpQualificationAdmissionCondition::getId);
        lqw.eq(bo.getQualificationId() != null, MmpQualificationAdmissionCondition::getQualificationId, bo.getQualificationId());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationType()), MmpQualificationAdmissionCondition::getQualificationType, bo.getQualificationType());
        lqw.eq(StringUtils.isNotBlank(bo.getConditionType()), MmpQualificationAdmissionCondition::getConditionType, bo.getConditionType());
        lqw.eq(StringUtils.isNotBlank(bo.getConditionOperator()), MmpQualificationAdmissionCondition::getConditionOperator, bo.getConditionOperator());
        lqw.eq(StringUtils.isNotBlank(bo.getConditionValue()), MmpQualificationAdmissionCondition::getConditionValue, bo.getConditionValue());
        lqw.eq(StringUtils.isNotBlank(bo.getConditionUnit()), MmpQualificationAdmissionCondition::getConditionUnit, bo.getConditionUnit());
        lqw.eq(bo.getIsRequired() != null, MmpQualificationAdmissionCondition::getIsRequired, bo.getIsRequired());
        lqw.eq(StringUtils.isNotBlank(bo.getLogicRelation()), MmpQualificationAdmissionCondition::getLogicRelation, bo.getLogicRelation());
        lqw.eq(bo.getSortOrder() != null, MmpQualificationAdmissionCondition::getSortOrder, bo.getSortOrder());
        lqw.eq(bo.getDelFlag() != null, MmpQualificationAdmissionCondition::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增资质准入条件
     *
     * @param bo 资质准入条件
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpQualificationAdmissionConditionBo bo) {
        MmpQualificationAdmissionCondition add = MapstructUtils.convert(bo, MmpQualificationAdmissionCondition.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改资质准入条件
     *
     * @param bo 资质准入条件
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpQualificationAdmissionConditionBo bo) {
        MmpQualificationAdmissionCondition update = MapstructUtils.convert(bo, MmpQualificationAdmissionCondition.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpQualificationAdmissionCondition entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除资质准入条件信息
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
