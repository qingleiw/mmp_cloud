import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorEducationVO, DoctorEducationForm, DoctorEducationQuery } from '@/api/doctor/doctorEducation/types';

/**
 * 查询教育经历列表
 * @param query
 * @returns {*}
 */

export const listDoctorEducation = (query?: DoctorEducationQuery): AxiosPromise<DoctorEducationVO[]> => {
  return request({
    url: '/doctor/doctorEducation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询教育经历详细
 * @param id
 */
export const getDoctorEducation = (id: string | number): AxiosPromise<DoctorEducationVO> => {
  return request({
    url: '/doctor/doctorEducation/' + id,
    method: 'get'
  });
};

/**
 * 新增教育经历
 * @param data
 */
export const addDoctorEducation = (data: DoctorEducationForm) => {
  return request({
    url: '/doctor/doctorEducation',
    method: 'post',
    data: data
  });
};

/**
 * 修改教育经历
 * @param data
 */
export const updateDoctorEducation = (data: DoctorEducationForm) => {
  return request({
    url: '/doctor/doctorEducation',
    method: 'put',
    data: data
  });
};

/**
 * 删除教育经历
 * @param id
 */
export const delDoctorEducation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorEducation/' + id,
    method: 'delete'
  });
};
