package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB061EmrProgressNotes;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB061EmrProgressNotesVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB061EmrProgressNotesBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B06-1 病程记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB061EmrProgressNotesService {

    /**
     * 查询B06-1 病程记录
     *
     * @param id 主键
     * @return B06-1 病程记录
     */
    MmpNatdssB061EmrProgressNotesVo queryById(Long id);

    /**
     * 分页查询B06-1 病程记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B06-1 病程记录分页列表
     */
    TableDataInfo<MmpNatdssB061EmrProgressNotesVo> queryPageList(MmpNatdssB061EmrProgressNotesBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B06-1 病程记录列表
     *
     * @param bo 查询条件
     * @return B06-1 病程记录列表
     */
    List<MmpNatdssB061EmrProgressNotesVo> queryList(MmpNatdssB061EmrProgressNotesBo bo);

    /**
     * 新增B06-1 病程记录
     *
     * @param bo B06-1 病程记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB061EmrProgressNotesBo bo);

    /**
     * 修改B06-1 病程记录
     *
     * @param bo B06-1 病程记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB061EmrProgressNotesBo bo);

    /**
     * 校验并批量删除B06-1 病程记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
