import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB031InpatientInfoVO, NatdssB031InpatientInfoForm, NatdssB031InpatientInfoQuery } from '@/api/natdss/natdssB031InpatientInfo/types';

/**
 * 查询B03-1 住院患者信息列表
 * @param query
 * @returns {*}
 */

export const listNatdssB031InpatientInfo = (query?: NatdssB031InpatientInfoQuery): AxiosPromise<NatdssB031InpatientInfoVO[]> => {
  return request({
    url: '/natdss/natdssB031InpatientInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B03-1 住院患者信息详细
 * @param id
 */
export const getNatdssB031InpatientInfo = (id: string | number): AxiosPromise<NatdssB031InpatientInfoVO> => {
  return request({
    url: '/natdss/natdssB031InpatientInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B03-1 住院患者信息
 * @param data
 */
export const addNatdssB031InpatientInfo = (data: NatdssB031InpatientInfoForm) => {
  return request({
    url: '/natdss/natdssB031InpatientInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B03-1 住院患者信息
 * @param data
 */
export const updateNatdssB031InpatientInfo = (data: NatdssB031InpatientInfoForm) => {
  return request({
    url: '/natdss/natdssB031InpatientInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B03-1 住院患者信息
 * @param id
 */
export const delNatdssB031InpatientInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB031InpatientInfo/' + id,
    method: 'delete'
  });
};
