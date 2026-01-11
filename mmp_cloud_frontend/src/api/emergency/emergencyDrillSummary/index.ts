import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { EmergencyDrillSummaryVO, EmergencyDrillSummaryForm, EmergencyDrillSummaryQuery } from '@/api/system/emergencyDrillSummary/types';

/**
 * 查询应急演练总结列表
 * @param query
 * @returns {*}
 */

export const listEmergencyDrillSummary = (query?: EmergencyDrillSummaryQuery): AxiosPromise<EmergencyDrillSummaryVO[]> => {
  return request({
    url: '/system/emergencyDrillSummary/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询应急演练总结详细
 * @param id
 */
export const getEmergencyDrillSummary = (id: string | number): AxiosPromise<EmergencyDrillSummaryVO> => {
  return request({
    url: '/system/emergencyDrillSummary/' + id,
    method: 'get'
  });
};

/**
 * 新增应急演练总结
 * @param data
 */
export const addEmergencyDrillSummary = (data: EmergencyDrillSummaryForm) => {
  return request({
    url: '/system/emergencyDrillSummary',
    method: 'post',
    data: data
  });
};

/**
 * 修改应急演练总结
 * @param data
 */
export const updateEmergencyDrillSummary = (data: EmergencyDrillSummaryForm) => {
  return request({
    url: '/system/emergencyDrillSummary',
    method: 'put',
    data: data
  });
};

/**
 * 删除应急演练总结
 * @param id
 */
export const delEmergencyDrillSummary = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/emergencyDrillSummary/' + id,
    method: 'delete'
  });
};
