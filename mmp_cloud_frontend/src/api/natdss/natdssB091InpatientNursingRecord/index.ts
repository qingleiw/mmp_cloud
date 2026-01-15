import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB091InpatientNursingRecordVO, NatdssB091InpatientNursingRecordForm, NatdssB091InpatientNursingRecordQuery } from '@/api/natdss/natdssB091InpatientNursingRecord/types';

/**
 * 查询B09-1 住院护理记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB091InpatientNursingRecord = (query?: NatdssB091InpatientNursingRecordQuery): AxiosPromise<NatdssB091InpatientNursingRecordVO[]> => {
  return request({
    url: '/natdss/natdssB091InpatientNursingRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B09-1 住院护理记录详细
 * @param id
 */
export const getNatdssB091InpatientNursingRecord = (id: string | number): AxiosPromise<NatdssB091InpatientNursingRecordVO> => {
  return request({
    url: '/natdss/natdssB091InpatientNursingRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B09-1 住院护理记录
 * @param data
 */
export const addNatdssB091InpatientNursingRecord = (data: NatdssB091InpatientNursingRecordForm) => {
  return request({
    url: '/natdss/natdssB091InpatientNursingRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B09-1 住院护理记录
 * @param data
 */
export const updateNatdssB091InpatientNursingRecord = (data: NatdssB091InpatientNursingRecordForm) => {
  return request({
    url: '/natdss/natdssB091InpatientNursingRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B09-1 住院护理记录
 * @param id
 */
export const delNatdssB091InpatientNursingRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB091InpatientNursingRecord/' + id,
    method: 'delete'
  });
};
