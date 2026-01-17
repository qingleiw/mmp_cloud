package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB121OutpatientInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB121OutpatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB121OutpatientInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B12-1 门诊患者信息Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB121OutpatientInfoService {

    /**
     * 查询B12-1 门诊患者信息
     *
     * @param id 主键
     * @return B12-1 门诊患者信息
     */
    MmpNatdssB121OutpatientInfoVo queryById(Long id);

    /**
     * 分页查询B12-1 门诊患者信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B12-1 门诊患者信息分页列表
     */
    TableDataInfo<MmpNatdssB121OutpatientInfoVo> queryPageList(MmpNatdssB121OutpatientInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B12-1 门诊患者信息列表
     *
     * @param bo 查询条件
     * @return B12-1 门诊患者信息列表
     */
    List<MmpNatdssB121OutpatientInfoVo> queryList(MmpNatdssB121OutpatientInfoBo bo);

    /**
     * 新增B12-1 门诊患者信息
     *
     * @param bo B12-1 门诊患者信息
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB121OutpatientInfoBo bo);

    /**
     * 修改B12-1 门诊患者信息
     *
     * @param bo B12-1 门诊患者信息
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB121OutpatientInfoBo bo);

    /**
     * 校验并批量删除B12-1 门诊患者信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
