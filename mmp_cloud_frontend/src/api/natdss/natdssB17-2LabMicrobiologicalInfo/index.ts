import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB17-2LabMicrobiologicalInfoVO, NatdssB17-2LabMicrobiologicalInfoForm, NatdssB17-2LabMicrobiologicalInfoQuery } from '@/api/natdss/natdssB17-2LabMicrobiologicalInfo/types';

/**
 * 查询B17-2 微生物检验记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB17-2LabMicrobiologicalInfo = (query?: NatdssB17-2LabMicrobiologicalInfoQuery): AxiosPromise<NatdssB17-2LabMicrobiologicalInfoVO[]> => {
  return request({
    url: '/natdss/natdssB17-2LabMicrobiologicalInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B17-2 微生物检验记录详细
 * @param id
 */
export const getNatdssB17-2LabMicrobiologicalInfo = (id: string | number): AxiosPromise<NatdssB17-2LabMicrobiologicalInfoVO> => {
  return request({
    url: '/natdss/natdssB17-2LabMicrobiologicalInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B17-2 微生物检验记录
 * @param data
 */
export const addNatdssB17-2LabMicrobiologicalInfo = (data: NatdssB17-2LabMicrobiologicalInfoForm) => {
  return request({
    url: '/natdss/natdssB17-2LabMicrobiologicalInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B17-2 微生物检验记录
 * @param data
 */
export const updateNatdssB17-2LabMicrobiologicalInfo = (data: NatdssB17-2LabMicrobiologicalInfoForm) => {
  return request({
    url: '/natdss/natdssB17-2LabMicrobiologicalInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B17-2 微生物检验记录
 * @param id
 */
export const delNatdssB17-2LabMicrobiologicalInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB17-2LabMicrobiologicalInfo/' + id,
    method: 'delete'
  });
};
