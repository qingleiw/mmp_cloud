import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorResearchProjectVO, DoctorResearchProjectForm, DoctorResearchProjectQuery } from '@/api/doctor/doctorResearchProject/types';

/**
 * 查询科研项目列表
 * @param query
 * @returns {*}
 */

export const listDoctorResearchProject = (query?: DoctorResearchProjectQuery): AxiosPromise<DoctorResearchProjectVO[]> => {
  return request({
    url: '/doctor/doctorResearchProject/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询科研项目详细
 * @param id
 */
export const getDoctorResearchProject = (id: string | number): AxiosPromise<DoctorResearchProjectVO> => {
  return request({
    url: '/doctor/doctorResearchProject/' + id,
    method: 'get'
  });
};

/**
 * 新增科研项目
 * @param data
 */
export const addDoctorResearchProject = (data: DoctorResearchProjectForm) => {
  return request({
    url: '/doctor/doctorResearchProject',
    method: 'post',
    data: data
  });
};

/**
 * 修改科研项目
 * @param data
 */
export const updateDoctorResearchProject = (data: DoctorResearchProjectForm) => {
  return request({
    url: '/doctor/doctorResearchProject',
    method: 'put',
    data: data
  });
};

/**
 * 删除科研项目
 * @param id
 */
export const delDoctorResearchProject = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorResearchProject/' + id,
    method: 'delete'
  });
};
