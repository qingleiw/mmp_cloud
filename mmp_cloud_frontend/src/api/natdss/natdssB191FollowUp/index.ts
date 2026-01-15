import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB191FollowUpVO, NatdssB191FollowUpForm, NatdssB191FollowUpQuery } from '@/api/natdss/natdssB191FollowUp/types';

/**
 * 查询B19-1 随访记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB191FollowUp = (query?: NatdssB191FollowUpQuery): AxiosPromise<NatdssB191FollowUpVO[]> => {
  return request({
    url: '/natdss/natdssB191FollowUp/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B19-1 随访记录详细
 * @param id
 */
export const getNatdssB191FollowUp = (id: string | number): AxiosPromise<NatdssB191FollowUpVO> => {
  return request({
    url: '/natdss/natdssB191FollowUp/' + id,
    method: 'get'
  });
};

/**
 * 新增B19-1 随访记录
 * @param data
 */
export const addNatdssB191FollowUp = (data: NatdssB191FollowUpForm) => {
  return request({
    url: '/natdss/natdssB191FollowUp',
    method: 'post',
    data: data
  });
};

/**
 * 修改B19-1 随访记录
 * @param data
 */
export const updateNatdssB191FollowUp = (data: NatdssB191FollowUpForm) => {
  return request({
    url: '/natdss/natdssB191FollowUp',
    method: 'put',
    data: data
  });
};

/**
 * 删除B19-1 随访记录
 * @param id
 */
export const delNatdssB191FollowUp = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB191FollowUp/' + id,
    method: 'delete'
  });
};
