import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { ImportantMedicalEventVO, ImportantMedicalEventForm, ImportantMedicalEventQuery } from '@/api/system/importantMedicalEvent/types';

/**
 * 查询重要医疗事件列表
 * @param query
 * @returns {*}
 */

export const listImportantMedicalEvent = (query?: ImportantMedicalEventQuery): AxiosPromise<ImportantMedicalEventVO[]> => {
  return request({
    url: '/system/importantMedicalEvent/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询重要医疗事件详细
 * @param id
 */
export const getImportantMedicalEvent = (id: string | number): AxiosPromise<ImportantMedicalEventVO> => {
  return request({
    url: '/system/importantMedicalEvent/' + id,
    method: 'get'
  });
};

/**
 * 新增重要医疗事件
 * @param data
 */
export const addImportantMedicalEvent = (data: ImportantMedicalEventForm) => {
  return request({
    url: '/system/importantMedicalEvent',
    method: 'post',
    data: data
  });
};

/**
 * 修改重要医疗事件
 * @param data
 */
export const updateImportantMedicalEvent = (data: ImportantMedicalEventForm) => {
  return request({
    url: '/system/importantMedicalEvent',
    method: 'put',
    data: data
  });
};

/**
 * 删除重要医疗事件
 * @param id
 */
export const delImportantMedicalEvent = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/importantMedicalEvent/' + id,
    method: 'delete'
  });
};
