import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationAdmissionConditionVO,
  QualificationAdmissionConditionForm,
  QualificationAdmissionConditionQuery
} from '@/api/qualification/qualificationAdmissionCondition/types';

/**
 * 查询资质准入条件列表
 * @param query
 * @returns {*}
 */

export const listQualificationAdmissionCondition = (
  query?: QualificationAdmissionConditionQuery
): AxiosPromise<QualificationAdmissionConditionVO[]> => {
  return request({
    url: '/qualification/qualificationAdmissionCondition/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质准入条件详细
 * @param id
 */
export const getQualificationAdmissionCondition = (id: string | number): AxiosPromise<QualificationAdmissionConditionVO> => {
  return request({
    url: '/qualification/qualificationAdmissionCondition/' + id,
    method: 'get'
  });
};

/**
 * 新增资质准入条件
 * @param data
 */
export const addQualificationAdmissionCondition = (data: QualificationAdmissionConditionForm) => {
  return request({
    url: '/qualification/qualificationAdmissionCondition',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质准入条件
 * @param data
 */
export const updateQualificationAdmissionCondition = (data: QualificationAdmissionConditionForm) => {
  return request({
    url: '/qualification/qualificationAdmissionCondition',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质准入条件
 * @param id
 */
export const delQualificationAdmissionCondition = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qualification/qualificationAdmissionCondition/' + id,
    method: 'delete'
  });
};
