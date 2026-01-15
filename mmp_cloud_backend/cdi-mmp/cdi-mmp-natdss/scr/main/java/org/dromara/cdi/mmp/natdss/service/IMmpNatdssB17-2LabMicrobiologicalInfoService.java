package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB17-2LabMicrobiologicalInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB17-2LabMicrobiologicalInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB17-2LabMicrobiologicalInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B17-2 微生物检验记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB17-2LabMicrobiologicalInfoService {

    /**
     * 查询B17-2 微生物检验记录
     *
     * @param id 主键
     * @return B17-2 微生物检验记录
     */
    MmpNatdssB17-2LabMicrobiologicalInfoVo queryById(Long id);

    /**
     * 分页查询B17-2 微生物检验记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B17-2 微生物检验记录分页列表
     */
    TableDataInfo<MmpNatdssB17-2LabMicrobiologicalInfoVo> queryPageList(MmpNatdssB17-2LabMicrobiologicalInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B17-2 微生物检验记录列表
     *
     * @param bo 查询条件
     * @return B17-2 微生物检验记录列表
     */
    List<MmpNatdssB17-2LabMicrobiologicalInfoVo> queryList(MmpNatdssB17-2LabMicrobiologicalInfoBo bo);

    /**
     * 新增B17-2 微生物检验记录
     *
     * @param bo B17-2 微生物检验记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB17-2LabMicrobiologicalInfoBo bo);

    /**
     * 修改B17-2 微生物检验记录
     *
     * @param bo B17-2 微生物检验记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB17-2LabMicrobiologicalInfoBo bo);

    /**
     * 校验并批量删除B17-2 微生物检验记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
