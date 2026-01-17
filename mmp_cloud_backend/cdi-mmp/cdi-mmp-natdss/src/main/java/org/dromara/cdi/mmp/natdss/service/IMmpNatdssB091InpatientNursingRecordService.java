package org.dromara.cdi.mmp.natdss.service;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB091InpatientNursingRecord;
import org.dromara.cdi.mmp.natdss.domain.vo.MmpNatdssB091InpatientNursingRecordVo;
import org.dromara.cdi.mmp.natdss.domain.bo.MmpNatdssB091InpatientNursingRecordBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * B09-1 住院护理记录Service接口
 *
 * @author LionLi
 * @date 2026-01-15
 */
public interface IMmpNatdssB091InpatientNursingRecordService {

    /**
     * 查询B09-1 住院护理记录
     *
     * @param id 主键
     * @return B09-1 住院护理记录
     */
    MmpNatdssB091InpatientNursingRecordVo queryById(Long id);

    /**
     * 分页查询B09-1 住院护理记录列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return B09-1 住院护理记录分页列表
     */
    TableDataInfo<MmpNatdssB091InpatientNursingRecordVo> queryPageList(MmpNatdssB091InpatientNursingRecordBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的B09-1 住院护理记录列表
     *
     * @param bo 查询条件
     * @return B09-1 住院护理记录列表
     */
    List<MmpNatdssB091InpatientNursingRecordVo> queryList(MmpNatdssB091InpatientNursingRecordBo bo);

    /**
     * 新增B09-1 住院护理记录
     *
     * @param bo B09-1 住院护理记录
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNatdssB091InpatientNursingRecordBo bo);

    /**
     * 修改B09-1 住院护理记录
     *
     * @param bo B09-1 住院护理记录
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNatdssB091InpatientNursingRecordBo bo);

    /**
     * 校验并批量删除B09-1 住院护理记录信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
