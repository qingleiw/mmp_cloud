package org.dromara.cdi.mmp.emergency.service.impl;

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
import org.dromara.cdi.mmp.emergency.domain.bo.MmpEmergencyEventResponseBo;
import org.dromara.cdi.mmp.emergency.domain.vo.MmpEmergencyEventResponseVo;
import org.dromara.cdi.mmp.emergency.domain.MmpEmergencyEventResponse;
import org.dromara.cdi.mmp.emergency.mapper.MmpEmergencyEventResponseMapper;
import org.dromara.cdi.mmp.emergency.service.IMmpEmergencyEventResponseService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 突发事件响应Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpEmergencyEventResponseServiceImpl implements IMmpEmergencyEventResponseService {

    private final MmpEmergencyEventResponseMapper baseMapper;

    /**
     * 查询突发事件响应
     *
     * @param id 主键
     * @return 突发事件响应
     */
    @Override
    public MmpEmergencyEventResponseVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询突发事件响应列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 突发事件响应分页列表
     */
    @Override
    public TableDataInfo<MmpEmergencyEventResponseVo> queryPageList(MmpEmergencyEventResponseBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpEmergencyEventResponse> lqw = buildQueryWrapper(bo);
        Page<MmpEmergencyEventResponseVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的突发事件响应列表
     *
     * @param bo 查询条件
     * @return 突发事件响应列表
     */
    @Override
    public List<MmpEmergencyEventResponseVo> queryList(MmpEmergencyEventResponseBo bo) {
        LambdaQueryWrapper<MmpEmergencyEventResponse> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpEmergencyEventResponse> buildQueryWrapper(MmpEmergencyEventResponseBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpEmergencyEventResponse> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpEmergencyEventResponse::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getResponseTeam()), MmpEmergencyEventResponse::getResponseTeam, bo.getResponseTeam());
        lqw.eq(bo.getResponseStartTime() != null, MmpEmergencyEventResponse::getResponseStartTime, bo.getResponseStartTime());
        lqw.eq(bo.getResponseEndTime() != null, MmpEmergencyEventResponse::getResponseEndTime, bo.getResponseEndTime());
        lqw.eq(StringUtils.isNotBlank(bo.getResponseMeasures()), MmpEmergencyEventResponse::getResponseMeasures, bo.getResponseMeasures());
        lqw.eq(StringUtils.isNotBlank(bo.getResponsiblePerson()), MmpEmergencyEventResponse::getResponsiblePerson, bo.getResponsiblePerson());
        return lqw;
    }

    /**
     * 新增突发事件响应
     *
     * @param bo 突发事件响应
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpEmergencyEventResponseBo bo) {
        MmpEmergencyEventResponse add = MapstructUtils.convert(bo, MmpEmergencyEventResponse.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改突发事件响应
     *
     * @param bo 突发事件响应
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpEmergencyEventResponseBo bo) {
        MmpEmergencyEventResponse update = MapstructUtils.convert(bo, MmpEmergencyEventResponse.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpEmergencyEventResponse entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除突发事件响应信息
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
