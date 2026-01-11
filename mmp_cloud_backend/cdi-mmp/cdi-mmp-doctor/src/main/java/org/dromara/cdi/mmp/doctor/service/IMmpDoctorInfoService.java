package org.dromara.cdi.mmp.doctor.service;

import org.dromara.cdi.mmp.doctor.domain.vo.MmpDoctorInfoVo;

/**
 * 医师信息Service接口
 *
 * @author Lion Li
 * @date 2026-01-05
 */
public interface IMmpDoctorInfoService {

    /**
     * 获取医师档案信息
     *
     * @param doctorId 医师ID
     * @return 医师档案信息
     */
    MmpDoctorInfoVo getDoctorArchive(Long doctorId);
}
