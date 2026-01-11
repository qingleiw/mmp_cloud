import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionFormVO, SupervisionFormForm, SupervisionFormQuery } from '@/api/supervision/supervisionForm/types';

/**
 * 查询督查单列表
 * @param query
 * @returns {*}
 */

export const listSupervisionForm = (query?: SupervisionFormQuery): AxiosPromise<SupervisionFormVO[]> => {
  return request({
    url: '/supervision/supervisionForm/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查单详细
 * @param id
 */
export const getSupervisionForm = (id: string | number): AxiosPromise<SupervisionFormVO> => {
  return request({
    url: '/supervision/supervisionForm/' + id,
    method: 'get'
  });
};

/**
 * 新增督查单
 * @param data
 */
export const addSupervisionForm = (data: SupervisionFormForm) => {
  return request({
    url: '/supervision/supervisionForm',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查单
 * @param data
 */
export const updateSupervisionForm = (data: SupervisionFormForm) => {
  return request({
    url: '/supervision/supervisionForm',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查单
 * @param id
 */
export const delSupervisionForm = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionForm/' + id,
    method: 'delete'
  });
};
