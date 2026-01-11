import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  DoctorQualificationCatalogVO,
  DoctorQualificationCatalogForm,
  DoctorQualificationCatalogQuery
} from '@/api/doctor/doctorQualificationCatalog/types';

/**
 * 查询医师资质目录列表
 * @param query
 * @returns {*}
 */

export const listDoctorQualificationCatalog = (query?: DoctorQualificationCatalogQuery): AxiosPromise<DoctorQualificationCatalogVO[]> => {
  return request({
    url: '/doctor/doctorQualificationCatalog/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医师资质目录详细
 * @param id
 */
export const getDoctorQualificationCatalog = (id: string | number): AxiosPromise<DoctorQualificationCatalogVO> => {
  return request({
    url: '/doctor/doctorQualificationCatalog/' + id,
    method: 'get'
  });
};

/**
 * 新增医师资质目录
 * @param data
 */
export const addDoctorQualificationCatalog = (data: DoctorQualificationCatalogForm) => {
  return request({
    url: '/doctor/doctorQualificationCatalog',
    method: 'post',
    data: data
  });
};

/**
 * 修改医师资质目录
 * @param data
 */
export const updateDoctorQualificationCatalog = (data: DoctorQualificationCatalogForm) => {
  return request({
    url: '/doctor/doctorQualificationCatalog',
    method: 'put',
    data: data
  });
};

/**
 * 删除医师资质目录
 * @param id
 */
export const delDoctorQualificationCatalog = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorQualificationCatalog/' + id,
    method: 'delete'
  });
};
