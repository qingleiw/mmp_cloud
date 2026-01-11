package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcManualDataVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcManualDataBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 人工补录数据Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQcManualDataService {

    /**
     * 查询人工补录数据
     *
     * @param id 主键
     * @return 人工补录数据
     */
    MmpQcManualDataVo queryById(Long id);

    /**
     * 分页查询人工补录数据列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 人工补录数据分页列表
     */
    TableDataInfo<MmpQcManualDataVo> queryPageList(MmpQcManualDataBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的人工补录数据列表
     *
     * @param bo 查询条件
     * @return 人工补录数据列表
     */
    List<MmpQcManualDataVo> queryList(MmpQcManualDataBo bo);

    /**
     * 新增人工补录数据
     *
     * @param bo 人工补录数据
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcManualDataBo bo);

    /**
     * 修改人工补录数据
     *
     * @param bo 人工补录数据
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcManualDataBo bo);

    /**
     * 校验并批量删除人工补录数据信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
