import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NewTechnologyProjectAssessmentVO, NewTechnologyProjectAssessmentForm, NewTechnologyProjectAssessmentQuery } from '@/api/system/newTechnologyProjectAssessment/types';

/**
 * 查询项目考核评估列表
 * @param query
 * @returns {*}
 */

export const listNewTechnologyProjectAssessment = (query?: NewTechnologyProjectAssessmentQuery): AxiosPromise<NewTechnologyProjectAssessmentVO[]> => {
  return request({
    url: '/system/newTechnologyProjectAssessment/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询项目考核评估详细
 * @param id
 */
export const getNewTechnologyProjectAssessment = (id: string | number): AxiosPromise<NewTechnologyProjectAssessmentVO> => {
  return request({
    url: '/system/newTechnologyProjectAssessment/' + id,
    method: 'get'
  });
};

/**
 * 新增项目考核评估
 * @param data
 */
export const addNewTechnologyProjectAssessment = (data: NewTechnologyProjectAssessmentForm) => {
  return request({
    url: '/system/newTechnologyProjectAssessment',
    method: 'post',
    data: data
  });
};

/**
 * 修改项目考核评估
 * @param data
 */
export const updateNewTechnologyProjectAssessment = (data: NewTechnologyProjectAssessmentForm) => {
  return request({
    url: '/system/newTechnologyProjectAssessment',
    method: 'put',
    data: data
  });
};

/**
 * 删除项目考核评估
 * @param id
 */
export const delNewTechnologyProjectAssessment = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/newTechnologyProjectAssessment/' + id,
    method: 'delete'
  });
};
