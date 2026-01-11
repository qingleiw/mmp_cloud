import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorAdverseRecordVO, DoctorAdverseRecordForm, DoctorAdverseRecordQuery } from '@/api/doctor/doctorAdverseRecord/types';

/**
 * 查询不良行为记录列表
 * @param query
 * @returns {*}
 */

export const listDoctorAdverseRecord = (query?: DoctorAdverseRecordQuery): AxiosPromise<DoctorAdverseRecordVO[]> => {
  return request({
    url: '/doctor/doctorAdverseRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询不良行为记录详细
 * @param id
 */
export const getDoctorAdverseRecord = (id: string | number): AxiosPromise<DoctorAdverseRecordVO> => {
  return request({
    url: '/doctor/doctorAdverseRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增不良行为记录
 * @param data
 */
export const addDoctorAdverseRecord = (data: DoctorAdverseRecordForm) => {
  return request({
    url: '/doctor/doctorAdverseRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改不良行为记录
 * @param data
 */
export const updateDoctorAdverseRecord = (data: DoctorAdverseRecordForm) => {
  return request({
    url: '/doctor/doctorAdverseRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除不良行为记录
 * @param id
 */
export const delDoctorAdverseRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorAdverseRecord/' + id,
    method: 'delete'
  });
};
