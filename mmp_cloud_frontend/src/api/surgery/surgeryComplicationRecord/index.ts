import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  SurgeryComplicationRecordVO,
  SurgeryComplicationRecordForm,
  SurgeryComplicationRecordQuery
} from '@/api/surgery/surgeryComplicationRecord/types';

/**
 * 查询手术并发症记录列表
 * @param query
 * @returns {*}
 */

export const listSurgeryComplicationRecord = (query?: SurgeryComplicationRecordQuery): AxiosPromise<SurgeryComplicationRecordVO[]> => {
  return request({
    url: '/surgery/surgeryComplicationRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询手术并发症记录详细
 * @param id
 */
export const getSurgeryComplicationRecord = (id: string | number): AxiosPromise<SurgeryComplicationRecordVO> => {
  return request({
    url: '/surgery/surgeryComplicationRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增手术并发症记录
 * @param data
 */
export const addSurgeryComplicationRecord = (data: SurgeryComplicationRecordForm) => {
  return request({
    url: '/surgery/surgeryComplicationRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改手术并发症记录
 * @param data
 */
export const updateSurgeryComplicationRecord = (data: SurgeryComplicationRecordForm) => {
  return request({
    url: '/surgery/surgeryComplicationRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除手术并发症记录
 * @param id
 */
export const delSurgeryComplicationRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/surgery/surgeryComplicationRecord/' + id,
    method: 'delete'
  });
};
