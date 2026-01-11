import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionReviewVO, SupervisionReviewForm, SupervisionReviewQuery } from '@/api/system/supervisionReview/types';

/**
 * 查询整改复查列表
 * @param query
 * @returns {*}
 */

export const listSupervisionReview = (query?: SupervisionReviewQuery): AxiosPromise<SupervisionReviewVO[]> => {
  return request({
    url: '/system/supervisionReview/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询整改复查详细
 * @param id
 */
export const getSupervisionReview = (id: string | number): AxiosPromise<SupervisionReviewVO> => {
  return request({
    url: '/system/supervisionReview/' + id,
    method: 'get'
  });
};

/**
 * 新增整改复查
 * @param data
 */
export const addSupervisionReview = (data: SupervisionReviewForm) => {
  return request({
    url: '/system/supervisionReview',
    method: 'post',
    data: data
  });
};

/**
 * 修改整改复查
 * @param data
 */
export const updateSupervisionReview = (data: SupervisionReviewForm) => {
  return request({
    url: '/system/supervisionReview',
    method: 'put',
    data: data
  });
};

/**
 * 删除整改复查
 * @param id
 */
export const delSupervisionReview = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/supervisionReview/' + id,
    method: 'delete'
  });
};
