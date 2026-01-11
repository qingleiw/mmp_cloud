package org.dromara.cdi.mmp.tumorqc.service;

import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcIndicatorDetailVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcIndicatorDetailBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 质控指标明细数据Service接口
 *
 * @author Lion Li
 * @date 2025-12-23
 */
public interface IMmpTumorQcIndicatorDetailService {

    /**
     * 查询质控指标明细数据
     *
     * @param id 主键
     * @return 质控指标明细数据
     */
    MmpTumorQcIndicatorDetailVo queryById(Long id);

    /**
     * 分页查询质控指标明细数据列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 质控指标明细数据分页列表
     */
    TableDataInfo<MmpTumorQcIndicatorDetailVo> queryPageList(MmpTumorQcIndicatorDetailBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的质控指标明细数据列表
     *
     * @param bo 查询条件
     * @return 质控指标明细数据列表
     */
    List<MmpTumorQcIndicatorDetailVo> queryList(MmpTumorQcIndicatorDetailBo bo);

    /**
     * 新增质控指标明细数据
     *
     * @param bo 质控指标明细数据
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpTumorQcIndicatorDetailBo bo);

    /**
     * 修改质控指标明细数据
     *
     * @param bo 质控指标明细数据
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpTumorQcIndicatorDetailBo bo);

    /**
     * 校验并批量删除质控指标明细数据信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
