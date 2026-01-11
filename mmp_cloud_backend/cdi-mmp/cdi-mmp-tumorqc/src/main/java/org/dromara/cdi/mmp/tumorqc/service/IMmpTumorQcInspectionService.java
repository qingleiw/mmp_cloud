package org.dromara.cdi.mmp.tumorqc.service;

import org.dromara.cdi.mmp.tumorqc.domain.vo.MmpTumorQcInspectionVo;
import org.dromara.cdi.mmp.tumorqc.domain.bo.MmpTumorQcInspectionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 肿瘤质控检查Service接口
 *
 * @author Lion Li
 * @date 2025-12-26
 */
public interface IMmpTumorQcInspectionService {

    /**
     * 查询肿瘤质控检查
     *
     * @param id 主键
     * @return 肿瘤质控检查
     */
    MmpTumorQcInspectionVo queryById(Long id);

    /**
     * 分页查询肿瘤质控检查列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 肿瘤质控检查分页列表
     */
    TableDataInfo<MmpTumorQcInspectionVo> queryPageList(MmpTumorQcInspectionBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的肿瘤质控检查列表
     *
     * @param bo 查询条件
     * @return 肿瘤质控检查列表
     */
    List<MmpTumorQcInspectionVo> queryList(MmpTumorQcInspectionBo bo);

    /**
     * 新增肿瘤质控检查
     *
     * @param bo 肿瘤质控检查
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpTumorQcInspectionBo bo);

    /**
     * 修改肿瘤质控检查
     *
     * @param bo 肿瘤质控检查
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpTumorQcInspectionBo bo);

    /**
     * 校验并批量删除肿瘤质控检查信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
