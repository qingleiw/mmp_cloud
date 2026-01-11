package org.dromara.cdi.mmp.radiation.service;

import org.dromara.cdi.mmp.radiation.domain.vo.MmpRadiationTrainingParticipantVo;
import org.dromara.cdi.mmp.radiation.domain.bo.MmpRadiationTrainingParticipantBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 培训参与记录Service接口
 *
 * @author Lion Li
 * @date 2026-01-03
 */
public interface IMmpRadiationTrainingParticipantService {

    /**
     * 查询培训参与记录
     *
     * @param id 主键
     * @return 培训参与记录
     */
    MmpRadiationTrainingParticipantVo queryById(Long id);

    /**
     * 分页查询培训参与记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 培训参与记录分页列表
     */
    TableDataInfo<MmpRadiationTrainingParticipantVo> queryPageList(MmpRadiationTrainingParticipantBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的培训参与记录列表
     *
     * @param bo 查询条件
     * @return 培训参与记录列表
     */
    List<MmpRadiationTrainingParticipantVo> queryList(MmpRadiationTrainingParticipantBo bo);

    /**
     * 新增培训参与记录
     *
     * @param bo 培训参与记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpRadiationTrainingParticipantBo bo);

    /**
     * 修改培训参与记录
     *
     * @param bo 培训参与记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpRadiationTrainingParticipantBo bo);

    /**
     * 校验并批量删除培训参与记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
