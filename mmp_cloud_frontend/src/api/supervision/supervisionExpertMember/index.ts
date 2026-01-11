import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SupervisionExpertMemberVO, SupervisionExpertMemberForm, SupervisionExpertMemberQuery } from '@/api/supervision/supervisionExpertMember/types';

/**
 * 查询专家组成员列表
 * @param query
 * @returns {*}
 */

export const listSupervisionExpertMember = (query?: SupervisionExpertMemberQuery): AxiosPromise<SupervisionExpertMemberVO[]> => {
  return request({
    url: '/supervision/supervisionExpertMember/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询专家组成员详细
 * @param id
 */
export const getSupervisionExpertMember = (id: string | number): AxiosPromise<SupervisionExpertMemberVO> => {
  return request({
    url: '/supervision/supervisionExpertMember/' + id,
    method: 'get'
  });
};

/**
 * 新增专家组成员
 * @param data
 */
export const addSupervisionExpertMember = (data: SupervisionExpertMemberForm) => {
  return request({
    url: '/supervision/supervisionExpertMember',
    method: 'post',
    data: data
  });
};

/**
 * 修改专家组成员
 * @param data
 */
export const updateSupervisionExpertMember = (data: SupervisionExpertMemberForm) => {
  return request({
    url: '/supervision/supervisionExpertMember',
    method: 'put',
    data: data
  });
};

/**
 * 删除专家组成员
 * @param id
 */
export const delSupervisionExpertMember = (id: string | number | Array<string | number>) => {
  return request({
    url: '/supervision/supervisionExpertMember/' + id,
    method: 'delete'
  });
};
