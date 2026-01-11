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
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationWorkerBo;
import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationWorkerVo;
import org.dromara.cdi.mmp.radiation.domain.MmpRadiationWorker;
import org.dromara.cdi.mmp.radiation.mapper.MmpRadiationWorkerMapper;
import org.dromara.cdi.mmp.radiation.service.IMmpRadiationWorkerService;

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
public class MmpRadiationWorkerServiceImpl implements IMmpRadiationWorkerService {

    private final MmpRadiationWorkerMapper baseMapper;

    /**
     * 查询放射工作人员
     *
     * @param id 主键
     * @return 放射工作人员
     */
    @Override
    public MmpRadiationWorkerVo queryById(Long id){
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
    public TableDataInfo<MmpRadiationWorkerVo> queryPageList(MmpRadiationWorkerBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpRadiationWorker> lqw = buildQueryWrapper(bo);
        Page<MmpRadiationWorkerVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的放射工作人员列表
     *
     * @param bo 查询条件
     * @return 放射工作人员列表
     */
    @Override
    public List<MmpRadiationWorkerVo> queryList(MmpRadiationWorkerBo bo) {
        LambdaQueryWrapper<MmpRadiationWorker> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpRadiationWorker> buildQueryWrapper(MmpRadiationWorkerBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpRadiationWorker> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpRadiationWorker::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getWorkerCode()), MmpRadiationWorker::getWorkerCode, bo.getWorkerCode());
        lqw.like(StringUtils.isNotBlank(bo.getWorkerName()), MmpRadiationWorker::getWorkerName, bo.getWorkerName());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), MmpRadiationWorker::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getPosition()), MmpRadiationWorker::getPosition, bo.getPosition());
        lqw.eq(StringUtils.isNotBlank(bo.getRadiationType()), MmpRadiationWorker::getRadiationType, bo.getRadiationType());
        lqw.eq(bo.getEmploymentDate() != null, MmpRadiationWorker::getEmploymentDate, bo.getEmploymentDate());
        lqw.eq(StringUtils.isNotBlank(bo.getContactInfo()), MmpRadiationWorker::getContactInfo, bo.getContactInfo());
        lqw.eq(StringUtils.isNotBlank(bo.getEmergencyContact()), MmpRadiationWorker::getEmergencyContact, bo.getEmergencyContact());
        lqw.eq(StringUtils.isNotBlank(bo.getHealthStatus()), MmpRadiationWorker::getHealthStatus, bo.getHealthStatus());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpRadiationWorker::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增放射工作人员
     *
     * @param bo 放射工作人员
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpRadiationWorkerBo bo) {
        MmpRadiationWorker add = MapstructUtils.convert(bo, MmpRadiationWorker.class);
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
    public Boolean updateByBo(MmpRadiationWorkerBo bo) {
        MmpRadiationWorker update = MapstructUtils.convert(bo, MmpRadiationWorker.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpRadiationWorker entity){
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
