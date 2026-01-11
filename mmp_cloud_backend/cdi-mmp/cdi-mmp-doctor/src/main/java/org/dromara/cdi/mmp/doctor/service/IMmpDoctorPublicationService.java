package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorPublicationVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorPublicationBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 论文论著Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorPublicationService {

    /**
     * 查询论文论著
     *
     * @param id 主键
     * @return 论文论著
     */
    MmpDoctorPublicationVo queryById(Long id);

    /**
     * 分页查询论文论著列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 论文论著分页列表
     */
    TableDataInfo<MmpDoctorPublicationVo> queryPageList(MmpDoctorPublicationBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的论文论著列表
     *
     * @param bo 查询条件
     * @return 论文论著列表
     */
    List<MmpDoctorPublicationVo> queryList(MmpDoctorPublicationBo bo);

    /**
     * 新增论文论著
     *
     * @param bo 论文论著
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorPublicationBo bo);

    /**
     * 修改论文论著
     *
     * @param bo 论文论著
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorPublicationBo bo);

    /**
     * 校验并批量删除论文论著信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
