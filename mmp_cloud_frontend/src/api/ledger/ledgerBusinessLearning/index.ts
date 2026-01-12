import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { LedgerBusinessLearningVO, LedgerBusinessLearningForm, LedgerBusinessLearningQuery } from '@/api/ledger/ledgerBusinessLearning/types';

/**
 * 查询业务学习记录本列表
 * @param query
 * @returns {*}
 */

export const listLedgerBusinessLearning = (query?: LedgerBusinessLearningQuery): AxiosPromise<LedgerBusinessLearningVO[]> => {
  return request({
    url: '/ledger/ledgerBusinessLearning/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询业务学习记录本详细
 * @param id
 */
export const getLedgerBusinessLearning = (id: string | number): AxiosPromise<LedgerBusinessLearningVO> => {
  return request({
    url: '/ledger/ledgerBusinessLearning/' + id,
    method: 'get'
  });
};

/**
 * 新增业务学习记录本
 * @param data
 */
export const addLedgerBusinessLearning = (data: LedgerBusinessLearningForm) => {
  return request({
    url: '/ledger/ledgerBusinessLearning',
    method: 'post',
    data: data
  });
};

/**
 * 修改业务学习记录本
 * @param data
 */
export const updateLedgerBusinessLearning = (data: LedgerBusinessLearningForm) => {
  return request({
    url: '/ledger/ledgerBusinessLearning',
    method: 'put',
    data: data
  });
};

/**
 * 删除业务学习记录本
 * @param id
 */
export const delLedgerBusinessLearning = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/ledgerBusinessLearning/' + id,
    method: 'delete'
  });
};
