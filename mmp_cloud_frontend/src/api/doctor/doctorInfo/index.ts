import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorInfoVO, DoctorInfoForm, DoctorInfoQuery } from '@/api/doctor/doctorInfo/types';

/**
 * 查询医师基本信息列表
 * @param query
 * @returns {*}
 */

export const listDoctorInfo = (query?: DoctorInfoQuery): AxiosPromise<DoctorInfoVO[]> => {
  return request({
    url: '/doctor/doctorInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医师基本信息详细
 * @param id
 */
export const getDoctorInfo = (id: string | number): AxiosPromise<DoctorInfoVO> => {
  return request({
    url: '/doctor/doctorInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增医师基本信息
 * @param data
 */
export const addDoctorInfo = (data: DoctorInfoForm) => {
  return request({
    url: '/doctor/doctorInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改医师基本信息
 * @param data
 */
export const updateDoctorInfo = (data: DoctorInfoForm) => {
  return request({
    url: '/doctor/doctorInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除医师基本信息
 * @param id
 */
export const delDoctorInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorInfo/' + id,
    method: 'delete'
  });
};
