import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NewTechnologyProjectCaseVO, NewTechnologyProjectCaseForm, NewTechnologyProjectCaseQuery } from '@/api/system/newTechnologyProjectCase/types';

/**
 * 查询新技术病例登记列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectCase = (query?: NewTechnologyProjectCaseQuery): AxiosPromise<NewTechnologyProjectCaseVO[]> => {
  return request({
    url: '/system/newTechnologyProjectCase/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询新技术病例登记详细
 * @param id
 */
export const getNewTechnologyProjectCase = (id: string | number): AxiosPromise<NewTechnologyProjectCaseVO> => {
  return request({
    url: '/system/newTechnologyProjectCase/' + id,
    method: 'get'
  });
};

/**
 * 新增新技术病例登记
 * @param data
 */
export const addNewTechnologyProjectCase = (data: NewTechnologyProjectCaseForm) => {
  return request({
    url: '/system/newTechnologyProjectCase',
    method: 'post',
    data: data
  });
};

/**
 * 修改新技术病例登记
 * @param data
 */
export const updateNewTechnologyProjectCase = (data: NewTechnologyProjectCaseForm) => {
  return request({
    url: '/system/newTechnologyProjectCase',
    method: 'put',
    data: data
  });
};

/**
 * 删除新技术病例登记
 * @param id
 */
export const delNewTechnologyProjectCase = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/newTechnologyProjectCase/' + id,
    method: 'delete'
  });
};
