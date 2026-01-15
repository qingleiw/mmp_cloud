import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB023DiagInfoVO, NatdssB023DiagInfoForm, NatdssB023DiagInfoQuery } from '@/api/natdss/natdssB023DiagInfo/types';

/**
 * 查询B02-3 患者诊断记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB023DiagInfo = (query?: NatdssB023DiagInfoQuery): AxiosPromise<NatdssB023DiagInfoVO[]> => {
  return request({
    url: '/natdss/natdssB023DiagInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B02-3 患者诊断记录详细
 * @param id
 */
export const getNatdssB023DiagInfo = (id: string | number): AxiosPromise<NatdssB023DiagInfoVO> => {
  return request({
    url: '/natdss/natdssB023DiagInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B02-3 患者诊断记录
 * @param data
 */
export const addNatdssB023DiagInfo = (data: NatdssB023DiagInfoForm) => {
  return request({
    url: '/natdss/natdssB023DiagInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B02-3 患者诊断记录
 * @param data
 */
export const updateNatdssB023DiagInfo = (data: NatdssB023DiagInfoForm) => {
  return request({
    url: '/natdss/natdssB023DiagInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B02-3 患者诊断记录
 * @param id
 */
export const delNatdssB023DiagInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB023DiagInfo/' + id,
    method: 'delete'
  });
};
