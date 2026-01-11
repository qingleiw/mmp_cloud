import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SurgeryRecordVO, SurgeryRecordForm, SurgeryRecordQuery } from '@/api/system/surgeryRecord/types';

/**
 * 查询手术记录列表
 * @param query
 * @returns {*}
 */

export const listSurgeryRecord = (query?: SurgeryRecordQuery): AxiosPromise<SurgeryRecordVO[]> => {
  return request({
    url: '/system/surgeryRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询手术记录详细
 * @param id
 */
export const getSurgeryRecord = (id: string | number): AxiosPromise<SurgeryRecordVO> => {
  return request({
    url: '/system/surgeryRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增手术记录
 * @param data
 */
export const addSurgeryRecord = (data: SurgeryRecordForm) => {
  return request({
    url: '/system/surgeryRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改手术记录
 * @param data
 */
export const updateSurgeryRecord = (data: SurgeryRecordForm) => {
  return request({
    url: '/system/surgeryRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除手术记录
 * @param id
 */
export const delSurgeryRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/surgeryRecord/' + id,
    method: 'delete'
  });
};
