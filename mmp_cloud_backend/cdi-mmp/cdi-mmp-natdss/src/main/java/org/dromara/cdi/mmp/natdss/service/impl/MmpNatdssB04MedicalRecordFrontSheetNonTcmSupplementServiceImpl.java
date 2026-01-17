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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B04非中医院-补充信息（其他手术+费用+扩展信息）Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementServiceImpl implements IMmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementService {

    private final MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementMapper baseMapper;

    /**
     * 查询B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param patientId 主键
     * @return B04非中医院-补充信息（其他手术+费用+扩展信息）
     */
    @Override
    public MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo queryById(String patientId){
        return baseMapper.selectVoById(patientId);
    }

    /**
     * 分页查询B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B04非中医院-补充信息（其他手术+费用+扩展信息）分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> queryPageList(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     *
     * @param bo 查询条件
     * @return B04非中医院-补充信息（其他手术+费用+扩展信息）列表
     */
    @Override
    public List<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementVo> queryList(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo) {
        LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement> buildQueryWrapper(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getPatientId);
        lqw.orderByAsc(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getVisitSn);
        lqw.eq(StringUtils.isNotBlank(bo.getC35x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x01c, bo.getC35x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x01n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x01n, bo.getC36x01n());
        lqw.eq(bo.getC37x01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x01, bo.getC37x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x01, bo.getC38x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x01, bo.getC39x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x01, bo.getC40x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x01, bo.getC41x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x01c, bo.getC42x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x01c, bo.getC43x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x01, bo.getC44x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x02c, bo.getC35x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x02n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x02n, bo.getC36x02n());
        lqw.eq(bo.getC37x02() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x02, bo.getC37x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x02, bo.getC38x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x02, bo.getC39x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x02, bo.getC40x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x02, bo.getC41x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x02c, bo.getC42x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x02c, bo.getC43x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x02, bo.getC44x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x03c, bo.getC35x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x03n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x03n, bo.getC36x03n());
        lqw.eq(bo.getC37x03() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x03, bo.getC37x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x03, bo.getC38x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x03, bo.getC39x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x03, bo.getC40x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x03, bo.getC41x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x03c, bo.getC42x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x03c, bo.getC43x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x03, bo.getC44x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x04c, bo.getC35x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x04n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x04n, bo.getC36x04n());
        lqw.eq(bo.getC37x04() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x04, bo.getC37x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x04, bo.getC38x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x04, bo.getC39x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x04, bo.getC40x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x04, bo.getC41x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x04c, bo.getC42x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x04c, bo.getC43x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x04, bo.getC44x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x05c, bo.getC35x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x05n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x05n, bo.getC36x05n());
        lqw.eq(bo.getC37x05() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x05, bo.getC37x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x05, bo.getC38x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x05, bo.getC39x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x05, bo.getC40x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x05, bo.getC41x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x05c, bo.getC42x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x05c, bo.getC43x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x05, bo.getC44x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x06c, bo.getC35x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x06n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x06n, bo.getC36x06n());
        lqw.eq(bo.getC37x06() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x06, bo.getC37x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x06, bo.getC38x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x06, bo.getC39x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x06, bo.getC40x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x06, bo.getC41x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x06c, bo.getC42x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x06c, bo.getC43x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x06, bo.getC44x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x07c, bo.getC35x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x07n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x07n, bo.getC36x07n());
        lqw.eq(bo.getC37x07() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x07, bo.getC37x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x07, bo.getC38x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x07, bo.getC39x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x07, bo.getC40x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x07, bo.getC41x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x07c, bo.getC42x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x07c, bo.getC43x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x07, bo.getC44x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x08c, bo.getC35x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x08n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x08n, bo.getC36x08n());
        lqw.eq(bo.getC37x08() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x08, bo.getC37x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x08, bo.getC38x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x08, bo.getC39x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x08, bo.getC40x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x08, bo.getC41x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x08c, bo.getC42x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x08c, bo.getC43x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x08, bo.getC44x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x09c, bo.getC35x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x09n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x09n, bo.getC36x09n());
        lqw.eq(bo.getC37x09() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x09, bo.getC37x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x09, bo.getC38x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x09, bo.getC39x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x09, bo.getC40x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x09, bo.getC41x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x09c, bo.getC42x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x09c, bo.getC43x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x09, bo.getC44x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x10c, bo.getC35x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x10n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x10n, bo.getC36x10n());
        lqw.eq(bo.getC37x10() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x10, bo.getC37x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x10, bo.getC38x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x10, bo.getC39x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x10, bo.getC40x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x10, bo.getC41x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x10c, bo.getC42x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x10c, bo.getC43x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x10, bo.getC44x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x11c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x11c, bo.getC35x11c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x11n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x11n, bo.getC36x11n());
        lqw.eq(bo.getC37x11() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x11, bo.getC37x11());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x11()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x11, bo.getC38x11());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x11()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x11, bo.getC39x11());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x11()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x11, bo.getC40x11());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x11()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x11, bo.getC41x11());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x11c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x11c, bo.getC42x11c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x11c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x11c, bo.getC43x11c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x11()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x11, bo.getC44x11());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x12c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x12c, bo.getC35x12c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x12n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x12n, bo.getC36x12n());
        lqw.eq(bo.getC37x12() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x12, bo.getC37x12());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x12()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x12, bo.getC38x12());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x12()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x12, bo.getC39x12());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x12()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x12, bo.getC40x12());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x12()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x12, bo.getC41x12());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x12c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x12c, bo.getC42x12c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x12c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x12c, bo.getC43x12c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x12()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x12, bo.getC44x12());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x13c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x13c, bo.getC35x13c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x13n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x13n, bo.getC36x13n());
        lqw.eq(bo.getC37x13() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x13, bo.getC37x13());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x13()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x13, bo.getC38x13());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x13()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x13, bo.getC39x13());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x13()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x13, bo.getC40x13());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x13()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x13, bo.getC41x13());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x13c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x13c, bo.getC42x13c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x13c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x13c, bo.getC43x13c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x13()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x13, bo.getC44x13());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x14c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x14c, bo.getC35x14c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x14n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x14n, bo.getC36x14n());
        lqw.eq(bo.getC37x14() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x14, bo.getC37x14());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x14()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x14, bo.getC38x14());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x14()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x14, bo.getC39x14());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x14()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x14, bo.getC40x14());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x14()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x14, bo.getC41x14());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x14c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x14c, bo.getC42x14c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x14c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x14c, bo.getC43x14c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x14()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x14, bo.getC44x14());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x15c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x15c, bo.getC35x15c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x15n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x15n, bo.getC36x15n());
        lqw.eq(bo.getC37x15() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x15, bo.getC37x15());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x15()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x15, bo.getC38x15());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x15()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x15, bo.getC39x15());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x15()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x15, bo.getC40x15());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x15()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x15, bo.getC41x15());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x15c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x15c, bo.getC42x15c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x15c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x15c, bo.getC43x15c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x15()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x15, bo.getC44x15());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x16c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x16c, bo.getC35x16c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x16n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x16n, bo.getC36x16n());
        lqw.eq(bo.getC37x16() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x16, bo.getC37x16());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x16()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x16, bo.getC38x16());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x16()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x16, bo.getC39x16());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x16()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x16, bo.getC40x16());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x16()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x16, bo.getC41x16());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x16c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x16c, bo.getC42x16c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x16c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x16c, bo.getC43x16c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x16()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x16, bo.getC44x16());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x17c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x17c, bo.getC35x17c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x17n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x17n, bo.getC36x17n());
        lqw.eq(bo.getC37x17() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x17, bo.getC37x17());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x17()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x17, bo.getC38x17());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x17()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x17, bo.getC39x17());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x17()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x17, bo.getC40x17());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x17()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x17, bo.getC41x17());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x17c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x17c, bo.getC42x17c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x17c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x17c, bo.getC43x17c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x17()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x17, bo.getC44x17());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x18c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x18c, bo.getC35x18c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x18n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x18n, bo.getC36x18n());
        lqw.eq(bo.getC37x18() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x18, bo.getC37x18());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x18()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x18, bo.getC38x18());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x18()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x18, bo.getC39x18());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x18()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x18, bo.getC40x18());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x18()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x18, bo.getC41x18());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x18c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x18c, bo.getC42x18c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x18c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x18c, bo.getC43x18c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x18()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x18, bo.getC44x18());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x19c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x19c, bo.getC35x19c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x19n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x19n, bo.getC36x19n());
        lqw.eq(bo.getC37x19() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x19, bo.getC37x19());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x19()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x19, bo.getC38x19());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x19()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x19, bo.getC39x19());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x19()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x19, bo.getC40x19());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x19()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x19, bo.getC41x19());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x19c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x19c, bo.getC42x19c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x19c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x19c, bo.getC43x19c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x19()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x19, bo.getC44x19());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x20c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x20c, bo.getC35x20c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x20n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x20n, bo.getC36x20n());
        lqw.eq(bo.getC37x20() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x20, bo.getC37x20());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x20()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x20, bo.getC38x20());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x20()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x20, bo.getC39x20());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x20()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x20, bo.getC40x20());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x20()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x20, bo.getC41x20());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x20c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x20c, bo.getC42x20c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x20c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x20c, bo.getC43x20c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x20()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x20, bo.getC44x20());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x21c, bo.getC35x21c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x21n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x21n, bo.getC36x21n());
        lqw.eq(bo.getC37x21() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x21, bo.getC37x21());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x21()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x21, bo.getC38x21());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x21()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x21, bo.getC39x21());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x21()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x21, bo.getC40x21());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x21()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x21, bo.getC41x21());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x21c, bo.getC42x21c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x21c, bo.getC43x21c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x21()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x21, bo.getC44x21());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x22c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x22c, bo.getC35x22c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x22n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x22n, bo.getC36x22n());
        lqw.eq(bo.getC37x22() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x22, bo.getC37x22());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x22()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x22, bo.getC38x22());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x22()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x22, bo.getC39x22());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x22()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x22, bo.getC40x22());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x22()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x22, bo.getC41x22());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x22c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x22c, bo.getC42x22c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x22c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x22c, bo.getC43x22c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x22()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x22, bo.getC44x22());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x23c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x23c, bo.getC35x23c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x23n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x23n, bo.getC36x23n());
        lqw.eq(bo.getC37x23() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x23, bo.getC37x23());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x23()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x23, bo.getC38x23());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x23()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x23, bo.getC39x23());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x23()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x23, bo.getC40x23());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x23()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x23, bo.getC41x23());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x23c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x23c, bo.getC42x23c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x23c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x23c, bo.getC43x23c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x23()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x23, bo.getC44x23());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x24c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x24c, bo.getC35x24c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x24n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x24n, bo.getC36x24n());
        lqw.eq(bo.getC37x24() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x24, bo.getC37x24());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x24()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x24, bo.getC38x24());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x24()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x24, bo.getC39x24());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x24()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x24, bo.getC40x24());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x24()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x24, bo.getC41x24());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x24c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x24c, bo.getC42x24c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x24c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x24c, bo.getC43x24c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x24()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x24, bo.getC44x24());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x25c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x25c, bo.getC35x25c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x25n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x25n, bo.getC36x25n());
        lqw.eq(bo.getC37x25() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x25, bo.getC37x25());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x25()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x25, bo.getC38x25());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x25()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x25, bo.getC39x25());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x25()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x25, bo.getC40x25());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x25()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x25, bo.getC41x25());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x25c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x25c, bo.getC42x25c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x25c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x25c, bo.getC43x25c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x25()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x25, bo.getC44x25());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x26c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x26c, bo.getC35x26c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x26n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x26n, bo.getC36x26n());
        lqw.eq(bo.getC37x26() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x26, bo.getC37x26());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x26()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x26, bo.getC38x26());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x26()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x26, bo.getC39x26());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x26()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x26, bo.getC40x26());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x26()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x26, bo.getC41x26());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x26c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x26c, bo.getC42x26c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x26c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x26c, bo.getC43x26c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x26()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x26, bo.getC44x26());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x27c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x27c, bo.getC35x27c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x27n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x27n, bo.getC36x27n());
        lqw.eq(bo.getC37x27() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x27, bo.getC37x27());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x27()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x27, bo.getC38x27());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x27()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x27, bo.getC39x27());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x27()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x27, bo.getC40x27());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x27()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x27, bo.getC41x27());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x27c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x27c, bo.getC42x27c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x27c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x27c, bo.getC43x27c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x27()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x27, bo.getC44x27());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x28c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x28c, bo.getC35x28c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x28n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x28n, bo.getC36x28n());
        lqw.eq(bo.getC37x28() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x28, bo.getC37x28());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x28()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x28, bo.getC38x28());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x28()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x28, bo.getC39x28());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x28()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x28, bo.getC40x28());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x28()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x28, bo.getC41x28());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x28c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x28c, bo.getC42x28c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x28c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x28c, bo.getC43x28c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x28()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x28, bo.getC44x28());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x29c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x29c, bo.getC35x29c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x29n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x29n, bo.getC36x29n());
        lqw.eq(bo.getC37x29() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x29, bo.getC37x29());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x29()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x29, bo.getC38x29());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x29()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x29, bo.getC39x29());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x29()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x29, bo.getC40x29());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x29()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x29, bo.getC41x29());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x29c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x29c, bo.getC42x29c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x29c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x29c, bo.getC43x29c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x29()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x29, bo.getC44x29());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x30c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x30c, bo.getC35x30c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x30n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x30n, bo.getC36x30n());
        lqw.eq(bo.getC37x30() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x30, bo.getC37x30());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x30()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x30, bo.getC38x30());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x30()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x30, bo.getC39x30());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x30()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x30, bo.getC40x30());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x30()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x30, bo.getC41x30());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x30c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x30c, bo.getC42x30c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x30c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x30c, bo.getC43x30c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x30()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x30, bo.getC44x30());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x31c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x31c, bo.getC35x31c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x31n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x31n, bo.getC36x31n());
        lqw.eq(bo.getC37x31() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x31, bo.getC37x31());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x31()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x31, bo.getC38x31());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x31()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x31, bo.getC39x31());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x31()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x31, bo.getC40x31());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x31()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x31, bo.getC41x31());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x31c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x31c, bo.getC42x31c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x31c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x31c, bo.getC43x31c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x31()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x31, bo.getC44x31());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x32c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x32c, bo.getC35x32c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x32n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x32n, bo.getC36x32n());
        lqw.eq(bo.getC37x32() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x32, bo.getC37x32());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x32()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x32, bo.getC38x32());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x32()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x32, bo.getC39x32());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x32()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x32, bo.getC40x32());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x32()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x32, bo.getC41x32());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x32c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x32c, bo.getC42x32c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x32c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x32c, bo.getC43x32c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x32()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x32, bo.getC44x32());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x33c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x33c, bo.getC35x33c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x33n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x33n, bo.getC36x33n());
        lqw.eq(bo.getC37x33() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x33, bo.getC37x33());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x33()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x33, bo.getC38x33());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x33()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x33, bo.getC39x33());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x33()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x33, bo.getC40x33());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x33()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x33, bo.getC41x33());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x33c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x33c, bo.getC42x33c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x33c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x33c, bo.getC43x33c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x33()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x33, bo.getC44x33());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x34c, bo.getC35x34c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x34n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x34n, bo.getC36x34n());
        lqw.eq(bo.getC37x34() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x34, bo.getC37x34());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x34()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x34, bo.getC38x34());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x34()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x34, bo.getC39x34());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x34()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x34, bo.getC40x34());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x34()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x34, bo.getC41x34());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x34c, bo.getC42x34c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x34c, bo.getC43x34c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x34()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x34, bo.getC44x34());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x35c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x35c, bo.getC35x35c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x35n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x35n, bo.getC36x35n());
        lqw.eq(bo.getC37x35() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x35, bo.getC37x35());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x35()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x35, bo.getC38x35());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x35()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x35, bo.getC39x35());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x35()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x35, bo.getC40x35());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x35()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x35, bo.getC41x35());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x35c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x35c, bo.getC42x35c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x35c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x35c, bo.getC43x35c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x35()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x35, bo.getC44x35());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x36c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x36c, bo.getC35x36c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x36n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x36n, bo.getC36x36n());
        lqw.eq(bo.getC37x36() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x36, bo.getC37x36());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x36()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x36, bo.getC38x36());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x36()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x36, bo.getC39x36());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x36()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x36, bo.getC40x36());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x36()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x36, bo.getC41x36());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x36c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x36c, bo.getC42x36c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x36c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x36c, bo.getC43x36c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x36()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x36, bo.getC44x36());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x37c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x37c, bo.getC35x37c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x37n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x37n, bo.getC36x37n());
        lqw.eq(bo.getC37x37() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x37, bo.getC37x37());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x37()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x37, bo.getC38x37());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x37()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x37, bo.getC39x37());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x37()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x37, bo.getC40x37());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x37()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x37, bo.getC41x37());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x37c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x37c, bo.getC42x37c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x37c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x37c, bo.getC43x37c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x37()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x37, bo.getC44x37());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x38c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x38c, bo.getC35x38c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x38n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x38n, bo.getC36x38n());
        lqw.eq(bo.getC37x38() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x38, bo.getC37x38());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x38()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x38, bo.getC38x38());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x38()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x38, bo.getC39x38());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x38()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x38, bo.getC40x38());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x38()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x38, bo.getC41x38());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x38c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x38c, bo.getC42x38c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x38c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x38c, bo.getC43x38c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x38()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x38, bo.getC44x38());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x39c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x39c, bo.getC35x39c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x39n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x39n, bo.getC36x39n());
        lqw.eq(bo.getC37x39() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x39, bo.getC37x39());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x39()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x39, bo.getC38x39());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x39()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x39, bo.getC39x39());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x39()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x39, bo.getC40x39());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x39()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x39, bo.getC41x39());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x39c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x39c, bo.getC42x39c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x39c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x39c, bo.getC43x39c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x39()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x39, bo.getC44x39());
        lqw.eq(StringUtils.isNotBlank(bo.getC35x40c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC35x40c, bo.getC35x40c());
        lqw.eq(StringUtils.isNotBlank(bo.getC36x40n()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC36x40n, bo.getC36x40n());
        lqw.eq(bo.getC37x40() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC37x40, bo.getC37x40());
        lqw.eq(StringUtils.isNotBlank(bo.getC38x40()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC38x40, bo.getC38x40());
        lqw.eq(StringUtils.isNotBlank(bo.getC39x40()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC39x40, bo.getC39x40());
        lqw.eq(StringUtils.isNotBlank(bo.getC40x40()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC40x40, bo.getC40x40());
        lqw.eq(StringUtils.isNotBlank(bo.getC41x40()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC41x40, bo.getC41x40());
        lqw.eq(StringUtils.isNotBlank(bo.getC42x40c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC42x40c, bo.getC42x40c());
        lqw.eq(StringUtils.isNotBlank(bo.getC43x40c()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC43x40c, bo.getC43x40c());
        lqw.eq(StringUtils.isNotBlank(bo.getC44x40()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getC44x40, bo.getC44x40());
        lqw.eq(bo.getD01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD01, bo.getD01());
        lqw.eq(bo.getD09() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD09, bo.getD09());
        lqw.eq(bo.getD11() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD11, bo.getD11());
        lqw.eq(bo.getD12() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD12, bo.getD12());
        lqw.eq(bo.getD13() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD13, bo.getD13());
        lqw.eq(bo.getD14() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD14, bo.getD14());
        lqw.eq(bo.getD15() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD15, bo.getD15());
        lqw.eq(bo.getD16() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD16, bo.getD16());
        lqw.eq(bo.getD17() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD17, bo.getD17());
        lqw.eq(bo.getD18() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD18, bo.getD18());
        lqw.eq(bo.getD19() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD19, bo.getD19());
        lqw.eq(bo.getD19x01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD19x01, bo.getD19x01());
        lqw.eq(bo.getD20() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD20, bo.getD20());
        lqw.eq(bo.getD20x01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD20x01, bo.getD20x01());
        lqw.eq(bo.getD20x02() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD20x02, bo.getD20x02());
        lqw.eq(bo.getD21() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD21, bo.getD21());
        lqw.eq(bo.getD22() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD22, bo.getD22());
        lqw.eq(bo.getD23() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD23, bo.getD23());
        lqw.eq(bo.getD23x01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD23x01, bo.getD23x01());
        lqw.eq(bo.getD24() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD24, bo.getD24());
        lqw.eq(bo.getD25() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD25, bo.getD25());
        lqw.eq(bo.getD26() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD26, bo.getD26());
        lqw.eq(bo.getD27() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD27, bo.getD27());
        lqw.eq(bo.getD28() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD28, bo.getD28());
        lqw.eq(bo.getD29() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD29, bo.getD29());
        lqw.eq(bo.getD30() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD30, bo.getD30());
        lqw.eq(bo.getD31() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD31, bo.getD31());
        lqw.eq(bo.getD32() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD32, bo.getD32());
        lqw.eq(bo.getD33() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD33, bo.getD33());
        lqw.eq(bo.getD34() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getD34, bo.getD34());
        lqw.eq(StringUtils.isNotBlank(bo.getE01()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE01, bo.getE01());
        lqw.eq(StringUtils.isNotBlank(bo.getE02()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE02, bo.getE02());
        lqw.eq(StringUtils.isNotBlank(bo.getE03()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE03, bo.getE03());
        lqw.eq(StringUtils.isNotBlank(bo.getE04()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE04, bo.getE04());
        lqw.eq(bo.getE05() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE05, bo.getE05());
        lqw.eq(bo.getE06() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE06, bo.getE06());
        lqw.eq(bo.getE07() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE07, bo.getE07());
        lqw.eq(StringUtils.isNotBlank(bo.getE08()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE08, bo.getE08());
        lqw.eq(bo.getE09() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE09, bo.getE09());
        lqw.eq(StringUtils.isNotBlank(bo.getE10()), MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement::getE10, bo.getE10());
        return lqw;
    }

    /**
     * 新增B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param bo B04非中医院-补充信息（其他手术+费用+扩展信息）
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo) {
        MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement add = MapstructUtils.convert(bo, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setPatientId(add.getPatientId());
        }
        return flag;
    }

    /**
     * 修改B04非中医院-补充信息（其他手术+费用+扩展信息）
     *
     * @param bo B04非中医院-补充信息（其他手术+费用+扩展信息）
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo bo) {
        MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement update = MapstructUtils.convert(bo, MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B04非中医院-补充信息（其他手术+费用+扩展信息）信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<String> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
