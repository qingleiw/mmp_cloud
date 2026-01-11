import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorWorkExperienceVO, DoctorWorkExperienceForm, DoctorWorkExperienceQuery } from '@/api/doctor/doctorWorkExperience/types';

/**
 * 查询工作经历列表
 * @param query
 * @returns {*}
 */

export const listDoctorWorkExperience = (query?: DoctorWorkExperienceQuery): AxiosPromise<DoctorWorkExperienceVO[]> => {
  return request({
    url: '/doctor/doctorWorkExperience/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询工作经历详细
 * @param id
 */
export const getDoctorWorkExperience = (id: string | number): AxiosPromise<DoctorWorkExperienceVO> => {
  return request({
    url: '/doctor/doctorWorkExperience/' + id,
    method: 'get'
  });
};

/**
 * 新增工作经历
 * @param data
 */
export const addDoctorWorkExperience = (data: DoctorWorkExperienceForm) => {
  return request({
    url: '/doctor/doctorWorkExperience',
    method: 'post',
    data: data
  });
};

/**
 * 修改工作经历
 * @param data
 */
export const updateDoctorWorkExperience = (data: DoctorWorkExperienceForm) => {
  return request({
    url: '/doctor/doctorWorkExperience',
    method: 'put',
    data: data
  });
};

/**
 * 删除工作经历
 * @param id
 */
export const delDoctorWorkExperience = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorWorkExperience/' + id,
    method: 'delete'
  });
};
