import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationExamQuestionVO,
  QualificationExamQuestionForm,
  QualificationExamQuestionQuery
} from '@/api/qualification/qualificationExamQuestion/types';

/**
 * 查询资质考核题库列表
 * @param query
 * @returns {*}
 */

export const listQualificationExamQuestion = (query?: QualificationExamQuestionQuery): AxiosPromise<QualificationExamQuestionVO[]> => {
  return request({
    url: '/qualification/qualificationExamQuestion/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考核题库详细
 * @param id
 */
export const getQualificationExamQuestion = (id: string | number): AxiosPromise<QualificationExamQuestionVO> => {
  return request({
    url: '/qualification/qualificationExamQuestion/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考核题库
 * @param data
 */
export const addQualificationExamQuestion = (data: QualificationExamQuestionForm) => {
  return request({
    url: '/qualification/qualificationExamQuestion',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考核题库
 * @param data
 */
export const updateQualificationExamQuestion = (data: QualificationExamQuestionForm) => {
  return request({
    url: '/qualification/qualificationExamQuestion',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考核题库
 * @param id
 */
export const delQualificationExamQuestion = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qualification/qualificationExamQuestion/' + id,
    method: 'delete'
  });
};
