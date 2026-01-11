import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationDoseAlertVO, RadiationDoseAlertForm, RadiationDoseAlertQuery } from '@/api/system/radiationDoseAlert/types';

/**
 * 查询剂量监测预警设置列表
 * @param query
 * @returns {*}
 */

export const listRadiationDoseAlert = (query?: RadiationDoseAlertQuery): AxiosPromise<RadiationDoseAlertVO[]> => {
  return request({
    url: '/system/radiationDoseAlert/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询剂量监测预警设置详细
 * @param id
 */
export const getRadiationDoseAlert = (id: string | number): AxiosPromise<RadiationDoseAlertVO> => {
  return request({
    url: '/system/radiationDoseAlert/' + id,
    method: 'get'
  });
};

/**
 * 新增剂量监测预警设置
 * @param data
 */
export const addRadiationDoseAlert = (data: RadiationDoseAlertForm) => {
  return request({
    url: '/system/radiationDoseAlert',
    method: 'post',
    data: data
  });
};

/**
 * 修改剂量监测预警设置
 * @param data
 */
export const updateRadiationDoseAlert = (data: RadiationDoseAlertForm) => {
  return request({
    url: '/system/radiationDoseAlert',
    method: 'put',
    data: data
  });
};

/**
 * 删除剂量监测预警设置
 * @param id
 */
export const delRadiationDoseAlert = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationDoseAlert/' + id,
    method: 'delete'
  });
};
