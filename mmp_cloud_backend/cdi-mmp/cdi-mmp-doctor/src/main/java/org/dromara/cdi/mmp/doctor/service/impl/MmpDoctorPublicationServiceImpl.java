package org.dromara.cdi.mmp.doctor.service.impl;

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
import org.dromara.cdi.mmp.doctor.domain.bo.MmpDoctorPublicationBo;
import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorPublicationVo;
import org.dromara.cdi.mmp.doctor.domain.MmpDoctorPublication;
import org.dromara.cdi.mmp.doctor.mapper.MmpDoctorPublicationMapper;
import org.dromara.cdi.mmp.doctor.service.IMmpDoctorPublicationService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 论文论著Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-23
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpDoctorPublicationServiceImpl implements IMmpDoctorPublicationService {

    private final MmpDoctorPublicationMapper baseMapper;

    /**
     * 查询论文论著
     *
     * @param id 主键
     * @return 论文论著
     */
    @Override
    public MmpDoctorPublicationVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询论文论著列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 论文论著分页列表
     */
    @Override
    public TableDataInfo<MmpDoctorPublicationVo> queryPageList(MmpDoctorPublicationBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpDoctorPublication> lqw = buildQueryWrapper(bo);
        Page<MmpDoctorPublicationVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的论文论著列表
     *
     * @param bo 查询条件
     * @return 论文论著列表
     */
    @Override
    public List<MmpDoctorPublicationVo> queryList(MmpDoctorPublicationBo bo) {
        LambdaQueryWrapper<MmpDoctorPublication> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpDoctorPublication> buildQueryWrapper(MmpDoctorPublicationBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpDoctorPublication> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpDoctorPublication::getId);
        lqw.eq(bo.getDoctorId() != null, MmpDoctorPublication::getDoctorId, bo.getDoctorId());
        lqw.eq(StringUtils.isNotBlank(bo.getPublicationType()), MmpDoctorPublication::getPublicationType, bo.getPublicationType());
        lqw.eq(StringUtils.isNotBlank(bo.getTitle()), MmpDoctorPublication::getTitle, bo.getTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthors()), MmpDoctorPublication::getAuthors, bo.getAuthors());
        lqw.eq(bo.getAuthorOrder() != null, MmpDoctorPublication::getAuthorOrder, bo.getAuthorOrder());
        lqw.like(StringUtils.isNotBlank(bo.getJournalName()), MmpDoctorPublication::getJournalName, bo.getJournalName());
        lqw.eq(bo.getPublishDate() != null, MmpDoctorPublication::getPublishDate, bo.getPublishDate());
        lqw.eq(StringUtils.isNotBlank(bo.getVolume()), MmpDoctorPublication::getVolume, bo.getVolume());
        lqw.eq(StringUtils.isNotBlank(bo.getIssue()), MmpDoctorPublication::getIssue, bo.getIssue());
        lqw.eq(StringUtils.isNotBlank(bo.getPages()), MmpDoctorPublication::getPages, bo.getPages());
        lqw.eq(StringUtils.isNotBlank(bo.getDoi()), MmpDoctorPublication::getDoi, bo.getDoi());
        lqw.eq(bo.getImpactFactor() != null, MmpDoctorPublication::getImpactFactor, bo.getImpactFactor());
        lqw.eq(bo.getCitationCount() != null, MmpDoctorPublication::getCitationCount, bo.getCitationCount());
        lqw.eq(StringUtils.isNotBlank(bo.getFullTextUrl()), MmpDoctorPublication::getFullTextUrl, bo.getFullTextUrl());
        lqw.eq(bo.getDelFlag() != null, MmpDoctorPublication::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增论文论著
     *
     * @param bo 论文论著
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpDoctorPublicationBo bo) {
        MmpDoctorPublication add = MapstructUtils.convert(bo, MmpDoctorPublication.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改论文论著
     *
     * @param bo 论文论著
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpDoctorPublicationBo bo) {
        MmpDoctorPublication update = MapstructUtils.convert(bo, MmpDoctorPublication.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpDoctorPublication entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除论文论著信息
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
