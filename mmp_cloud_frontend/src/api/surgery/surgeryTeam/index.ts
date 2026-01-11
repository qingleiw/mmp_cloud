import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SurgeryTeamVO, SurgeryTeamForm, SurgeryTeamQuery } from '@/api/surgery/surgeryTeam/types';

/**
 * 查询手术团队列表
 * @param query
 * @returns {*}
 */

export const listSurgeryTeam = (query?: SurgeryTeamQuery): AxiosPromise<SurgeryTeamVO[]> => {
  return request({
    url: '/surgery/surgeryTeam/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询手术团队详细
 * @param id
 */
export const getSurgeryTeam = (id: string | number): AxiosPromise<SurgeryTeamVO> => {
  return request({
    url: '/surgery/surgeryTeam/' + id,
    method: 'get'
  });
};

/**
 * 新增手术团队
 * @param data
 */
export const addSurgeryTeam = (data: SurgeryTeamForm) => {
  return request({
    url: '/surgery/surgeryTeam',
    method: 'post',
    data: data
  });
};

/**
 * 修改手术团队
 * @param data
 */
export const updateSurgeryTeam = (data: SurgeryTeamForm) => {
  return request({
    url: '/surgery/surgeryTeam',
    method: 'put',
    data: data
  });
};

/**
 * 删除手术团队
 * @param id
 */
export const delSurgeryTeam = (id: string | number | Array<string | number>) => {
  return request({
    url: '/surgery/surgeryTeam/' + id,
    method: 'delete'
  });
};
