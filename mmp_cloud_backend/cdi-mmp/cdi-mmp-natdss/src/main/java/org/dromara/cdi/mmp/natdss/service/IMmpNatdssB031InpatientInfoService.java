package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB031InpatientInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB031InpatientInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB031InpatientInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B03-1 住院患者信息Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB031InpatientInfoService {

    /**
     * 查询B03-1 住院患者信息
     *
     * @param id 主键
     * @return B03-1 住院患者信息
     */
    MmpNatdssB031InpatientInfoVo queryById(Long id);

    /**
     * 分页查询B03-1 住院患者信息列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B03-1 住院患者信息分页列表
     */
    TableDataInfo<MmpNatdssB031InpatientInfoVo> queryPageList(MmpNatdssB031InpatientInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B03-1 住院患者信息列表
     *
     * @param bo 查询条件
     * @return B03-1 住院患者信息列表
     */
    List<MmpNatdssB031InpatientInfoVo> queryList(MmpNatdssB031InpatientInfoBo bo);

    /**
     * 新增B03-1 住院患者信息
     *
     * @param bo B03-1 住院患者信息
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB031InpatientInfoBo bo);

    /**
     * 修改B03-1 住院患者信息
     *
     * @param bo B03-1 住院患者信息
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB031InpatientInfoBo bo);

    /**
     * 校验并批量删除B03-1 住院患者信息信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
