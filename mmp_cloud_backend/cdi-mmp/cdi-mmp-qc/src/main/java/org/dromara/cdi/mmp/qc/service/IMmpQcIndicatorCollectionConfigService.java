package org.dromara.cdi.mmp.qc.service;

import org.dromara.cdi.mmp.qc.domain.vo.MmpQcIndicatorCollectionConfigVo;
import org.dromara.cdi.mmp.qc.domain.bo.MmpQcIndicatorCollectionConfigBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 质控指标数据采集配置Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQcIndicatorCollectionConfigService {

    /**
     * 查询质控指标数据采集配置
     *
     * @param id 主键
     * @return 质控指标数据采集配置
     */
    MmpQcIndicatorCollectionConfigVo queryById(Long id);

    /**
     * 分页查询质控指标数据采集配置列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质控指标数据采集配置分页列表
     */
    TableDataInfo<MmpQcIndicatorCollectionConfigVo> queryPageList(MmpQcIndicatorCollectionConfigBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的质控指标数据采集配置列表
     *
     * @param bo 查询条件
     * @return 质控指标数据采集配置列表
     */
    List<MmpQcIndicatorCollectionConfigVo> queryList(MmpQcIndicatorCollectionConfigBo bo);

    /**
     * 新增质控指标数据采集配置
     *
     * @param bo 质控指标数据采集配置
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQcIndicatorCollectionConfigBo bo);

    /**
     * 修改质控指标数据采集配置
     *
     * @param bo 质控指标数据采集配置
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQcIndicatorCollectionConfigBo bo);

    /**
     * 校验并批量删除质控指标数据采集配置信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
