import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  SupervisionResultDetailVO,
  SupervisionResultDetailForm,
  SupervisionResultDetailQuery
} from '@/api/supervision/supervisionResultDetail/types';

/**
 * 查询督查结果明细列表
 * @param query
 * @returns {*}
 */

export const listSupervisionResultDetail = (query?: SupervisionResultDetailQuery): AxiosPromise<SupervisionResultDetailVO[]> => {
  return request({
    url: '/supervision/supervisionResultDetail/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查结果明细详细
 * @param id
 */
export const getSupervisionResultDetail = (id: string | number): AxiosPromise<SupervisionResultDetailVO> => {
  return request({
    url: '/supervision/supervisionResultDetail/' + id,
    method: 'get'
  });
};

/**
 * 新增督查结果明细
 * @param data
 */
export const addSupervisionResultDetail = (data: SupervisionResultDetailForm) => {
  return request({
    url: '/supervision/supervisionResultDetail',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查结果明细
 * @param data
 */
export const updateSupervisionResultDetail = (data: SupervisionResultDetailForm) => {
  return request({
    url: '/supervision/supervisionResultDetail',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查结果明细
 * @param id
 */
export const delSupervisionResultDetail = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionResultDetail/' + id,
    method: 'delete'
  });
};
