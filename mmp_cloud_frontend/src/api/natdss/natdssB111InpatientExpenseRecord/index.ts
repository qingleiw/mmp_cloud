import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB111InpatientExpenseRecordVO, NatdssB111InpatientExpenseRecordForm, NatdssB111InpatientExpenseRecordQuery } from '@/api/natdss/natdssB111InpatientExpenseRecord/types';

/**
 * 查询B11-1 住院收费记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB111InpatientExpenseRecord = (query?: NatdssB111InpatientExpenseRecordQuery): AxiosPromise<NatdssB111InpatientExpenseRecordVO[]> => {
  return request({
    url: '/natdss/natdssB111InpatientExpenseRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B11-1 住院收费记录详细
 * @param id
 */
export const getNatdssB111InpatientExpenseRecord = (id: string | number): AxiosPromise<NatdssB111InpatientExpenseRecordVO> => {
  return request({
    url: '/natdss/natdssB111InpatientExpenseRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B11-1 住院收费记录
 * @param data
 */
export const addNatdssB111InpatientExpenseRecord = (data: NatdssB111InpatientExpenseRecordForm) => {
  return request({
    url: '/natdss/natdssB111InpatientExpenseRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B11-1 住院收费记录
 * @param data
 */
export const updateNatdssB111InpatientExpenseRecord = (data: NatdssB111InpatientExpenseRecordForm) => {
  return request({
    url: '/natdss/natdssB111InpatientExpenseRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B11-1 住院收费记录
 * @param id
 */
export const delNatdssB111InpatientExpenseRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB111InpatientExpenseRecord/' + id,
    method: 'delete'
  });
};
