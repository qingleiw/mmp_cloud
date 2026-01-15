import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB022AdrInfoVO, NatdssB022AdrInfoForm, NatdssB022AdrInfoQuery } from '@/api/natdss/natdssB022AdrInfo/types';

/**
 * 查询B02-2 患者药物不良反应记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB022AdrInfo = (query?: NatdssB022AdrInfoQuery): AxiosPromise<NatdssB022AdrInfoVO[]> => {
  return request({
    url: '/natdss/natdssB022AdrInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B02-2 患者药物不良反应记录详细
 * @param id
 */
export const getNatdssB022AdrInfo = (id: string | number): AxiosPromise<NatdssB022AdrInfoVO> => {
  return request({
    url: '/natdss/natdssB022AdrInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B02-2 患者药物不良反应记录
 * @param data
 */
export const addNatdssB022AdrInfo = (data: NatdssB022AdrInfoForm) => {
  return request({
    url: '/natdss/natdssB022AdrInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B02-2 患者药物不良反应记录
 * @param data
 */
export const updateNatdssB022AdrInfo = (data: NatdssB022AdrInfoForm) => {
  return request({
    url: '/natdss/natdssB022AdrInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B02-2 患者药物不良反应记录
 * @param id
 */
export const delNatdssB022AdrInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB022AdrInfo/' + id,
    method: 'delete'
  });
};
