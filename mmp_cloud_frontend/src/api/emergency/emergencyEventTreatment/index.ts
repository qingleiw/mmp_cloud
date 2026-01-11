import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyEventTreatmentVO, EmergencyEventTreatmentForm, EmergencyEventTreatmentQuery } from '@/api/emergency/emergencyEventTreatment/types';

/**
 * 查询突发事件救治列表
 * @param query
 * @returns {*}
 */

export const listEmergencyEventTreatment = (query?: EmergencyEventTreatmentQuery): AxiosPromise<EmergencyEventTreatmentVO[]> => {
  return request({
    url: '/emergency/emergencyEventTreatment/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询突发事件救治详细
 * @param id
 */
export const getEmergencyEventTreatment = (id: string | number): AxiosPromise<EmergencyEventTreatmentVO> => {
  return request({
    url: '/emergency/emergencyEventTreatment/' + id,
    method: 'get'
  });
};

/**
 * 新增突发事件救治
 * @param data
 */
export const addEmergencyEventTreatment = (data: EmergencyEventTreatmentForm) => {
  return request({
    url: '/emergency/emergencyEventTreatment',
    method: 'post',
    data: data
  });
};

/**
 * 修改突发事件救治
 * @param data
 */
export const updateEmergencyEventTreatment = (data: EmergencyEventTreatmentForm) => {
  return request({
    url: '/emergency/emergencyEventTreatment',
    method: 'put',
    data: data
  });
};

/**
 * 删除突发事件救治
 * @param id
 */
export const delEmergencyEventTreatment = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyEventTreatment/' + id,
    method: 'delete'
  });
};
