import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { MajorSurgeryApplicationVO, MajorSurgeryApplicationForm, MajorSurgeryApplicationQuery } from '@/api/system/majorSurgeryApplication/types';

/**
 * 查询重大手术申请列表
 * @param query
 * @returns {*}
 */

export const listMajorSurgeryApplication = (query?: MajorSurgeryApplicationQuery): AxiosPromise<MajorSurgeryApplicationVO[]> => {
  return request({
    url: '/system/majorSurgeryApplication/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询重大手术申请详细
 * @param id
 */
export const getMajorSurgeryApplication = (id: string | number): AxiosPromise<MajorSurgeryApplicationVO> => {
  return request({
    url: '/system/majorSurgeryApplication/' + id,
    method: 'get'
  });
};

/**
 * 新增重大手术申请
 * @param data
 */
export const addMajorSurgeryApplication = (data: MajorSurgeryApplicationForm) => {
  return request({
    url: '/system/majorSurgeryApplication',
    method: 'post',
    data: data
  });
};

/**
 * 修改重大手术申请
 * @param data
 */
export const updateMajorSurgeryApplication = (data: MajorSurgeryApplicationForm) => {
  return request({
    url: '/system/majorSurgeryApplication',
    method: 'put',
    data: data
  });
};

/**
 * 删除重大手术申请
 * @param id
 */
export const delMajorSurgeryApplication = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/majorSurgeryApplication/' + id,
    method: 'delete'
  });
};
