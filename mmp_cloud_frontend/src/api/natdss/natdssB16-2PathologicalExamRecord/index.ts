import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB16-2PathologicalExamRecordVO, NatdssB16-2PathologicalExamRecordForm, NatdssB16-2PathologicalExamRecordQuery } from '@/api/natdss/natdssB16-2PathologicalExamRecord/types';

/**
 * 查询B16-2 病理检查记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB16-2PathologicalExamRecord = (query?: NatdssB16-2PathologicalExamRecordQuery): AxiosPromise<NatdssB16-2PathologicalExamRecordVO[]> => {
  return request({
    url: '/natdss/natdssB16-2PathologicalExamRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B16-2 病理检查记录详细
 * @param id
 */
export const getNatdssB16-2PathologicalExamRecord = (id: string | number): AxiosPromise<NatdssB16-2PathologicalExamRecordVO> => {
  return request({
    url: '/natdss/natdssB16-2PathologicalExamRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B16-2 病理检查记录
 * @param data
 */
export const addNatdssB16-2PathologicalExamRecord = (data: NatdssB16-2PathologicalExamRecordForm) => {
  return request({
    url: '/natdss/natdssB16-2PathologicalExamRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B16-2 病理检查记录
 * @param data
 */
export const updateNatdssB16-2PathologicalExamRecord = (data: NatdssB16-2PathologicalExamRecordForm) => {
  return request({
    url: '/natdss/natdssB16-2PathologicalExamRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B16-2 病理检查记录
 * @param id
 */
export const delNatdssB16-2PathologicalExamRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB16-2PathologicalExamRecord/' + id,
    method: 'delete'
  });
};
