import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB012DrugUseVO, NatdssB012DrugUseForm, NatdssB012DrugUseQuery } from '@/api/natdss/natdssB012DrugUse/types';

/**
 * 查询B01-2 抗肿瘤药物使用记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB012DrugUse = (query?: NatdssB012DrugUseQuery): AxiosPromise<NatdssB012DrugUseVO[]> => {
  return request({
    url: '/natdss/natdssB012DrugUse/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B01-2 抗肿瘤药物使用记录详细
 * @param id
 */
export const getNatdssB012DrugUse = (id: string | number): AxiosPromise<NatdssB012DrugUseVO> => {
  return request({
    url: '/natdss/natdssB012DrugUse/' + id,
    method: 'get'
  });
};

/**
 * 新增B01-2 抗肿瘤药物使用记录
 * @param data
 */
export const addNatdssB012DrugUse = (data: NatdssB012DrugUseForm) => {
  return request({
    url: '/natdss/natdssB012DrugUse',
    method: 'post',
    data: data
  });
};

/**
 * 修改B01-2 抗肿瘤药物使用记录
 * @param data
 */
export const updateNatdssB012DrugUse = (data: NatdssB012DrugUseForm) => {
  return request({
    url: '/natdss/natdssB012DrugUse',
    method: 'put',
    data: data
  });
};

/**
 * 删除B01-2 抗肿瘤药物使用记录
 * @param id
 */
export const delNatdssB012DrugUse = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB012DrugUse/' + id,
    method: 'delete'
  });
};
