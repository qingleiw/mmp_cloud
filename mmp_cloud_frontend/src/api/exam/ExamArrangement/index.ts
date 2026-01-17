import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  ExamArrangementVO,
  ExamArrangementForm,
  ExamArrangementQuery
} from '@/api/exam/ExamArrangement/types';

/**
 * 查询资质考试安排列表
 * @param query
 * @returns {*}
 */

export const listExamArrangement = (query?: ExamArrangementQuery): AxiosPromise<ExamArrangementVO[]> => {
  return request({
    url: '/exam/ExamArrangement/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考试安排详细
 * @param id
 */
export const getExamArrangement = (id: string | number): AxiosPromise<ExamArrangementVO> => {
  return request({
    url: '/exam/ExamArrangement/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考试安排
 * @param data
 */
export const addExamArrangement = (data: ExamArrangementForm) => {
  return request({
    url: '/exam/ExamArrangement',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考试安排
 * @param data
 */
export const updateExamArrangement = (data: ExamArrangementForm) => {
  return request({
    url: '/exam/ExamArrangement',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考试安排
 * @param id
 */
export const delExamArrangement = (id: string | number | Array<string | number>) => {
  return request({
    url: '/exam/ExamArrangement/' + id,
    method: 'delete'
  });
};
