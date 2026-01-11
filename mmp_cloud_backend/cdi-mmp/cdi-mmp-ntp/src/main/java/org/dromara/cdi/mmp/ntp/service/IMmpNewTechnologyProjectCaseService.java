package org.dromara.cdi.mmp.ntp.service;

import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectCaseVo;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectCaseBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 新技术病例登记Service接口
 *
 * @author Lion Li
 * @date 2026-01-07
 */
public interface IMmpNewTechnologyProjectCaseService {

    /**
     * 查询新技术病例登记
     *
     * @param id 主键
     * @return 新技术病例登记
     */
    MmpNewTechnologyProjectCaseVo queryById(Long id);

    /**
     * 分页查询新技术病例登记列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 新技术病例登记分页列表
     */
    TableDataInfo<MmpNewTechnologyProjectCaseVo> queryPageList(MmpNewTechnologyProjectCaseBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的新技术病例登记列表
     *
     * @param bo 查询条件
     * @return 新技术病例登记列表
     */
    List<MmpNewTechnologyProjectCaseVo> queryList(MmpNewTechnologyProjectCaseBo bo);

    /**
     * 新增新技术病例登记
     *
     * @param bo 新技术病例登记
     * @return 是否新增成功
     */
    Boolean insertByBo(MmpNewTechnologyProjectCaseBo bo);

    /**
     * 修改新技术病例登记
     *
     * @param bo 新技术病例登记
     * @return 是否修改成功
     */
    Boolean updateByBo(MmpNewTechnologyProjectCaseBo bo);

    /**
     * 校验并批量删除新技术病例登记信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
