import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcQualityIndicatorVO, QcQualityIndicatorForm, QcQualityIndicatorQuery } from '@/api/qc/qcQualityIndicator/types';

/**
 * 查询质量指标列表
 * @param query
 * @returns {*}
 */

export const listQcQualityIndicator = (query?: QcQualityIndicatorQuery): AxiosPromise<QcQualityIndicatorVO[]> => {
  return request({
    url: '/qc/qcQualityIndicator/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询质量指标详细
 * @param id
 */
export const getQcQualityIndicator = (id: string | number): AxiosPromise<QcQualityIndicatorVO> => {
  return request({
    url: '/qc/qcQualityIndicator/' + id,
    method: 'get'
  });
};

/**
 * 新增质量指标
 * @param data
 */
export const addQcQualityIndicator = (data: QcQualityIndicatorForm) => {
  return request({
    url: '/qc/qcQualityIndicator',
    method: 'post',
    data: data
  });
};

/**
 * 修改质量指标
 * @param data
 */
export const updateQcQualityIndicator = (data: QcQualityIndicatorForm) => {
  return request({
    url: '/qc/qcQualityIndicator',
    method: 'put',
    data: data
  });
};

/**
 * 删除质量指标
 * @param id
 */
export const delQcQualityIndicator = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qc/qcQualityIndicator/' + id,
    method: 'delete'
  });
};
