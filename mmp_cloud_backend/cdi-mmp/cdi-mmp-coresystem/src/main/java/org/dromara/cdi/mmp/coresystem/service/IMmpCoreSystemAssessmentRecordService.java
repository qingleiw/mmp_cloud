package org.dromara.cdi.mmp.coresystem.service;

import org.dromara.cdi.mmp.coresystem.domain.vo.MmpCoreSystemAssessmentRecordVo;
import org.dromara.cdi.mmp.coresystem.domain.bo.MmpCoreSystemAssessmentRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 制度考核记录Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpCoreSystemAssessmentRecordService {

    /**
     * 查询制度考核记录
     *
     * @param id 主键
     * @return 制度考核记录
     */
    MmpCoreSystemAssessmentRecordVo queryById(Long id);

    /**
     * 分页查询制度考核记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 制度考核记录分页列表
     */
    TableDataInfo<MmpCoreSystemAssessmentRecordVo> queryPageList(MmpCoreSystemAssessmentRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的制度考核记录列表
     *
     * @param bo 查询条件
     * @return 制度考核记录列表
     */
    List<MmpCoreSystemAssessmentRecordVo> queryList(MmpCoreSystemAssessmentRecordBo bo);

    /**
     * 新增制度考核记录
     *
     * @param bo 制度考核记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpCoreSystemAssessmentRecordBo bo);

    /**
     * 修改制度考核记录
     *
     * @param bo 制度考核记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpCoreSystemAssessmentRecordBo bo);

    /**
     * 校验并批量删除制度考核记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
