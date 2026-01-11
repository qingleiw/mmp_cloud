package org.dromara.cdi.mmp.surgery.service;

import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryVideoVo;
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryVideoBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 手术视频Service接口
 *
 * @author Lion Li
 * @date 2025-12-28
 */
public interface IMmpSurgeryVideoService {

    /**
     * 查询手术视频
     *
     * @param id 主键
     * @return 手术视频
     */
    MmpSurgeryVideoVo queryById(Long id);

    /**
     * 分页查询手术视频列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术视频分页列表
     */
    TableDataInfo<MmpSurgeryVideoVo> queryPageList(MmpSurgeryVideoBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的手术视频列表
     *
     * @param bo 查询条件
     * @return 手术视频列表
     */
    List<MmpSurgeryVideoVo> queryList(MmpSurgeryVideoBo bo);

    /**
     * 新增手术视频
     *
     * @param bo 手术视频
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpSurgeryVideoBo bo);

    /**
     * 修改手术视频
     *
     * @param bo 手术视频
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpSurgeryVideoBo bo);

    /**
     * 校验并批量删除手术视频信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
