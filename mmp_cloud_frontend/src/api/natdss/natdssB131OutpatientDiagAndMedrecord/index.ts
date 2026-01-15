import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB131OutpatientDiagAndMedrecordVO, NatdssB131OutpatientDiagAndMedrecordForm, NatdssB131OutpatientDiagAndMedrecordQuery } from '@/api/natdss/natdssB131OutpatientDiagAndMedrecord/types';

/**
 * 查询B13-1 门诊病历记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB131OutpatientDiagAndMedrecord = (query?: NatdssB131OutpatientDiagAndMedrecordQuery): AxiosPromise<NatdssB131OutpatientDiagAndMedrecordVO[]> => {
  return request({
    url: '/natdss/natdssB131OutpatientDiagAndMedrecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B13-1 门诊病历记录详细
 * @param id
 */
export const getNatdssB131OutpatientDiagAndMedrecord = (id: string | number): AxiosPromise<NatdssB131OutpatientDiagAndMedrecordVO> => {
  return request({
    url: '/natdss/natdssB131OutpatientDiagAndMedrecord/' + id,
    method: 'get'
  });
};

/**
 * 新增B13-1 门诊病历记录
 * @param data
 */
export const addNatdssB131OutpatientDiagAndMedrecord = (data: NatdssB131OutpatientDiagAndMedrecordForm) => {
  return request({
    url: '/natdss/natdssB131OutpatientDiagAndMedrecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改B13-1 门诊病历记录
 * @param data
 */
export const updateNatdssB131OutpatientDiagAndMedrecord = (data: NatdssB131OutpatientDiagAndMedrecordForm) => {
  return request({
    url: '/natdss/natdssB131OutpatientDiagAndMedrecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除B13-1 门诊病历记录
 * @param id
 */
export const delNatdssB131OutpatientDiagAndMedrecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB131OutpatientDiagAndMedrecord/' + id,
    method: 'delete'
  });
};
