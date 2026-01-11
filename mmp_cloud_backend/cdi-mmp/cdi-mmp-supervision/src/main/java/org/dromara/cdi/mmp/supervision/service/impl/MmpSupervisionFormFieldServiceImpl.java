package org.dromara.cdi.mmp.supervision.service.impl;

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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionFormFieldBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionFormFieldVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionFormField;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionFormFieldMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionFormFieldService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查单字段Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionFormFieldServiceImpl implements IMmpSupervisionFormFieldService {

    private final MmpSupervisionFormFieldMapper baseMapper;

    /**
     * 查询督查单字段
     *
     * @param id 主键
     * @return 督查单字段
     */
    @Override
    public MmpSupervisionFormFieldVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查单字段列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查单字段分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionFormFieldVo> queryPageList(MmpSupervisionFormFieldBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionFormField> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionFormFieldVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查单字段列表
     *
     * @param bo 查询条件
     * @return 督查单字段列表
     */
    @Override
    public List<MmpSupervisionFormFieldVo> queryList(MmpSupervisionFormFieldBo bo) {
        LambdaQueryWrapper<MmpSupervisionFormField> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionFormField> buildQueryWrapper(MmpSupervisionFormFieldBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionFormField> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionFormField::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getFieldCode()), MmpSupervisionFormField::getFieldCode, bo.getFieldCode());
        lqw.like(StringUtils.isNotBlank(bo.getFieldName()), MmpSupervisionFormField::getFieldName, bo.getFieldName());
        lqw.eq(StringUtils.isNotBlank(bo.getFieldType()), MmpSupervisionFormField::getFieldType, bo.getFieldType());
        lqw.eq(StringUtils.isNotBlank(bo.getFieldConfig()), MmpSupervisionFormField::getFieldConfig, bo.getFieldConfig());
        lqw.eq(StringUtils.isNotBlank(bo.getRequiredFlag()), MmpSupervisionFormField::getRequiredFlag, bo.getRequiredFlag());
        lqw.eq(bo.getSortOrder() != null, MmpSupervisionFormField::getSortOrder, bo.getSortOrder());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionFormField::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查单字段
     *
     * @param bo 督查单字段
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionFormFieldBo bo) {
        MmpSupervisionFormField add = MapstructUtils.convert(bo, MmpSupervisionFormField.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查单字段
     *
     * @param bo 督查单字段
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionFormFieldBo bo) {
        MmpSupervisionFormField update = MapstructUtils.convert(bo, MmpSupervisionFormField.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionFormField entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查单字段信息
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
