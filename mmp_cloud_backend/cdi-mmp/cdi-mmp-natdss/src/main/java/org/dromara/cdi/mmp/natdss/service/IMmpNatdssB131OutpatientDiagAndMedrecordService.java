package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB131OutpatientDiagAndMedrecord;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB131OutpatientDiagAndMedrecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB131OutpatientDiagAndMedrecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B13-1 门诊病历记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB131OutpatientDiagAndMedrecordService {

    /**
     * 查询B13-1 门诊病历记录
     *
     * @param id 主键
     * @return B13-1 门诊病历记录
     */
    MmpNatdssB131OutpatientDiagAndMedrecordVo queryById(Long id);

    /**
     * 分页查询B13-1 门诊病历记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B13-1 门诊病历记录分页列表
     */
    TableDataInfo<MmpNatdssB131OutpatientDiagAndMedrecordVo> queryPageList(MmpNatdssB131OutpatientDiagAndMedrecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B13-1 门诊病历记录列表
     *
     * @param bo 查询条件
     * @return B13-1 门诊病历记录列表
     */
    List<MmpNatdssB131OutpatientDiagAndMedrecordVo> queryList(MmpNatdssB131OutpatientDiagAndMedrecordBo bo);

    /**
     * 新增B13-1 门诊病历记录
     *
     * @param bo B13-1 门诊病历记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB131OutpatientDiagAndMedrecordBo bo);

    /**
     * 修改B13-1 门诊病历记录
     *
     * @param bo B13-1 门诊病历记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB131OutpatientDiagAndMedrecordBo bo);

    /**
     * 校验并批量删除B13-1 门诊病历记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
