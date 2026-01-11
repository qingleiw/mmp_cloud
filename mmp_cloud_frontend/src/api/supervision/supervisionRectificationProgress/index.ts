import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  SupervisionRectificationProgressVO,
  SupervisionRectificationProgressForm,
  SupervisionRectificationProgressQuery
} from '@/api/supervision/supervisionRectificationProgress/types';

/**
 * 查询整改进度列表
 * @param query
 * @returns {*}
 */

export const listSupervisionRectificationProgress = (
  query?: SupervisionRectificationProgressQuery
): AxiosPromise<SupervisionRectificationProgressVO[]> => {
  return request({
    url: '/supervision/supervisionRectificationProgress/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询整改进度详细
 * @param id
 */
export const getSupervisionRectificationProgress = (id: string | number): AxiosPromise<SupervisionRectificationProgressVO> => {
  return request({
    url: '/supervision/supervisionRectificationProgress/' + id,
    method: 'get'
  });
};

/**
 * 新增整改进度
 * @param data
 */
export const addSupervisionRectificationProgress = (data: SupervisionRectificationProgressForm) => {
  return request({
    url: '/supervision/supervisionRectificationProgress',
    method: 'post',
    data: data
  });
};

/**
 * 修改整改进度
 * @param data
 */
export const updateSupervisionRectificationProgress = (data: SupervisionRectificationProgressForm) => {
  return request({
    url: '/supervision/supervisionRectificationProgress',
    method: 'put',
    data: data
  });
};

/**
 * 删除整改进度
 * @param id
 */
export const delSupervisionRectificationProgress = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionRectificationProgress/' + id,
    method: 'delete'
  });
};
