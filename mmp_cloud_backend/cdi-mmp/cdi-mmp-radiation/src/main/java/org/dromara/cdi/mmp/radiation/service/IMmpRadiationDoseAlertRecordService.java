package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseAlertRecordVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseAlertRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 剂量异常预警记录Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationDoseAlertRecordService {

    /**
     * 查询剂量异常预警记录
     *
     * @param id 主键
     * @return 剂量异常预警记录
     */
    MmpRadiationDoseAlertRecordVo queryById(Long id);

    /**
     * 分页查询剂量异常预警记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 剂量异常预警记录分页列表
     */
    TableDataInfo<MmpRadiationDoseAlertRecordVo> queryPageList(MmpRadiationDoseAlertRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的剂量异常预警记录列表
     *
     * @param bo 查询条件
     * @return 剂量异常预警记录列表
     */
    List<MmpRadiationDoseAlertRecordVo> queryList(MmpRadiationDoseAlertRecordBo bo);

    /**
     * 新增剂量异常预警记录
     *
     * @param bo 剂量异常预警记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationDoseAlertRecordBo bo);

    /**
     * 修改剂量异常预警记录
     *
     * @param bo 剂量异常预警记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationDoseAlertRecordBo bo);

    /**
     * 校验并批量删除剂量异常预警记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
