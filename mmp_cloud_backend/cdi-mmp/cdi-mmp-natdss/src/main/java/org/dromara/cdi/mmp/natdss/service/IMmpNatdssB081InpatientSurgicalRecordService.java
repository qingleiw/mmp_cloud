package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB081InpatientSurgicalRecord;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB081InpatientSurgicalRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB081InpatientSurgicalRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B08-1 住院手术记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB081InpatientSurgicalRecordService {

    /**
     * 查询B08-1 住院手术记录
     *
     * @param id 主键
     * @return B08-1 住院手术记录
     */
    MmpNatdssB081InpatientSurgicalRecordVo queryById(Long id);

    /**
     * 分页查询B08-1 住院手术记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B08-1 住院手术记录分页列表
     */
    TableDataInfo<MmpNatdssB081InpatientSurgicalRecordVo> queryPageList(MmpNatdssB081InpatientSurgicalRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B08-1 住院手术记录列表
     *
     * @param bo 查询条件
     * @return B08-1 住院手术记录列表
     */
    List<MmpNatdssB081InpatientSurgicalRecordVo> queryList(MmpNatdssB081InpatientSurgicalRecordBo bo);

    /**
     * 新增B08-1 住院手术记录
     *
     * @param bo B08-1 住院手术记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB081InpatientSurgicalRecordBo bo);

    /**
     * 修改B08-1 住院手术记录
     *
     * @param bo B08-1 住院手术记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB081InpatientSurgicalRecordBo bo);

    /**
     * 校验并批量删除B08-1 住院手术记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
