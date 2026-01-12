import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { LedgerCriticalPatientVO, LedgerCriticalPatientForm, LedgerCriticalPatientQuery } from '@/api/ledger/ledgerCriticalPatient/types';

/**
 * 查询危重病人抢救登记本列表
 * @param query
 * @returns {*}
 */

export const listLedgerCriticalPatient = (query?: LedgerCriticalPatientQuery): AxiosPromise<LedgerCriticalPatientVO[]> => {
  return request({
    url: '/ledger/ledgerCriticalPatient/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询危重病人抢救登记本详细
 * @param id
 */
export const getLedgerCriticalPatient = (id: string | number): AxiosPromise<LedgerCriticalPatientVO> => {
  return request({
    url: '/ledger/ledgerCriticalPatient/' + id,
    method: 'get'
  });
};

/**
 * 新增危重病人抢救登记本
 * @param data
 */
export const addLedgerCriticalPatient = (data: LedgerCriticalPatientForm) => {
  return request({
    url: '/ledger/ledgerCriticalPatient',
    method: 'post',
    data: data
  });
};

/**
 * 修改危重病人抢救登记本
 * @param data
 */
export const updateLedgerCriticalPatient = (data: LedgerCriticalPatientForm) => {
  return request({
    url: '/ledger/ledgerCriticalPatient',
    method: 'put',
    data: data
  });
};

/**
 * 删除危重病人抢救登记本
 * @param id
 */
export const delLedgerCriticalPatient = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/ledgerCriticalPatient/' + id,
    method: 'delete'
  });
};
