import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB101InpatientOrderVO, NatdssB101InpatientOrderForm, NatdssB101InpatientOrderQuery } from '@/api/natdss/natdssB101InpatientOrder/types';

/**
 * 查询B10-1 住院医嘱记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB101InpatientOrder = (query?: NatdssB101InpatientOrderQuery): AxiosPromise<NatdssB101InpatientOrderVO[]> => {
  return request({
    url: '/natdss/natdssB101InpatientOrder/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B10-1 住院医嘱记录详细
 * @param id
 */
export const getNatdssB101InpatientOrder = (id: string | number): AxiosPromise<NatdssB101InpatientOrderVO> => {
  return request({
    url: '/natdss/natdssB101InpatientOrder/' + id,
    method: 'get'
  });
};

/**
 * 新增B10-1 住院医嘱记录
 * @param data
 */
export const addNatdssB101InpatientOrder = (data: NatdssB101InpatientOrderForm) => {
  return request({
    url: '/natdss/natdssB101InpatientOrder',
    method: 'post',
    data: data
  });
};

/**
 * 修改B10-1 住院医嘱记录
 * @param data
 */
export const updateNatdssB101InpatientOrder = (data: NatdssB101InpatientOrderForm) => {
  return request({
    url: '/natdss/natdssB101InpatientOrder',
    method: 'put',
    data: data
  });
};

/**
 * 删除B10-1 住院医嘱记录
 * @param id
 */
export const delNatdssB101InpatientOrder = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB101InpatientOrder/' + id,
    method: 'delete'
  });
};
