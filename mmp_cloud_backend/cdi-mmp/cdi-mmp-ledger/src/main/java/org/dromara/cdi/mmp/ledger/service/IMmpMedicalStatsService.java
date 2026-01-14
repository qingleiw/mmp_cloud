package org.dromara.cdi.mmp.ledger.service;

import org.dromara.cdi.mmp.ledger.domain.vo.MmpMedicalStatsVo;
import org.dromara.cdi.mmp.ledger.domain.bo.MmpMedicalStatsBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 医疗质量统计数据Service接口
 *
 * @author Lion Li
 * @date 2025-12-27
 */
public interface IMmpMedicalStatsService {

    /**
     * 查询医疗质量统计数据
     *
     * @param id 主键
     * @return 医疗质量统计数据
     */
    MmpMedicalStatsVo queryById(Long id);

    /**
     * 分页查询医疗质量统计数据列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 医疗质量统计数据分页列表
     */
    TableDataInfo<MmpMedicalStatsVo> queryPageList(MmpMedicalStatsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的医疗质量统计数据列表
     *
     * @param bo 查询条件
     * @return 医疗质量统计数据列表
     */
    List<MmpMedicalStatsVo> queryList(MmpMedicalStatsBo bo);

    /**
     * 新增医疗质量统计数据
     *
     * @param bo 医疗质量统计数据
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpMedicalStatsBo bo);

    /**
     * 修改医疗质量统计数据
     *
     * @param bo 医疗质量统计数据
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpMedicalStatsBo bo);

    /**
     * 校验并批量删除医疗质量统计数据信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
