import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QualificationExamArrangementVO,
  QualificationExamArrangementForm,
  QualificationExamArrangementQuery
} from '@/api/system/qualificationExamArrangement/types';

/**
 * 查询资质考试安排列表
 * @param query
 * @returns {*}
 */

export const listQualificationExamArrangement = (query?: QualificationExamArrangementQuery): AxiosPromise<QualificationExamArrangementVO[]> => {
  return request({
    url: '/system/qualificationExamArrangement/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质考试安排详细
 * @param id
 */
export const getQualificationExamArrangement = (id: string | number): AxiosPromise<QualificationExamArrangementVO> => {
  return request({
    url: '/system/qualificationExamArrangement/' + id,
    method: 'get'
  });
};

/**
 * 新增资质考试安排
 * @param data
 */
export const addQualificationExamArrangement = (data: QualificationExamArrangementForm) => {
  return request({
    url: '/system/qualificationExamArrangement',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质考试安排
 * @param data
 */
export const updateQualificationExamArrangement = (data: QualificationExamArrangementForm) => {
  return request({
    url: '/system/qualificationExamArrangement',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质考试安排
 * @param id
 */
export const delQualificationExamArrangement = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qualificationExamArrangement/' + id,
    method: 'delete'
  });
};
