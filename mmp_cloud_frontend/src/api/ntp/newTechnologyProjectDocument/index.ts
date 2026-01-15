import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  NewTechnologyProjectDocumentVO,
  NewTechnologyProjectDocumentForm,
  NewTechnologyProjectDocumentQuery
} from '@/api/ntp/newTechnologyProjectDocument/types';

/**
 * 查询项目文档列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectDocument = (query?: NewTechnologyProjectDocumentQuery): AxiosPromise<NewTechnologyProjectDocumentVO[]> => {
  return request({
    url: '/ntp/newTechnologyProjectDocument/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询项目文档详细
 * @param id
 */
export const getNewTechnologyProjectDocument = (id: string | number): AxiosPromise<NewTechnologyProjectDocumentVO> => {
  return request({
    url: '/ntp/newTechnologyProjectDocument/' + id,
    method: 'get'
  });
};

/**
 * 新增项目文档
 * @param data
 */
export const addNewTechnologyProjectDocument = (data: NewTechnologyProjectDocumentForm) => {
  return request({
    url: '/ntp/newTechnologyProjectDocument',
    method: 'post',
    data: data
  });
};

/**
 * 修改项目文档
 * @param data
 */
export const updateNewTechnologyProjectDocument = (data: NewTechnologyProjectDocumentForm) => {
  return request({
    url: '/ntp/newTechnologyProjectDocument',
    method: 'put',
    data: data
  });
};

/**
 * 删除项目文档
 * @param id
 */
export const delNewTechnologyProjectDocument = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ntp/newTechnologyProjectDocument/' + id,
    method: 'delete'
  });
};
