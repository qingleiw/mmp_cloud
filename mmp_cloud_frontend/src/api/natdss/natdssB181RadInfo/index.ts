import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB181RadInfoVO, NatdssB181RadInfoForm, NatdssB181RadInfoQuery } from '@/api/natdss/natdssB181RadInfo/types';

/**
 * 查询B18-1 临床放疗记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB181RadInfo = (query?: NatdssB181RadInfoQuery): AxiosPromise<NatdssB181RadInfoVO[]> => {
  return request({
    url: '/natdss/natdssB181RadInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B18-1 临床放疗记录详细
 * @param id
 */
export const getNatdssB181RadInfo = (id: string | number): AxiosPromise<NatdssB181RadInfoVO> => {
  return request({
    url: '/natdss/natdssB181RadInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B18-1 临床放疗记录
 * @param data
 */
export const addNatdssB181RadInfo = (data: NatdssB181RadInfoForm) => {
  return request({
    url: '/natdss/natdssB181RadInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B18-1 临床放疗记录
 * @param data
 */
export const updateNatdssB181RadInfo = (data: NatdssB181RadInfoForm) => {
  return request({
    url: '/natdss/natdssB181RadInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B18-1 临床放疗记录
 * @param id
 */
export const delNatdssB181RadInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB181RadInfo/' + id,
    method: 'delete'
  });
};
