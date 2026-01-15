import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  ComplaintInvestigationVO,
  ComplaintInvestigationForm,
  ComplaintInvestigationQuery
} from '@/api/complaindispute/complaintInvestigation/types';

/**
 * 查询投诉调查记录列表
 * @param query
 * @returns {*}
 */

export const listComplaintInvestigation = (query?: ComplaintInvestigationQuery): AxiosPromise<ComplaintInvestigationVO[]> => {
  return request({
    url: '/complaindispute/complaintInvestigation/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询投诉调查记录详细
 * @param id
 */
export const getComplaintInvestigation = (id: string | number): AxiosPromise<ComplaintInvestigationVO> => {
  return request({
    url: '/complaindispute/complaintInvestigation/' + id,
    method: 'get'
  });
};

/**
 * 新增投诉调查记录
 * @param data
 */
export const addComplaintInvestigation = (data: ComplaintInvestigationForm) => {
  return request({
    url: '/complaindispute/complaintInvestigation',
    method: 'post',
    data: data
  });
};

/**
 * 修改投诉调查记录
 * @param data
 */
export const updateComplaintInvestigation = (data: ComplaintInvestigationForm) => {
  return request({
    url: '/complaindispute/complaintInvestigation',
    method: 'put',
    data: data
  });
};

/**
 * 删除投诉调查记录
 * @param id
 */
export const delComplaintInvestigation = (id: string | number | Array<string | number>) => {
  return request({
    url: '/complaindispute/complaintInvestigation/' + id,
    method: 'delete'
  });
};
