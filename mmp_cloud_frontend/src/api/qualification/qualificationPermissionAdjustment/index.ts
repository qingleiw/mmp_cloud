import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationPermissionAdjustmentVO,
  QualificationPermissionAdjustmentForm,
  QualificationPermissionAdjustmentQuery
} from '@/api/system/qualificationPermissionAdjustment/types';

/**
 * 查询资质权限调整历史列表
 * @param query
 * @returns {*}
 */

export const listQualificationPermissionAdjustment = (
  query?: QualificationPermissionAdjustmentQuery
): AxiosPromise<QualificationPermissionAdjustmentVO[]> => {
  return request({
    url: '/system/qualificationPermissionAdjustment/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质权限调整历史详细
 * @param id
 */
export const getQualificationPermissionAdjustment = (id: string | number): AxiosPromise<QualificationPermissionAdjustmentVO> => {
  return request({
    url: '/system/qualificationPermissionAdjustment/' + id,
    method: 'get'
  });
};

/**
 * 新增资质权限调整历史
 * @param data
 */
export const addQualificationPermissionAdjustment = (data: QualificationPermissionAdjustmentForm) => {
  return request({
    url: '/system/qualificationPermissionAdjustment',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质权限调整历史
 * @param data
 */
export const updateQualificationPermissionAdjustment = (data: QualificationPermissionAdjustmentForm) => {
  return request({
    url: '/system/qualificationPermissionAdjustment',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质权限调整历史
 * @param id
 */
export const delQualificationPermissionAdjustment = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qualificationPermissionAdjustment/' + id,
    method: 'delete'
  });
};
