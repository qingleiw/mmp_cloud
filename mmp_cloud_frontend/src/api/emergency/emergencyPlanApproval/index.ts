import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyPlanApprovalVO, EmergencyPlanApprovalForm, EmergencyPlanApprovalQuery } from '@/api/emergency/emergencyPlanApproval/types';

/**
 * 查询应急预案审批列表
 * @param query
 * @returns {*}
 */

export const listEmergencyPlanApproval = (query?: EmergencyPlanApprovalQuery): AxiosPromise<EmergencyPlanApprovalVO[]> => {
  return request({
    url: '/emergency/emergencyPlanApproval/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询应急预案审批详细
 * @param id
 */
export const getEmergencyPlanApproval = (id: string | number): AxiosPromise<EmergencyPlanApprovalVO> => {
  return request({
    url: '/emergency/emergencyPlanApproval/' + id,
    method: 'get'
  });
};

/**
 * 新增应急预案审批
 * @param data
 */
export const addEmergencyPlanApproval = (data: EmergencyPlanApprovalForm) => {
  return request({
    url: '/emergency/emergencyPlanApproval',
    method: 'post',
    data: data
  });
};

/**
 * 修改应急预案审批
 * @param data
 */
export const updateEmergencyPlanApproval = (data: EmergencyPlanApprovalForm) => {
  return request({
    url: '/emergency/emergencyPlanApproval',
    method: 'put',
    data: data
  });
};

/**
 * 删除应急预案审批
 * @param id
 */
export const delEmergencyPlanApproval = (id: string | number | Array<string | number>) => {
  return request({
    url: '/emergency/emergencyPlanApproval/' + id,
    method: 'delete'
  });
};
