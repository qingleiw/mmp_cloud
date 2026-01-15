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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB091InpatientNursingRecordBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB091InpatientNursingRecordVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB091InpatientNursingRecord;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB091InpatientNursingRecordMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB091InpatientNursingRecordService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B09-1 住院护理记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB091InpatientNursingRecordServiceImpl implements IMmpNatdssB091InpatientNursingRecordService {

    private final MmpNatdssB091InpatientNursingRecordMapper baseMapper;

    /**
     * 查询B09-1 住院护理记录
     *
     * @param id 主键
     * @return B09-1 住院护理记录
     */
    @Override
    public MmpNatdssB091InpatientNursingRecordVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B09-1 住院护理记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B09-1 住院护理记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB091InpatientNursingRecordVo> queryPageList(MmpNatdssB091InpatientNursingRecordBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB091InpatientNursingRecord> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB091InpatientNursingRecordVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B09-1 住院护理记录列表
     *
     * @param bo 查询条件
     * @return B09-1 住院护理记录列表
     */
    @Override
    public List<MmpNatdssB091InpatientNursingRecordVo> queryList(MmpNatdssB091InpatientNursingRecordBo bo) {
        LambdaQueryWrapper<MmpNatdssB091InpatientNursingRecord> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB091InpatientNursingRecord> buildQueryWrapper(MmpNatdssB091InpatientNursingRecordBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB091InpatientNursingRecord> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB091InpatientNursingRecord::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB091InpatientNursingRecord::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB091InpatientNursingRecord::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB091InpatientNursingRecord::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getInpatientNo()), MmpNatdssB091InpatientNursingRecord::getInpatientNo, bo.getInpatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB091InpatientNursingRecord::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordSn()), MmpNatdssB091InpatientNursingRecord::getRecordSn, bo.getRecordSn());
        lqw.eq(StringUtils.isNotBlank(bo.getDeptCode()), MmpNatdssB091InpatientNursingRecord::getDeptCode, bo.getDeptCode());
        lqw.like(StringUtils.isNotBlank(bo.getDeptName()), MmpNatdssB091InpatientNursingRecord::getDeptName, bo.getDeptName());
        lqw.eq(StringUtils.isNotBlank(bo.getBedNo()), MmpNatdssB091InpatientNursingRecord::getBedNo, bo.getBedNo());
        lqw.eq(bo.getRecordDatetime() != null, MmpNatdssB091InpatientNursingRecord::getRecordDatetime, bo.getRecordDatetime());
        lqw.eq(bo.getTestDatetime() != null, MmpNatdssB091InpatientNursingRecord::getTestDatetime, bo.getTestDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getTestMethod()), MmpNatdssB091InpatientNursingRecord::getTestMethod, bo.getTestMethod());
        lqw.eq(StringUtils.isNotBlank(bo.getItemCode()), MmpNatdssB091InpatientNursingRecord::getItemCode, bo.getItemCode());
        lqw.like(StringUtils.isNotBlank(bo.getItemName()), MmpNatdssB091InpatientNursingRecord::getItemName, bo.getItemName());
        lqw.eq(StringUtils.isNotBlank(bo.getPainScores()), MmpNatdssB091InpatientNursingRecord::getPainScores, bo.getPainScores());
        lqw.eq(StringUtils.isNotBlank(bo.getItemResultValue1()), MmpNatdssB091InpatientNursingRecord::getItemResultValue1, bo.getItemResultValue1());
        lqw.eq(StringUtils.isNotBlank(bo.getItemResultUnit1()), MmpNatdssB091InpatientNursingRecord::getItemResultUnit1, bo.getItemResultUnit1());
        lqw.eq(StringUtils.isNotBlank(bo.getItemResultValue2()), MmpNatdssB091InpatientNursingRecord::getItemResultValue2, bo.getItemResultValue2());
        lqw.eq(StringUtils.isNotBlank(bo.getItemResultUnit2()), MmpNatdssB091InpatientNursingRecord::getItemResultUnit2, bo.getItemResultUnit2());
        lqw.eq(StringUtils.isNotBlank(bo.getObservationMeasures()), MmpNatdssB091InpatientNursingRecord::getObservationMeasures, bo.getObservationMeasures());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB091InpatientNursingRecord::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB091InpatientNursingRecord::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB091InpatientNursingRecord::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB091InpatientNursingRecord::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB091InpatientNursingRecord::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B09-1 住院护理记录
     *
     * @param bo B09-1 住院护理记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB091InpatientNursingRecordBo bo) {
        MmpNatdssB091InpatientNursingRecord add = MapstructUtils.convert(bo, MmpNatdssB091InpatientNursingRecord.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B09-1 住院护理记录
     *
     * @param bo B09-1 住院护理记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB091InpatientNursingRecordBo bo) {
        MmpNatdssB091InpatientNursingRecord update = MapstructUtils.convert(bo, MmpNatdssB091InpatientNursingRecord.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB091InpatientNursingRecord entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B09-1 住院护理记录信息
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
