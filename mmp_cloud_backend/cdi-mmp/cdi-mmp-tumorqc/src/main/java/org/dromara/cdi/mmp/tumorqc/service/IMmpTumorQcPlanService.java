package org.dromara.cdi.mmp.tumorqc.service;

import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcPlanVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcPlanBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 肿瘤质控方案Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpTumorQcPlanService {

    /**
     * 查询肿瘤质控方案
     *
     * @param id 主键
     * @return 肿瘤质控方案
     */
    MmpTumorQcPlanVo queryById(Long id);

    /**
     * 分页查询肿瘤质控方案列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控方案分页列表
     */
    TableDataInfo<MmpTumorQcPlanVo> queryPageList(MmpTumorQcPlanBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的肿瘤质控方案列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控方案列表
     */
    List<MmpTumorQcPlanVo> queryList(MmpTumorQcPlanBo bo);

    /**
     * 新增肿瘤质控方案
     *
     * @param bo 肿瘤质控方案
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpTumorQcPlanBo bo);

    /**
     * 修改肿瘤质控方案
     *
     * @param bo 肿瘤质控方案
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpTumorQcPlanBo bo);

    /**
     * 校验并批量删除肿瘤质控方案信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
