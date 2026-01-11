package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseMonitoringVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseMonitoringBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 个人剂量监测Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationDoseMonitoringService {

    /**
     * 查询个人剂量监测
     *
     * @param id 主键
     * @return 个人剂量监测
     */
    MmpRadiationDoseMonitoringVo queryById(Long id);

    /**
     * 分页查询个人剂量监测列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 个人剂量监测分页列表
     */
    TableDataInfo<MmpRadiationDoseMonitoringVo> queryPageList(MmpRadiationDoseMonitoringBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的个人剂量监测列表
     *
     * @param bo 查询条件
     * @return 个人剂量监测列表
     */
    List<MmpRadiationDoseMonitoringVo> queryList(MmpRadiationDoseMonitoringBo bo);

    /**
     * 新增个人剂量监测
     *
     * @param bo 个人剂量监测
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationDoseMonitoringBo bo);

    /**
     * 修改个人剂量监测
     *
     * @param bo 个人剂量监测
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationDoseMonitoringBo bo);

    /**
     * 校验并批量删除个人剂量监测信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
