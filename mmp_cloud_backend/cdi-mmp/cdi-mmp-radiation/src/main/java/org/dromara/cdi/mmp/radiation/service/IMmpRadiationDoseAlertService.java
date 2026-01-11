package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseAlertVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseAlertBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 剂量监测预警设置Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationDoseAlertService {

    /**
     * 查询剂量监测预警设置
     *
     * @param id 主键
     * @return 剂量监测预警设置
     */
    MmpRadiationDoseAlertVo queryById(Long id);

    /**
     * 分页查询剂量监测预警设置列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 剂量监测预警设置分页列表
     */
    TableDataInfo<MmpRadiationDoseAlertVo> queryPageList(MmpRadiationDoseAlertBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的剂量监测预警设置列表
     *
     * @param bo 查询条件
     * @return 剂量监测预警设置列表
     */
    List<MmpRadiationDoseAlertVo> queryList(MmpRadiationDoseAlertBo bo);

    /**
     * 新增剂量监测预警设置
     *
     * @param bo 剂量监测预警设置
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationDoseAlertBo bo);

    /**
     * 修改剂量监测预警设置
     *
     * @param bo 剂量监测预警设置
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationDoseAlertBo bo);

    /**
     * 校验并批量删除剂量监测预警设置信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
