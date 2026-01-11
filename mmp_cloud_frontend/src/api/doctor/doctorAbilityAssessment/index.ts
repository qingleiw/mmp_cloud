import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorAbilityAssessmentVO, DoctorAbilityAssessmentForm, DoctorAbilityAssessmentQuery } from '@/api/doctor/doctorAbilityAssessment/types';

/**
 * 查询医师能力评估列表
 * @param query
 * @returns {*}
 */

export const listDoctorAbilityAssessment = (query?: DoctorAbilityAssessmentQuery): AxiosPromise<DoctorAbilityAssessmentVO[]> => {
  return request({
    url: '/doctor/doctorAbilityAssessment/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医师能力评估详细
 * @param id
 */
export const getDoctorAbilityAssessment = (id: string | number): AxiosPromise<DoctorAbilityAssessmentVO> => {
  return request({
    url: '/doctor/doctorAbilityAssessment/' + id,
    method: 'get'
  });
};

/**
 * 新增医师能力评估
 * @param data
 */
export const addDoctorAbilityAssessment = (data: DoctorAbilityAssessmentForm) => {
  return request({
    url: '/doctor/doctorAbilityAssessment',
    method: 'post',
    data: data
  });
};

/**
 * 修改医师能力评估
 * @param data
 */
export const updateDoctorAbilityAssessment = (data: DoctorAbilityAssessmentForm) => {
  return request({
    url: '/doctor/doctorAbilityAssessment',
    method: 'put',
    data: data
  });
};

/**
 * 删除医师能力评估
 * @param id
 */
export const delDoctorAbilityAssessment = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorAbilityAssessment/' + id,
    method: 'delete'
  });
};
