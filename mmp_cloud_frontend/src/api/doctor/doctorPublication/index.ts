import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorPublicationVO, DoctorPublicationForm, DoctorPublicationQuery } from '@/api/doctor/doctorPublication/types';

/**
 * 查询论文论著列表
 * @param query
 * @returns {*}
 */

export const listDoctorPublication = (query?: DoctorPublicationQuery): AxiosPromise<DoctorPublicationVO[]> => {
  return request({
    url: '/doctor/doctorPublication/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询论文论著详细
 * @param id
 */
export const getDoctorPublication = (id: string | number): AxiosPromise<DoctorPublicationVO> => {
  return request({
    url: '/doctor/doctorPublication/' + id,
    method: 'get'
  });
};

/**
 * 新增论文论著
 * @param data
 */
export const addDoctorPublication = (data: DoctorPublicationForm) => {
  return request({
    url: '/doctor/doctorPublication',
    method: 'post',
    data: data
  });
};

/**
 * 修改论文论著
 * @param data
 */
export const updateDoctorPublication = (data: DoctorPublicationForm) => {
  return request({
    url: '/doctor/doctorPublication',
    method: 'put',
    data: data
  });
};

/**
 * 删除论文论著
 * @param id
 */
export const delDoctorPublication = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorPublication/' + id,
    method: 'delete'
  });
};
