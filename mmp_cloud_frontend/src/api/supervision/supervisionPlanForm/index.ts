import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionPlanFormVO, SupervisionPlanFormForm, SupervisionPlanFormQuery } from '@/api/supervision/supervisionPlanForm/types';

/**
 * 查询督查计划单关联列表
 * @param query
 * @returns {*}
 */

export const listSupervisionPlanForm = (query?: SupervisionPlanFormQuery): AxiosPromise<SupervisionPlanFormVO[]> => {
  return request({
    url: '/supervision/supervisionPlanForm/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查计划单关联详细
 * @param id
 */
export const getSupervisionPlanForm = (id: string | number): AxiosPromise<SupervisionPlanFormVO> => {
  return request({
    url: '/supervision/supervisionPlanForm/' + id,
    method: 'get'
  });
};

/**
 * 新增督查计划单关联
 * @param data
 */
export const addSupervisionPlanForm = (data: SupervisionPlanFormForm) => {
  return request({
    url: '/supervision/supervisionPlanForm',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查计划单关联
 * @param data
 */
export const updateSupervisionPlanForm = (data: SupervisionPlanFormForm) => {
  return request({
    url: '/supervision/supervisionPlanForm',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查计划单关联
 * @param id
 */
export const delSupervisionPlanForm = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionPlanForm/' + id,
    method: 'delete'
  });
};
