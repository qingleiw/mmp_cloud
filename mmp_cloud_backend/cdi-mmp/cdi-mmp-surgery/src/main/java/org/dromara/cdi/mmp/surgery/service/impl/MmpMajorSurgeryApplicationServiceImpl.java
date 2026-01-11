package org.dromara.cdi.mmp.surgery.service.impl;

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
import org.dromara.cdi.mmp.surgery.domain.bo.MmpMajorSurgeryApplicationBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpMajorSurgeryApplicationVo;
import org.dromara.cdi.mmp.surgery.domain.MmpMajorSurgeryApplication;
import org.dromara.cdi.mmp.surgery.mapper.MmpMajorSurgeryApplicationMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpMajorSurgeryApplicationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 重大手术申请Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-26
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpMajorSurgeryApplicationServiceImpl implements IMmpMajorSurgeryApplicationService {

    private final MmpMajorSurgeryApplicationMapper baseMapper;

    /**
     * 查询重大手术申请
     *
     * @param id 主键
     * @return 重大手术申请
     */
    @Override
    public MmpMajorSurgeryApplicationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询重大手术申请列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 重大手术申请分页列表
     */
    @Override
    public TableDataInfo<MmpMajorSurgeryApplicationVo> queryPageList(MmpMajorSurgeryApplicationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpMajorSurgeryApplication> lqw = buildQueryWrapper(bo);
        Page<MmpMajorSurgeryApplicationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的重大手术申请列表
     *
     * @param bo 查询条件
     * @return 重大手术申请列表
     */
    @Override
    public List<MmpMajorSurgeryApplicationVo> queryList(MmpMajorSurgeryApplicationBo bo) {
        LambdaQueryWrapper<MmpMajorSurgeryApplication> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpMajorSurgeryApplication> buildQueryWrapper(MmpMajorSurgeryApplicationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpMajorSurgeryApplication> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpMajorSurgeryApplication::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getApplicationNo()), MmpMajorSurgeryApplication::getApplicationNo, bo.getApplicationNo());
        lqw.like(StringUtils.isNotBlank(bo.getPatientName()), MmpMajorSurgeryApplication::getPatientName, bo.getPatientName());
        lqw.like(StringUtils.isNotBlank(bo.getDoctorName()), MmpMajorSurgeryApplication::getDoctorName, bo.getDoctorName());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpMajorSurgeryApplication::getDepartmentName, bo.getDepartmentName());
        lqw.like(StringUtils.isNotBlank(bo.getSurgeryName()), MmpMajorSurgeryApplication::getSurgeryName, bo.getSurgeryName());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryReason()), MmpMajorSurgeryApplication::getSurgeryReason, bo.getSurgeryReason());
        lqw.eq(StringUtils.isNotBlank(bo.getSurgeryRisk()), MmpMajorSurgeryApplication::getSurgeryRisk, bo.getSurgeryRisk());
        lqw.eq(bo.getExpectedTime() != null, MmpMajorSurgeryApplication::getExpectedTime, bo.getExpectedTime());
        lqw.eq(StringUtils.isNotBlank(bo.getApplicationStatus()), MmpMajorSurgeryApplication::getApplicationStatus, bo.getApplicationStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getApprovalOpinion()), MmpMajorSurgeryApplication::getApprovalOpinion, bo.getApprovalOpinion());
        lqw.like(StringUtils.isNotBlank(bo.getApproverName()), MmpMajorSurgeryApplication::getApproverName, bo.getApproverName());
        lqw.eq(bo.getApprovalTime() != null, MmpMajorSurgeryApplication::getApprovalTime, bo.getApprovalTime());
        lqw.eq(StringUtils.isNotBlank(bo.getAttachments()), MmpMajorSurgeryApplication::getAttachments, bo.getAttachments());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpMajorSurgeryApplication::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增重大手术申请
     *
     * @param bo 重大手术申请
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpMajorSurgeryApplicationBo bo) {
        MmpMajorSurgeryApplication add = MapstructUtils.convert(bo, MmpMajorSurgeryApplication.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改重大手术申请
     *
     * @param bo 重大手术申请
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpMajorSurgeryApplicationBo bo) {
        MmpMajorSurgeryApplication update = MapstructUtils.convert(bo, MmpMajorSurgeryApplication.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpMajorSurgeryApplication entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除重大手术申请信息
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
