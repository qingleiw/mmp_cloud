import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB172LabMicrobiologicalInfoVO, NatdssB172LabMicrobiologicalInfoForm, NatdssB172LabMicrobiologicalInfoQuery } from '@/api/natdss/natdssB172LabMicrobiologicalInfo/types';

/**
 * 查询B172 微生物检验记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB172LabMicrobiologicalInfo = (query?: NatdssB172LabMicrobiologicalInfoQuery): AxiosPromise<NatdssB172LabMicrobiologicalInfoVO[]> => {
  return request({
    url: '/natdss/natdssB172LabMicrobiologicalInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B172 微生物检验记录详细
 * @param id
 */
export const getNatdssB172LabMicrobiologicalInfo = (id: string | number): AxiosPromise<NatdssB172LabMicrobiologicalInfoVO> => {
  return request({
    url: '/natdss/natdssB172LabMicrobiologicalInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B172 微生物检验记录
 * @param data
 */
export const addNatdssB172LabMicrobiologicalInfo = (data: NatdssB172LabMicrobiologicalInfoForm) => {
  return request({
    url: '/natdss/natdssB172LabMicrobiologicalInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B172 微生物检验记录
 * @param data
 */
export const updateNatdssB172LabMicrobiologicalInfo = (data: NatdssB172LabMicrobiologicalInfoForm) => {
  return request({
    url: '/natdss/natdssB172LabMicrobiologicalInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B172 微生物检验记录
 * @param id
 */
export const delNatdssB172LabMicrobiologicalInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB172LabMicrobiologicalInfo/' + id,
    method: 'delete'
  });
};
