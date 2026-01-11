package org.dromara.cdi.mmp.ntp.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.cdi.mmp.ntp.domain.bo.MmpNewTechnologyProjectDocumentBo;
import org.dromara.cdi.mmp.ntp.domain.vo.MmpNewTechnologyProjectDocumentVo;
import org.dromara.cdi.mmp.ntp.domain.MmpNewTechnologyProjectDocument;
import org.dromara.cdi.mmp.ntp.mapper.MmpNewTechnologyProjectDocumentMapper;
import org.dromara.cdi.mmp.ntp.service.IMmpNewTechnologyProjectDocumentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 项目文档Service业务层处理
 *
 * @author Lion Li
 * @date 2026-01-07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpNewTechnologyProjectDocumentServiceImpl implements IMmpNewTechnologyProjectDocumentService {

    private final MmpNewTechnologyProjectDocumentMapper baseMapper;

    /**
     * 查询项目文档
     *
     * @param id 主键
     * @return 项目文档
     */
    @Override
    public MmpNewTechnologyProjectDocumentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询项目文档列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 项目文档分页列表
     */
    @Override
    public TableDataInfo<MmpNewTechnologyProjectDocumentVo> queryPageList(MmpNewTechnologyProjectDocumentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpNewTechnologyProjectDocument> lqw = buildQueryWrapper(bo);
        Page<MmpNewTechnologyProjectDocumentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的项目文档列表
     *
     * @param bo 查询条件
     * @return 项目文档列表
     */
    @Override
    public List<MmpNewTechnologyProjectDocumentVo> queryList(MmpNewTechnologyProjectDocumentBo bo) {
        LambdaQueryWrapper<MmpNewTechnologyProjectDocument> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpNewTechnologyProjectDocument> buildQueryWrapper(MmpNewTechnologyProjectDocumentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpNewTechnologyProjectDocument> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpNewTechnologyProjectDocument::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getDocumentType()), MmpNewTechnologyProjectDocument::getDocumentType, bo.getDocumentType());
        lqw.like(StringUtils.isNotBlank(bo.getDocumentName()), MmpNewTechnologyProjectDocument::getDocumentName, bo.getDocumentName());
        lqw.eq(StringUtils.isNotBlank(bo.getFilePath()), MmpNewTechnologyProjectDocument::getFilePath, bo.getFilePath());
        lqw.like(StringUtils.isNotBlank(bo.getFileName()), MmpNewTechnologyProjectDocument::getFileName, bo.getFileName());
        lqw.eq(bo.getFileSize() != null, MmpNewTechnologyProjectDocument::getFileSize, bo.getFileSize());
        lqw.eq(StringUtils.isNotBlank(bo.getUploadBy()), MmpNewTechnologyProjectDocument::getUploadBy, bo.getUploadBy());
        lqw.eq(bo.getUploadTime() != null, MmpNewTechnologyProjectDocument::getUploadTime, bo.getUploadTime());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), MmpNewTechnologyProjectDocument::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增项目文档
     *
     * @param bo 项目文档
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpNewTechnologyProjectDocumentBo bo) {
        MmpNewTechnologyProjectDocument add = MapstructUtils.convert(bo, MmpNewTechnologyProjectDocument.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改项目文档
     *
     * @param bo 项目文档
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpNewTechnologyProjectDocumentBo bo) {
        MmpNewTechnologyProjectDocument update = MapstructUtils.convert(bo, MmpNewTechnologyProjectDocument.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpNewTechnologyProjectDocument entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除项目文档信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
