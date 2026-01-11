package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationHealthExamResultVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationHealthExamResultBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 体检结果记录Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationHealthExamResultService {

    /**
     * 查询体检结果记录
     *
     * @param id 主键
     * @return 体检结果记录
     */
    MmpRadiationHealthExamResultVo queryById(Long id);

    /**
     * 分页查询体检结果记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 体检结果记录分页列表
     */
    TableDataInfo<MmpRadiationHealthExamResultVo> queryPageList(MmpRadiationHealthExamResultBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的体检结果记录列表
     *
     * @param bo 查询条件
     * @return 体检结果记录列表
     */
    List<MmpRadiationHealthExamResultVo> queryList(MmpRadiationHealthExamResultBo bo);

    /**
     * 新增体检结果记录
     *
     * @param bo 体检结果记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationHealthExamResultBo bo);

    /**
     * 修改体检结果记录
     *
     * @param bo 体检结果记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationHealthExamResultBo bo);

    /**
     * 校验并批量删除体检结果记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
