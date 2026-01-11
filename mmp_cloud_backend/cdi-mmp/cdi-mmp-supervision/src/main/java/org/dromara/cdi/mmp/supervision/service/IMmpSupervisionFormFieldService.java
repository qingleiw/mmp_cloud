package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionFormFieldVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionFormFieldBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查单字段Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionFormFieldService {

    /**
     * 查询督查单字段
     *
     * @param id 主键
     * @return 督查单字段
     */
    MmpSupervisionFormFieldVo queryById(Long id);

    /**
     * 分页查询督查单字段列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查单字段分页列表
     */
    TableDataInfo<MmpSupervisionFormFieldVo> queryPageList(MmpSupervisionFormFieldBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查单字段列表
     *
     * @param bo 查询条件
     * @return 督查单字段列表
     */
    List<MmpSupervisionFormFieldVo> queryList(MmpSupervisionFormFieldBo bo);

    /**
     * 新增督查单字段
     *
     * @param bo 督查单字段
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionFormFieldBo bo);

    /**
     * 修改督查单字段
     *
     * @param bo 督查单字段
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionFormFieldBo bo);

    /**
     * 校验并批量删除督查单字段信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
