import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationAuthorizationApplyVO,
  QualificationAuthorizationApplyForm,
  QualificationAuthorizationApplyQuery
} from '@/api/system/qualificationAuthorizationApply/types';

/**
 * 查询资质授权申请列表
 * @param query
 * @returns {*}
 */

export const listQualificationAuthorizationApply = (
  query?: QualificationAuthorizationApplyQuery
): AxiosPromise<QualificationAuthorizationApplyVO[]> => {
  return request({
    url: '/system/qualificationAuthorizationApply/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质授权申请详细
 * @param id
 */
export const getQualificationAuthorizationApply = (id: string | number): AxiosPromise<QualificationAuthorizationApplyVO> => {
  return request({
    url: '/system/qualificationAuthorizationApply/' + id,
    method: 'get'
  });
};

/**
 * 新增资质授权申请
 * @param data
 */
export const addQualificationAuthorizationApply = (data: QualificationAuthorizationApplyForm) => {
  return request({
    url: '/system/qualificationAuthorizationApply',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质授权申请
 * @param data
 */
export const updateQualificationAuthorizationApply = (data: QualificationAuthorizationApplyForm) => {
  return request({
    url: '/system/qualificationAuthorizationApply',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质授权申请
 * @param id
 */
export const delQualificationAuthorizationApply = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qualificationAuthorizationApply/' + id,
    method: 'delete'
  });
};
