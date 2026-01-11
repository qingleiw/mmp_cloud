import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcScoringResultVO, QcScoringResultForm, QcScoringResultQuery } from '@/api/qc/qcScoringResult/types';

/**
 * 查询评分结果列表
 * @param query
 * @returns {*}
 */

export const listQcScoringResult = (query?: QcScoringResultQuery): AxiosPromise<QcScoringResultVO[]> => {
  return request({
    url: '/qc/qcScoringResult/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询评分结果详细
 * @param id
 */
export const getQcScoringResult = (id: string | number): AxiosPromise<QcScoringResultVO> => {
  return request({
    url: '/qc/qcScoringResult/' + id,
    method: 'get'
  });
};

/**
 * 新增评分结果
 * @param data
 */
export const addQcScoringResult = (data: QcScoringResultForm) => {
  return request({
    url: '/qc/qcScoringResult',
    method: 'post',
    data: data
  });
};

/**
 * 修改评分结果
 * @param data
 */
export const updateQcScoringResult = (data: QcScoringResultForm) => {
  return request({
    url: '/qc/qcScoringResult',
    method: 'put',
    data: data
  });
};

/**
 * 删除评分结果
 * @param id
 */
export const delQcScoringResult = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qc/qcScoringResult/' + id,
    method: 'delete'
  });
};
