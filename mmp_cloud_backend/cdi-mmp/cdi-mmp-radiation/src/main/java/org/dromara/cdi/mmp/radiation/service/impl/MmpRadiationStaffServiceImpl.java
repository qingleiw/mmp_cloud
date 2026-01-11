package org.dromara.cdi.mmp.radiation.service.impl;

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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationStaffBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationStaffVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationStaff;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationStaffMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationStaffService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 放射工作人员Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpRadiationStaffServiceImpl implements IMmpRadiationStaffService {

    private final MmpRadiationStaffMapper baseMapper;

    /**
     * 查询放射工作人员
     *
     * @param id 主键
     * @return 放射工作人员
     */
    @Override
    public MmpRadiationStaffVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询放射工作人员列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 放射工作人员分页列表
     */
    @Override
    public TableDataInfo<MmpRadiationStaffVo> queryPageList(MmpRadiationStaffBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationStaff> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationStaffVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的放射工作人员列表
     *
     * @param bo 查询条件
     * @return 放射工作人员列表
     */
    @Override
    public List<MmpRadiationStaffVo> queryList(MmpRadiationStaffBo bo) {
        LambdaQueryWrapper<MmpRadiationStaff> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationStaff> buildQueryWrapper(MmpRadiationStaffBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationStaff> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationStaff::getId);
        lqw.like(StringUtils.isNotBlank(bo.getUserName()), MmpRadiationStaff::getUserName, bo.getUserName());
        lqw.eq(StringUtils.isNotBlank(bo.getEmployeeCode()), MmpRadiationStaff::getEmployeeCode, bo.getEmployeeCode());
        lqw.like(StringUtils.isNotBlank(bo.getDepartmentName()), MmpRadiationStaff::getDepartmentName, bo.getDepartmentName());
        lqw.eq(StringUtils.isNotBlank(bo.getPosition()), MmpRadiationStaff::getPosition, bo.getPosition());
        lqw.eq(bo.getHireDate() != null, MmpRadiationStaff::getHireDate, bo.getHireDate());
        lqw.eq(bo.getRadiationWorkYears() != null, MmpRadiationStaff::getRadiationWorkYears, bo.getRadiationWorkYears());
        lqw.eq(StringUtils.isNotBlank(bo.getRadiationQualification()), MmpRadiationStaff::getRadiationQualification, bo.getRadiationQualification());
        lqw.eq(StringUtils.isNotBlank(bo.getQualificationCertificate()), MmpRadiationStaff::getQualificationCertificate, bo.getQualificationCertificate());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNumber()), MmpRadiationStaff::getCertificateNumber, bo.getCertificateNumber());
        lqw.eq(bo.getCertificateIssueDate() != null, MmpRadiationStaff::getCertificateIssueDate, bo.getCertificateIssueDate());
        lqw.eq(bo.getCertificateExpiryDate() != null, MmpRadiationStaff::getCertificateExpiryDate, bo.getCertificateExpiryDate());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingRecords()), MmpRadiationStaff::getTrainingRecords, bo.getTrainingRecords());
        lqw.eq(StringUtils.isNotBlank(bo.getHealthExamRecords()), MmpRadiationStaff::getHealthExamRecords, bo.getHealthExamRecords());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpRadiationStaff::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增放射工作人员
     *
     * @param bo 放射工作人员
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationStaffBo bo) {
        MmpRadiationStaff add = MapstructUtils.convert(bo, MmpRadiationStaff.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改放射工作人员
     *
     * @param bo 放射工作人员
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpRadiationStaffBo bo) {
        MmpRadiationStaff update = MapstructUtils.convert(bo, MmpRadiationStaff.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationStaff entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除放射工作人员信息
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
