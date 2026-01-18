package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB172LabMicrobiologicalInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB172LabMicrobiologicalInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B172 微生物检验记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB172LabMicrobiologicalInfoService {

    /**
     * 查询B172 微生物检验记录
     *
     * @param id 主键
     * @return B172 微生物检验记录
     */
    MmpNatdssB172LabMicrobiologicalInfoVo queryById(Long id);

    /**
     * 分页查询B172 微生物检验记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B172 微生物检验记录分页列表
     */
    TableDataInfo<MmpNatdssB172LabMicrobiologicalInfoVo> queryPageList(MmpNatdssB172LabMicrobiologicalInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B172 微生物检验记录列表
     *
     * @param bo 查询条件
     * @return B172 微生物检验记录列表
     */
    List<MmpNatdssB172LabMicrobiologicalInfoVo> queryList(MmpNatdssB172LabMicrobiologicalInfoBo bo);

    /**
     * 新增B172 微生物检验记录
     *
     * @param bo B172 微生物检验记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB172LabMicrobiologicalInfoBo bo);

    /**
     * 修改B172 微生物检验记录
     *
     * @param bo B172 微生物检验记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB172LabMicrobiologicalInfoBo bo);

    /**
     * 校验并批量删除B172 微生物检验记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
