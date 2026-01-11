import request from '@/utils/request';
import type { DoctorInfoVO } from './types';

/**
 * 获取医师档案信息
 * @param doctorId 医师ID
 * @returns 医师档案信息
 */
export function getDoctorArchive(doctorId: number | string) {
  return request.get<DoctorInfoVO>(`/doctor/doctorInfo/archive/${doctorId}`);
}
