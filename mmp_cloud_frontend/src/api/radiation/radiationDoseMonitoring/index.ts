import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationDoseMonitoringVO, RadiationDoseMonitoringForm, RadiationDoseMonitoringQuery } from '@/api/radiation/radiationDoseMonitoring/types';

/**
 * 查询个人剂量监测列表
 * @param query
 * @returns {*}
 */

export const listRadiationDoseMonitoring = (query?: RadiationDoseMonitoringQuery): AxiosPromise<RadiationDoseMonitoringVO[]> => {
  return request({
    url: '/radiation/radiationDoseMonitoring/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询个人剂量监测详细
 * @param id
 */
export const getRadiationDoseMonitoring = (id: string | number): AxiosPromise<RadiationDoseMonitoringVO> => {
  return request({
    url: '/radiation/radiationDoseMonitoring/' + id,
    method: 'get'
  });
};

/**
 * 新增个人剂量监测
 * @param data
 */
export const addRadiationDoseMonitoring = (data: RadiationDoseMonitoringForm) => {
  return request({
    url: '/radiation/radiationDoseMonitoring',
    method: 'post',
    data: data
  });
};

/**
 * 修改个人剂量监测
 * @param data
 */
export const updateRadiationDoseMonitoring = (data: RadiationDoseMonitoringForm) => {
  return request({
    url: '/radiation/radiationDoseMonitoring',
    method: 'put',
    data: data
  });
};

/**
 * 删除个人剂量监测
 * @param id
 */
export const delRadiationDoseMonitoring = (id: string | number | Array<string | number>) => {
  return request({
    url: '/radiation/radiationDoseMonitoring/' + id,
    method: 'delete'
  });
};
