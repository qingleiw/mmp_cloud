import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyMedicalSupportVO, EmergencyMedicalSupportForm, EmergencyMedicalSupportQuery } from '@/api/emergency/emergencyMedicalSupport/types';

/**
 * 查询医疗保障资源列表
 * @param query
 * @returns {*}
 */

export const listEmergencyMedicalSupport = (query?: EmergencyMedicalSupportQuery): AxiosPromise<EmergencyMedicalSupportVO[]> => {
  return request({
    url: '/emergency/emergencyMedicalSupport/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医疗保障资源详细
 * @param id
 */
export const getEmergencyMedicalSupport = (id: string | number): AxiosPromise<EmergencyMedicalSupportVO> => {
  return request({
    url: '/emergency/emergencyMedicalSupport/' + id,
    method: 'get'
  });
};

/**
 * 新增医疗保障资源
 * @param data
 */
export const addEmergencyMedicalSupport = (data: EmergencyMedicalSupportForm) => {
  return request({
    url: '/emergency/emergencyMedicalSupport',
    method: 'post',
    data: data
  });
};

/**
 * 修改医疗保障资源
 * @param data
 */
export const updateEmergencyMedicalSupport = (data: EmergencyMedicalSupportForm) => {
  return request({
    url: '/emergency/emergencyMedicalSupport',
    method: 'put',
    data: data
  });
};

/**
 * 删除医疗保障资源
 * @param id
 */
export const delEmergencyMedicalSupport = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyMedicalSupport/' + id,
    method: 'delete'
  });
};
