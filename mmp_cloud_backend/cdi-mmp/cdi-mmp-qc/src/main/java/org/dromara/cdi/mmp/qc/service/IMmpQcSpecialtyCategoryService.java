package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcSpecialtyCategoryVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcSpecialtyCategoryBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 专业类别Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQcSpecialtyCategoryService {

    /**
     * 查询专业类别
     *
     * @param id 主键
     * @return 专业类别
     */
    MmpQcSpecialtyCategoryVo queryById(Long id);

    /**
     * 分页查询专业类别列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 专业类别分页列表
     */
    TableDataInfo<MmpQcSpecialtyCategoryVo> queryPageList(MmpQcSpecialtyCategoryBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的专业类别列表
     *
     * @param bo 查询条件
     * @return 专业类别列表
     */
    List<MmpQcSpecialtyCategoryVo> queryList(MmpQcSpecialtyCategoryBo bo);

    /**
     * 新增专业类别
     *
     * @param bo 专业类别
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcSpecialtyCategoryBo bo);

    /**
     * 修改专业类别
     *
     * @param bo 专业类别
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcSpecialtyCategoryBo bo);

    /**
     * 校验并批量删除专业类别信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
