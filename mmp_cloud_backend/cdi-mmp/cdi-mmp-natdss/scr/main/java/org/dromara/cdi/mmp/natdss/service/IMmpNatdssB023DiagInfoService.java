package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB023DiagInfo;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB023DiagInfoVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB023DiagInfoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B02-3 患者诊断记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB023DiagInfoService {

    /**
     * 查询B02-3 患者诊断记录
     *
     * @param id 主键
     * @return B02-3 患者诊断记录
     */
    MmpNatdssB023DiagInfoVo queryById(Long id);

    /**
     * 分页查询B02-3 患者诊断记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B02-3 患者诊断记录分页列表
     */
    TableDataInfo<MmpNatdssB023DiagInfoVo> queryPageList(MmpNatdssB023DiagInfoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B02-3 患者诊断记录列表
     *
     * @param bo 查询条件
     * @return B02-3 患者诊断记录列表
     */
    List<MmpNatdssB023DiagInfoVo> queryList(MmpNatdssB023DiagInfoBo bo);

    /**
     * 新增B02-3 患者诊断记录
     *
     * @param bo B02-3 患者诊断记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB023DiagInfoBo bo);

    /**
     * 修改B02-3 患者诊断记录
     *
     * @param bo B02-3 患者诊断记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB023DiagInfoBo bo);

    /**
     * 校验并批量删除B02-3 患者诊断记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
