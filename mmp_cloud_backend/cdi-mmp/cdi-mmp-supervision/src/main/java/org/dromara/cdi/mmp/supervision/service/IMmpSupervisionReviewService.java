package org.dromara.cdi.mmp.supervision.service;

import org.dromara.cdi.mmp.supervision.domain.vo.MmpSupervisionReviewVo;
import org.dromara.cdi.mmp.supervision.domain.bo.MmpSupervisionReviewBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 整改复查Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpSupervisionReviewService {

    /**
     * 查询整改复查
     *
     * @param id 主键
     * @return 整改复查
     */
    MmpSupervisionReviewVo queryById(Long id);

    /**
     * 分页查询整改复查列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 整改复查分页列表
     */
    TableDataInfo<MmpSupervisionReviewVo> queryPageList(MmpSupervisionReviewBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的整改复查列表
     *
     * @param bo 查询条件
     * @return 整改复查列表
     */
    List<MmpSupervisionReviewVo> queryList(MmpSupervisionReviewBo bo);

    /**
     * 新增整改复查
     *
     * @param bo 整改复查
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSupervisionReviewBo bo);

    /**
     * 修改整改复查
     *
     * @param bo 整改复查
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSupervisionReviewBo bo);

    /**
     * 校验并批量删除整改复查信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
