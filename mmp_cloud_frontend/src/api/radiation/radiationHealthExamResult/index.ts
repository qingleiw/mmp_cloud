import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  RadiationHealthExamResultVO,
  RadiationHealthExamResultForm,
  RadiationHealthExamResultQuery
} from '@/api/system/radiationHealthExamResult/types';

/**
 * 查询体检结果记录列表
 * @param query
 * @returns {*}
 */

export const listRadiationHealthExamResult = (query?: RadiationHealthExamResultQuery): AxiosPromise<RadiationHealthExamResultVO[]> => {
  return request({
    url: '/system/radiationHealthExamResult/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询体检结果记录详细
 * @param id
 */
export const getRadiationHealthExamResult = (id: string | number): AxiosPromise<RadiationHealthExamResultVO> => {
  return request({
    url: '/system/radiationHealthExamResult/' + id,
    method: 'get'
  });
};

/**
 * 新增体检结果记录
 * @param data
 */
export const addRadiationHealthExamResult = (data: RadiationHealthExamResultForm) => {
  return request({
    url: '/system/radiationHealthExamResult',
    method: 'post',
    data: data
  });
};

/**
 * 修改体检结果记录
 * @param data
 */
export const updateRadiationHealthExamResult = (data: RadiationHealthExamResultForm) => {
  return request({
    url: '/system/radiationHealthExamResult',
    method: 'put',
    data: data
  });
};

/**
 * 删除体检结果记录
 * @param id
 */
export const delRadiationHealthExamResult = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationHealthExamResult/' + id,
    method: 'delete'
  });
};
