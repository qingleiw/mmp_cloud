import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB162PathologicalExamRecordVO, NatdssB162PathologicalExamRecordForm, NatdssB162PathologicalExamRecordQuery } from '@/api/natdss/natdssB162PathologicalExamRecord/types';

/**
 * 查询B162 病理检查记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB162PathologicalExamRecord = (query?: NatdssB162PathologicalExamRecordQuery): AxiosPromise<NatdssB162PathologicalExamRecordVO[]> => {
  return request({
    url: '/natdss/natdssB162PathologicalExamRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B162 病理检查记录详细
 * @param id
 */
export const getNatdssB162PathologicalExamRecord = (id: string | number): AxiosPromise<NatdssB162PathologicalExamRecordVO> => {
  return request({
    url: '/natdss/natdssB162PathologicalExamRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B162 病理检查记录
 * @param data
 */
export const addNatdssB162PathologicalExamRecord = (data: NatdssB162PathologicalExamRecordForm) => {
  return request({
    url: '/natdss/natdssB162PathologicalExamRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B162 病理检查记录
 * @param data
 */
export const updateNatdssB162PathologicalExamRecord = (data: NatdssB162PathologicalExamRecordForm) => {
  return request({
    url: '/natdss/natdssB162PathologicalExamRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B162 病理检查记录
 * @param id
 */
export const delNatdssB162PathologicalExamRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB162PathologicalExamRecord/' + id,
    method: 'delete'
  });
};
