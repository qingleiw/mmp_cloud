import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB04MedicalRecordFrontSheetNonTcmVO, NatdssB04MedicalRecordFrontSheetNonTcmForm, NatdssB04MedicalRecordFrontSheetNonTcmQuery } from '@/api/natdss/natdssB04MedicalRecordFrontSheetNonTcm/types';

/**
 * 查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表
 * @param query
 * @returns {*}
 */

export const listNatdssB04MedicalRecordFrontSheetNonTcm = (query?: NatdssB04MedicalRecordFrontSheetNonTcmQuery): AxiosPromise<NatdssB04MedicalRecordFrontSheetNonTcmVO[]> => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcm/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）详细
 * @param patientId
 */
export const getNatdssB04MedicalRecordFrontSheetNonTcm = (patientId: string | number): AxiosPromise<NatdssB04MedicalRecordFrontSheetNonTcmVO> => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcm/' + patientId,
    method: 'get'
  });
};

/**
 * 新增B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
 * @param data
 */
export const addNatdssB04MedicalRecordFrontSheetNonTcm = (data: NatdssB04MedicalRecordFrontSheetNonTcmForm) => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcm',
    method: 'post',
    data: data
  });
};

/**
 * 修改B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
 * @param data
 */
export const updateNatdssB04MedicalRecordFrontSheetNonTcm = (data: NatdssB04MedicalRecordFrontSheetNonTcmForm) => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcm',
    method: 'put',
    data: data
  });
};

/**
 * 删除B04病历首页-核心信息-非中医院（基础+诊断+主要手术）
 * @param patientId
 */
export const delNatdssB04MedicalRecordFrontSheetNonTcm = (patientId: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcm/' + patientId,
    method: 'delete'
  });
};
