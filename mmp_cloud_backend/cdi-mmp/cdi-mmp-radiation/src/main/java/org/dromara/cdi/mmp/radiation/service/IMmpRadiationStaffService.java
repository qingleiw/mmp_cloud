package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationStaffVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationStaffBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 放射工作人员Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationStaffService {

    /**
     * 查询放射工作人员
     *
     * @param id 主键
     * @return 放射工作人员
     */
    MmpRadiationStaffVo queryById(Long id);

    /**
     * 分页查询放射工作人员列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 放射工作人员分页列表
     */
    TableDataInfo<MmpRadiationStaffVo> queryPageList(MmpRadiationStaffBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的放射工作人员列表
     *
     * @param bo 查询条件
     * @return 放射工作人员列表
     */
    List<MmpRadiationStaffVo> queryList(MmpRadiationStaffBo bo);

    /**
     * 新增放射工作人员
     *
     * @param bo 放射工作人员
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationStaffBo bo);

    /**
     * 修改放射工作人员
     *
     * @param bo 放射工作人员
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationStaffBo bo);

    /**
     * 校验并批量删除放射工作人员信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
