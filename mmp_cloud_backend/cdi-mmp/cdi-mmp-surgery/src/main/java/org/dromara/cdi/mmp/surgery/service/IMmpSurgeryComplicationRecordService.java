package org.dromara.cdi.mmp.surgery.service;

import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryComplicationRecordVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryComplicationRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 手术并发症记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpSurgeryComplicationRecordService {

    /**
     * 查询手术并发症记录
     *
     * @param id 主键
     * @return 手术并发症记录
     */
    MmpSurgeryComplicationRecordVo queryById(Long id);

    /**
     * 分页查询手术并发症记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术并发症记录分页列表
     */
    TableDataInfo<MmpSurgeryComplicationRecordVo> queryPageList(MmpSurgeryComplicationRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的手术并发症记录列表
     *
     * @param bo 查询条件
     * @return 手术并发症记录列表
     */
    List<MmpSurgeryComplicationRecordVo> queryList(MmpSurgeryComplicationRecordBo bo);

    /**
     * 新增手术并发症记录
     *
     * @param bo 手术并发症记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSurgeryComplicationRecordBo bo);

    /**
     * 修改手术并发症记录
     *
     * @param bo 手术并发症记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSurgeryComplicationRecordBo bo);

    /**
     * 校验并批量删除手术并发症记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
