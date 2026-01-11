import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyIncidentVO, EmergencyIncidentForm, EmergencyIncidentQuery } from '@/api/emergency/emergencyIncident/types';

/**
 * 查询突发事件记录列表
 * @param query
 * @returns {*}
 */

export const listEmergencyIncident = (query?: EmergencyIncidentQuery): AxiosPromise<EmergencyIncidentVO[]> => {
  return request({
    url: '/emergency/emergencyIncident/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询突发事件记录详细
 * @param id
 */
export const getEmergencyIncident = (id: string | number): AxiosPromise<EmergencyIncidentVO> => {
  return request({
    url: '/emergency/emergencyIncident/' + id,
    method: 'get'
  });
};

/**
 * 新增突发事件记录
 * @param data
 */
export const addEmergencyIncident = (data: EmergencyIncidentForm) => {
  return request({
    url: '/emergency/emergencyIncident',
    method: 'post',
    data: data
  });
};

/**
 * 修改突发事件记录
 * @param data
 */
export const updateEmergencyIncident = (data: EmergencyIncidentForm) => {
  return request({
    url: '/emergency/emergencyIncident',
    method: 'put',
    data: data
  });
};

/**
 * 删除突发事件记录
 * @param id
 */
export const delEmergencyIncident = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyIncident/' + id,
    method: 'delete'
  });
};
