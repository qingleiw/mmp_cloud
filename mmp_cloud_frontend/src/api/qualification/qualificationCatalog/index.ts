import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QualificationCatalogVO, QualificationCatalogForm, QualificationCatalogQuery } from '@/api/system/qualificationCatalog/types';

/**
 * 查询医生手术授权目录列表
 * @param query
 * @returns {*}
 */

export const listQualificationCatalog = (query?: QualificationCatalogQuery): AxiosPromise<QualificationCatalogVO[]> => {
  return request({
    url: '/system/qualificationCatalog/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医生手术授权目录详细
 * @param id
 */
export const getQualificationCatalog = (id: string | number): AxiosPromise<QualificationCatalogVO> => {
  return request({
    url: '/system/qualificationCatalog/' + id,
    method: 'get'
  });
};

/**
 * 新增医生手术授权目录
 * @param data
 */
export const addQualificationCatalog = (data: QualificationCatalogForm) => {
  return request({
    url: '/system/qualificationCatalog',
    method: 'post',
    data: data
  });
};

/**
 * 修改医生手术授权目录
 * @param data
 */
export const updateQualificationCatalog = (data: QualificationCatalogForm) => {
  return request({
    url: '/system/qualificationCatalog',
    method: 'put',
    data: data
  });
};

/**
 * 删除医生手术授权目录
 * @param id
 */
export const delQualificationCatalog = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qualificationCatalog/' + id,
    method: 'delete'
  });
};
