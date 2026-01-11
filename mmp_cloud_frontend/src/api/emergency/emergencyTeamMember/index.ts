import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyTeamMemberVO, EmergencyTeamMemberForm, EmergencyTeamMemberQuery } from '@/api/system/emergencyTeamMember/types';

/**
 * 查询应急队伍成员列表
 * @param query
 * @returns {*}
 */

export const listEmergencyTeamMember = (query?: EmergencyTeamMemberQuery): AxiosPromise<EmergencyTeamMemberVO[]> => {
  return request({
    url: '/system/emergencyTeamMember/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询应急队伍成员详细
 * @param id
 */
export const getEmergencyTeamMember = (id: string | number): AxiosPromise<EmergencyTeamMemberVO> => {
  return request({
    url: '/system/emergencyTeamMember/' + id,
    method: 'get'
  });
};

/**
 * 新增应急队伍成员
 * @param data
 */
export const addEmergencyTeamMember = (data: EmergencyTeamMemberForm) => {
  return request({
    url: '/system/emergencyTeamMember',
    method: 'post',
    data: data
  });
};

/**
 * 修改应急队伍成员
 * @param data
 */
export const updateEmergencyTeamMember = (data: EmergencyTeamMemberForm) => {
  return request({
    url: '/system/emergencyTeamMember',
    method: 'put',
    data: data
  });
};

/**
 * 删除应急队伍成员
 * @param id
 */
export const delEmergencyTeamMember = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/emergencyTeamMember/' + id,
    method: 'delete'
  });
};
