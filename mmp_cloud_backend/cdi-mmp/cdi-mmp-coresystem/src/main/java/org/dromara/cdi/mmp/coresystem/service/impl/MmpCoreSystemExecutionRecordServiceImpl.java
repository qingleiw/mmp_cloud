package org.dromara.cdi.mmp.coresystem.service.impl;

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
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemExecutionRecordBo;
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemExecutionRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemExecutionRecord;
import org.dromara.cdi.mmp.coresystem.mapper.MmpCoreSystemExecutionRecordMapper;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemExecutionRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 制度执行记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpCoreSystemExecutionRecordServiceImpl implements IMmpCoreSystemExecutionRecordService {

    private final MmpCoreSystemExecutionRecordMapper baseMapper;

    /**
     * 查询制度执行记录
     *
     * @param id 主键
     * @return 制度执行记录
     */
    @Override
    public MmpCoreSystemExecutionRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询制度执行记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 制度执行记录分页列表
     */
    @Override
    public TableDataInfo<MmpCoreSystemExecutionRecordVo> queryPageList(MmpCoreSystemExecutionRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpCoreSystemExecutionRecord> lqw = buildQueryWrapper(bo);
        Page<MmpCoreSystemExecutionRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的制度执行记录列表
     *
     * @param bo 查询条件
     * @return 制度执行记录列表
     */
    @Override
    public List<MmpCoreSystemExecutionRecordVo> queryList(MmpCoreSystemExecutionRecordBo bo) {
        LambdaQueryWrapper<MmpCoreSystemExecutionRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpCoreSystemExecutionRecord> buildQueryWrapper(MmpCoreSystemExecutionRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpCoreSystemExecutionRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpCoreSystemExecutionRecord::getId);
        lqw.like(StringUtils.isNotBlank(bo.getSystemName()), MmpCoreSystemExecutionRecord::getSystemName, bo.getSystemName());
        lqw.like(StringUtils.isNotBlank(bo.getExecutorName()), MmpCoreSystemExecutionRecord::getExecutorName, bo.getExecutorName());
        lqw.eq(bo.getExecutionTime() != null, MmpCoreSystemExecutionRecord::getExecutionTime, bo.getExecutionTime());
        lqw.eq(StringUtils.isNotBlank(bo.getExecutionResult()), MmpCoreSystemExecutionRecord::getExecutionResult, bo.getExecutionResult());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpCoreSystemExecutionRecord::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增制度执行记录
     *
     * @param bo 制度执行记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpCoreSystemExecutionRecordBo bo) {
        MmpCoreSystemExecutionRecord add = MapstructUtils.convert(bo, MmpCoreSystemExecutionRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改制度执行记录
     *
     * @param bo 制度执行记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpCoreSystemExecutionRecordBo bo) {
        MmpCoreSystemExecutionRecord update = MapstructUtils.convert(bo, MmpCoreSystemExecutionRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpCoreSystemExecutionRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除制度执行记录信息
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
