import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionProjectVO, SupervisionProjectForm, SupervisionProjectQuery } from '@/api/supervision/supervisionProject/types';

/**
 * 查询督查项目列表
 * @param query
 * @returns {*}
 */

export const listSupervisionProject = (query?: SupervisionProjectQuery): AxiosPromise<SupervisionProjectVO[]> => {
  return request({
    url: '/supervision/supervisionProject/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查项目详细
 * @param id
 */
export const getSupervisionProject = (id: string | number): AxiosPromise<SupervisionProjectVO> => {
  return request({
    url: '/supervision/supervisionProject/' + id,
    method: 'get'
  });
};

/**
 * 新增督查项目
 * @param data
 */
export const addSupervisionProject = (data: SupervisionProjectForm) => {
  return request({
    url: '/supervision/supervisionProject',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查项目
 * @param data
 */
export const updateSupervisionProject = (data: SupervisionProjectForm) => {
  return request({
    url: '/supervision/supervisionProject',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查项目
 * @param id
 */
export const delSupervisionProject = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionProject/' + id,
    method: 'delete'
  });
};
