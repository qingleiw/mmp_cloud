import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { LedgerLongStayPatientVO, LedgerLongStayPatientForm, LedgerLongStayPatientQuery } from '@/api/ledger/ledgerLongStayPatient/types';

/**
 * 查询住院超30天患者登记本列表
 * @param query
 * @returns {*}
 */

export const listLedgerLongStayPatient = (query?: LedgerLongStayPatientQuery): AxiosPromise<LedgerLongStayPatientVO[]> => {
  return request({
    url: '/ledger/ledgerLongStayPatient/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询住院超30天患者登记本详细
 * @param id
 */
export const getLedgerLongStayPatient = (id: string | number): AxiosPromise<LedgerLongStayPatientVO> => {
  return request({
    url: '/ledger/ledgerLongStayPatient/' + id,
    method: 'get'
  });
};

/**
 * 新增住院超30天患者登记本
 * @param data
 */
export const addLedgerLongStayPatient = (data: LedgerLongStayPatientForm) => {
  return request({
    url: '/ledger/ledgerLongStayPatient',
    method: 'post',
    data: data
  });
};

/**
 * 修改住院超30天患者登记本
 * @param data
 */
export const updateLedgerLongStayPatient = (data: LedgerLongStayPatientForm) => {
  return request({
    url: '/ledger/ledgerLongStayPatient',
    method: 'put',
    data: data
  });
};

/**
 * 删除住院超30天患者登记本
 * @param id
 */
export const delLedgerLongStayPatient = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/ledgerLongStayPatient/' + id,
    method: 'delete'
  });
};
