package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationDoseRecordVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationDoseRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 个人剂量监测记录Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationDoseRecordService {

    /**
     * 查询个人剂量监测记录
     *
     * @param id 主键
     * @return 个人剂量监测记录
     */
    MmpRadiationDoseRecordVo queryById(Long id);

    /**
     * 分页查询个人剂量监测记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 个人剂量监测记录分页列表
     */
    TableDataInfo<MmpRadiationDoseRecordVo> queryPageList(MmpRadiationDoseRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的个人剂量监测记录列表
     *
     * @param bo 查询条件
     * @return 个人剂量监测记录列表
     */
    List<MmpRadiationDoseRecordVo> queryList(MmpRadiationDoseRecordBo bo);

    /**
     * 新增个人剂量监测记录
     *
     * @param bo 个人剂量监测记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationDoseRecordBo bo);

    /**
     * 修改个人剂量监测记录
     *
     * @param bo 个人剂量监测记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationDoseRecordBo bo);

    /**
     * 校验并批量删除个人剂量监测记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
