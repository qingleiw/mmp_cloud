import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorBasicInfoVO, DoctorBasicInfoForm, DoctorBasicInfoQuery } from '@/api/doctor/doctorBasicInfo/types';

/**
 * 查询医师基本信息列表
 * @param query
 * @returns {*}
 */

export const listDoctorBasicInfo = (query?: DoctorBasicInfoQuery): AxiosPromise<DoctorBasicInfoVO[]> => {
  return request({
    url: '/doctor/doctorBasicInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医师基本信息详细
 * @param id
 */
export const getDoctorBasicInfo = (id: string | number): AxiosPromise<DoctorBasicInfoVO> => {
  return request({
    url: '/doctor/doctorBasicInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增医师基本信息
 * @param data
 */
export const addDoctorBasicInfo = (data: DoctorBasicInfoForm) => {
  return request({
    url: '/doctor/doctorBasicInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改医师基本信息
 * @param data
 */
export const updateDoctorBasicInfo = (data: DoctorBasicInfoForm) => {
  return request({
    url: '/doctor/doctorBasicInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除医师基本信息
 * @param id
 */
export const delDoctorBasicInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorBasicInfo/' + id,
    method: 'delete'
  });
};
