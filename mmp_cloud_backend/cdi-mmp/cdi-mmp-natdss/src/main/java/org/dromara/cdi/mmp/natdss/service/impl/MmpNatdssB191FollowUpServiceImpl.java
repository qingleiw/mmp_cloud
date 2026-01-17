package org.dromara.cdi.mmp.natdss.service.impl;

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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB191FollowUpBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB191FollowUpVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB191FollowUp;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB191FollowUpMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB191FollowUpService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B19-1 随访记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB191FollowUpServiceImpl implements IMmpNatdssB191FollowUpService {

    private final MmpNatdssB191FollowUpMapper baseMapper;

    /**
     * 查询B19-1 随访记录
     *
     * @param id 主键
     * @return B19-1 随访记录
     */
    @Override
    public MmpNatdssB191FollowUpVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B19-1 随访记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B19-1 随访记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB191FollowUpVo> queryPageList(MmpNatdssB191FollowUpBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB191FollowUp> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB191FollowUpVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B19-1 随访记录列表
     *
     * @param bo 查询条件
     * @return B19-1 随访记录列表
     */
    @Override
    public List<MmpNatdssB191FollowUpVo> queryList(MmpNatdssB191FollowUpBo bo) {
        LambdaQueryWrapper<MmpNatdssB191FollowUp> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB191FollowUp> buildQueryWrapper(MmpNatdssB191FollowUpBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB191FollowUp> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB191FollowUp::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB191FollowUp::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB191FollowUp::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitType()), MmpNatdssB191FollowUp::getVisitType, bo.getVisitType());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitCardNo()), MmpNatdssB191FollowUp::getVisitCardNo, bo.getVisitCardNo());
        lqw.eq(StringUtils.isNotBlank(bo.getOutpatientNo()), MmpNatdssB191FollowUp::getOutpatientNo, bo.getOutpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB191FollowUp::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB191FollowUp::getInpatientNo, bo.getInpatientNo());
        lqw.like(StringUtils.isNotBlank(bo.getName()), MmpNatdssB191FollowUp::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getGender()), MmpNatdssB191FollowUp::getGender, bo.getGender());
        lqw.eq(bo.getAge() != null, MmpNatdssB191FollowUp::getAge, bo.getAge());
        lqw.eq(bo.getDateOfBirth() != null, MmpNatdssB191FollowUp::getDateOfBirth, bo.getDateOfBirth());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowupSn()), MmpNatdssB191FollowUp::getFollowupSn, bo.getFollowupSn());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowupMethod()), MmpNatdssB191FollowUp::getFollowupMethod, bo.getFollowupMethod());
        lqw.eq(bo.getFirstTreatAge() != null, MmpNatdssB191FollowUp::getFirstTreatAge, bo.getFirstTreatAge());
        lqw.eq(bo.getFirstTreatDatetime() != null, MmpNatdssB191FollowUp::getFirstTreatDatetime, bo.getFirstTreatDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowupPeriod()), MmpNatdssB191FollowUp::getFollowupPeriod, bo.getFollowupPeriod());
        lqw.eq(bo.getFollowupDatetime() != null, MmpNatdssB191FollowUp::getFollowupDatetime, bo.getFollowupDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowupStatusCode()), MmpNatdssB191FollowUp::getFollowupStatusCode, bo.getFollowupStatusCode());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowupStatus()), MmpNatdssB191FollowUp::getFollowupStatus, bo.getFollowupStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getHealthStatus()), MmpNatdssB191FollowUp::getHealthStatus, bo.getHealthStatus());
        lqw.eq(bo.getDeathDatetime() != null, MmpNatdssB191FollowUp::getDeathDatetime, bo.getDeathDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getCauseOfDeath()), MmpNatdssB191FollowUp::getCauseOfDeath, bo.getCauseOfDeath());
        lqw.eq(bo.getRecurDatetime() != null, MmpNatdssB191FollowUp::getRecurDatetime, bo.getRecurDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getRecurDiagCode()), MmpNatdssB191FollowUp::getRecurDiagCode, bo.getRecurDiagCode());
        lqw.like(StringUtils.isNotBlank(bo.getRecurDiagName()), MmpNatdssB191FollowUp::getRecurDiagName, bo.getRecurDiagName());
        lqw.eq(bo.getFirstRecurMetsDate() != null, MmpNatdssB191FollowUp::getFirstRecurMetsDate, bo.getFirstRecurMetsDate());
        lqw.eq(bo.getMetsDatetime() != null, MmpNatdssB191FollowUp::getMetsDatetime, bo.getMetsDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getMetsSite()), MmpNatdssB191FollowUp::getMetsSite, bo.getMetsSite());
        lqw.eq(StringUtils.isNotBlank(bo.getMetsDiagCode()), MmpNatdssB191FollowUp::getMetsDiagCode, bo.getMetsDiagCode());
        lqw.like(StringUtils.isNotBlank(bo.getMetsDiagName()), MmpNatdssB191FollowUp::getMetsDiagName, bo.getMetsDiagName());
        lqw.eq(StringUtils.isNotBlank(bo.getMulpriDiagCode()), MmpNatdssB191FollowUp::getMulpriDiagCode, bo.getMulpriDiagCode());
        lqw.like(StringUtils.isNotBlank(bo.getMulpriDiagName()), MmpNatdssB191FollowUp::getMulpriDiagName, bo.getMulpriDiagName());
        lqw.eq(StringUtils.isNotBlank(bo.getFollowupConclusion()), MmpNatdssB191FollowUp::getFollowupConclusion, bo.getFollowupConclusion());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateType()), MmpNatdssB191FollowUp::getCertificateType, bo.getCertificateType());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNo()), MmpNatdssB191FollowUp::getCertificateNo, bo.getCertificateNo());
        lqw.eq(StringUtils.isNotBlank(bo.getCurrentAddress()), MmpNatdssB191FollowUp::getCurrentAddress, bo.getCurrentAddress());
        lqw.eq(StringUtils.isNotBlank(bo.getPhoneNo()), MmpNatdssB191FollowUp::getPhoneNo, bo.getPhoneNo());
        lqw.eq(StringUtils.isNotBlank(bo.getPhoneNo2()), MmpNatdssB191FollowUp::getPhoneNo2, bo.getPhoneNo2());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), MmpNatdssB191FollowUp::getEmail, bo.getEmail());
        lqw.eq(StringUtils.isNotBlank(bo.getWeixin()), MmpNatdssB191FollowUp::getWeixin, bo.getWeixin());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson1()), MmpNatdssB191FollowUp::getContactPerson1, bo.getContactPerson1());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPhoneNo1()), MmpNatdssB191FollowUp::getContactPhoneNo1, bo.getContactPhoneNo1());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPerson2()), MmpNatdssB191FollowUp::getContactPerson2, bo.getContactPerson2());
        lqw.eq(StringUtils.isNotBlank(bo.getContactPhoneNo2()), MmpNatdssB191FollowUp::getContactPhoneNo2, bo.getContactPhoneNo2());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB191FollowUp::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB191FollowUp::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB191FollowUp::getRecordStatus, bo.getRecordStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getAdverseReaction()), MmpNatdssB191FollowUp::getAdverseReaction, bo.getAdverseReaction());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB191FollowUp::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB191FollowUp::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B19-1 随访记录
     *
     * @param bo B19-1 随访记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB191FollowUpBo bo) {
        MmpNatdssB191FollowUp add = MapstructUtils.convert(bo, MmpNatdssB191FollowUp.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B19-1 随访记录
     *
     * @param bo B19-1 随访记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB191FollowUpBo bo) {
        MmpNatdssB191FollowUp update = MapstructUtils.convert(bo, MmpNatdssB191FollowUp.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB191FollowUp entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B19-1 随访记录信息
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
