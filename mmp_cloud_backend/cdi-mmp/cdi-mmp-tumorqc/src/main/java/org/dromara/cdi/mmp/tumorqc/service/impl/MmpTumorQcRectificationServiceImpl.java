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
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcRectificationBo;
import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcRectificationVo;
import org.dromara.cdi.mmp.tumorqc.domain.MmpTumorQcRectification;
import org.dromara.cdi.mmp.tumorqc.mapper.MmpTumorQcRectificationMapper;
import org.dromara.cdi.mmp.tumorqc.service.IMmpTumorQcRectificationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 肿瘤质控整改Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpTumorQcRectificationServiceImpl implements IMmpTumorQcRectificationService {

    private final MmpTumorQcRectificationMapper baseMapper;

    /**
     * 查询肿瘤质控整改
     *
     * @param id 主键
     * @return 肿瘤质控整改
     */
    @Override
    public MmpTumorQcRectificationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询肿瘤质控整改列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控整改分页列表
     */
    @Override
    public TableDataInfo<MmpTumorQcRectificationVo> queryPageList(MmpTumorQcRectificationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpTumorQcRectification> lqw = buildQueryWrapper(bo);
        Page<MmpTumorQcRectificationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的肿瘤质控整改列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控整改列表
     */
    @Override
    public List<MmpTumorQcRectificationVo> queryList(MmpTumorQcRectificationBo bo) {
        LambdaQueryWrapper<MmpTumorQcRectification> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpTumorQcRectification> buildQueryWrapper(MmpTumorQcRectificationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpTumorQcRectification> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpTumorQcRectification::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getRectificationCode()), MmpTumorQcRectification::getRectificationCode, bo.getRectificationCode());
        lqw.eq(StringUtils.isNotBlank(bo.getProblemDescription()), MmpTumorQcRectification::getProblemDescription, bo.getProblemDescription());
        lqw.eq(StringUtils.isNotBlank(bo.getRectificationMeasures()), MmpTumorQcRectification::getRectificationMeasures, bo.getRectificationMeasures());
        lqw.like(StringUtils.isNotBlank(bo.getResponsiblePersonName()), MmpTumorQcRectification::getResponsiblePersonName, bo.getResponsiblePersonName());
        lqw.eq(bo.getDeadline() != null, MmpTumorQcRectification::getDeadline, bo.getDeadline());
        lqw.eq(bo.getCompletionTime() != null, MmpTumorQcRectification::getCompletionTime, bo.getCompletionTime());
        lqw.eq(StringUtils.isNotBlank(bo.getRectificationResult()), MmpTumorQcRectification::getRectificationResult, bo.getRectificationResult());
        lqw.eq(StringUtils.isNotBlank(bo.getVerificationStatus()), MmpTumorQcRectification::getVerificationStatus, bo.getVerificationStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpTumorQcRectification::getStatus, bo.getStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpTumorQcRectification::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增肿瘤质控整改
     *
     * @param bo 肿瘤质控整改
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpTumorQcRectificationBo bo) {
        MmpTumorQcRectification add = MapstructUtils.convert(bo, MmpTumorQcRectification.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改肿瘤质控整改
     *
     * @param bo 肿瘤质控整改
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpTumorQcRectificationBo bo) {
        MmpTumorQcRectification update = MapstructUtils.convert(bo, MmpTumorQcRectification.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpTumorQcRectification entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除肿瘤质控整改信息
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
