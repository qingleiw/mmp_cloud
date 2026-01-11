import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QualificationExamPaperVO, QualificationExamPaperForm, QualificationExamPaperQuery } from '@/api/system/qualificationExamPaper/types';

/**
 * 查询资质考核试卷列表
 * @param query
 * @returns {*}
 */

export const listQualificationExamPaper = (query?: QualificationExamPaperQuery): AxiosPromise<QualificationExamPaperVO[]> => {
  return request({
    url: '/system/qualificationExamPaper/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考核试卷详细
 * @param id
 */
export const getQualificationExamPaper = (id: string | number): AxiosPromise<QualificationExamPaperVO> => {
  return request({
    url: '/system/qualificationExamPaper/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考核试卷
 * @param data
 */
export const addQualificationExamPaper = (data: QualificationExamPaperForm) => {
  return request({
    url: '/system/qualificationExamPaper',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考核试卷
 * @param data
 */
export const updateQualificationExamPaper = (data: QualificationExamPaperForm) => {
  return request({
    url: '/system/qualificationExamPaper',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考核试卷
 * @param id
 */
export const delQualificationExamPaper = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qualificationExamPaper/' + id,
    method: 'delete'
  });
};
