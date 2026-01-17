package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB022AdrInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB022AdrInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB022AdrInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B02-2 患者药物不良反应记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB022AdrInfoService {

    /**
     * 查询B02-2 患者药物不良反应记录
     *
     * @param id 主键
     * @return B02-2 患者药物不良反应记录
     */
    MmpNatdssB022AdrInfoVo queryById(Long id);

    /**
     * 分页查询B02-2 患者药物不良反应记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B02-2 患者药物不良反应记录分页列表
     */
    TableDataInfo<MmpNatdssB022AdrInfoVo> queryPageList(MmpNatdssB022AdrInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B02-2 患者药物不良反应记录列表
     *
     * @param bo 查询条件
     * @return B02-2 患者药物不良反应记录列表
     */
    List<MmpNatdssB022AdrInfoVo> queryList(MmpNatdssB022AdrInfoBo bo);

    /**
     * 新增B02-2 患者药物不良反应记录
     *
     * @param bo B02-2 患者药物不良反应记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB022AdrInfoBo bo);

    /**
     * 修改B02-2 患者药物不良反应记录
     *
     * @param bo B02-2 患者药物不良反应记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB022AdrInfoBo bo);

    /**
     * 校验并批量删除B02-2 患者药物不良反应记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
