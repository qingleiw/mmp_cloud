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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB061EmrProgressNotesBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB061EmrProgressNotesVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB061EmrProgressNotes;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB061EmrProgressNotesMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB061EmrProgressNotesService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B06-1 病程记录Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB061EmrProgressNotesServiceImpl implements IMmpNatdssB061EmrProgressNotesService {

    private final MmpNatdssB061EmrProgressNotesMapper baseMapper;

    /**
     * 查询B06-1 病程记录
     *
     * @param id 主键
     * @return B06-1 病程记录
     */
    @Override
    public MmpNatdssB061EmrProgressNotesVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询B06-1 病程记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B06-1 病程记录分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB061EmrProgressNotesVo> queryPageList(MmpNatdssB061EmrProgressNotesBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB061EmrProgressNotes> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB061EmrProgressNotesVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B06-1 病程记录列表
     *
     * @param bo 查询条件
     * @return B06-1 病程记录列表
     */
    @Override
    public List<MmpNatdssB061EmrProgressNotesVo> queryList(MmpNatdssB061EmrProgressNotesBo bo) {
        LambdaQueryWrapper<MmpNatdssB061EmrProgressNotes> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB061EmrProgressNotes> buildQueryWrapper(MmpNatdssB061EmrProgressNotesBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB061EmrProgressNotes> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB061EmrProgressNotes::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getPatientId()), MmpNatdssB061EmrProgressNotes::getPatientId, bo.getPatientId());
        lqw.eq(StringUtils.isNotBlank(bo.getVisitSn()), MmpNatdssB061EmrProgressNotes::getVisitSn, bo.getVisitSn());
        lqw.eq(StringUtils.isNotBlank(bo.getMedicalRecordNo()), MmpNatdssB061EmrProgressNotes::getMedicalRecordNo, bo.getMedicalRecordNo());
        lqw.eq(StringUtils.isNotBlank(bo.getPatientNo()), MmpNatdssB061EmrProgressNotes::getPatientNo, bo.getPatientNo());
        lqw.eq(StringUtils.isNotBlank(bo.getHospitalizationTimes()), MmpNatdssB061EmrProgressNotes::getHospitalizationTimes, bo.getHospitalizationTimes());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordSn()), MmpNatdssB061EmrProgressNotes::getRecordSn, bo.getRecordSn());
        lqw.eq(bo.getRecordDatetime() != null, MmpNatdssB061EmrProgressNotes::getRecordDatetime, bo.getRecordDatetime());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordTitleCode()), MmpNatdssB061EmrProgressNotes::getRecordTitleCode, bo.getRecordTitleCode());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordTitle()), MmpNatdssB061EmrProgressNotes::getRecordTitle, bo.getRecordTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordContent()), MmpNatdssB061EmrProgressNotes::getRecordContent, bo.getRecordContent());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData1()), MmpNatdssB061EmrProgressNotes::getExtendData1, bo.getExtendData1());
        lqw.eq(StringUtils.isNotBlank(bo.getExtendData2()), MmpNatdssB061EmrProgressNotes::getExtendData2, bo.getExtendData2());
        lqw.eq(bo.getRecordStatus() != null, MmpNatdssB061EmrProgressNotes::getRecordStatus, bo.getRecordStatus());
        lqw.eq(bo.getCreatedTime() != null, MmpNatdssB061EmrProgressNotes::getCreatedTime, bo.getCreatedTime());
        lqw.eq(bo.getUpdatedTime() != null, MmpNatdssB061EmrProgressNotes::getUpdatedTime, bo.getUpdatedTime());
        return lqw;
    }

    /**
     * 新增B06-1 病程记录
     *
     * @param bo B06-1 病程记录
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB061EmrProgressNotesBo bo) {
        MmpNatdssB061EmrProgressNotes add = MapstructUtils.convert(bo, MmpNatdssB061EmrProgressNotes.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改B06-1 病程记录
     *
     * @param bo B06-1 病程记录
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB061EmrProgressNotesBo bo) {
        MmpNatdssB061EmrProgressNotes update = MapstructUtils.convert(bo, MmpNatdssB061EmrProgressNotes.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB061EmrProgressNotes entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B06-1 病程记录信息
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
