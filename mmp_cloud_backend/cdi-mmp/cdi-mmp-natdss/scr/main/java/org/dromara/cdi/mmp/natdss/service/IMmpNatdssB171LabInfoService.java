package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB171LabInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB171LabInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB171LabInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B17-1 常规检验记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB171LabInfoService {

    /**
     * 查询B17-1 常规检验记录
     *
     * @param id 主键
     * @return B17-1 常规检验记录
     */
    MmpNatdssB171LabInfoVo queryById(Long id);

    /**
     * 分页查询B17-1 常规检验记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B17-1 常规检验记录分页列表
     */
    TableDataInfo<MmpNatdssB171LabInfoVo> queryPageList(MmpNatdssB171LabInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B17-1 常规检验记录列表
     *
     * @param bo 查询条件
     * @return B17-1 常规检验记录列表
     */
    List<MmpNatdssB171LabInfoVo> queryList(MmpNatdssB171LabInfoBo bo);

    /**
     * 新增B17-1 常规检验记录
     *
     * @param bo B17-1 常规检验记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB171LabInfoBo bo);

    /**
     * 修改B17-1 常规检验记录
     *
     * @param bo B17-1 常规检验记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB171LabInfoBo bo);

    /**
     * 校验并批量删除B17-1 常规检验记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
