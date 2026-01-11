import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { ComplaintDisputeVO, ComplaintDisputeForm, ComplaintDisputeQuery } from '@/api/complaindispute/complaintDispute/types';

/**
 * 查询投诉纠纷主列表
 * @param query
 * @returns {*}
 */

export const listComplaintDispute = (query?: ComplaintDisputeQuery): AxiosPromise<ComplaintDisputeVO[]> => {
  return request({
    url: '/complaindispute/complaintDispute/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询投诉纠纷主详细
 * @param id
 */
export const getComplaintDispute = (id: string | number): AxiosPromise<ComplaintDisputeVO> => {
  return request({
    url: '/complaindispute/complaintDispute/' + id,
    method: 'get'
  });
};

/**
 * 新增投诉纠纷主
 * @param data
 */
export const addComplaintDispute = (data: ComplaintDisputeForm) => {
  return request({
    url: '/complaindispute/complaintDispute',
    method: 'post',
    data: data
  });
};

/**
 * 修改投诉纠纷主
 * @param data
 */
export const updateComplaintDispute = (data: ComplaintDisputeForm) => {
  return request({
    url: '/complaindispute/complaintDispute',
    method: 'put',
    data: data
  });
};

/**
 * 删除投诉纠纷主
 * @param id
 */
export const delComplaintDispute = (id: string | number | Array<string | number>) => {
  return request({
    url: '/complaindispute/complaintDispute/' + id,
    method: 'delete'
  });
};
