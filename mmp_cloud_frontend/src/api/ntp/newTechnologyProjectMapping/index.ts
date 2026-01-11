import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NewTechnologyProjectMappingVO, NewTechnologyProjectMappingForm, NewTechnologyProjectMappingQuery } from '@/api/system/newTechnologyProjectMapping/types';

/**
 * 查询新技术项目对码列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectMapping = (query?: NewTechnologyProjectMappingQuery): AxiosPromise<NewTechnologyProjectMappingVO[]> => {
  return request({
    url: '/system/newTechnologyProjectMapping/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询新技术项目对码详细
 * @param id
 */
export const getNewTechnologyProjectMapping = (id: string | number): AxiosPromise<NewTechnologyProjectMappingVO> => {
  return request({
    url: '/system/newTechnologyProjectMapping/' + id,
    method: 'get'
  });
};

/**
 * 新增新技术项目对码
 * @param data
 */
export const addNewTechnologyProjectMapping = (data: NewTechnologyProjectMappingForm) => {
  return request({
    url: '/system/newTechnologyProjectMapping',
    method: 'post',
    data: data
  });
};

/**
 * 修改新技术项目对码
 * @param data
 */
export const updateNewTechnologyProjectMapping = (data: NewTechnologyProjectMappingForm) => {
  return request({
    url: '/system/newTechnologyProjectMapping',
    method: 'put',
    data: data
  });
};

/**
 * 删除新技术项目对码
 * @param id
 */
export const delNewTechnologyProjectMapping = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/newTechnologyProjectMapping/' + id,
    method: 'delete'
  });
};
