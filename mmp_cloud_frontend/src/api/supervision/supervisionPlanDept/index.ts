import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionPlanDeptVO, SupervisionPlanDeptForm, SupervisionPlanDeptQuery } from '@/api/system/supervisionPlanDept/types';

/**
 * 查询督查计划科室关联列表
 * @param query
 * @returns {*}
 */

export const listSupervisionPlanDept = (query?: SupervisionPlanDeptQuery): AxiosPromise<SupervisionPlanDeptVO[]> => {
  return request({
    url: '/system/supervisionPlanDept/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查计划科室关联详细
 * @param id
 */
export const getSupervisionPlanDept = (id: string | number): AxiosPromise<SupervisionPlanDeptVO> => {
  return request({
    url: '/system/supervisionPlanDept/' + id,
    method: 'get'
  });
};

/**
 * 新增督查计划科室关联
 * @param data
 */
export const addSupervisionPlanDept = (data: SupervisionPlanDeptForm) => {
  return request({
    url: '/system/supervisionPlanDept',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查计划科室关联
 * @param data
 */
export const updateSupervisionPlanDept = (data: SupervisionPlanDeptForm) => {
  return request({
    url: '/system/supervisionPlanDept',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查计划科室关联
 * @param id
 */
export const delSupervisionPlanDept = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/supervisionPlanDept/' + id,
    method: 'delete'
  });
};
