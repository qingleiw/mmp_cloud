import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorProfessionalRatingVO, DoctorProfessionalRatingForm, DoctorProfessionalRatingQuery } from '@/api/doctor/doctorProfessionalRating/types';

/**
 * 查询医师职业评分列表
 * @param query
 * @returns {*}
 */

export const listDoctorProfessionalRating = (query?: DoctorProfessionalRatingQuery): AxiosPromise<DoctorProfessionalRatingVO[]> => {
  return request({
    url: '/doctor/doctorProfessionalRating/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医师职业评分详细
 * @param id
 */
export const getDoctorProfessionalRating = (id: string | number): AxiosPromise<DoctorProfessionalRatingVO> => {
  return request({
    url: '/doctor/doctorProfessionalRating/' + id,
    method: 'get'
  });
};

/**
 * 新增医师职业评分
 * @param data
 */
export const addDoctorProfessionalRating = (data: DoctorProfessionalRatingForm) => {
  return request({
    url: '/doctor/doctorProfessionalRating',
    method: 'post',
    data: data
  });
};

/**
 * 修改医师职业评分
 * @param data
 */
export const updateDoctorProfessionalRating = (data: DoctorProfessionalRatingForm) => {
  return request({
    url: '/doctor/doctorProfessionalRating',
    method: 'put',
    data: data
  });
};

/**
 * 删除医师职业评分
 * @param id
 */
export const delDoctorProfessionalRating = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorProfessionalRating/' + id,
    method: 'delete'
  });
};
