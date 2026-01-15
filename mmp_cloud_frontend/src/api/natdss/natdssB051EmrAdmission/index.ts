import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB051EmrAdmissionVO, NatdssB051EmrAdmissionForm, NatdssB051EmrAdmissionQuery } from '@/api/natdss/natdssB051EmrAdmission/types';

/**
 * 查询B05-1 入院记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB051EmrAdmission = (query?: NatdssB051EmrAdmissionQuery): AxiosPromise<NatdssB051EmrAdmissionVO[]> => {
  return request({
    url: '/natdss/natdssB051EmrAdmission/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B05-1 入院记录详细
 * @param id
 */
export const getNatdssB051EmrAdmission = (id: string | number): AxiosPromise<NatdssB051EmrAdmissionVO> => {
  return request({
    url: '/natdss/natdssB051EmrAdmission/' + id,
    method: 'get'
  });
};

/**
 * 新增B05-1 入院记录
 * @param data
 */
export const addNatdssB051EmrAdmission = (data: NatdssB051EmrAdmissionForm) => {
  return request({
    url: '/natdss/natdssB051EmrAdmission',
    method: 'post',
    data: data
  });
};

/**
 * 修改B05-1 入院记录
 * @param data
 */
export const updateNatdssB051EmrAdmission = (data: NatdssB051EmrAdmissionForm) => {
  return request({
    url: '/natdss/natdssB051EmrAdmission',
    method: 'put',
    data: data
  });
};

/**
 * 删除B05-1 入院记录
 * @param id
 */
export const delNatdssB051EmrAdmission = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB051EmrAdmission/' + id,
    method: 'delete'
  });
};
