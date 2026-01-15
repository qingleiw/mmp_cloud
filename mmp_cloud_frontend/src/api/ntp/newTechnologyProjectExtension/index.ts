import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  NewTechnologyProjectExtensionVO,
  NewTechnologyProjectExtensionForm,
  NewTechnologyProjectExtensionQuery
} from '@/api/ntp/newTechnologyProjectExtension/types';

/**
 * 查询新技术延期申请列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectExtension = (query?: NewTechnologyProjectExtensionQuery): AxiosPromise<NewTechnologyProjectExtensionVO[]> => {
  return request({
    url: '/ntp/newTechnologyProjectExtension/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询新技术延期申请详细
 * @param id
 */
export const getNewTechnologyProjectExtension = (id: string | number): AxiosPromise<NewTechnologyProjectExtensionVO> => {
  return request({
    url: '/ntp/newTechnologyProjectExtension/' + id,
    method: 'get'
  });
};

/**
 * 新增新技术延期申请
 * @param data
 */
export const addNewTechnologyProjectExtension = (data: NewTechnologyProjectExtensionForm) => {
  return request({
    url: '/ntp/newTechnologyProjectExtension',
    method: 'post',
    data: data
  });
};

/**
 * 修改新技术延期申请
 * @param data
 */
export const updateNewTechnologyProjectExtension = (data: NewTechnologyProjectExtensionForm) => {
  return request({
    url: '/ntp/newTechnologyProjectExtension',
    method: 'put',
    data: data
  });
};

/**
 * 删除新技术延期申请
 * @param id
 */
export const delNewTechnologyProjectExtension = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ntp/newTechnologyProjectExtension/' + id,
    method: 'delete'
  });
};
