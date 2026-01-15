import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationUsageRecordVO,
  QualificationUsageRecordForm,
  QualificationUsageRecordQuery
} from '@/api/qualification/qualificationUsageRecord/types';

/**
 * 查询资质使用记录列表
 * @param query
 * @returns {*}
 */

export const listQualificationUsageRecord = (query?: QualificationUsageRecordQuery): AxiosPromise<QualificationUsageRecordVO[]> => {
  return request({
    url: '/qualification/qualificationUsageRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质使用记录详细
 * @param id
 */
export const getQualificationUsageRecord = (id: string | number): AxiosPromise<QualificationUsageRecordVO> => {
  return request({
    url: '/qualification/qualificationUsageRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增资质使用记录
 * @param data
 */
export const addQualificationUsageRecord = (data: QualificationUsageRecordForm) => {
  return request({
    url: '/qualification/qualificationUsageRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质使用记录
 * @param data
 */
export const updateQualificationUsageRecord = (data: QualificationUsageRecordForm) => {
  return request({
    url: '/qualification/qualificationUsageRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质使用记录
 * @param id
 */
export const delQualificationUsageRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qualification/qualificationUsageRecord/' + id,
    method: 'delete'
  });
};
