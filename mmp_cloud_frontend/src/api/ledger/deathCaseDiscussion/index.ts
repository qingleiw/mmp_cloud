import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DeathCaseDiscussionVO, DeathCaseDiscussionForm, DeathCaseDiscussionQuery } from '@/api/ledger/deathCaseDiscussion/types';

/**
 * 查询死亡病例讨论列表
 * @param query
 * @returns {*}
 */

export const listDeathCaseDiscussion = (query?: DeathCaseDiscussionQuery): AxiosPromise<DeathCaseDiscussionVO[]> => {
  return request({
    url: '/ledger/deathCaseDiscussion/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询死亡病例讨论详细
 * @param id
 */
export const getDeathCaseDiscussion = (id: string | number): AxiosPromise<DeathCaseDiscussionVO> => {
  return request({
    url: '/ledger/deathCaseDiscussion/' + id,
    method: 'get'
  });
};

/**
 * 新增死亡病例讨论
 * @param data
 */
export const addDeathCaseDiscussion = (data: DeathCaseDiscussionForm) => {
  return request({
    url: '/ledger/deathCaseDiscussion',
    method: 'post',
    data: data
  });
};

/**
 * 修改死亡病例讨论
 * @param data
 */
export const updateDeathCaseDiscussion = (data: DeathCaseDiscussionForm) => {
  return request({
    url: '/ledger/deathCaseDiscussion',
    method: 'put',
    data: data
  });
};

/**
 * 删除死亡病例讨论
 * @param id
 */
export const delDeathCaseDiscussion = (id: string | number | Array<string | number>) => {
  return request({
    url: '/ledger/deathCaseDiscussion/' + id,
    method: 'delete'
  });
};
