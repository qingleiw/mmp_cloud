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
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemRectificationRecordBo;
import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemRectificationRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.MmpCoreSystemRectificationRecord;
import org.dromara.cdi.mmp.coresystem.mapper.MmpCoreSystemRectificationRecordMapper;
import org.dromara.cdi.mmp.coresystem.service.IMmpCoreSystemRectificationRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 制度整改记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpCoreSystemRectificationRecordServiceImpl implements IMmpCoreSystemRectificationRecordService {

    private final MmpCoreSystemRectificationRecordMapper baseMapper;

    /**
     * 查询制度整改记录
     *
     * @param id 主键
     * @return 制度整改记录
     */
    @Override
    public MmpCoreSystemRectificationRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询制度整改记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 制度整改记录分页列表
     */
    @Override
    public TableDataInfo<MmpCoreSystemRectificationRecordVo> queryPageList(MmpCoreSystemRectificationRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpCoreSystemRectificationRecord> lqw = buildQueryWrapper(bo);
        Page<MmpCoreSystemRectificationRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的制度整改记录列表
     *
     * @param bo 查询条件
     * @return 制度整改记录列表
     */
    @Override
    public List<MmpCoreSystemRectificationRecordVo> queryList(MmpCoreSystemRectificationRecordBo bo) {
        LambdaQueryWrapper<MmpCoreSystemRectificationRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpCoreSystemRectificationRecord> buildQueryWrapper(MmpCoreSystemRectificationRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpCoreSystemRectificationRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpCoreSystemRectificationRecord::getId);
        lqw.like(StringUtils.isNotBlank(bo.getSystemName()), MmpCoreSystemRectificationRecord::getSystemName, bo.getSystemName());
        lqw.like(StringUtils.isNotBlank(bo.getRectifierName()), MmpCoreSystemRectificationRecord::getRectifierName, bo.getRectifierName());
        lqw.eq(StringUtils.isNotBlank(bo.getRectificationStatus()), MmpCoreSystemRectificationRecord::getRectificationStatus, bo.getRectificationStatus());
        lqw.eq(bo.getRectificationStartTime() != null, MmpCoreSystemRectificationRecord::getRectificationStartTime, bo.getRectificationStartTime());
        lqw.eq(bo.getRectificationEndTime() != null, MmpCoreSystemRectificationRecord::getRectificationEndTime, bo.getRectificationEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getRectificationContent()), MmpCoreSystemRectificationRecord::getRectificationContent, bo.getRectificationContent());
        lqw.eq(StringUtils.isNotBlank(bo.getRectificationMeasures()), MmpCoreSystemRectificationRecord::getRectificationMeasures, bo.getRectificationMeasures());
        lqw.eq(StringUtils.isNotBlank(bo.getAcceptanceResult()), MmpCoreSystemRectificationRecord::getAcceptanceResult, bo.getAcceptanceResult());
        lqw.eq(StringUtils.isNotBlank(bo.getAcceptanceOpinion()), MmpCoreSystemRectificationRecord::getAcceptanceOpinion, bo.getAcceptanceOpinion());
        lqw.eq(bo.getDelFlag() != null, MmpCoreSystemRectificationRecord::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增制度整改记录
     *
     * @param bo 制度整改记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpCoreSystemRectificationRecordBo bo) {
        MmpCoreSystemRectificationRecord add = MapstructUtils.convert(bo, MmpCoreSystemRectificationRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改制度整改记录
     *
     * @param bo 制度整改记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpCoreSystemRectificationRecordBo bo) {
        MmpCoreSystemRectificationRecord update = MapstructUtils.convert(bo, MmpCoreSystemRectificationRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpCoreSystemRectificationRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除制度整改记录信息
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
