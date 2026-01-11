import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  DoctorElectronicRegistrationVO,
  DoctorElectronicRegistrationForm,
  DoctorElectronicRegistrationQuery
} from '@/api/doctor/doctorElectronicRegistration/types';

/**
 * 查询医师电子化注册列表
 * @param query
 * @returns {*}
 */

export const listDoctorElectronicRegistration = (query?: DoctorElectronicRegistrationQuery): AxiosPromise<DoctorElectronicRegistrationVO[]> => {
  return request({
    url: '/doctor/doctorElectronicRegistration/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医师电子化注册详细
 * @param id
 */
export const getDoctorElectronicRegistration = (id: string | number): AxiosPromise<DoctorElectronicRegistrationVO> => {
  return request({
    url: '/doctor/doctorElectronicRegistration/' + id,
    method: 'get'
  });
};

/**
 * 新增医师电子化注册
 * @param data
 */
export const addDoctorElectronicRegistration = (data: DoctorElectronicRegistrationForm) => {
  return request({
    url: '/doctor/doctorElectronicRegistration',
    method: 'post',
    data: data
  });
};

/**
 * 修改医师电子化注册
 * @param data
 */
export const updateDoctorElectronicRegistration = (data: DoctorElectronicRegistrationForm) => {
  return request({
    url: '/doctor/doctorElectronicRegistration',
    method: 'put',
    data: data
  });
};

/**
 * 删除医师电子化注册
 * @param id
 */
export const delDoctorElectronicRegistration = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorElectronicRegistration/' + id,
    method: 'delete'
  });
};
