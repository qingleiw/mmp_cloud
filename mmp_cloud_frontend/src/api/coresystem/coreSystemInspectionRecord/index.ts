import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  CoreSystemInspectionRecordVO,
  CoreSystemInspectionRecordForm,
  CoreSystemInspectionRecordQuery
} from '@/api/system/coreSystemInspectionRecord/types';

/**
 * 查询制度检查记录列表
 * @param query
 * @returns {*}
 */

export const listCoreSystemInspectionRecord = (query?: CoreSystemInspectionRecordQuery): AxiosPromise<CoreSystemInspectionRecordVO[]> => {
  return request({
    url: '/system/coreSystemInspectionRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询制度检查记录详细
 * @param id
 */
export const getCoreSystemInspectionRecord = (id: string | number): AxiosPromise<CoreSystemInspectionRecordVO> => {
  return request({
    url: '/system/coreSystemInspectionRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增制度检查记录
 * @param data
 */
export const addCoreSystemInspectionRecord = (data: CoreSystemInspectionRecordForm) => {
  return request({
    url: '/system/coreSystemInspectionRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改制度检查记录
 * @param data
 */
export const updateCoreSystemInspectionRecord = (data: CoreSystemInspectionRecordForm) => {
  return request({
    url: '/system/coreSystemInspectionRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除制度检查记录
 * @param id
 */
export const delCoreSystemInspectionRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/coreSystemInspectionRecord/' + id,
    method: 'delete'
  });
};
