import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { ComplaintHandlingVO, ComplaintHandlingForm, ComplaintHandlingQuery } from '@/api/system/complaintHandling/types';

/**
 * 查询投诉处理记录列表
 * @param query
 * @returns {*}
 */

export const listComplaintHandling = (query?: ComplaintHandlingQuery): AxiosPromise<ComplaintHandlingVO[]> => {
  return request({
    url: '/system/complaintHandling/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询投诉处理记录详细
 * @param id
 */
export const getComplaintHandling = (id: string | number): AxiosPromise<ComplaintHandlingVO> => {
  return request({
    url: '/system/complaintHandling/' + id,
    method: 'get'
  });
};

/**
 * 新增投诉处理记录
 * @param data
 */
export const addComplaintHandling = (data: ComplaintHandlingForm) => {
  return request({
    url: '/system/complaintHandling',
    method: 'post',
    data: data
  });
};

/**
 * 修改投诉处理记录
 * @param data
 */
export const updateComplaintHandling = (data: ComplaintHandlingForm) => {
  return request({
    url: '/system/complaintHandling',
    method: 'put',
    data: data
  });
};

/**
 * 删除投诉处理记录
 * @param id
 */
export const delComplaintHandling = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/complaintHandling/' + id,
    method: 'delete'
  });
};
