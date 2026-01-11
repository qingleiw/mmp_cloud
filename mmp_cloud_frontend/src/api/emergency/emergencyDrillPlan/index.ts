import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyDrillPlanVO, EmergencyDrillPlanForm, EmergencyDrillPlanQuery } from '@/api/emergency/emergencyDrillPlan/types';

/**
 * 查询应急演练计划列表
 * @param query
 * @returns {*}
 */

export const listEmergencyDrillPlan = (query?: EmergencyDrillPlanQuery): AxiosPromise<EmergencyDrillPlanVO[]> => {
  return request({
    url: '/emergency/emergencyDrillPlan/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询应急演练计划详细
 * @param id
 */
export const getEmergencyDrillPlan = (id: string | number): AxiosPromise<EmergencyDrillPlanVO> => {
  return request({
    url: '/emergency/emergencyDrillPlan/' + id,
    method: 'get'
  });
};

/**
 * 新增应急演练计划
 * @param data
 */
export const addEmergencyDrillPlan = (data: EmergencyDrillPlanForm) => {
  return request({
    url: '/emergency/emergencyDrillPlan',
    method: 'post',
    data: data
  });
};

/**
 * 修改应急演练计划
 * @param data
 */
export const updateEmergencyDrillPlan = (data: EmergencyDrillPlanForm) => {
  return request({
    url: '/emergency/emergencyDrillPlan',
    method: 'put',
    data: data
  });
};

/**
 * 删除应急演练计划
 * @param id
 */
export const delEmergencyDrillPlan = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyDrillPlan/' + id,
    method: 'delete'
  });
};
