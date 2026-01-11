import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  CoreSystemExecutionRecordVO,
  CoreSystemExecutionRecordForm,
  CoreSystemExecutionRecordQuery
} from '@/api/system/coreSystemExecutionRecord/types';

/**
 * 查询制度执行记录列表
 * @param query
 * @returns {*}
 */

export const listCoreSystemExecutionRecord = (query?: CoreSystemExecutionRecordQuery): AxiosPromise<CoreSystemExecutionRecordVO[]> => {
  return request({
    url: '/system/coreSystemExecutionRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询制度执行记录详细
 * @param id
 */
export const getCoreSystemExecutionRecord = (id: string | number): AxiosPromise<CoreSystemExecutionRecordVO> => {
  return request({
    url: '/system/coreSystemExecutionRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增制度执行记录
 * @param data
 */
export const addCoreSystemExecutionRecord = (data: CoreSystemExecutionRecordForm) => {
  return request({
    url: '/system/coreSystemExecutionRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改制度执行记录
 * @param data
 */
export const updateCoreSystemExecutionRecord = (data: CoreSystemExecutionRecordForm) => {
  return request({
    url: '/system/coreSystemExecutionRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除制度执行记录
 * @param id
 */
export const delCoreSystemExecutionRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/coreSystemExecutionRecord/' + id,
    method: 'delete'
  });
};
