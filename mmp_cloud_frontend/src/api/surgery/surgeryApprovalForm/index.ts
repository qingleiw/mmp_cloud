import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { SurgeryApprovalFormVO, SurgeryApprovalFormForm, SurgeryApprovalFormQuery } from '@/api/surgery/surgeryApprovalForm/types';

/**
 * 查询重大手术审批报告单列表
 * @param query
 * @returns {*}
 */

export const listSurgeryApprovalForm = (query?: SurgeryApprovalFormQuery): AxiosPromise<SurgeryApprovalFormVO[]> => {
  return request({
    url: '/surgery/surgeryApprovalForm/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询重大手术审批报告单详细
 * @param id
 */
export const getSurgeryApprovalForm = (id: string | number): AxiosPromise<SurgeryApprovalFormVO> => {
  return request({
    url: '/surgery/surgeryApprovalForm/' + id,
    method: 'get'
  });
};

/**
 * 新增重大手术审批报告单
 * @param data
 */
export const addSurgeryApprovalForm = (data: SurgeryApprovalFormForm) => {
  return request({
    url: '/surgery/surgeryApprovalForm',
    method: 'post',
    data: data
  });
};

/**
 * 修改重大手术审批报告单
 * @param data
 */
export const updateSurgeryApprovalForm = (data: SurgeryApprovalFormForm) => {
  return request({
    url: '/surgery/surgeryApprovalForm',
    method: 'put',
    data: data
  });
};

/**
 * 删除重大手术审批报告单
 * @param id
 */
export const delSurgeryApprovalForm = (id: string | number | Array<string | number>) => {
  return request({
    url: '/surgery/surgeryApprovalForm/' + id,
    method: 'delete'
  });
};

/**
 * 提交重大手术审批报告单
 * @param data
 */
export const submitApproval = (data: SurgeryApprovalFormForm) => {
  return request({
    url: '/surgery/surgeryApprovalForm/submit',
    method: 'post',
    data: data
  });
};
