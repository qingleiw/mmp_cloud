package org.dromara.cdi.mmp.ntp.service.impl;

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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectImplementationBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectImplementationVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectImplementation;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectImplementationMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectImplementationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 新技术实施Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectImplementationServiceImpl implements IMmpNewTechnologyProjectImplementationService {

    private final MmpNewTechnologyProjectImplementationMapper baseMapper;

    /**
     * 查询新技术实施
     *
     * @param id 主键
     * @return 新技术实施
     */
    @Override
    public MmpNewTechnologyProjectImplementationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询新技术实施列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术实施分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectImplementationVo> queryPageList(MmpNewTechnologyProjectImplementationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectImplementation> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectImplementationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的新技术实施列表
     *
     * @param bo 查询条件
     * @return 新技术实施列表
     */
    @Override
    public List<MmpNewTechnologyProjectImplementationVo> queryList(MmpNewTechnologyProjectImplementationBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectImplementation> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectImplementation> buildQueryWrapper(MmpNewTechnologyProjectImplementationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectImplementation> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectImplementation::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getProjectNo()), MmpNewTechnologyProjectImplementation::getProjectNo, bo.getProjectNo());
        lqw.eq(bo.getImplementationStatus() != null, MmpNewTechnologyProjectImplementation::getImplementationStatus, bo.getImplementationStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getImplementDoctor()), MmpNewTechnologyProjectImplementation::getImplementDoctor, bo.getImplementDoctor());
        lqw.eq(StringUtils.isNotBlank(bo.getImplementationLocation()), MmpNewTechnologyProjectImplementation::getImplementationLocation, bo.getImplementationLocation());
        lqw.eq(bo.getImplementationDate() != null, MmpNewTechnologyProjectImplementation::getImplementationDate, bo.getImplementationDate());
        lqw.eq(StringUtils.isNotBlank(bo.getImplementationResult()), MmpNewTechnologyProjectImplementation::getImplementationResult, bo.getImplementationResult());
        lqw.eq(bo.getIsDeleted() != null, MmpNewTechnologyProjectImplementation::getIsDeleted, bo.getIsDeleted());
        return lqw;
    }

    /**
     * 新增新技术实施
     *
     * @param bo 新技术实施
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectImplementationBo bo) {
        MmpNewTechnologyProjectImplementation add = MapstructUtils.convert(bo, MmpNewTechnologyProjectImplementation.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改新技术实施
     *
     * @param bo 新技术实施
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectImplementationBo bo) {
        MmpNewTechnologyProjectImplementation update = MapstructUtils.convert(bo, MmpNewTechnologyProjectImplementation.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectImplementation entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除新技术实施信息
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
