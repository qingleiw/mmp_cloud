import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  ExamQuestionVO,
  ExamQuestionForm,
  ExamQuestionQuery
} from '@/api/exam/ExamQuestion/types';

/**
 * 查询资质考核题库列表
 * @param query
 * @returns {*}
 */

export const listExamQuestion = (query?: ExamQuestionQuery): AxiosPromise<ExamQuestionVO[]> => {
  return request({
    url: '/exam/ExamQuestion/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考核题库详细
 * @param id
 */
export const getExamQuestion = (id: string | number): AxiosPromise<ExamQuestionVO> => {
  return request({
    url: '/exam/ExamQuestion/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考核题库
 * @param data
 */
export const addExamQuestion = (data: ExamQuestionForm) => {
  return request({
    url: '/exam/ExamQuestion',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考核题库
 * @param data
 */
export const updateExamQuestion = (data: ExamQuestionForm) => {
  return request({
    url: '/exam/ExamQuestion',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考核题库
 * @param id
 */
export const delExamQuestion = (id: string | number | Array<string | number>) => {
  return request({
    url: '/exam/ExamQuestion/' + id,
    method: 'delete'
  });
};
