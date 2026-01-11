import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorInsuranceCodeVO, DoctorInsuranceCodeForm, DoctorInsuranceCodeQuery } from '@/api/doctor/doctorInsuranceCode/types';

/**
 * 查询医保医师码列表
 * @param query
 * @returns {*}
 */

export const listDoctorInsuranceCode = (query?: DoctorInsuranceCodeQuery): AxiosPromise<DoctorInsuranceCodeVO[]> => {
  return request({
    url: '/doctor/doctorInsuranceCode/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医保医师码详细
 * @param id
 */
export const getDoctorInsuranceCode = (id: string | number): AxiosPromise<DoctorInsuranceCodeVO> => {
  return request({
    url: '/doctor/doctorInsuranceCode/' + id,
    method: 'get'
  });
};

/**
 * 新增医保医师码
 * @param data
 */
export const addDoctorInsuranceCode = (data: DoctorInsuranceCodeForm) => {
  return request({
    url: '/doctor/doctorInsuranceCode',
    method: 'post',
    data: data
  });
};

/**
 * 修改医保医师码
 * @param data
 */
export const updateDoctorInsuranceCode = (data: DoctorInsuranceCodeForm) => {
  return request({
    url: '/doctor/doctorInsuranceCode',
    method: 'put',
    data: data
  });
};

/**
 * 删除医保医师码
 * @param id
 */
export const delDoctorInsuranceCode = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorInsuranceCode/' + id,
    method: 'delete'
  });
};
