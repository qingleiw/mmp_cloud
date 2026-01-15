import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { NatdssB121OutpatientInfoVO, NatdssB121OutpatientInfoForm, NatdssB121OutpatientInfoQuery } from '@/api/natdss/natdssB121OutpatientInfo/types';

/**
 * 查询B12-1 门诊患者信息列表
 * @param query
 * @returns {*}
 */

export const listNatdssB121OutpatientInfo = (query?: NatdssB121OutpatientInfoQuery): AxiosPromise<NatdssB121OutpatientInfoVO[]> => {
  return request({
    url: '/natdss/natdssB121OutpatientInfo/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询B12-1 门诊患者信息详细
 * @param id
 */
export const getNatdssB121OutpatientInfo = (id: string | number): AxiosPromise<NatdssB121OutpatientInfoVO> => {
  return request({
    url: '/natdss/natdssB121OutpatientInfo/' + id,
    method: 'get'
  });
};

/**
 * 新增B12-1 门诊患者信息
 * @param data
 */
export const addNatdssB121OutpatientInfo = (data: NatdssB121OutpatientInfoForm) => {
  return request({
    url: '/natdss/natdssB121OutpatientInfo',
    method: 'post',
    data: data
  });
};

/**
 * 修改B12-1 门诊患者信息
 * @param data
 */
export const updateNatdssB121OutpatientInfo = (data: NatdssB121OutpatientInfoForm) => {
  return request({
    url: '/natdss/natdssB121OutpatientInfo',
    method: 'put',
    data: data
  });
};

/**
 * 删除B12-1 门诊患者信息
 * @param id
 */
export const delNatdssB121OutpatientInfo = (id: string | number | Array<string | number>) => {
  return request({
    url: '/natdss/natdssB121OutpatientInfo/' + id,
    method: 'delete'
  });
};
