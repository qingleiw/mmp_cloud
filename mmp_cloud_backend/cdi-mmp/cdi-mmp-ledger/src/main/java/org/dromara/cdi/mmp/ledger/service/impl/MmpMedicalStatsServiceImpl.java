package org.dromara.cdi.mmp.ledger.service.impl;

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
import org.dromara.cdi.mmp.ledger.domain.bo.MmpMedicalStatsBo;
import org.dromara.cdi.mmp.ledger.domain.vo.MmpMedicalStatsVo;
import org.dromara.cdi.mmp.ledger.domain.MmpMedicalStats;
import org.dromara.cdi.mmp.ledger.mapper.MmpMedicalStatsMapper;
import org.dromara.cdi.mmp.ledger.service.IMmpMedicalStatsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医疗质量统计数据Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-27
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpMedicalStatsServiceImpl implements IMmpMedicalStatsService {

    private final MmpMedicalStatsMapper baseMapper;

    /**
     * 查询医疗质量统计数据
     *
     * @param id 主键
     * @return 医疗质量统计数据
     */
    @Override
    public MmpMedicalStatsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医疗质量统计数据列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医疗质量统计数据分页列表
     */
    @Override
    public TableDataInfo<MmpMedicalStatsVo> queryPageList(MmpMedicalStatsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpMedicalStats> lqw = buildQueryWrapper(bo);
        Page<MmpMedicalStatsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医疗质量统计数据列表
     *
     * @param bo 查询条件
     * @return 医疗质量统计数据列表
     */
    @Override
    public List<MmpMedicalStatsVo> queryList(MmpMedicalStatsBo bo) {
        LambdaQueryWrapper<MmpMedicalStats> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpMedicalStats> buildQueryWrapper(MmpMedicalStatsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpMedicalStats> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpMedicalStats::getId);
        lqw.like(StringUtils.isNotBlank(bo.getDeptName()), MmpMedicalStats::getDeptName, bo.getDeptName());
        lqw.eq(bo.getStatDate() != null, MmpMedicalStats::getStatDate, bo.getStatDate());
        lqw.eq(bo.getNewAdmissions() != null, MmpMedicalStats::getNewAdmissions, bo.getNewAdmissions());
        lqw.eq(bo.getInWard() != null, MmpMedicalStats::getInWard, bo.getInWard());
        lqw.eq(bo.getCritical() != null, MmpMedicalStats::getCritical, bo.getCritical());
        lqw.eq(bo.getDischarged() != null, MmpMedicalStats::getDischarged, bo.getDischarged());
        lqw.eq(bo.getDeaths() != null, MmpMedicalStats::getDeaths, bo.getDeaths());
        lqw.eq(bo.getTransfersIn() != null, MmpMedicalStats::getTransfersIn, bo.getTransfersIn());
        lqw.eq(bo.getTransfersOut() != null, MmpMedicalStats::getTransfersOut, bo.getTransfersOut());
        lqw.eq(bo.getAttentionPatients() != null, MmpMedicalStats::getAttentionPatients, bo.getAttentionPatients());
        lqw.eq(bo.getRescues() != null, MmpMedicalStats::getRescues, bo.getRescues());
        lqw.eq(bo.getCriticalValues() != null, MmpMedicalStats::getCriticalValues, bo.getCriticalValues());
        lqw.eq(bo.getCriticallyIll() != null, MmpMedicalStats::getCriticallyIll, bo.getCriticallyIll());
        lqw.eq(bo.getSeriouslyIll() != null, MmpMedicalStats::getSeriouslyIll, bo.getSeriouslyIll());
        lqw.eq(bo.getConsultations() != null, MmpMedicalStats::getConsultations, bo.getConsultations());
        lqw.eq(bo.getLongStayPatients() != null, MmpMedicalStats::getLongStayPatients, bo.getLongStayPatients());
        lqw.eq(bo.getLevel3Surgeries() != null, MmpMedicalStats::getLevel3Surgeries, bo.getLevel3Surgeries());
        lqw.eq(bo.getLevel4Surgeries() != null, MmpMedicalStats::getLevel4Surgeries, bo.getLevel4Surgeries());
        lqw.eq(bo.getSecondarySurgeries() != null, MmpMedicalStats::getSecondarySurgeries, bo.getSecondarySurgeries());
        lqw.eq(bo.getBloodTransfusions() != null, MmpMedicalStats::getBloodTransfusions, bo.getBloodTransfusions());
        lqw.eq(bo.getPathwayEntries() != null, MmpMedicalStats::getPathwayEntries, bo.getPathwayEntries());
        lqw.eq(bo.getAntibioticUsage() != null, MmpMedicalStats::getAntibioticUsage, bo.getAntibioticUsage());
        return lqw;
    }

    /**
     * 新增医疗质量统计数据
     *
     * @param bo 医疗质量统计数据
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpMedicalStatsBo bo) {
        MmpMedicalStats add = MapstructUtils.convert(bo, MmpMedicalStats.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医疗质量统计数据
     *
     * @param bo 医疗质量统计数据
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpMedicalStatsBo bo) {
        MmpMedicalStats update = MapstructUtils.convert(bo, MmpMedicalStats.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpMedicalStats entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医疗质量统计数据信息
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
