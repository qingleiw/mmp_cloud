import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { LedgerUnplannedReoperationVO, LedgerUnplannedReoperationForm, LedgerUnplannedReoperationQuery } from '@/api/ledger/ledgerUnplannedReoperation/types';

/**
 * 查询非计划再次手术登记本列表
 * @param query
 * @returns {*}
 */

export const listLedgerUnplannedReoperation = (query?: LedgerUnplannedReoperationQuery): AxiosPromise<LedgerUnplannedReoperationVO[]> => {
  return request({
    url: '/ledger/ledgerUnplannedReoperation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询非计划再次手术登记本详细
 * @param id
 */
export const getLedgerUnplannedReoperation = (id: string | number): AxiosPromise<LedgerUnplannedReoperationVO> => {
  return request({
    url: '/ledger/ledgerUnplannedReoperation/' + id,
    method: 'get'
  });
};

/**
 * 新增非计划再次手术登记本
 * @param data
 */
export const addLedgerUnplannedReoperation = (data: LedgerUnplannedReoperationForm) => {
  return request({
    url: '/ledger/ledgerUnplannedReoperation',
    method: 'post',
    data: data
  });
};

/**
 * 修改非计划再次手术登记本
 * @param data
 */
export const updateLedgerUnplannedReoperation = (data: LedgerUnplannedReoperationForm) => {
  return request({
    url: '/ledger/ledgerUnplannedReoperation',
    method: 'put',
    data: data
  });
};

/**
 * 删除非计划再次手术登记本
 * @param id
 */
export const delLedgerUnplannedReoperation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/ledgerUnplannedReoperation/' + id,
    method: 'delete'
  });
};
