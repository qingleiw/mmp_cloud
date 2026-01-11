import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  SupervisionRectificationTaskVO,
  SupervisionRectificationTaskForm,
  SupervisionRectificationTaskQuery
} from '@/api/supervision/supervisionRectificationTask/types';

/**
 * 查询整改任务列表
 * @param query
 * @returns {*}
 */

export const listSupervisionRectificationTask = (query?: SupervisionRectificationTaskQuery): AxiosPromise<SupervisionRectificationTaskVO[]> => {
  return request({
    url: '/supervision/supervisionRectificationTask/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询整改任务详细
 * @param id
 */
export const getSupervisionRectificationTask = (id: string | number): AxiosPromise<SupervisionRectificationTaskVO> => {
  return request({
    url: '/supervision/supervisionRectificationTask/' + id,
    method: 'get'
  });
};

/**
 * 新增整改任务
 * @param data
 */
export const addSupervisionRectificationTask = (data: SupervisionRectificationTaskForm) => {
  return request({
    url: '/supervision/supervisionRectificationTask',
    method: 'post',
    data: data
  });
};

/**
 * 修改整改任务
 * @param data
 */
export const updateSupervisionRectificationTask = (data: SupervisionRectificationTaskForm) => {
  return request({
    url: '/supervision/supervisionRectificationTask',
    method: 'put',
    data: data
  });
};

/**
 * 删除整改任务
 * @param id
 */
export const delSupervisionRectificationTask = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionRectificationTask/' + id,
    method: 'delete'
  });
};
