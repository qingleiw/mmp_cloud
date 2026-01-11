import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionFormFieldVO, SupervisionFormFieldForm, SupervisionFormFieldQuery } from '@/api/supervision/supervisionFormField/types';

/**
 * 查询督查单字段列表
 * @param query
 * @returns {*}
 */

export const listSupervisionFormField = (query?: SupervisionFormFieldQuery): AxiosPromise<SupervisionFormFieldVO[]> => {
  return request({
    url: '/supervision/supervisionFormField/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查单字段详细
 * @param id
 */
export const getSupervisionFormField = (id: string | number): AxiosPromise<SupervisionFormFieldVO> => {
  return request({
    url: '/supervision/supervisionFormField/' + id,
    method: 'get'
  });
};

/**
 * 新增督查单字段
 * @param data
 */
export const addSupervisionFormField = (data: SupervisionFormFieldForm) => {
  return request({
    url: '/supervision/supervisionFormField',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查单字段
 * @param data
 */
export const updateSupervisionFormField = (data: SupervisionFormFieldForm) => {
  return request({
    url: '/supervision/supervisionFormField',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查单字段
 * @param id
 */
export const delSupervisionFormField = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionFormField/' + id,
    method: 'delete'
  });
};
