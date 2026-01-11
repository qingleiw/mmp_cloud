package org.dromara.cdi.mmp.surgery.service.impl;

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
import org.dromara.cdi.mmp.surgery.domain.bo.MmpSurgeryVideoBo;
import org.dromara.cdi.mmp.surgery.domain.vo.MmpSurgeryVideoVo;
import org.dromara.cdi.mmp.surgery.domain.MmpSurgeryVideo;
import org.dromara.cdi.mmp.surgery.mapper.MmpSurgeryVideoMapper;
import org.dromara.cdi.mmp.surgery.service.IMmpSurgeryVideoService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 手术视频Service业务层处理
 *
 * @author Lion Li
 * @date 2025-12-28
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MmpSurgeryVideoServiceImpl implements IMmpSurgeryVideoService {

    private final MmpSurgeryVideoMapper baseMapper;

    /**
     * 查询手术视频
     *
     * @param id 主键
     * @return 手术视频
     */
    @Override
    public MmpSurgeryVideoVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询手术视频列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 手术视频分页列表
     */
    @Override
    public TableDataInfo<MmpSurgeryVideoVo> queryPageList(MmpSurgeryVideoBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<MmpSurgeryVideo> lqw = buildQueryWrapper(bo);
        Page<MmpSurgeryVideoVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的手术视频列表
     *
     * @param bo 查询条件
     * @return 手术视频列表
     */
    @Override
    public List<MmpSurgeryVideoVo> queryList(MmpSurgeryVideoBo bo) {
        LambdaQueryWrapper<MmpSurgeryVideo> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<MmpSurgeryVideo> buildQueryWrapper(MmpSurgeryVideoBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<MmpSurgeryVideo> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(MmpSurgeryVideo::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getVideoNo()), MmpSurgeryVideo::getVideoNo, bo.getVideoNo());
        lqw.eq(StringUtils.isNotBlank(bo.getVideoTitle()), MmpSurgeryVideo::getVideoTitle, bo.getVideoTitle());
        lqw.eq(StringUtils.isNotBlank(bo.getVideoType()), MmpSurgeryVideo::getVideoType, bo.getVideoType());
        lqw.eq(StringUtils.isNotBlank(bo.getVideoUrl()), MmpSurgeryVideo::getVideoUrl, bo.getVideoUrl());
        lqw.eq(bo.getVideoDuration() != null, MmpSurgeryVideo::getVideoDuration, bo.getVideoDuration());
        lqw.eq(bo.getVideoSize() != null, MmpSurgeryVideo::getVideoSize, bo.getVideoSize());
        lqw.eq(StringUtils.isNotBlank(bo.getVideoFormat()), MmpSurgeryVideo::getVideoFormat, bo.getVideoFormat());
        lqw.eq(StringUtils.isNotBlank(bo.getRecordingDevice()), MmpSurgeryVideo::getRecordingDevice, bo.getRecordingDevice());
        lqw.like(StringUtils.isNotBlank(bo.getRecordingDoctorName()), MmpSurgeryVideo::getRecordingDoctorName, bo.getRecordingDoctorName());
        lqw.eq(bo.getUploadTime() != null, MmpSurgeryVideo::getUploadTime, bo.getUploadTime());
        lqw.eq(StringUtils.isNotBlank(bo.getReviewStatus()), MmpSurgeryVideo::getReviewStatus, bo.getReviewStatus());
        lqw.eq(bo.getReviewTime() != null, MmpSurgeryVideo::getReviewTime, bo.getReviewTime());
        lqw.eq(StringUtils.isNotBlank(bo.getReviewComment()), MmpSurgeryVideo::getReviewComment, bo.getReviewComment());
        lqw.eq(StringUtils.isNotBlank(bo.getAccessLevel()), MmpSurgeryVideo::getAccessLevel, bo.getAccessLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getDelFlag()), MmpSurgeryVideo::getDelFlag, bo.getDelFlag());
        return lqw;
    }

    /**
     * 新增手术视频
     *
     * @param bo 手术视频
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(MmpSurgeryVideoBo bo) {
        MmpSurgeryVideo add = MapstructUtils.convert(bo, MmpSurgeryVideo.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改手术视频
     *
     * @param bo 手术视频
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(MmpSurgeryVideoBo bo) {
        MmpSurgeryVideo update = MapstructUtils.convert(bo, MmpSurgeryVideo.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(MmpSurgeryVideo entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除手术视频信息
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
