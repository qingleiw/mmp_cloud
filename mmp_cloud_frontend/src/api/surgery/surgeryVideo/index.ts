import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SurgeryVideoVO, SurgeryVideoForm, SurgeryVideoQuery } from '@/api/surgery/surgeryVideo/types';

/**
 * 查询手术视频列表
 * @param query
 * @returns {*}
 */

export const listSurgeryVideo = (query?: SurgeryVideoQuery): AxiosPromise<SurgeryVideoVO[]> => {
  return request({
    url: '/surgery/surgeryVideo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询手术视频详细
 * @param id
 */
export const getSurgeryVideo = (id: string | number): AxiosPromise<SurgeryVideoVO> => {
  return request({
    url: '/surgery/surgeryVideo/' + id,
    method: 'get'
  });
};

/**
 * 新增手术视频
 * @param data
 */
export const addSurgeryVideo = (data: SurgeryVideoForm) => {
  return request({
    url: '/surgery/surgeryVideo',
    method: 'post',
    data: data
  });
};

/**
 * 修改手术视频
 * @param data
 */
export const updateSurgeryVideo = (data: SurgeryVideoForm) => {
  return request({
    url: '/surgery/surgeryVideo',
    method: 'put',
    data: data
  });
};

/**
 * 删除手术视频
 * @param id
 */
export const delSurgeryVideo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/surgery/surgeryVideo/' + id,
    method: 'delete'
  });
};
