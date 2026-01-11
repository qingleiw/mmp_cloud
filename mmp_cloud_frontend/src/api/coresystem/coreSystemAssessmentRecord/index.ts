import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  CoreSystemAssessmentRecordVO,
  CoreSystemAssessmentRecordForm,
  CoreSystemAssessmentRecordQuery
} from '@/api/coresystem/coreSystemAssessmentRecord/types';

/**
 * 查询制度考核记录列表
 * @param query
 * @returns {*}
 */

export const listCoreSystemAssessmentRecord = (query?: CoreSystemAssessmentRecordQuery): AxiosPromise<CoreSystemAssessmentRecordVO[]> => {
  return request({
    url: '/coresystem/coreSystemAssessmentRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询制度考核记录详细
 * @param id
 */
export const getCoreSystemAssessmentRecord = (id: string | number): AxiosPromise<CoreSystemAssessmentRecordVO> => {
  return request({
    url: '/coresystem/coreSystemAssessmentRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增制度考核记录
 * @param data
 */
export const addCoreSystemAssessmentRecord = (data: CoreSystemAssessmentRecordForm) => {
  return request({
    url: '/coresystem/coreSystemAssessmentRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改制度考核记录
 * @param data
 */
export const updateCoreSystemAssessmentRecord = (data: CoreSystemAssessmentRecordForm) => {
  return request({
    url: '/coresystem/coreSystemAssessmentRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除制度考核记录
 * @param id
 */
export const delCoreSystemAssessmentRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/coresystem/coreSystemAssessmentRecord/' + id,
    method: 'delete'
  });
};
