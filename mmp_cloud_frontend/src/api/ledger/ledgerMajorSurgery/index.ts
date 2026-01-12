import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { LedgerMajorSurgeryVO, LedgerMajorSurgeryForm, LedgerMajorSurgeryQuery } from '@/api/ledger/ledgerMajorSurgery/types';

/**
 * 查询重大疑难手术监测与管理列表
 * @param query
 * @returns {*}
 */

export const listLedgerMajorSurgery = (query?: LedgerMajorSurgeryQuery): AxiosPromise<LedgerMajorSurgeryVO[]> => {
  return request({
    url: '/ledger/ledgerMajorSurgery/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询重大疑难手术监测与管理详细
 * @param id
 */
export const getLedgerMajorSurgery = (id: string | number): AxiosPromise<LedgerMajorSurgeryVO> => {
  return request({
    url: '/ledger/ledgerMajorSurgery/' + id,
    method: 'get'
  });
};

/**
 * 新增重大疑难手术监测与管理
 * @param data
 */
export const addLedgerMajorSurgery = (data: LedgerMajorSurgeryForm) => {
  return request({
    url: '/ledger/ledgerMajorSurgery',
    method: 'post',
    data: data
  });
};

/**
 * 修改重大疑难手术监测与管理
 * @param data
 */
export const updateLedgerMajorSurgery = (data: LedgerMajorSurgeryForm) => {
  return request({
    url: '/ledger/ledgerMajorSurgery',
    method: 'put',
    data: data
  });
};

/**
 * 删除重大疑难手术监测与管理
 * @param id
 */
export const delLedgerMajorSurgery = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/ledgerMajorSurgery/' + id,
    method: 'delete'
  });
};
