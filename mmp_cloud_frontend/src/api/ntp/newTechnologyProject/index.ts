import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NewTechnologyProjectVO, NewTechnologyProjectForm, NewTechnologyProjectQuery } from '@/api/ntp/newTechnologyProject/types';

/**
 * 查询新技术项目基本信息列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProject = (query?: NewTechnologyProjectQuery): AxiosPromise<NewTechnologyProjectVO[]> => {
  return request({
    url: '/ntp/newTechnologyProject/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询新技术项目基本信息详细
 * @param id
 */
export const getNewTechnologyProject = (id: string | number): AxiosPromise<NewTechnologyProjectVO> => {
  return request({
    url: '/ntp/newTechnologyProject/' + id,
    method: 'get'
  });
};

/**
 * 新增新技术项目基本信息
 * @param data
 */
export const addNewTechnologyProject = (data: NewTechnologyProjectForm) => {
  return request({
    url: '/ntp/newTechnologyProject',
    method: 'post',
    data: data
  });
};

/**
 * 修改新技术项目基本信息
 * @param data
 */
export const updateNewTechnologyProject = (data: NewTechnologyProjectForm) => {
  return request({
    url: '/ntp/newTechnologyProject',
    method: 'put',
    data: data
  });
};

/**
 * 删除新技术项目基本信息
 * @param id
 */
export const delNewTechnologyProject = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ntp/newTechnologyProject/' + id,
    method: 'delete'
  });
};
