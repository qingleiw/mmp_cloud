import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcSpecialtyCategoryVO, QcSpecialtyCategoryForm, QcSpecialtyCategoryQuery } from '@/api/system/qcSpecialtyCategory/types';

/**
 * 查询专业类别列表
 * @param query
 * @returns {*}
 */

export const listQcSpecialtyCategory = (query?: QcSpecialtyCategoryQuery): AxiosPromise<QcSpecialtyCategoryVO[]> => {
  return request({
    url: '/system/qcSpecialtyCategory/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询专业类别详细
 * @param id
 */
export const getQcSpecialtyCategory = (id: string | number): AxiosPromise<QcSpecialtyCategoryVO> => {
  return request({
    url: '/system/qcSpecialtyCategory/' + id,
    method: 'get'
  });
};

/**
 * 新增专业类别
 * @param data
 */
export const addQcSpecialtyCategory = (data: QcSpecialtyCategoryForm) => {
  return request({
    url: '/system/qcSpecialtyCategory',
    method: 'post',
    data: data
  });
};

/**
 * 修改专业类别
 * @param data
 */
export const updateQcSpecialtyCategory = (data: QcSpecialtyCategoryForm) => {
  return request({
    url: '/system/qcSpecialtyCategory',
    method: 'put',
    data: data
  });
};

/**
 * 删除专业类别
 * @param id
 */
export const delQcSpecialtyCategory = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qcSpecialtyCategory/' + id,
    method: 'delete'
  });
};
