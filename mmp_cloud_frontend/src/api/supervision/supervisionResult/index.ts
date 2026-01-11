import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionResultVO, SupervisionResultForm, SupervisionResultQuery } from '@/api/supervision/supervisionResult/types';

/**
 * 查询督查结果列表
 * @param query
 * @returns {*}
 */

export const listSupervisionResult = (query?: SupervisionResultQuery): AxiosPromise<SupervisionResultVO[]> => {
  return request({
    url: '/supervision/supervisionResult/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查结果详细
 * @param id
 */
export const getSupervisionResult = (id: string | number): AxiosPromise<SupervisionResultVO> => {
  return request({
    url: '/supervision/supervisionResult/' + id,
    method: 'get'
  });
};

/**
 * 新增督查结果
 * @param data
 */
export const addSupervisionResult = (data: SupervisionResultForm) => {
  return request({
    url: '/supervision/supervisionResult',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查结果
 * @param data
 */
export const updateSupervisionResult = (data: SupervisionResultForm) => {
  return request({
    url: '/supervision/supervisionResult',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查结果
 * @param id
 */
export const delSupervisionResult = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionResult/' + id,
    method: 'delete'
  });
};
