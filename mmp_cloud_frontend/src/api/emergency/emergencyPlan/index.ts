import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyPlanVO, EmergencyPlanForm, EmergencyPlanQuery } from '@/api/system/emergencyPlan/types';

/**
 * 查询应急预案列表
 * @param query
 * @returns {*}
 */

export const listEmergencyPlan = (query?: EmergencyPlanQuery): AxiosPromise<EmergencyPlanVO[]> => {
  return request({
    url: '/system/emergencyPlan/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询应急预案详细
 * @param id
 */
export const getEmergencyPlan = (id: string | number): AxiosPromise<EmergencyPlanVO> => {
  return request({
    url: '/system/emergencyPlan/' + id,
    method: 'get'
  });
};

/**
 * 新增应急预案
 * @param data
 */
export const addEmergencyPlan = (data: EmergencyPlanForm) => {
  return request({
    url: '/system/emergencyPlan',
    method: 'post',
    data: data
  });
};

/**
 * 修改应急预案
 * @param data
 */
export const updateEmergencyPlan = (data: EmergencyPlanForm) => {
  return request({
    url: '/system/emergencyPlan',
    method: 'put',
    data: data
  });
};

/**
 * 删除应急预案
 * @param id
 */
export const delEmergencyPlan = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/emergencyPlan/' + id,
    method: 'delete'
  });
};
