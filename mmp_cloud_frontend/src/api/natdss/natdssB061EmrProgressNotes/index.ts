import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB061EmrProgressNotesVO, NatdssB061EmrProgressNotesForm, NatdssB061EmrProgressNotesQuery } from '@/api/natdss/natdssB061EmrProgressNotes/types';

/**
 * 查询B06-1 病程记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB061EmrProgressNotes = (query?: NatdssB061EmrProgressNotesQuery): AxiosPromise<NatdssB061EmrProgressNotesVO[]> => {
  return request({
    url: '/natdss/natdssB061EmrProgressNotes/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B06-1 病程记录详细
 * @param id
 */
export const getNatdssB061EmrProgressNotes = (id: string | number): AxiosPromise<NatdssB061EmrProgressNotesVO> => {
  return request({
    url: '/natdss/natdssB061EmrProgressNotes/' + id,
    method: 'get'
  });
};

/**
 * 新增B06-1 病程记录
 * @param data
 */
export const addNatdssB061EmrProgressNotes = (data: NatdssB061EmrProgressNotesForm) => {
  return request({
    url: '/natdss/natdssB061EmrProgressNotes',
    method: 'post',
    data: data
  });
};

/**
 * 修改B06-1 病程记录
 * @param data
 */
export const updateNatdssB061EmrProgressNotes = (data: NatdssB061EmrProgressNotesForm) => {
  return request({
    url: '/natdss/natdssB061EmrProgressNotes',
    method: 'put',
    data: data
  });
};

/**
 * 删除B06-1 病程记录
 * @param id
 */
export const delNatdssB061EmrProgressNotes = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB061EmrProgressNotes/' + id,
    method: 'delete'
  });
};
