package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationRiskMonitorVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationRiskMonitorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质风险监测Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationRiskMonitorService {

    /**
     * 查询资质风险监测
     *
     * @param id 主键
     * @return 资质风险监测
     */
    MmpQualificationRiskMonitorVo queryById(Long id);

    /**
     * 分页查询资质风险监测列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质风险监测分页列表
     */
    TableDataInfo<MmpQualificationRiskMonitorVo> queryPageList(MmpQualificationRiskMonitorBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质风险监测列表
     *
     * @param bo 查询条件
     * @return 资质风险监测列表
     */
    List<MmpQualificationRiskMonitorVo> queryList(MmpQualificationRiskMonitorBo bo);

    /**
     * 新增资质风险监测
     *
     * @param bo 资质风险监测
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationRiskMonitorBo bo);

    /**
     * 修改资质风险监测
     *
     * @param bo 资质风险监测
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationRiskMonitorBo bo);

    /**
     * 校验并批量删除资质风险监测信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
