import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionIssueVO, SupervisionIssueForm, SupervisionIssueQuery } from '@/api/system/supervisionIssue/types';

/**
 * 查询督导问题列表
 * @param query
 * @returns {*}
 */

export const listSupervisionIssue = (query?: SupervisionIssueQuery): AxiosPromise<SupervisionIssueVO[]> => {
  return request({
    url: '/system/supervisionIssue/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询督导问题详细
 * @param id
 */
export const getSupervisionIssue = (id: string | number): AxiosPromise<SupervisionIssueVO> => {
  return request({
    url: '/system/supervisionIssue/' + id,
    method: 'get'
  });
};

/**
 * 新增督导问题
 * @param data
 */
export const addSupervisionIssue = (data: SupervisionIssueForm) => {
  return request({
    url: '/system/supervisionIssue',
    method: 'post',
    data: data
  });
};

/**
 * 修改督导问题
 * @param data
 */
export const updateSupervisionIssue = (data: SupervisionIssueForm) => {
  return request({
    url: '/system/supervisionIssue',
    method: 'put',
    data: data
  });
};

/**
 * 删除督导问题
 * @param id
 */
export const delSupervisionIssue = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/supervisionIssue/' + id,
    method: 'delete'
  });
};
