import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NewTechnologyProjectImplementationVO, NewTechnologyProjectImplementationForm, NewTechnologyProjectImplementationQuery } from '@/api/system/newTechnologyProjectImplementation/types';

/**
 * 查询新技术实施列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectImplementation = (query?: NewTechnologyProjectImplementationQuery): AxiosPromise<NewTechnologyProjectImplementationVO[]> => {
  return request({
    url: '/system/newTechnologyProjectImplementation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询新技术实施详细
 * @param id
 */
export const getNewTechnologyProjectImplementation = (id: string | number): AxiosPromise<NewTechnologyProjectImplementationVO> => {
  return request({
    url: '/system/newTechnologyProjectImplementation/' + id,
    method: 'get'
  });
};

/**
 * 新增新技术实施
 * @param data
 */
export const addNewTechnologyProjectImplementation = (data: NewTechnologyProjectImplementationForm) => {
  return request({
    url: '/system/newTechnologyProjectImplementation',
    method: 'post',
    data: data
  });
};

/**
 * 修改新技术实施
 * @param data
 */
export const updateNewTechnologyProjectImplementation = (data: NewTechnologyProjectImplementationForm) => {
  return request({
    url: '/system/newTechnologyProjectImplementation',
    method: 'put',
    data: data
  });
};

/**
 * 删除新技术实施
 * @param id
 */
export const delNewTechnologyProjectImplementation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/newTechnologyProjectImplementation/' + id,
    method: 'delete'
  });
};
