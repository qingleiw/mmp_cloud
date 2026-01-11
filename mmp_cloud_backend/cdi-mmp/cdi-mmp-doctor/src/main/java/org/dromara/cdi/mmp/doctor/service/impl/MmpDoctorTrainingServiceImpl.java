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
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorBasicInfoVo;
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorTrainingBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorTrainingVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorTraining;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorTrainingMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorTrainingService;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorBasicInfoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

/**
 * 培训记录Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorTrainingServiceImpl implements IMmpDoctorTrainingService {

    private final MmpDoctorTrainingMapper baseMapper;

    private final IMmpDoctorBasicInfoService doctorInfoService;

    /**
     * 查询培训记录
     *
     * @param id 主键
     * @return 培训记录
     */
    @Override
    public MmpDoctorTrainingVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询培训记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 培训记录分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorTrainingVo> queryPageList(MmpDoctorTrainingBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorTraining> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorTrainingVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        log.info("Doctor training query returned {} records", result.getRecords().size());
        // 填充医生姓名
        fillDoctorNames(result.getRecords());
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的培训记录列表
     *
     * @param bo 查询条件
     * @return 培训记录列表
     */
    @Override
    public List<MmpDoctorTrainingVo> queryList(MmpDoctorTrainingBo bo) {
        LambdaQueryWrapper<MmpDoctorTraining> lqw = buildQueryWrapper(bo);
        List<MmpDoctorTrainingVo> result = baseMapper.selectVoList(lqw);
        // 填充医生姓名
        fillDoctorNames(result);
        return result;
    }

    private LambdaQueryWrapper<MmpDoctorTraining> buildQueryWrapper(MmpDoctorTrainingBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorTraining> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorTraining::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorTraining::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingType()), MmpDoctorTraining::getTrainingType, bo.getTrainingType());
        lqw.like(StringUtils.isNotBlank(bo.getTrainingName()), MmpDoctorTraining::getTrainingName, bo.getTrainingName());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingUnit()), MmpDoctorTraining::getTrainingUnit, bo.getTrainingUnit());
        lqw.eq(bo.getStartDate() != null, MmpDoctorTraining::getStartDate, bo.getStartDate());
        lqw.eq(bo.getEndDate() != null, MmpDoctorTraining::getEndDate, bo.getEndDate());
        lqw.eq(bo.getTrainingHours() != null, MmpDoctorTraining::getTrainingHours, bo.getTrainingHours());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingContent()), MmpDoctorTraining::getTrainingContent, bo.getTrainingContent());
        lqw.eq(StringUtils.isNotBlank(bo.getTrainingResult()), MmpDoctorTraining::getTrainingResult, bo.getTrainingResult());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateNo()), MmpDoctorTraining::getCertificateNo, bo.getCertificateNo());
        lqw.eq(StringUtils.isNotBlank(bo.getCertificateUrl()), MmpDoctorTraining::getCertificateUrl, bo.getCertificateUrl());
        lqw.eq(bo.getCredits() != null, MmpDoctorTraining::getCredits, bo.getCredits());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorTraining::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增培训记录
     *
     * @param bo 培训记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorTrainingBo bo) {
        MmpDoctorTraining add = MapstructUtils.convert(bo, MmpDoctorTraining.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改培训记录
     *
     * @param bo 培训记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorTrainingBo bo) {
        MmpDoctorTraining update = MapstructUtils.convert(bo, MmpDoctorTraining.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorTraining entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除培训记录信息
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

    /**
     * 填充医生姓名
     *
     * @param trainingList 培训记录列表
     */
    private void fillDoctorNames(List<MmpDoctorTrainingVo> trainingList) {
        if (trainingList == null || trainingList.isEmpty()) {
            log.info("Training list is null or empty, skipping doctor name filling");
            return;
        }

        // 获取所有医生ID
        List<Long> doctorIds = trainingList.stream()
            .map(MmpDoctorTrainingVo::getDoctorId)
            .distinct()
            .filter(id -> id != null)
            .toList();

        log.info("Found {} unique doctor IDs: {}", doctorIds.size(), doctorIds);

        if (doctorIds.isEmpty()) {
            log.info("No valid doctor IDs found, skipping doctor name filling");
            return;
        }

        // 批量查询医生信息 - 通过循环调用queryById
        Map<Long, String> doctorNameMap = new HashMap<>();
        for (Long doctorId : doctorIds) {
            try {
                MmpDoctorBasicInfoVo doctorInfo = doctorInfoService.queryById(doctorId);
                if (doctorInfo != null && doctorInfo.getDoctorName() != null) {
                    doctorNameMap.put(doctorId, doctorInfo.getDoctorName());
                    log.debug("Found doctor name for ID {}: {}", doctorId, doctorInfo.getDoctorName());
                } else {
                    log.warn("Doctor info not found or name is null for ID: {}", doctorId);
                }
            } catch (Exception e) {
                log.error("Failed to query doctor info for ID: {}, error: {}", doctorId, e.getMessage(), e);
            }
        }

        log.info("Successfully mapped {} doctor names out of {} doctor IDs", doctorNameMap.size(), doctorIds.size());

        // 填充医生姓名
        trainingList.forEach(training -> {
            if (training.getDoctorId() != null) {
                String doctorName = doctorNameMap.get(training.getDoctorId());
                training.setDoctorName(doctorName != null ? doctorName : "");
                log.debug("Set doctor name for training record {}: {}", training.getId(), training.getDoctorName());
            } else {
                training.setDoctorName("");
                log.debug("Doctor ID is null for training record {}", training.getId());
            }
        });
    }
}
