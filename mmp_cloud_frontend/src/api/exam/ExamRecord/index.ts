import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  ExamRecordVO,
  ExamRecordForm,
  ExamRecordQuery
} from '@/api/exam/ExamRecord/types';

/**
 * 查询资质考试记录列表
 * @param query
 * @returns {*}
 */

export const listExamRecord = (query?: ExamRecordQuery): AxiosPromise<ExamRecordVO[]> => {
  return request({
    url: '/exam/ExamRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考试记录详细
 * @param id
 */
export const getExamRecord = (id: string | number): AxiosPromise<ExamRecordVO> => {
  return request({
    url: '/exam/ExamRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考试记录
 * @param data
 */
export const addExamRecord = (data: ExamRecordForm) => {
  return request({
    url: '/exam/ExamRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考试记录
 * @param data
 */
export const updateExamRecord = (data: ExamRecordForm) => {
  return request({
    url: '/exam/ExamRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考试记录
 * @param id
 */
export const delExamRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/exam/ExamRecord/' + id,
    method: 'delete'
  });
};
