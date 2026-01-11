import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcIndicatorFactorVO, QcIndicatorFactorForm, QcIndicatorFactorQuery } from '@/api/qc/qcIndicatorFactor/types';

/**
 * 查询指标计算因子列表
 * @param query
 * @returns {*}
 */

export const listQcIndicatorFactor = (query?: QcIndicatorFactorQuery): AxiosPromise<QcIndicatorFactorVO[]> => {
  return request({
    url: '/qc/qcIndicatorFactor/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询指标计算因子详细
 * @param id
 */
export const getQcIndicatorFactor = (id: string | number): AxiosPromise<QcIndicatorFactorVO> => {
  return request({
    url: '/qc/qcIndicatorFactor/' + id,
    method: 'get'
  });
};

/**
 * 新增指标计算因子
 * @param data
 */
export const addQcIndicatorFactor = (data: QcIndicatorFactorForm) => {
  return request({
    url: '/qc/qcIndicatorFactor',
    method: 'post',
    data: data
  });
};

/**
 * 修改指标计算因子
 * @param data
 */
export const updateQcIndicatorFactor = (data: QcIndicatorFactorForm) => {
  return request({
    url: '/qc/qcIndicatorFactor',
    method: 'put',
    data: data
  });
};

/**
 * 删除指标计算因子
 * @param id
 */
export const delQcIndicatorFactor = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qc/qcIndicatorFactor/' + id,
    method: 'delete'
  });
};
