import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB021PatientInfoVO, NatdssB021PatientInfoForm, NatdssB021PatientInfoQuery } from '@/api/natdss/natdssB021PatientInfo/types';

/**
 * 查询B02-1 患者就诊基本信息列表
 * @param query
 * @returns {*}
 */

export const listNatdssB021PatientInfo = (query?: NatdssB021PatientInfoQuery): AxiosPromise<NatdssB021PatientInfoVO[]> => {
  return request({
    url: '/natdss/natdssB021PatientInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B02-1 患者就诊基本信息详细
 * @param id
 */
export const getNatdssB021PatientInfo = (id: string | number): AxiosPromise<NatdssB021PatientInfoVO> => {
  return request({
    url: '/natdss/natdssB021PatientInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B02-1 患者就诊基本信息
 * @param data
 */
export const addNatdssB021PatientInfo = (data: NatdssB021PatientInfoForm) => {
  return request({
    url: '/natdss/natdssB021PatientInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B02-1 患者就诊基本信息
 * @param data
 */
export const updateNatdssB021PatientInfo = (data: NatdssB021PatientInfoForm) => {
  return request({
    url: '/natdss/natdssB021PatientInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B02-1 患者就诊基本信息
 * @param id
 */
export const delNatdssB021PatientInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB021PatientInfo/' + id,
    method: 'delete'
  });
};
