import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationHealthExamPlanVO, RadiationHealthExamPlanForm, RadiationHealthExamPlanQuery } from '@/api/radiation/radiationHealthExamPlan/types';

/**
 * 查询职业健康体检计划列表
 * @param query
 * @returns {*}
 */

export const listRadiationHealthExamPlan = (query?: RadiationHealthExamPlanQuery): AxiosPromise<RadiationHealthExamPlanVO[]> => {
  return request({
    url: '/radiation/radiationHealthExamPlan/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询职业健康体检计划详细
 * @param id
 */
export const getRadiationHealthExamPlan = (id: string | number): AxiosPromise<RadiationHealthExamPlanVO> => {
  return request({
    url: '/radiation/radiationHealthExamPlan/' + id,
    method: 'get'
  });
};

/**
 * 新增职业健康体检计划
 * @param data
 */
export const addRadiationHealthExamPlan = (data: RadiationHealthExamPlanForm) => {
  return request({
    url: '/radiation/radiationHealthExamPlan',
    method: 'post',
    data: data
  });
};

/**
 * 修改职业健康体检计划
 * @param data
 */
export const updateRadiationHealthExamPlan = (data: RadiationHealthExamPlanForm) => {
  return request({
    url: '/radiation/radiationHealthExamPlan',
    method: 'put',
    data: data
  });
};

/**
 * 删除职业健康体检计划
 * @param id
 */
export const delRadiationHealthExamPlan = (id: string | number | Array<string | number>) => {
  return request({
    url: '/radiation/radiationHealthExamPlan/' + id,
    method: 'delete'
  });
};
