import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorHonorVO, DoctorHonorForm, DoctorHonorQuery } from '@/api/doctor/doctorHonor/types';

/**
 * 查询荣誉奖励列表
 * @param query
 * @returns {*}
 */

export const listDoctorHonor = (query?: DoctorHonorQuery): AxiosPromise<DoctorHonorVO[]> => {
  return request({
    url: '/doctor/doctorHonor/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询荣誉奖励详细
 * @param id
 */
export const getDoctorHonor = (id: string | number): AxiosPromise<DoctorHonorVO> => {
  return request({
    url: '/doctor/doctorHonor/' + id,
    method: 'get'
  });
};

/**
 * 新增荣誉奖励
 * @param data
 */
export const addDoctorHonor = (data: DoctorHonorForm) => {
  return request({
    url: '/doctor/doctorHonor',
    method: 'post',
    data: data
  });
};

/**
 * 修改荣誉奖励
 * @param data
 */
export const updateDoctorHonor = (data: DoctorHonorForm) => {
  return request({
    url: '/doctor/doctorHonor',
    method: 'put',
    data: data
  });
};

/**
 * 删除荣誉奖励
 * @param id
 */
export const delDoctorHonor = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorHonor/' + id,
    method: 'delete'
  });
};
