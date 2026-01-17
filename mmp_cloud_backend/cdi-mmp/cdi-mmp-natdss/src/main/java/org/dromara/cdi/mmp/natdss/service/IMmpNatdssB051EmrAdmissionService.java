package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB051EmrAdmission;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB051EmrAdmissionVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB051EmrAdmissionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B05-1 入院记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB051EmrAdmissionService {

    /**
     * 查询B05-1 入院记录
     *
     * @param id 主键
     * @return B05-1 入院记录
     */
    MmpNatdssB051EmrAdmissionVo queryById(Long id);

    /**
     * 分页查询B05-1 入院记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B05-1 入院记录分页列表
     */
    TableDataInfo<MmpNatdssB051EmrAdmissionVo> queryPageList(MmpNatdssB051EmrAdmissionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B05-1 入院记录列表
     *
     * @param bo 查询条件
     * @return B05-1 入院记录列表
     */
    List<MmpNatdssB051EmrAdmissionVo> queryList(MmpNatdssB051EmrAdmissionBo bo);

    /**
     * 新增B05-1 入院记录
     *
     * @param bo B05-1 入院记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB051EmrAdmissionBo bo);

    /**
     * 修改B05-1 入院记录
     *
     * @param bo B05-1 入院记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB051EmrAdmissionBo bo);

    /**
     * 校验并批量删除B05-1 入院记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
