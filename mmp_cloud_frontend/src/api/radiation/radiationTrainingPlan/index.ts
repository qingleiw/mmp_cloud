import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationTrainingPlanVO, RadiationTrainingPlanForm, RadiationTrainingPlanQuery } from '@/api/radiation/radiationTrainingPlan/types';

/**
 * 查询职业健康培训计划列表
 * @param query
 * @returns {*}
 */

export const listRadiationTrainingPlan = (query?: RadiationTrainingPlanQuery): AxiosPromise<RadiationTrainingPlanVO[]> => {
  return request({
    url: '/radiation/radiationTrainingPlan/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询职业健康培训计划详细
 * @param id
 */
export const getRadiationTrainingPlan = (id: string | number): AxiosPromise<RadiationTrainingPlanVO> => {
  return request({
    url: '/radiation/radiationTrainingPlan/' + id,
    method: 'get'
  });
};

/**
 * 新增职业健康培训计划
 * @param data
 */
export const addRadiationTrainingPlan = (data: RadiationTrainingPlanForm) => {
  return request({
    url: '/radiation/radiationTrainingPlan',
    method: 'post',
    data: data
  });
};

/**
 * 修改职业健康培训计划
 * @param data
 */
export const updateRadiationTrainingPlan = (data: RadiationTrainingPlanForm) => {
  return request({
    url: '/radiation/radiationTrainingPlan',
    method: 'put',
    data: data
  });
};

/**
 * 删除职业健康培训计划
 * @param id
 */
export const delRadiationTrainingPlan = (id: string | number | Array<string | number>) => {
  return request({
    url: '/radiation/radiationTrainingPlan/' + id,
    method: 'delete'
  });
};
