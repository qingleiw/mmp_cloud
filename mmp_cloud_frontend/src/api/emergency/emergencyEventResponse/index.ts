import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyEventResponseVO, EmergencyEventResponseForm, EmergencyEventResponseQuery } from '@/api/emergency/emergencyEventResponse/types';

/**
 * 查询突发事件响应列表
 * @param query
 * @returns {*}
 */

export const listEmergencyEventResponse = (query?: EmergencyEventResponseQuery): AxiosPromise<EmergencyEventResponseVO[]> => {
  return request({
    url: '/emergency/emergencyEventResponse/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询突发事件响应详细
 * @param id
 */
export const getEmergencyEventResponse = (id: string | number): AxiosPromise<EmergencyEventResponseVO> => {
  return request({
    url: '/emergency/emergencyEventResponse/' + id,
    method: 'get'
  });
};

/**
 * 新增突发事件响应
 * @param data
 */
export const addEmergencyEventResponse = (data: EmergencyEventResponseForm) => {
  return request({
    url: '/emergency/emergencyEventResponse',
    method: 'post',
    data: data
  });
};

/**
 * 修改突发事件响应
 * @param data
 */
export const updateEmergencyEventResponse = (data: EmergencyEventResponseForm) => {
  return request({
    url: '/emergency/emergencyEventResponse',
    method: 'put',
    data: data
  });
};

/**
 * 删除突发事件响应
 * @param id
 */
export const delEmergencyEventResponse = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyEventResponse/' + id,
    method: 'delete'
  });
};
