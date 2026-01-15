import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB151OutpatientExpenseRecordVO, NatdssB151OutpatientExpenseRecordForm, NatdssB151OutpatientExpenseRecordQuery } from '@/api/natdss/natdssB151OutpatientExpenseRecord/types';

/**
 * 查询B15-1 门诊收费记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB151OutpatientExpenseRecord = (query?: NatdssB151OutpatientExpenseRecordQuery): AxiosPromise<NatdssB151OutpatientExpenseRecordVO[]> => {
  return request({
    url: '/natdss/natdssB151OutpatientExpenseRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B15-1 门诊收费记录详细
 * @param id
 */
export const getNatdssB151OutpatientExpenseRecord = (id: string | number): AxiosPromise<NatdssB151OutpatientExpenseRecordVO> => {
  return request({
    url: '/natdss/natdssB151OutpatientExpenseRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B15-1 门诊收费记录
 * @param data
 */
export const addNatdssB151OutpatientExpenseRecord = (data: NatdssB151OutpatientExpenseRecordForm) => {
  return request({
    url: '/natdss/natdssB151OutpatientExpenseRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B15-1 门诊收费记录
 * @param data
 */
export const updateNatdssB151OutpatientExpenseRecord = (data: NatdssB151OutpatientExpenseRecordForm) => {
  return request({
    url: '/natdss/natdssB151OutpatientExpenseRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B15-1 门诊收费记录
 * @param id
 */
export const delNatdssB151OutpatientExpenseRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB151OutpatientExpenseRecord/' + id,
    method: 'delete'
  });
};
