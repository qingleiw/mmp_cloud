import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { ExamPaperVO, ExamPaperForm, ExamPaperQuery } from '@/api/exam/ExamPaper/types';

/**
 * 查询资质考核试卷列表
 * @param query
 * @returns {*}
 */

export const listExamPaper = (query?: ExamPaperQuery): AxiosPromise<ExamPaperVO[]> => {
  return request({
    url: '/exam/ExamPaper/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考核试卷详细
 * @param id
 */
export const getExamPaper = (id: string | number): AxiosPromise<ExamPaperVO> => {
  return request({
    url: '/exam/ExamPaper/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考核试卷
 * @param data
 */
export const addExamPaper = (data: ExamPaperForm) => {
  return request({
    url: '/exam/ExamPaper',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考核试卷
 * @param data
 */
export const updateExamPaper = (data: ExamPaperForm) => {
  return request({
    url: '/exam/ExamPaper',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考核试卷
 * @param id
 */
export const delExamPaper = (id: string | number | Array<string | number>) => {
  return request({
    url: '/exam/ExamPaper/' + id,
    method: 'delete'
  });
};
