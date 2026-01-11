import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorAcademicPositionVO, DoctorAcademicPositionForm, DoctorAcademicPositionQuery } from '@/api/doctor/doctorAcademicPosition/types';

/**
 * 查询学术任职列表
 * @param query
 * @returns {*}
 */

export const listDoctorAcademicPosition = (query?: DoctorAcademicPositionQuery): AxiosPromise<DoctorAcademicPositionVO[]> => {
  return request({
    url: '/doctor/doctorAcademicPosition/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询学术任职详细
 * @param id
 */
export const getDoctorAcademicPosition = (id: string | number): AxiosPromise<DoctorAcademicPositionVO> => {
  return request({
    url: '/doctor/doctorAcademicPosition/' + id,
    method: 'get'
  });
};

/**
 * 新增学术任职
 * @param data
 */
export const addDoctorAcademicPosition = (data: DoctorAcademicPositionForm) => {
  return request({
    url: '/doctor/doctorAcademicPosition',
    method: 'post',
    data: data
  });
};

/**
 * 修改学术任职
 * @param data
 */
export const updateDoctorAcademicPosition = (data: DoctorAcademicPositionForm) => {
  return request({
    url: '/doctor/doctorAcademicPosition',
    method: 'put',
    data: data
  });
};

/**
 * 删除学术任职
 * @param id
 */
export const delDoctorAcademicPosition = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorAcademicPosition/' + id,
    method: 'delete'
  });
};
