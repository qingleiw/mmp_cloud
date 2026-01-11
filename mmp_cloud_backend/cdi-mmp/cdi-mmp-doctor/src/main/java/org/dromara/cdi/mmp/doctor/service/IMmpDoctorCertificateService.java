package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorCertificateVo;
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorCertificateBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质证书Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpDoctorCertificateService {

    /**
     * 查询资质证书
     *
     * @param id 主键
     * @return 资质证书
     */
    MmpDoctorCertificateVo queryById(Long id);

    /**
     * 分页查询资质证书列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质证书分页列表
     */
    TableDataInfo<MmpDoctorCertificateVo> queryPageList(MmpDoctorCertificateBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质证书列表
     *
     * @param bo 查询条件
     * @return 资质证书列表
     */
    List<MmpDoctorCertificateVo> queryList(MmpDoctorCertificateBo bo);

    /**
     * 新增资质证书
     *
     * @param bo 资质证书
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpDoctorCertificateBo bo);

    /**
     * 修改资质证书
     *
     * @param bo 资质证书
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpDoctorCertificateBo bo);

    /**
     * 校验并批量删除资质证书信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
