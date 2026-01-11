import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  CoreSystemRectificationRecordVO,
  CoreSystemRectificationRecordForm,
  CoreSystemRectificationRecordQuery
} from '@/api/system/coreSystemRectificationRecord/types';

/**
 * 查询制度整改记录列表
 * @param query
 * @returns {*}
 */

export const listCoreSystemRectificationRecord = (query?: CoreSystemRectificationRecordQuery): AxiosPromise<CoreSystemRectificationRecordVO[]> => {
  return request({
    url: '/system/coreSystemRectificationRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询制度整改记录详细
 * @param id
 */
export const getCoreSystemRectificationRecord = (id: string | number): AxiosPromise<CoreSystemRectificationRecordVO> => {
  return request({
    url: '/system/coreSystemRectificationRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增制度整改记录
 * @param data
 */
export const addCoreSystemRectificationRecord = (data: CoreSystemRectificationRecordForm) => {
  return request({
    url: '/system/coreSystemRectificationRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改制度整改记录
 * @param data
 */
export const updateCoreSystemRectificationRecord = (data: CoreSystemRectificationRecordForm) => {
  return request({
    url: '/system/coreSystemRectificationRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除制度整改记录
 * @param id
 */
export const delCoreSystemRectificationRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/coreSystemRectificationRecord/' + id,
    method: 'delete'
  });
};
