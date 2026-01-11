import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorTrainingVO, DoctorTrainingForm, DoctorTrainingQuery } from '@/api/doctor/doctorTraining/types';

/**
 * 查询培训记录列表
 * @param query
 * @returns {*}
 */

export const listDoctorTraining = (query?: DoctorTrainingQuery): AxiosPromise<DoctorTrainingVO[]> => {
  return request({
    url: '/doctor/doctorTraining/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询培训记录详细
 * @param id
 */
export const getDoctorTraining = (id: string | number): AxiosPromise<DoctorTrainingVO> => {
  return request({
    url: '/doctor/doctorTraining/' + id,
    method: 'get'
  });
};

/**
 * 新增培训记录
 * @param data
 */
export const addDoctorTraining = (data: DoctorTrainingForm) => {
  return request({
    url: '/doctor/doctorTraining',
    method: 'post',
    data: data
  });
};

/**
 * 修改培训记录
 * @param data
 */
export const updateDoctorTraining = (data: DoctorTrainingForm) => {
  return request({
    url: '/doctor/doctorTraining',
    method: 'put',
    data: data
  });
};

/**
 * 删除培训记录
 * @param id
 */
export const delDoctorTraining = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorTraining/' + id,
    method: 'delete'
  });
};
