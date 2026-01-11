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
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectExtensionBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectExtensionVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectExtension;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectExtensionMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectExtensionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 新技术延期申请Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectExtensionServiceImpl implements IMmpNewTechnologyProjectExtensionService {

    private final MmpNewTechnologyProjectExtensionMapper baseMapper;

    /**
     * 查询新技术延期申请
     *
     * @param id 主键
     * @return 新技术延期申请
     */
    @Override
    public MmpNewTechnologyProjectExtensionVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询新技术延期申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术延期申请分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectExtensionVo> queryPageList(MmpNewTechnologyProjectExtensionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectExtension> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectExtensionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的新技术延期申请列表
     *
     * @param bo 查询条件
     * @return 新技术延期申请列表
     */
    @Override
    public List<MmpNewTechnologyProjectExtensionVo> queryList(MmpNewTechnologyProjectExtensionBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectExtension> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectExtension> buildQueryWrapper(MmpNewTechnologyProjectExtensionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectExtension> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectExtension::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getApplyNo()), MmpNewTechnologyProjectExtension::getApplyNo, bo.getApplyNo());
        lqw.eq(bo.getOriginalEndDate() != null, MmpNewTechnologyProjectExtension::getOriginalEndDate, bo.getOriginalEndDate());
        lqw.eq(bo.getExtendDays() != null, MmpNewTechnologyProjectExtension::getExtendDays, bo.getExtendDays());
        lqw.eq(bo.getNewEndDate() != null, MmpNewTechnologyProjectExtension::getNewEndDate, bo.getNewEndDate());
        lqw.eq(StringUtils.isNotBlank(bo.getExtensionReason()), MmpNewTechnologyProjectExtension::getExtensionReason, bo.getExtensionReason());
        lqw.eq(StringUtils.isNotBlank(bo.getApplyStatus()), MmpNewTechnologyProjectExtension::getApplyStatus, bo.getApplyStatus());
        return lqw;
    }

    /**
     * 新增新技术延期申请
     *
     * @param bo 新技术延期申请
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectExtensionBo bo) {
        MmpNewTechnologyProjectExtension add = MapstructUtils.convert(bo, MmpNewTechnologyProjectExtension.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改新技术延期申请
     *
     * @param bo 新技术延期申请
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectExtensionBo bo) {
        MmpNewTechnologyProjectExtension update = MapstructUtils.convert(bo, MmpNewTechnologyProjectExtension.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectExtension entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除新技术延期申请信息
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
