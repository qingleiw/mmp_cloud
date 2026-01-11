import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  TechnicianQualificationCatalogVO,
  TechnicianQualificationCatalogForm,
  TechnicianQualificationCatalogQuery
} from '@/api/qualification/technicianQualificationCatalog/types';

/**
 * 查询医技资质目录列表
 * @param query
 * @returns {*}
 */

export const listTechnicianQualificationCatalog = (query?: TechnicianQualificationCatalogQuery): AxiosPromise<TechnicianQualificationCatalogVO[]> => {
  return request({
    url: '/qualification/technicianQualificationCatalog/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医技资质目录详细
 * @param id
 */
export const getTechnicianQualificationCatalog = (id: string | number): AxiosPromise<TechnicianQualificationCatalogVO> => {
  return request({
    url: '/qualification/technicianQualificationCatalog/' + id,
    method: 'get'
  });
};

/**
 * 新增医技资质目录
 * @param data
 */
export const addTechnicianQualificationCatalog = (data: TechnicianQualificationCatalogForm) => {
  return request({
    url: '/qualification/technicianQualificationCatalog',
    method: 'post',
    data: data
  });
};

/**
 * 修改医技资质目录
 * @param data
 */
export const updateTechnicianQualificationCatalog = (data: TechnicianQualificationCatalogForm) => {
  return request({
    url: '/qualification/technicianQualificationCatalog',
    method: 'put',
    data: data
  });
};

/**
 * 删除医技资质目录
 * @param id
 */
export const delTechnicianQualificationCatalog = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qualification/technicianQualificationCatalog/' + id,
    method: 'delete'
  });
};
