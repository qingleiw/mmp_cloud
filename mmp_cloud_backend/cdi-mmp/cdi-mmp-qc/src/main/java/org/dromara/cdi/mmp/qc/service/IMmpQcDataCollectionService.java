package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcDataCollectionVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcDataCollectionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 数据采集记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-30
 */
public interface IMmpQcDataCollectionService {

    /**
     * 查询数据采集记录
     *
     * @param id 主键
     * @return 数据采集记录
     */
    MmpQcDataCollectionVo queryById(Long id);

    /**
     * 分页查询数据采集记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 数据采集记录分页列表
     */
    TableDataInfo<MmpQcDataCollectionVo> queryPageList(MmpQcDataCollectionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的数据采集记录列表
     *
     * @param bo 查询条件
     * @return 数据采集记录列表
     */
    List<MmpQcDataCollectionVo> queryList(MmpQcDataCollectionBo bo);

    /**
     * 新增数据采集记录
     *
     * @param bo 数据采集记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcDataCollectionBo bo);

    /**
     * 修改数据采集记录
     *
     * @param bo 数据采集记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcDataCollectionBo bo);

    /**
     * 校验并批量删除数据采集记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
