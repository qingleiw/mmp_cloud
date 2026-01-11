import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SurgeryCatalogVO, SurgeryCatalogForm, SurgeryCatalogQuery } from '@/api/surgery/surgeryCatalog/types';

/**
 * 查询手术目录列表
 * @param query
 * @returns {*}
 */

export const listSurgeryCatalog = (query?: SurgeryCatalogQuery): AxiosPromise<SurgeryCatalogVO[]> => {
  return request({
    url: '/surgery/surgeryCatalog/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询手术目录详细
 * @param id
 */
export const getSurgeryCatalog = (id: string | number): AxiosPromise<SurgeryCatalogVO> => {
  return request({
    url: '/surgery/surgeryCatalog/' + id,
    method: 'get'
  });
};

/**
 * 新增手术目录
 * @param data
 */
export const addSurgeryCatalog = (data: SurgeryCatalogForm) => {
  return request({
    url: '/surgery/surgeryCatalog',
    method: 'post',
    data: data
  });
};

/**
 * 修改手术目录
 * @param data
 */
export const updateSurgeryCatalog = (data: SurgeryCatalogForm) => {
  return request({
    url: '/surgery/surgeryCatalog',
    method: 'put',
    data: data
  });
};

/**
 * 删除手术目录
 * @param id
 */
export const delSurgeryCatalog = (id: string | number | Array<string | number>) => {
  return request({
    url: '/surgery/surgeryCatalog/' + id,
    method: 'delete'
  });
};
