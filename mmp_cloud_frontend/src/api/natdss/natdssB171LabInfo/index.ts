import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB171LabInfoVO, NatdssB171LabInfoForm, NatdssB171LabInfoQuery } from '@/api/natdss/natdssB171LabInfo/types';

/**
 * 查询B17-1 常规检验记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB171LabInfo = (query?: NatdssB171LabInfoQuery): AxiosPromise<NatdssB171LabInfoVO[]> => {
  return request({
    url: '/natdss/natdssB171LabInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B17-1 常规检验记录详细
 * @param id
 */
export const getNatdssB171LabInfo = (id: string | number): AxiosPromise<NatdssB171LabInfoVO> => {
  return request({
    url: '/natdss/natdssB171LabInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B17-1 常规检验记录
 * @param data
 */
export const addNatdssB171LabInfo = (data: NatdssB171LabInfoForm) => {
  return request({
    url: '/natdss/natdssB171LabInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B17-1 常规检验记录
 * @param data
 */
export const updateNatdssB171LabInfo = (data: NatdssB171LabInfoForm) => {
  return request({
    url: '/natdss/natdssB171LabInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B17-1 常规检验记录
 * @param id
 */
export const delNatdssB171LabInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB171LabInfo/' + id,
    method: 'delete'
  });
};
