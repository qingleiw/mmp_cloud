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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionRectificationProgressBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionRectificationProgressVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionRectificationProgress;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionRectificationProgressMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionRectificationProgressService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 整改进度Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionRectificationProgressServiceImpl implements IMmpSupervisionRectificationProgressService {

    private final MmpSupervisionRectificationProgressMapper baseMapper;

    /**
     * 查询整改进度
     *
     * @param id 主键
     * @return 整改进度
     */
    @Override
    public MmpSupervisionRectificationProgressVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询整改进度列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 整改进度分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionRectificationProgressVo> queryPageList(MmpSupervisionRectificationProgressBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionRectificationProgress> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionRectificationProgressVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的整改进度列表
     *
     * @param bo 查询条件
     * @return 整改进度列表
     */
    @Override
    public List<MmpSupervisionRectificationProgressVo> queryList(MmpSupervisionRectificationProgressBo bo) {
        LambdaQueryWrapper<MmpSupervisionRectificationProgress> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionRectificationProgress> buildQueryWrapper(MmpSupervisionRectificationProgressBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionRectificationProgress> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionRectificationProgress::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getProgressDescription()), MmpSupervisionRectificationProgress::getProgressDescription, bo.getProgressDescription());
        lqw.eq(bo.getProgressPercentage() != null, MmpSupervisionRectificationProgress::getProgressPercentage, bo.getProgressPercentage());
        lqw.eq(StringUtils.isNotBlank(bo.getAttachmentUrls()), MmpSupervisionRectificationProgress::getAttachmentUrls, bo.getAttachmentUrls());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpSupervisionRectificationProgress::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增整改进度
     *
     * @param bo 整改进度
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionRectificationProgressBo bo) {
        MmpSupervisionRectificationProgress add = MapstructUtils.convert(bo, MmpSupervisionRectificationProgress.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改整改进度
     *
     * @param bo 整改进度
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionRectificationProgressBo bo) {
        MmpSupervisionRectificationProgress update = MapstructUtils.convert(bo, MmpSupervisionRectificationProgress.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionRectificationProgress entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除整改进度信息
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
