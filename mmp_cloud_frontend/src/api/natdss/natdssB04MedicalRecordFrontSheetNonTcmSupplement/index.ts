import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO, NatdssB04MedicalRecordFrontSheetNonTcmSupplementForm, NatdssB04MedicalRecordFrontSheetNonTcmSupplementQuery } from '@/api/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement/types';

/**
 * 查询B04非中医院-补充信息（其他手术+费用+扩展信息）列表
 * @param query
 * @returns {*}
 */

export const listNatdssB04MedicalRecordFrontSheetNonTcmSupplement = (query?: NatdssB04MedicalRecordFrontSheetNonTcmSupplementQuery): AxiosPromise<NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO[]> => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B04非中医院-补充信息（其他手术+费用+扩展信息）详细
 * @param patientId
 */
export const getNatdssB04MedicalRecordFrontSheetNonTcmSupplement = (patientId: string | number): AxiosPromise<NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO> => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement/' + patientId,
    method: 'get'
  });
};

/**
 * 新增B04非中医院-补充信息（其他手术+费用+扩展信息）
 * @param data
 */
export const addNatdssB04MedicalRecordFrontSheetNonTcmSupplement = (data: NatdssB04MedicalRecordFrontSheetNonTcmSupplementForm) => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement',
    method: 'post',
    data: data
  });
};

/**
 * 修改B04非中医院-补充信息（其他手术+费用+扩展信息）
 * @param data
 */
export const updateNatdssB04MedicalRecordFrontSheetNonTcmSupplement = (data: NatdssB04MedicalRecordFrontSheetNonTcmSupplementForm) => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement',
    method: 'put',
    data: data
  });
};

/**
 * 删除B04非中医院-补充信息（其他手术+费用+扩展信息）
 * @param patientId
 */
export const delNatdssB04MedicalRecordFrontSheetNonTcmSupplement = (patientId: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement/' + patientId,
    method: 'delete'
  });
};
