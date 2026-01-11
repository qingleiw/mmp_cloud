package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionFormVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionFormBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 督查单Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionFormService {

    /**
     * 查询督查单
     *
     * @param id 主键
     * @return 督查单
     */
    MmpSupervisionFormVo queryById(Long id);

    /**
     * 分页查询督查单列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 督查单分页列表
     */
    TableDataInfo<MmpSupervisionFormVo> queryPageList(MmpSupervisionFormBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的督查单列表
     *
     * @param bo 查询条件
     * @return 督查单列表
     */
    List<MmpSupervisionFormVo> queryList(MmpSupervisionFormBo bo);

    /**
     * 新增督查单
     *
     * @param bo 督查单
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionFormBo bo);

    /**
     * 修改督查单
     *
     * @param bo 督查单
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionFormBo bo);

    /**
     * 校验并批量删除督查单信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
