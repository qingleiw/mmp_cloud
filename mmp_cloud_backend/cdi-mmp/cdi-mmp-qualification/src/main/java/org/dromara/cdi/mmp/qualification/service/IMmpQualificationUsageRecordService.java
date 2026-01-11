package org.dromara.cdi.mmp.qualification.service;

import org.dromara.cdi.mmp.qualification.domain.vo.MmpQualificationUsageRecordVo;
import org.dromara.cdi.mmp.qualification.domain.bo.MmpQualificationUsageRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 资质使用记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpQualificationUsageRecordService {

    /**
     * 查询资质使用记录
     *
     * @param id 主键
     * @return 资质使用记录
     */
    MmpQualificationUsageRecordVo queryById(Long id);

    /**
     * 分页查询资质使用记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 资质使用记录分页列表
     */
    TableDataInfo<MmpQualificationUsageRecordVo> queryPageList(MmpQualificationUsageRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的资质使用记录列表
     *
     * @param bo 查询条件
     * @return 资质使用记录列表
     */
    List<MmpQualificationUsageRecordVo> queryList(MmpQualificationUsageRecordBo bo);

    /**
     * 新增资质使用记录
     *
     * @param bo 资质使用记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpQualificationUsageRecordBo bo);

    /**
     * 修改资质使用记录
     *
     * @param bo 资质使用记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpQualificationUsageRecordBo bo);

    /**
     * 校验并批量删除资质使用记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
