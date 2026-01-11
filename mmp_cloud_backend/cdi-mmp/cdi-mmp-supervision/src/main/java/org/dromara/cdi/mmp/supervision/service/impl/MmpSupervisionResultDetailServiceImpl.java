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
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionResultDetailBo;
import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionResultDetailVo;
import org.dromara.cdi.mmp.supervision.domain.MmpSupervisionResultDetail;
import org.dromara.cdi.mmp.supervision.mapper.MmpSupervisionResultDetailMapper;
import org.dromara.cdi.mmp.supervision.service.IMmpSupervisionResultDetailService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 督查结果明细Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSupervisionResultDetailServiceImpl implements IMmpSupervisionResultDetailService {

    private final MmpSupervisionResultDetailMapper baseMapper;

    /**
     * 查询督查结果明细
     *
     * @param id 主键
     * @return 督查结果明细
     */
    @Override
    public MmpSupervisionResultDetailVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询督查结果明细列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查结果明细分页列表
     */
    @Override
    public TableDataInfo<MmpSupervisionResultDetailVo> queryPageList(MmpSupervisionResultDetailBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSupervisionResultDetail> lqw = buildQueryWrapper(bo);
        Page<MmpSupervisionResultDetailVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的督查结果明细列表
     *
     * @param bo 查询条件
     * @return 督查结果明细列表
     */
    @Override
    public List<MmpSupervisionResultDetailVo> queryList(MmpSupervisionResultDetailBo bo) {
        LambdaQueryWrapper<MmpSupervisionResultDetail> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSupervisionResultDetail> buildQueryWrapper(MmpSupervisionResultDetailBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSupervisionResultDetail> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSupervisionResultDetail::getId);
        lqw.eq(bo.getScore() != null, MmpSupervisionResultDetail::getScore, bo.getScore());
        lqw.eq(StringUtils.isNotBlank(bo.getRemarks()), MmpSupervisionResultDetail::getRemarks, bo.getRemarks());
        return lqw;
    }

    /**
     * 新增督查结果明细
     *
     * @param bo 督查结果明细
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSupervisionResultDetailBo bo) {
        MmpSupervisionResultDetail add = MapstructUtils.convert(bo, MmpSupervisionResultDetail.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改督查结果明细
     *
     * @param bo 督查结果明细
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSupervisionResultDetailBo bo) {
        MmpSupervisionResultDetail update = MapstructUtils.convert(bo, MmpSupervisionResultDetail.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSupervisionResultDetail entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除督查结果明细信息
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
