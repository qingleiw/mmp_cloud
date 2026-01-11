import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationTrainingVO, RadiationTrainingForm, RadiationTrainingQuery } from '@/api/system/radiationTraining/types';

/**
 * 查询职业健康培训列表
 * @param query
 * @returns {*}
 */

export const listRadiationTraining = (query?: RadiationTrainingQuery): AxiosPromise<RadiationTrainingVO[]> => {
  return request({
    url: '/system/radiationTraining/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询职业健康培训详细
 * @param id
 */
export const getRadiationTraining = (id: string | number): AxiosPromise<RadiationTrainingVO> => {
  return request({
    url: '/system/radiationTraining/' + id,
    method: 'get'
  });
};

/**
 * 新增职业健康培训
 * @param data
 */
export const addRadiationTraining = (data: RadiationTrainingForm) => {
  return request({
    url: '/system/radiationTraining',
    method: 'post',
    data: data
  });
};

/**
 * 修改职业健康培训
 * @param data
 */
export const updateRadiationTraining = (data: RadiationTrainingForm) => {
  return request({
    url: '/system/radiationTraining',
    method: 'put',
    data: data
  });
};

/**
 * 删除职业健康培训
 * @param id
 */
export const delRadiationTraining = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationTraining/' + id,
    method: 'delete'
  });
};
