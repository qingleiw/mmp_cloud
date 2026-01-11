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
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorInsuranceCodeBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInsuranceCodeVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorInsuranceCode;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorInsuranceCodeMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorInsuranceCodeService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 医保医师码Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorInsuranceCodeServiceImpl implements IMmpDoctorInsuranceCodeService {

    private final MmpDoctorInsuranceCodeMapper baseMapper;

    /**
     * 查询医保医师码
     *
     * @param id 主键
     * @return 医保医师码
     */
    @Override
    public MmpDoctorInsuranceCodeVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询医保医师码列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医保医师码分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorInsuranceCodeVo> queryPageList(MmpDoctorInsuranceCodeBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorInsuranceCode> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorInsuranceCodeVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的医保医师码列表
     *
     * @param bo 查询条件
     * @return 医保医师码列表
     */
    @Override
    public List<MmpDoctorInsuranceCodeVo> queryList(MmpDoctorInsuranceCodeBo bo) {
        LambdaQueryWrapper<MmpDoctorInsuranceCode> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorInsuranceCode> buildQueryWrapper(MmpDoctorInsuranceCodeBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorInsuranceCode> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorInsuranceCode::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorInsuranceCode::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getInsuranceCode()), MmpDoctorInsuranceCode::getInsuranceCode, bo.getInsuranceCode());
        lqw.eq(StringUtils.isNotBlank(bo.getInsuranceType()), MmpDoctorInsuranceCode::getInsuranceType, bo.getInsuranceType());
        lqw.eq(bo.getValidDate() != null, MmpDoctorInsuranceCode::getValidDate, bo.getValidDate());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpDoctorInsuranceCode::getStatus, bo.getStatus());
        lqw.eq(bo.getApplyDate() != null, MmpDoctorInsuranceCode::getApplyDate, bo.getApplyDate());
        lqw.eq(bo.getApproveDate() != null, MmpDoctorInsuranceCode::getApproveDate, bo.getApproveDate());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorInsuranceCode::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增医保医师码
     *
     * @param bo 医保医师码
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorInsuranceCodeBo bo) {
        MmpDoctorInsuranceCode add = MapstructUtils.convert(bo, MmpDoctorInsuranceCode.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改医保医师码
     *
     * @param bo 医保医师码
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorInsuranceCodeBo bo) {
        MmpDoctorInsuranceCode update = MapstructUtils.convert(bo, MmpDoctorInsuranceCode.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorInsuranceCode entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除医保医师码信息
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
