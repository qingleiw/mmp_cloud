package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorResearchProjectVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorResearchProjectBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 科研项目Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorResearchProjectService {

    /**
     * 查询科研项目
     *
     * @param id 主键
     * @return 科研项目
     */
    MmpDoctorResearchProjectVo queryById(Long id);

    /**
     * 分页查询科研项目列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 科研项目分页列表
     */
    TableDataInfo<MmpDoctorResearchProjectVo> queryPageList(MmpDoctorResearchProjectBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的科研项目列表
     *
     * @param bo 查询条件
     * @return 科研项目列表
     */
    List<MmpDoctorResearchProjectVo> queryList(MmpDoctorResearchProjectBo bo);

    /**
     * 新增科研项目
     *
     * @param bo 科研项目
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorResearchProjectBo bo);

    /**
     * 修改科研项目
     *
     * @param bo 科研项目
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorResearchProjectBo bo);

    /**
     * 校验并批量删除科研项目信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
