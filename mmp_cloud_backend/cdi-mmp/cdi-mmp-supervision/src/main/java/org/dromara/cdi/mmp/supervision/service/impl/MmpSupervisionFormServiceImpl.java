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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionFormBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionFormVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionForm;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionFormMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionFormService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查单Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionFormServiceImpl implements IMmpSupervisionFormService {

    private final MmpSupervisionFormMapper baseMapper;

    /**
     * 查询督查单
     *
     * @param id 主键
     * @return 督查单
     */
    @Override
    public MmpSupervisionFormVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查单列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查单分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionFormVo> queryPageList(MmpSupervisionFormBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionForm> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionFormVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查单列表
     *
     * @param bo 查询条件
     * @return 督查单列表
     */
    @Override
    public List<MmpSupervisionFormVo> queryList(MmpSupervisionFormBo bo) {
        LambdaQueryWrapper<MmpSupervisionForm> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionForm> buildQueryWrapper(MmpSupervisionFormBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionForm> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionForm::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getFormCode()), MmpSupervisionForm::getFormCode, bo.getFormCode());
        lqw.like(StringUtils.isNotBlank(bo.getFormName()), MmpSupervisionForm::getFormName, bo.getFormName());
        lqw.eq(StringUtils.isNotBlank(bo.getFormDescription()), MmpSupervisionForm::getFormDescription, bo.getFormDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getFormConfig()), MmpSupervisionForm::getFormConfig, bo.getFormConfig());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionForm::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增督查单
     *
     * @param bo 督查单
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionFormBo bo) {
        MmpSupervisionForm add = MapstructUtils.convert(bo, MmpSupervisionForm.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查单
     *
     * @param bo 督查单
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionFormBo bo) {
        MmpSupervisionForm update = MapstructUtils.convert(bo, MmpSupervisionForm.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionForm entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查单信息
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
