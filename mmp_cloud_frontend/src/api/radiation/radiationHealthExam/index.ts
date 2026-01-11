import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationHealthExamVO, RadiationHealthExamForm, RadiationHealthExamQuery } from '@/api/system/radiationHealthExam/types';

/**
 * 查询职业健康体检列表
 * @param query
 * @returns {*}
 */

export const listRadiationHealthExam = (query?: RadiationHealthExamQuery): AxiosPromise<RadiationHealthExamVO[]> => {
  return request({
    url: '/system/radiationHealthExam/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询职业健康体检详细
 * @param id
 */
export const getRadiationHealthExam = (id: string | number): AxiosPromise<RadiationHealthExamVO> => {
  return request({
    url: '/system/radiationHealthExam/' + id,
    method: 'get'
  });
};

/**
 * 新增职业健康体检
 * @param data
 */
export const addRadiationHealthExam = (data: RadiationHealthExamForm) => {
  return request({
    url: '/system/radiationHealthExam',
    method: 'post',
    data: data
  });
};

/**
 * 修改职业健康体检
 * @param data
 */
export const updateRadiationHealthExam = (data: RadiationHealthExamForm) => {
  return request({
    url: '/system/radiationHealthExam',
    method: 'put',
    data: data
  });
};

/**
 * 删除职业健康体检
 * @param id
 */
export const delRadiationHealthExam = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationHealthExam/' + id,
    method: 'delete'
  });
};
