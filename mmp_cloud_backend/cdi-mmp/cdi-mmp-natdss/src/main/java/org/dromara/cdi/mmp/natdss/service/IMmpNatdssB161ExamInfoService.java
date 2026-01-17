package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB161ExamInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB161ExamInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB161ExamInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B16-1 常规检查记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB161ExamInfoService {

    /**
     * 查询B16-1 常规检查记录
     *
     * @param id 主键
     * @return B16-1 常规检查记录
     */
    MmpNatdssB161ExamInfoVo queryById(Long id);

    /**
     * 分页查询B16-1 常规检查记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B16-1 常规检查记录分页列表
     */
    TableDataInfo<MmpNatdssB161ExamInfoVo> queryPageList(MmpNatdssB161ExamInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B16-1 常规检查记录列表
     *
     * @param bo 查询条件
     * @return B16-1 常规检查记录列表
     */
    List<MmpNatdssB161ExamInfoVo> queryList(MmpNatdssB161ExamInfoBo bo);

    /**
     * 新增B16-1 常规检查记录
     *
     * @param bo B16-1 常规检查记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB161ExamInfoBo bo);

    /**
     * 修改B16-1 常规检查记录
     *
     * @param bo B16-1 常规检查记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB161ExamInfoBo bo);

    /**
     * 校验并批量删除B16-1 常规检查记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
