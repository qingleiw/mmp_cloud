import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionExpertGroupVO, SupervisionExpertGroupForm, SupervisionExpertGroupQuery } from '@/api/supervision/supervisionExpertGroup/types';

/**
 * 查询专家组列表
 * @param query
 * @returns {*}
 */

export const listSupervisionExpertGroup = (query?: SupervisionExpertGroupQuery): AxiosPromise<SupervisionExpertGroupVO[]> => {
  return request({
    url: '/supervision/supervisionExpertGroup/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询专家组详细
 * @param id
 */
export const getSupervisionExpertGroup = (id: string | number): AxiosPromise<SupervisionExpertGroupVO> => {
  return request({
    url: '/supervision/supervisionExpertGroup/' + id,
    method: 'get'
  });
};

/**
 * 新增专家组
 * @param data
 */
export const addSupervisionExpertGroup = (data: SupervisionExpertGroupForm) => {
  return request({
    url: '/supervision/supervisionExpertGroup',
    method: 'post',
    data: data
  });
};

/**
 * 修改专家组
 * @param data
 */
export const updateSupervisionExpertGroup = (data: SupervisionExpertGroupForm) => {
  return request({
    url: '/supervision/supervisionExpertGroup',
    method: 'put',
    data: data
  });
};

/**
 * 删除专家组
 * @param id
 */
export const delSupervisionExpertGroup = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionExpertGroup/' + id,
    method: 'delete'
  });
};
