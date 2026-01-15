import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB071EmrDischargeVO, NatdssB071EmrDischargeForm, NatdssB071EmrDischargeQuery } from '@/api/natdss/natdssB071EmrDischarge/types';

/**
 * 查询B07-1 出院记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB071EmrDischarge = (query?: NatdssB071EmrDischargeQuery): AxiosPromise<NatdssB071EmrDischargeVO[]> => {
  return request({
    url: '/natdss/natdssB071EmrDischarge/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B07-1 出院记录详细
 * @param id
 */
export const getNatdssB071EmrDischarge = (id: string | number): AxiosPromise<NatdssB071EmrDischargeVO> => {
  return request({
    url: '/natdss/natdssB071EmrDischarge/' + id,
    method: 'get'
  });
};

/**
 * 新增B07-1 出院记录
 * @param data
 */
export const addNatdssB071EmrDischarge = (data: NatdssB071EmrDischargeForm) => {
  return request({
    url: '/natdss/natdssB071EmrDischarge',
    method: 'post',
    data: data
  });
};

/**
 * 修改B07-1 出院记录
 * @param data
 */
export const updateNatdssB071EmrDischarge = (data: NatdssB071EmrDischargeForm) => {
  return request({
    url: '/natdss/natdssB071EmrDischarge',
    method: 'put',
    data: data
  });
};

/**
 * 删除B07-1 出院记录
 * @param id
 */
export const delNatdssB071EmrDischarge = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB071EmrDischarge/' + id,
    method: 'delete'
  });
};
