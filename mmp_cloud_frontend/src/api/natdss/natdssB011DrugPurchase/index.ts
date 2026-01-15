import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB011DrugPurchaseVO, NatdssB011DrugPurchaseForm, NatdssB011DrugPurchaseQuery } from '@/api/natdss/natdssB011DrugPurchase/types';

/**
 * 查询B01-1 抗肿瘤药物采购记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB011DrugPurchase = (query?: NatdssB011DrugPurchaseQuery): AxiosPromise<NatdssB011DrugPurchaseVO[]> => {
  return request({
    url: '/natdss/natdssB011DrugPurchase/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B01-1 抗肿瘤药物采购记录详细
 * @param id
 */
export const getNatdssB011DrugPurchase = (id: string | number): AxiosPromise<NatdssB011DrugPurchaseVO> => {
  return request({
    url: '/natdss/natdssB011DrugPurchase/' + id,
    method: 'get'
  });
};

/**
 * 新增B01-1 抗肿瘤药物采购记录
 * @param data
 */
export const addNatdssB011DrugPurchase = (data: NatdssB011DrugPurchaseForm) => {
  return request({
    url: '/natdss/natdssB011DrugPurchase',
    method: 'post',
    data: data
  });
};

/**
 * 修改B01-1 抗肿瘤药物采购记录
 * @param data
 */
export const updateNatdssB011DrugPurchase = (data: NatdssB011DrugPurchaseForm) => {
  return request({
    url: '/natdss/natdssB011DrugPurchase',
    method: 'put',
    data: data
  });
};

/**
 * 删除B01-1 抗肿瘤药物采购记录
 * @param id
 */
export const delNatdssB011DrugPurchase = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB011DrugPurchase/' + id,
    method: 'delete'
  });
};
