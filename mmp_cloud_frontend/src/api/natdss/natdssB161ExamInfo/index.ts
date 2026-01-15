import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB161ExamInfoVO, NatdssB161ExamInfoForm, NatdssB161ExamInfoQuery } from '@/api/natdss/natdssB161ExamInfo/types';

/**
 * 查询B16-1 常规检查记录列表
 * @param query
 * @returns {*}
 */

export const listNatdssB161ExamInfo = (query?: NatdssB161ExamInfoQuery): AxiosPromise<NatdssB161ExamInfoVO[]> => {
  return request({
    url: '/natdss/natdssB161ExamInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B16-1 常规检查记录详细
 * @param id
 */
export const getNatdssB161ExamInfo = (id: string | number): AxiosPromise<NatdssB161ExamInfoVO> => {
  return request({
    url: '/natdss/natdssB161ExamInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B16-1 常规检查记录
 * @param data
 */
export const addNatdssB161ExamInfo = (data: NatdssB161ExamInfoForm) => {
  return request({
    url: '/natdss/natdssB161ExamInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B16-1 常规检查记录
 * @param data
 */
export const updateNatdssB161ExamInfo = (data: NatdssB161ExamInfoForm) => {
  return request({
    url: '/natdss/natdssB161ExamInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B16-1 常规检查记录
 * @param id
 */
export const delNatdssB161ExamInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB161ExamInfo/' + id,
    method: 'delete'
  });
};
