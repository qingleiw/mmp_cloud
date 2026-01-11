import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NewTechnologyProjectProgressVO, NewTechnologyProjectProgressForm, NewTechnologyProjectProgressQuery } from '@/api/ntp/newTechnologyProjectProgress/types';

/**
 * 查询新技术进展报告列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectProgress = (query?: NewTechnologyProjectProgressQuery): AxiosPromise<NewTechnologyProjectProgressVO[]> => {
  return request({
    url: '/ntp/newTechnologyProjectProgress/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询新技术进展报告详细
 * @param id
 */
export const getNewTechnologyProjectProgress = (id: string | number): AxiosPromise<NewTechnologyProjectProgressVO> => {
  return request({
    url: '/ntp/newTechnologyProjectProgress/' + id,
    method: 'get'
  });
};

/**
 * 新增新技术进展报告
 * @param data
 */
export const addNewTechnologyProjectProgress = (data: NewTechnologyProjectProgressForm) => {
  return request({
    url: '/ntp/newTechnologyProjectProgress',
    method: 'post',
    data: data
  });
};

/**
 * 修改新技术进展报告
 * @param data
 */
export const updateNewTechnologyProjectProgress = (data: NewTechnologyProjectProgressForm) => {
  return request({
    url: '/ntp/newTechnologyProjectProgress',
    method: 'put',
    data: data
  });
};

/**
 * 删除新技术进展报告
 * @param id
 */
export const delNewTechnologyProjectProgress = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ntp/newTechnologyProjectProgress/' + id,
    method: 'delete'
  });
};
