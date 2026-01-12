import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { LedgerPatientFullCycleVO, LedgerPatientFullCycleForm, LedgerPatientFullCycleQuery } from '@/api/ledger/ledgerPatientFullCycle/types';

/**
 * 查询患者医疗全周期信息管理列表
 * @param query
 * @returns {*}
 */

export const listLedgerPatientFullCycle = (query?: LedgerPatientFullCycleQuery): AxiosPromise<LedgerPatientFullCycleVO[]> => {
  return request({
    url: '/ledger/ledgerPatientFullCycle/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询患者医疗全周期信息管理详细
 * @param id
 */
export const getLedgerPatientFullCycle = (id: string | number): AxiosPromise<LedgerPatientFullCycleVO> => {
  return request({
    url: '/ledger/ledgerPatientFullCycle/' + id,
    method: 'get'
  });
};

/**
 * 新增患者医疗全周期信息管理
 * @param data
 */
export const addLedgerPatientFullCycle = (data: LedgerPatientFullCycleForm) => {
  return request({
    url: '/ledger/ledgerPatientFullCycle',
    method: 'post',
    data: data
  });
};

/**
 * 修改患者医疗全周期信息管理
 * @param data
 */
export const updateLedgerPatientFullCycle = (data: LedgerPatientFullCycleForm) => {
  return request({
    url: '/ledger/ledgerPatientFullCycle',
    method: 'put',
    data: data
  });
};

/**
 * 删除患者医疗全周期信息管理
 * @param id
 */
export const delLedgerPatientFullCycle = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/ledgerPatientFullCycle/' + id,
    method: 'delete'
  });
};
