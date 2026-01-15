import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB081InpatientSurgicalRecordVO, NatdssB081InpatientSurgicalRecordForm, NatdssB081InpatientSurgicalRecordQuery } from '@/api/natdss/natdssB081InpatientSurgicalRecord/types';

/**
 * 查询B08-1 住院手术记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB081InpatientSurgicalRecord = (query?: NatdssB081InpatientSurgicalRecordQuery): AxiosPromise<NatdssB081InpatientSurgicalRecordVO[]> => {
  return request({
    url: '/natdss/natdssB081InpatientSurgicalRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B08-1 住院手术记录详细
 * @param id
 */
export const getNatdssB081InpatientSurgicalRecord = (id: string | number): AxiosPromise<NatdssB081InpatientSurgicalRecordVO> => {
  return request({
    url: '/natdss/natdssB081InpatientSurgicalRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B08-1 住院手术记录
 * @param data
 */
export const addNatdssB081InpatientSurgicalRecord = (data: NatdssB081InpatientSurgicalRecordForm) => {
  return request({
    url: '/natdss/natdssB081InpatientSurgicalRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B08-1 住院手术记录
 * @param data
 */
export const updateNatdssB081InpatientSurgicalRecord = (data: NatdssB081InpatientSurgicalRecordForm) => {
  return request({
    url: '/natdss/natdssB081InpatientSurgicalRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B08-1 住院手术记录
 * @param id
 */
export const delNatdssB081InpatientSurgicalRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB081InpatientSurgicalRecord/' + id,
    method: 'delete'
  });
};
