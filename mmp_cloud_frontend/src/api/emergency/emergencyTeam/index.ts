import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyTeamVO, EmergencyTeamForm, EmergencyTeamQuery } from '@/api/emergency/emergencyTeam/types';

/**
 * 查询应急队伍列表
 * @param query
 * @returns {*}
 */

export const listEmergencyTeam = (query?: EmergencyTeamQuery): AxiosPromise<EmergencyTeamVO[]> => {
  return request({
    url: '/emergency/emergencyTeam/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询应急队伍详细
 * @param id
 */
export const getEmergencyTeam = (id: string | number): AxiosPromise<EmergencyTeamVO> => {
  return request({
    url: '/emergency/emergencyTeam/' + id,
    method: 'get'
  });
};

/**
 * 新增应急队伍
 * @param data
 */
export const addEmergencyTeam = (data: EmergencyTeamForm) => {
  return request({
    url: '/emergency/emergencyTeam',
    method: 'post',
    data: data
  });
};

/**
 * 修改应急队伍
 * @param data
 */
export const updateEmergencyTeam = (data: EmergencyTeamForm) => {
  return request({
    url: '/emergency/emergencyTeam',
    method: 'put',
    data: data
  });
};

/**
 * 删除应急队伍
 * @param id
 */
export const delEmergencyTeam = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyTeam/' + id,
    method: 'delete'
  });
};
