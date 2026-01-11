import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorCertificateVO, DoctorCertificateForm, DoctorCertificateQuery } from '@/api/doctor/doctorCertificate/types';

/**
 * 查询资质证书列表
 * @param query
 * @returns {*}
 */

export const listDoctorCertificate = (query?: DoctorCertificateQuery): AxiosPromise<DoctorCertificateVO[]> => {
  return request({
    url: '/doctor/doctorCertificate/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质证书详细
 * @param id
 */
export const getDoctorCertificate = (id: string | number): AxiosPromise<DoctorCertificateVO> => {
  return request({
    url: '/doctor/doctorCertificate/' + id,
    method: 'get'
  });
};

/**
 * 新增资质证书
 * @param data
 */
export const addDoctorCertificate = (data: DoctorCertificateForm) => {
  return request({
    url: '/doctor/doctorCertificate',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质证书
 * @param data
 */
export const updateDoctorCertificate = (data: DoctorCertificateForm) => {
  return request({
    url: '/doctor/doctorCertificate',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质证书
 * @param id
 */
export const delDoctorCertificate = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorCertificate/' + id,
    method: 'delete'
  });
};
