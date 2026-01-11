import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QualificationExamRecordVO, QualificationExamRecordForm, QualificationExamRecordQuery } from '@/api/qualification/qualificationExamRecord/types';

/**
 * 查询资质考试记录列表
 * @param query
 * @returns {*}
 */

export const listQualificationExamRecord = (query?: QualificationExamRecordQuery): AxiosPromise<QualificationExamRecordVO[]> => {
  return request({
    url: '/qualification/qualificationExamRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考试记录详细
 * @param id
 */
export const getQualificationExamRecord = (id: string | number): AxiosPromise<QualificationExamRecordVO> => {
  return request({
    url: '/qualification/qualificationExamRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考试记录
 * @param data
 */
export const addQualificationExamRecord = (data: QualificationExamRecordForm) => {
  return request({
    url: '/qualification/qualificationExamRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考试记录
 * @param data
 */
export const updateQualificationExamRecord = (data: QualificationExamRecordForm) => {
  return request({
    url: '/qualification/qualificationExamRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考试记录
 * @param id
 */
export const delQualificationExamRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qualification/qualificationExamRecord/' + id,
    method: 'delete'
  });
};
