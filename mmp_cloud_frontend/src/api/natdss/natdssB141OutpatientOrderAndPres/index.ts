import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB141OutpatientOrderAndPresVO, NatdssB141OutpatientOrderAndPresForm, NatdssB141OutpatientOrderAndPresQuery } from '@/api/natdss/natdssB141OutpatientOrderAndPres/types';

/**
 * 查询B14-1 门诊医嘱处方记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB141OutpatientOrderAndPres = (query?: NatdssB141OutpatientOrderAndPresQuery): AxiosPromise<NatdssB141OutpatientOrderAndPresVO[]> => {
  return request({
    url: '/natdss/natdssB141OutpatientOrderAndPres/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B14-1 门诊医嘱处方记录详细
 * @param id
 */
export const getNatdssB141OutpatientOrderAndPres = (id: string | number): AxiosPromise<NatdssB141OutpatientOrderAndPresVO> => {
  return request({
    url: '/natdss/natdssB141OutpatientOrderAndPres/' + id,
    method: 'get'
  });
};

/**
 * 新增B14-1 门诊医嘱处方记录
 * @param data
 */
export const addNatdssB141OutpatientOrderAndPres = (data: NatdssB141OutpatientOrderAndPresForm) => {
  return request({
    url: '/natdss/natdssB141OutpatientOrderAndPres',
    method: 'post',
    data: data
  });
};

/**
 * 修改B14-1 门诊医嘱处方记录
 * @param data
 */
export const updateNatdssB141OutpatientOrderAndPres = (data: NatdssB141OutpatientOrderAndPresForm) => {
  return request({
    url: '/natdss/natdssB141OutpatientOrderAndPres',
    method: 'put',
    data: data
  });
};

/**
 * 删除B14-1 门诊医嘱处方记录
 * @param id
 */
export const delNatdssB141OutpatientOrderAndPres = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB141OutpatientOrderAndPres/' + id,
    method: 'delete'
  });
};
