import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationDoseRecordVO, RadiationDoseRecordForm, RadiationDoseRecordQuery } from '@/api/system/radiationDoseRecord/types';

/**
 * 查询个人剂量监测记录列表
 * @param query
 * @returns {*}
 */

export const listRadiationDoseRecord = (query?: RadiationDoseRecordQuery): AxiosPromise<RadiationDoseRecordVO[]> => {
  return request({
    url: '/system/radiationDoseRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询个人剂量监测记录详细
 * @param id
 */
export const getRadiationDoseRecord = (id: string | number): AxiosPromise<RadiationDoseRecordVO> => {
  return request({
    url: '/system/radiationDoseRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增个人剂量监测记录
 * @param data
 */
export const addRadiationDoseRecord = (data: RadiationDoseRecordForm) => {
  return request({
    url: '/system/radiationDoseRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改个人剂量监测记录
 * @param data
 */
export const updateRadiationDoseRecord = (data: RadiationDoseRecordForm) => {
  return request({
    url: '/system/radiationDoseRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除个人剂量监测记录
 * @param id
 */
export const delRadiationDoseRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationDoseRecord/' + id,
    method: 'delete'
  });
};
