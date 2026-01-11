import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationAuthorizationRecordVO,
  QualificationAuthorizationRecordForm,
  QualificationAuthorizationRecordQuery
} from '@/api/system/qualificationAuthorizationRecord/types';

/**
 * 查询资质授权记录列表
 * @param query
 * @returns {*}
 */

export const listQualificationAuthorizationRecord = (
  query?: QualificationAuthorizationRecordQuery
): AxiosPromise<QualificationAuthorizationRecordVO[]> => {
  return request({
    url: '/system/qualificationAuthorizationRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质授权记录详细
 * @param id
 */
export const getQualificationAuthorizationRecord = (id: string | number): AxiosPromise<QualificationAuthorizationRecordVO> => {
  return request({
    url: '/system/qualificationAuthorizationRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增资质授权记录
 * @param data
 */
export const addQualificationAuthorizationRecord = (data: QualificationAuthorizationRecordForm) => {
  return request({
    url: '/system/qualificationAuthorizationRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质授权记录
 * @param data
 */
export const updateQualificationAuthorizationRecord = (data: QualificationAuthorizationRecordForm) => {
  return request({
    url: '/system/qualificationAuthorizationRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质授权记录
 * @param id
 */
export const delQualificationAuthorizationRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qualificationAuthorizationRecord/' + id,
    method: 'delete'
  });
};
