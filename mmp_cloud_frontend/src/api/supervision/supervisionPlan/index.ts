import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionPlanVO, SupervisionPlanForm, SupervisionPlanQuery } from '@/api/supervision/supervisionPlan/types';

/**
 * 查询督查计划列表
 * @param query
 * @returns {*}
 */

export const listSupervisionPlan = (query?: SupervisionPlanQuery): AxiosPromise<SupervisionPlanVO[]> => {
  return request({
    url: '/supervision/supervisionPlan/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查计划详细
 * @param id
 */
export const getSupervisionPlan = (id: string | number): AxiosPromise<SupervisionPlanVO> => {
  return request({
    url: '/supervision/supervisionPlan/' + id,
    method: 'get'
  });
};

/**
 * 新增督查计划
 * @param data
 */
export const addSupervisionPlan = (data: SupervisionPlanForm) => {
  return request({
    url: '/supervision/supervisionPlan',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查计划
 * @param data
 */
export const updateSupervisionPlan = (data: SupervisionPlanForm) => {
  return request({
    url: '/supervision/supervisionPlan',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查计划
 * @param id
 */
export const delSupervisionPlan = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionPlan/' + id,
    method: 'delete'
  });
};
