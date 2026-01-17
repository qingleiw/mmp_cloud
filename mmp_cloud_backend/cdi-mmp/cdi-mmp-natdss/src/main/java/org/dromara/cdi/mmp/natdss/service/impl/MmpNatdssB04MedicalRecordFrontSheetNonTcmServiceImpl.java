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
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB04MedicalRecordFrontSheetNonTcmBo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB04MedicalRecordFrontSheetNonTcmVo;
import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB04MedicalRecordFrontSheetNonTcm;
import org.dromara.cdi.mmp.natdss.mapper.MmpNatdssB04MedicalRecordFrontSheetNonTcmMapper;
import org.dromara.cdi.mmp.natdss.service.IMmpNatdssB04MedicalRecordFrontSheetNonTcmService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * B04病历首页-核心信息-非中医院（基础+诊断+主要手术）Service业务层处理
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNatdssB04MedicalRecordFrontSheetNonTcmServiceImpl implements IMmpNatdssB04MedicalRecordFrontSheetNonTcmService {

    private final MmpNatdssB04MedicalRecordFrontSheetNonTcmMapper baseMapper;

    /**
     * 查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param patientId 主键
     * @return B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     */
    @Override
    public MmpNatdssB04MedicalRecordFrontSheetNonTcmVo queryById(String patientId){
        return baseMapper.selectVoById(patientId);
    }

    /**
     * 分页查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B04病历首页-核心信息-非中医院（基础+诊断+主要手术）分页列表
     */
    @Override
    public TableDataInfo<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> queryPageList(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcm> lqw = buildQueryWrapper(bo);
        Page<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     *
     * @param bo 查询条件
     * @return B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
     */
    @Override
    public List<MmpNatdssB04MedicalRecordFrontSheetNonTcmVo> queryList(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo) {
        LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcm> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcm> buildQueryWrapper(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNatdssB04MedicalRecordFrontSheetNonTcm> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNatdssB04MedicalRecordFrontSheetNonTcm::getPatientId);
        lqw.orderByAsc(MmpNatdssB04MedicalRecordFrontSheetNonTcm::getVisitSn);
        lqw.eq(StringUtils.isNotBlank(bo.getA01()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA01, bo.getA01());
        lqw.eq(StringUtils.isNotBlank(bo.getA02()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA02, bo.getA02());
        lqw.eq(StringUtils.isNotBlank(bo.getA48()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA48, bo.getA48());
        lqw.eq(bo.getA49() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA49, bo.getA49());
        lqw.eq(bo.getB12() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB12, bo.getB12());
        lqw.eq(bo.getB15() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB15, bo.getB15());
        lqw.eq(StringUtils.isNotBlank(bo.getA47()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA47, bo.getA47());
        lqw.eq(StringUtils.isNotBlank(bo.getA46c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA46c, bo.getA46c());
        lqw.eq(StringUtils.isNotBlank(bo.getA11()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA11, bo.getA11());
        lqw.eq(bo.getA12c() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA12c, bo.getA12c());
        lqw.eq(bo.getA13() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA13, bo.getA13());
        lqw.eq(bo.getA14() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA14, bo.getA14());
        lqw.eq(StringUtils.isNotBlank(bo.getA15c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA15c, bo.getA15c());
        lqw.eq(StringUtils.isNotBlank(bo.getA21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA21c, bo.getA21c());
        lqw.eq(StringUtils.isNotBlank(bo.getA38c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA38c, bo.getA38c());
        lqw.eq(StringUtils.isNotBlank(bo.getA19c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA19c, bo.getA19c());
        lqw.eq(StringUtils.isNotBlank(bo.getA20()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA20, bo.getA20());
        lqw.eq(StringUtils.isNotBlank(bo.getA22()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA22, bo.getA22());
        lqw.eq(StringUtils.isNotBlank(bo.getA23c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA23c, bo.getA23c());
        lqw.eq(StringUtils.isNotBlank(bo.getA24()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA24, bo.getA24());
        lqw.eq(StringUtils.isNotBlank(bo.getA25c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA25c, bo.getA25c());
        lqw.eq(StringUtils.isNotBlank(bo.getA26()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA26, bo.getA26());
        lqw.eq(StringUtils.isNotBlank(bo.getA27()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA27, bo.getA27());
        lqw.eq(StringUtils.isNotBlank(bo.getA28c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA28c, bo.getA28c());
        lqw.eq(StringUtils.isNotBlank(bo.getA29()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA29, bo.getA29());
        lqw.eq(StringUtils.isNotBlank(bo.getA30()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA30, bo.getA30());
        lqw.eq(StringUtils.isNotBlank(bo.getA31c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA31c, bo.getA31c());
        lqw.eq(StringUtils.isNotBlank(bo.getA32()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA32, bo.getA32());
        lqw.eq(StringUtils.isNotBlank(bo.getA33c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA33c, bo.getA33c());
        lqw.eq(StringUtils.isNotBlank(bo.getA34()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA34, bo.getA34());
        lqw.eq(StringUtils.isNotBlank(bo.getA35()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA35, bo.getA35());
        lqw.eq(StringUtils.isNotBlank(bo.getB11c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB11c, bo.getB11c());
        lqw.eq(StringUtils.isNotBlank(bo.getB13c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB13c, bo.getB13c());
        lqw.eq(StringUtils.isNotBlank(bo.getB14()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB14, bo.getB14());
        lqw.eq(StringUtils.isNotBlank(bo.getB21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB21c, bo.getB21c());
        lqw.eq(StringUtils.isNotBlank(bo.getB16c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB16c, bo.getB16c());
        lqw.eq(StringUtils.isNotBlank(bo.getB17()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB17, bo.getB17());
        lqw.eq(bo.getB20() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB20, bo.getB20());
        lqw.eq(StringUtils.isNotBlank(bo.getC01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC01c, bo.getC01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC02n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC02n, bo.getC02n());
        lqw.eq(StringUtils.isNotBlank(bo.getC03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC03c, bo.getC03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC04n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC04n, bo.getC04n());
        lqw.eq(StringUtils.isNotBlank(bo.getC05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC05c, bo.getC05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x01c, bo.getC06x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x01n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x01n, bo.getC07x01n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x01c, bo.getC08x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x02c, bo.getC06x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x02n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x02n, bo.getC07x02n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x02c, bo.getC08x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x03c, bo.getC06x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x03n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x03n, bo.getC07x03n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x03c, bo.getC08x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x04c, bo.getC06x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x04n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x04n, bo.getC07x04n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x04c, bo.getC08x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x05c, bo.getC06x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x05n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x05n, bo.getC07x05n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x05c, bo.getC08x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x06c, bo.getC06x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x06n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x06n, bo.getC07x06n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x06c, bo.getC08x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x07c, bo.getC06x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x07n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x07n, bo.getC07x07n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x07c, bo.getC08x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x08c, bo.getC06x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x08n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x08n, bo.getC07x08n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x08c, bo.getC08x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x09c, bo.getC06x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x09n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x09n, bo.getC07x09n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x09c, bo.getC08x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x10c, bo.getC06x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x10n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x10n, bo.getC07x10n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x10c, bo.getC08x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x11c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x11c, bo.getC06x11c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x11n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x11n, bo.getC07x11n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x11c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x11c, bo.getC08x11c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x12c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x12c, bo.getC06x12c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x12n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x12n, bo.getC07x12n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x12c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x12c, bo.getC08x12c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x13c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x13c, bo.getC06x13c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x13n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x13n, bo.getC07x13n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x13c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x13c, bo.getC08x13c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x14c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x14c, bo.getC06x14c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x14n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x14n, bo.getC07x14n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x14c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x14c, bo.getC08x14c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x15c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x15c, bo.getC06x15c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x15n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x15n, bo.getC07x15n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x15c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x15c, bo.getC08x15c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x16c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x16c, bo.getC06x16c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x16n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x16n, bo.getC07x16n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x16c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x16c, bo.getC08x16c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x17c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x17c, bo.getC06x17c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x17n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x17n, bo.getC07x17n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x17c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x17c, bo.getC08x17c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x18c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x18c, bo.getC06x18c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x18n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x18n, bo.getC07x18n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x18c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x18c, bo.getC08x18c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x19c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x19c, bo.getC06x19c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x19n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x19n, bo.getC07x19n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x19c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x19c, bo.getC08x19c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x20c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x20c, bo.getC06x20c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x20n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x20n, bo.getC07x20n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x20c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x20c, bo.getC08x20c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x21c, bo.getC06x21c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x21n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x21n, bo.getC07x21n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x21c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x21c, bo.getC08x21c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x22c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x22c, bo.getC06x22c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x22n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x22n, bo.getC07x22n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x22c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x22c, bo.getC08x22c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x23c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x23c, bo.getC06x23c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x23n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x23n, bo.getC07x23n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x23c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x23c, bo.getC08x23c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x24c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x24c, bo.getC06x24c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x24n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x24n, bo.getC07x24n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x24c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x24c, bo.getC08x24c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x25c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x25c, bo.getC06x25c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x25n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x25n, bo.getC07x25n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x25c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x25c, bo.getC08x25c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x26c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x26c, bo.getC06x26c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x26n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x26n, bo.getC07x26n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x26c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x26c, bo.getC08x26c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x27c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x27c, bo.getC06x27c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x27n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x27n, bo.getC07x27n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x27c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x27c, bo.getC08x27c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x28c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x28c, bo.getC06x28c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x28n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x28n, bo.getC07x28n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x28c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x28c, bo.getC08x28c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x29c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x29c, bo.getC06x29c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x29n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x29n, bo.getC07x29n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x29c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x29c, bo.getC08x29c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x30c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x30c, bo.getC06x30c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x30n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x30n, bo.getC07x30n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x30c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x30c, bo.getC08x30c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x31c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x31c, bo.getC06x31c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x31n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x31n, bo.getC07x31n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x31c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x31c, bo.getC08x31c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x32c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x32c, bo.getC06x32c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x32n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x32n, bo.getC07x32n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x32c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x32c, bo.getC08x32c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x33c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x33c, bo.getC06x33c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x33n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x33n, bo.getC07x33n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x33c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x33c, bo.getC08x33c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x34c, bo.getC06x34c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x34n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x34n, bo.getC07x34n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x34c, bo.getC08x34c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x35c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x35c, bo.getC06x35c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x35n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x35n, bo.getC07x35n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x35c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x35c, bo.getC08x35c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x36c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x36c, bo.getC06x36c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x36n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x36n, bo.getC07x36n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x36c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x36c, bo.getC08x36c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x37c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x37c, bo.getC06x37c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x37n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x37n, bo.getC07x37n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x37c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x37c, bo.getC08x37c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x38c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x38c, bo.getC06x38c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x38n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x38n, bo.getC07x38n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x38c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x38c, bo.getC08x38c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x39c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x39c, bo.getC06x39c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x39n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x39n, bo.getC07x39n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x39c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x39c, bo.getC08x39c());
        lqw.eq(StringUtils.isNotBlank(bo.getC06x40c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC06x40c, bo.getC06x40c());
        lqw.eq(StringUtils.isNotBlank(bo.getC07x40n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC07x40n, bo.getC07x40n());
        lqw.eq(StringUtils.isNotBlank(bo.getC08x40c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC08x40c, bo.getC08x40c());
        lqw.eq(StringUtils.isNotBlank(bo.getC09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC09c, bo.getC09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC10n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC10n, bo.getC10n());
        lqw.eq(StringUtils.isNotBlank(bo.getC11()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC11, bo.getC11());
        lqw.eq(StringUtils.isNotBlank(bo.getC12c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC12c, bo.getC12c());
        lqw.eq(StringUtils.isNotBlank(bo.getC13n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC13n, bo.getC13n());
        lqw.eq(StringUtils.isNotBlank(bo.getC24c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC24c, bo.getC24c());
        lqw.eq(StringUtils.isNotBlank(bo.getC25()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC25, bo.getC25());
        lqw.eq(StringUtils.isNotBlank(bo.getC26c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC26c, bo.getC26c());
        lqw.eq(StringUtils.isNotBlank(bo.getC27c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC27c, bo.getC27c());
        lqw.eq(StringUtils.isNotBlank(bo.getC34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC34c, bo.getC34c());
        lqw.eq(StringUtils.isNotBlank(bo.getB22()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB22, bo.getB22());
        lqw.eq(StringUtils.isNotBlank(bo.getB23()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB23, bo.getB23());
        lqw.eq(StringUtils.isNotBlank(bo.getB24()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB24, bo.getB24());
        lqw.eq(StringUtils.isNotBlank(bo.getB25()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB25, bo.getB25());
        lqw.eq(StringUtils.isNotBlank(bo.getB26()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB26, bo.getB26());
        lqw.eq(StringUtils.isNotBlank(bo.getB27()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB27, bo.getB27());
        lqw.eq(StringUtils.isNotBlank(bo.getB28()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB28, bo.getB28());
        lqw.eq(StringUtils.isNotBlank(bo.getB29()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB29, bo.getB29());
        lqw.eq(StringUtils.isNotBlank(bo.getB30c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB30c, bo.getB30c());
        lqw.eq(StringUtils.isNotBlank(bo.getB31()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB31, bo.getB31());
        lqw.eq(StringUtils.isNotBlank(bo.getB32()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB32, bo.getB32());
        lqw.eq(bo.getB33() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB33, bo.getB33());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x01c, bo.getC14x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x01n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x01n, bo.getC15x01n());
        lqw.eq(bo.getC16x01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x01, bo.getC16x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x01, bo.getC17x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x01, bo.getC18x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x01, bo.getC19x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x01, bo.getC20x01());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x01c, bo.getC21x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x01c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x01c, bo.getC22x01c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x01()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x01, bo.getC23x01());
        lqw.eq(bo.getA16() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA16, bo.getA16());
        lqw.eq(bo.getA18x01() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA18x01, bo.getA18x01());
        lqw.eq(bo.getA18x02() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA18x02, bo.getA18x02());
        lqw.eq(bo.getA18x03() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA18x03, bo.getA18x03());
        lqw.eq(bo.getA18x04() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA18x04, bo.getA18x04());
        lqw.eq(bo.getA18x05() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA18x05, bo.getA18x05());
        lqw.eq(bo.getA17() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getA17, bo.getA17());
        lqw.eq(bo.getC28() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC28, bo.getC28());
        lqw.eq(bo.getC29() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC29, bo.getC29());
        lqw.eq(bo.getC30() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC30, bo.getC30());
        lqw.eq(bo.getC31() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC31, bo.getC31());
        lqw.eq(bo.getC32() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC32, bo.getC32());
        lqw.eq(bo.getC33() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC33, bo.getC33());
        lqw.eq(bo.getB36c() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB36c, bo.getB36c());
        lqw.eq(StringUtils.isNotBlank(bo.getB37()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB37, bo.getB37());
        lqw.eq(StringUtils.isNotBlank(bo.getB34c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB34c, bo.getB34c());
        lqw.eq(StringUtils.isNotBlank(bo.getB35()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getB35, bo.getB35());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x02c, bo.getC14x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x02n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x02n, bo.getC15x02n());
        lqw.eq(bo.getC16x02() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x02, bo.getC16x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x02, bo.getC17x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x02, bo.getC18x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x02, bo.getC19x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x02, bo.getC20x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x02c, bo.getC21x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x02c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x02c, bo.getC22x02c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x02()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x02, bo.getC23x02());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x03c, bo.getC14x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x03n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x03n, bo.getC15x03n());
        lqw.eq(bo.getC16x03() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x03, bo.getC16x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x03, bo.getC17x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x03, bo.getC18x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x03, bo.getC19x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x03, bo.getC20x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x03c, bo.getC21x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x03c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x03c, bo.getC22x03c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x03()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x03, bo.getC23x03());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x04c, bo.getC14x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x04n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x04n, bo.getC15x04n());
        lqw.eq(bo.getC16x04() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x04, bo.getC16x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x04, bo.getC17x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x04, bo.getC18x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x04, bo.getC19x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x04, bo.getC20x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x04c, bo.getC21x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x04c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x04c, bo.getC22x04c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x04()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x04, bo.getC23x04());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x05c, bo.getC14x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x05n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x05n, bo.getC15x05n());
        lqw.eq(bo.getC16x05() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x05, bo.getC16x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x05, bo.getC17x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x05, bo.getC18x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x05, bo.getC19x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x05, bo.getC20x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x05c, bo.getC21x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x05c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x05c, bo.getC22x05c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x05()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x05, bo.getC23x05());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x06c, bo.getC14x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x06n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x06n, bo.getC15x06n());
        lqw.eq(bo.getC16x06() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x06, bo.getC16x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x06, bo.getC17x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x06, bo.getC18x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x06, bo.getC19x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x06, bo.getC20x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x06c, bo.getC21x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x06c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x06c, bo.getC22x06c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x06()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x06, bo.getC23x06());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x07c, bo.getC14x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x07n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x07n, bo.getC15x07n());
        lqw.eq(bo.getC16x07() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x07, bo.getC16x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x07, bo.getC17x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x07, bo.getC18x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x07, bo.getC19x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x07, bo.getC20x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x07c, bo.getC21x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x07c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x07c, bo.getC22x07c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x07()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x07, bo.getC23x07());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x08c, bo.getC14x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x08n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x08n, bo.getC15x08n());
        lqw.eq(bo.getC16x08() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x08, bo.getC16x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x08, bo.getC17x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x08, bo.getC18x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x08, bo.getC19x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x08, bo.getC20x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x08c, bo.getC21x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x08c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x08c, bo.getC22x08c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x08()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x08, bo.getC23x08());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x09c, bo.getC14x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x09n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x09n, bo.getC15x09n());
        lqw.eq(bo.getC16x09() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x09, bo.getC16x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x09, bo.getC17x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x09, bo.getC18x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x09, bo.getC19x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x09, bo.getC20x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x09c, bo.getC21x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x09c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x09c, bo.getC22x09c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x09()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x09, bo.getC23x09());
        lqw.eq(StringUtils.isNotBlank(bo.getC14x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC14x10c, bo.getC14x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC15x10n()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC15x10n, bo.getC15x10n());
        lqw.eq(bo.getC16x10() != null, MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC16x10, bo.getC16x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC17x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC17x10, bo.getC17x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC18x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC18x10, bo.getC18x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC19x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC19x10, bo.getC19x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC20x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC20x10, bo.getC20x10());
        lqw.eq(StringUtils.isNotBlank(bo.getC21x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC21x10c, bo.getC21x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC22x10c()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC22x10c, bo.getC22x10c());
        lqw.eq(StringUtils.isNotBlank(bo.getC23x10()), MmpNatdssB04MedicalRecordFrontSheetNonTcm::getC23x10, bo.getC23x10());
        return lqw;
    }

    /**
     * 新增B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param bo B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo) {
        MmpNatdssB04MedicalRecordFrontSheetNonTcm add = MapstructUtils.convert(bo, MmpNatdssB04MedicalRecordFrontSheetNonTcm.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setPatientId(add.getPatientId());
        }
        return flag;
    }

    /**
     * 修改B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     *
     * @param bo B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNatdssB04MedicalRecordFrontSheetNonTcmBo bo) {
        MmpNatdssB04MedicalRecordFrontSheetNonTcm update = MapstructUtils.convert(bo, MmpNatdssB04MedicalRecordFrontSheetNonTcm.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNatdssB04MedicalRecordFrontSheetNonTcm entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除B04病历首页-核心信息-非中医院（基础+诊断+主要手术）信息
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
