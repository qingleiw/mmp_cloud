import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcScoringRuleVO, QcScoringRuleForm, QcScoringRuleQuery } from '@/api/qc/qcScoringRule/types';

/**
 * 查询评分规则列表
 * @param query
 * @returns {*}
 */

export const listQcScoringRule = (query?: QcScoringRuleQuery): AxiosPromise<QcScoringRuleVO[]> => {
  return request({
    url: '/qc/qcScoringRule/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询评分规则详细
 * @param id
 */
export const getQcScoringRule = (id: string | number): AxiosPromise<QcScoringRuleVO> => {
  return request({
    url: '/qc/qcScoringRule/' + id,
    method: 'get'
  });
};

/**
 * 新增评分规则
 * @param data
 */
export const addQcScoringRule = (data: QcScoringRuleForm) => {
  return request({
    url: '/qc/qcScoringRule',
    method: 'post',
    data: data
  });
};

/**
 * 修改评分规则
 * @param data
 */
export const updateQcScoringRule = (data: QcScoringRuleForm) => {
  return request({
    url: '/qc/qcScoringRule',
    method: 'put',
    data: data
  });
};

/**
 * 删除评分规则
 * @param id
 */
export const delQcScoringRule = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qc/qcScoringRule/' + id,
    method: 'delete'
  });
};
