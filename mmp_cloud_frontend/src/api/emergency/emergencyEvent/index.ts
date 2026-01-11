import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyEventVO, EmergencyEventForm, EmergencyEventQuery } from '@/api/emergency/emergencyEvent/types';

/**
 * 查询突发事件记录列表
 * @param query
 * @returns {*}
 */

export const listEmergencyEvent = (query?: EmergencyEventQuery): AxiosPromise<EmergencyEventVO[]> => {
  return request({
    url: '/emergency/emergencyEvent/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询突发事件记录详细
 * @param id
 */
export const getEmergencyEvent = (id: string | number): AxiosPromise<EmergencyEventVO> => {
  return request({
    url: '/emergency/emergencyEvent/' + id,
    method: 'get'
  });
};

/**
 * 新增突发事件记录
 * @param data
 */
export const addEmergencyEvent = (data: EmergencyEventForm) => {
  return request({
    url: '/emergency/emergencyEvent',
    method: 'post',
    data: data
  });
};

/**
 * 修改突发事件记录
 * @param data
 */
export const updateEmergencyEvent = (data: EmergencyEventForm) => {
  return request({
    url: '/emergency/emergencyEvent',
    method: 'put',
    data: data
  });
};

/**
 * 删除突发事件记录
 * @param id
 */
export const delEmergencyEvent = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyEvent/' + id,
    method: 'delete'
  });
};
