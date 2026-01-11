import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  SupervisionProjectIndicatorVO,
  SupervisionProjectIndicatorForm,
  SupervisionProjectIndicatorQuery
} from '@/api/system/supervisionProjectIndicator/types';

/**
 * 查询督查项目指标列表
 * @param query
 * @returns {*}
 */

export const listSupervisionProjectIndicator = (query?: SupervisionProjectIndicatorQuery): AxiosPromise<SupervisionProjectIndicatorVO[]> => {
  return request({
    url: '/system/supervisionProjectIndicator/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督查项目指标详细
 * @param id
 */
export const getSupervisionProjectIndicator = (id: string | number): AxiosPromise<SupervisionProjectIndicatorVO> => {
  return request({
    url: '/system/supervisionProjectIndicator/' + id,
    method: 'get'
  });
};

/**
 * 新增督查项目指标
 * @param data
 */
export const addSupervisionProjectIndicator = (data: SupervisionProjectIndicatorForm) => {
  return request({
    url: '/system/supervisionProjectIndicator',
    method: 'post',
    data: data
  });
};

/**
 * 修改督查项目指标
 * @param data
 */
export const updateSupervisionProjectIndicator = (data: SupervisionProjectIndicatorForm) => {
  return request({
    url: '/system/supervisionProjectIndicator',
    method: 'put',
    data: data
  });
};

/**
 * 删除督查项目指标
 * @param id
 */
export const delSupervisionProjectIndicator = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/supervisionProjectIndicator/' + id,
    method: 'delete'
  });
};
