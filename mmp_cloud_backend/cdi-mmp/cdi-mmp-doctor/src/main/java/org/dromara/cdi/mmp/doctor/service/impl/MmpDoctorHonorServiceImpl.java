package org.dromara.cdi.mmp.doctor.service.impl;

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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorHonorBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorHonorVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorHonor;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorHonorMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorHonorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 荣誉奖励Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorHonorServiceImpl implements IMmpDoctorHonorService {

    private final MmpDoctorHonorMapper baseMapper;

    /**
     * 查询荣誉奖励
     *
     * @param id 主键
     * @return 荣誉奖励
     */
    @Override
    public MmpDoctorHonorVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询荣誉奖励列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 荣誉奖励分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorHonorVo> queryPageList(MmpDoctorHonorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorHonor> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorHonorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的荣誉奖励列表
     *
     * @param bo 查询条件
     * @return 荣誉奖励列表
     */
    @Override
    public List<MmpDoctorHonorVo> queryList(MmpDoctorHonorBo bo) {
        LambdaQueryWrapper<MmpDoctorHonor> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorHonor> buildQueryWrapper(MmpDoctorHonorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorHonor> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorHonor::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorHonor::getDoctorId, bo.getDoctorId());
        lqw.like(StringUtils.isNotBlank(bo.getHonorName()), MmpDoctorHonor::getHonorName, bo.getHonorName());
        lqw.eq(StringUtils.isNotBlank(bo.getHonorLevel()), MmpDoctorHonor::getHonorLevel, bo.getHonorLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getAwardUnit()), MmpDoctorHonor::getAwardUnit, bo.getAwardUnit());
        lqw.eq(bo.getAwardDate() != null, MmpDoctorHonor::getAwardDate, bo.getAwardDate());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNo()), MmpDoctorHonor::getCertificateNo, bo.getCertificateNo());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateUrl()), MmpDoctorHonor::getCertificateUrl, bo.getCertificateUrl());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorHonor::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增荣誉奖励
     *
     * @param bo 荣誉奖励
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorHonorBo bo) {
        MmpDoctorHonor add = MapstructUtils.convert(bo, MmpDoctorHonor.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改荣誉奖励
     *
     * @param bo 荣誉奖励
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorHonorBo bo) {
        MmpDoctorHonor update = MapstructUtils.convert(bo, MmpDoctorHonor.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorHonor entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除荣誉奖励信息
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
