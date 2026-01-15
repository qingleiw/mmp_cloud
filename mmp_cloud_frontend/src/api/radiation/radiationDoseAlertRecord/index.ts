import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  RadiationDoseAlertRecordVO,
  RadiationDoseAlertRecordForm,
  RadiationDoseAlertRecordQuery
} from '@/api/radiation/radiationDoseAlertRecord/types';

/**
 * 查询剂量异常预警记录列表
 * @param query
 * @returns {*}
 */

export const listRadiationDoseAlertRecord = (query?: RadiationDoseAlertRecordQuery): AxiosPromise<RadiationDoseAlertRecordVO[]> => {
  return request({
    url: '/radiation/radiationDoseAlertRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询剂量异常预警记录详细
 * @param id
 */
export const getRadiationDoseAlertRecord = (id: string | number): AxiosPromise<RadiationDoseAlertRecordVO> => {
  return request({
    url: '/radiation/radiationDoseAlertRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增剂量异常预警记录
 * @param data
 */
export const addRadiationDoseAlertRecord = (data: RadiationDoseAlertRecordForm) => {
  return request({
    url: '/radiation/radiationDoseAlertRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改剂量异常预警记录
 * @param data
 */
export const updateRadiationDoseAlertRecord = (data: RadiationDoseAlertRecordForm) => {
  return request({
    url: '/radiation/radiationDoseAlertRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除剂量异常预警记录
 * @param id
 */
export const delRadiationDoseAlertRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/radiation/radiationDoseAlertRecord/' + id,
    method: 'delete'
  });
};
