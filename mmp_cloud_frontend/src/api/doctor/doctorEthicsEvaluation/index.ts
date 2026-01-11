import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DoctorEthicsEvaluationVO, DoctorEthicsEvaluationForm, DoctorEthicsEvaluationQuery } from '@/api/doctor/doctorEthicsEvaluation/types';

/**
 * 查询医德医风考评列表
 * @param query
 * @returns {*}
 */

export const listDoctorEthicsEvaluation = (query?: DoctorEthicsEvaluationQuery): AxiosPromise<DoctorEthicsEvaluationVO[]> => {
  return request({
    url: '/doctor/doctorEthicsEvaluation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医德医风考评详细
 * @param id
 */
export const getDoctorEthicsEvaluation = (id: string | number): AxiosPromise<DoctorEthicsEvaluationVO> => {
  return request({
    url: '/doctor/doctorEthicsEvaluation/' + id,
    method: 'get'
  });
};

/**
 * 新增医德医风考评
 * @param data
 */
export const addDoctorEthicsEvaluation = (data: DoctorEthicsEvaluationForm) => {
  return request({
    url: '/doctor/doctorEthicsEvaluation',
    method: 'post',
    data: data
  });
};

/**
 * 修改医德医风考评
 * @param data
 */
export const updateDoctorEthicsEvaluation = (data: DoctorEthicsEvaluationForm) => {
  return request({
    url: '/doctor/doctorEthicsEvaluation',
    method: 'put',
    data: data
  });
};

/**
 * 删除医德医风考评
 * @param id
 */
export const delDoctorEthicsEvaluation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/doctor/doctorEthicsEvaluation/' + id,
    method: 'delete'
  });
};
