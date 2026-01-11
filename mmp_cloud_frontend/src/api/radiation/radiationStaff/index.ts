import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationStaffVO, RadiationStaffForm, RadiationStaffQuery } from '@/api/radiation/radiationStaff/types';

/**
 * 查询放射工作人员列表
 * @param query
 * @returns {*}
 */

export const listRadiationStaff = (query?: RadiationStaffQuery): AxiosPromise<RadiationStaffVO[]> => {
  return request({
    url: '/radiation/radiationStaff/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询放射工作人员详细
 * @param id
 */
export const getRadiationStaff = (id: string | number): AxiosPromise<RadiationStaffVO> => {
  return request({
    url: '/radiation/radiationStaff/' + id,
    method: 'get'
  });
};

/**
 * 新增放射工作人员
 * @param data
 */
export const addRadiationStaff = (data: RadiationStaffForm) => {
  return request({
    url: '/radiation/radiationStaff',
    method: 'post',
    data: data
  });
};

/**
 * 修改放射工作人员
 * @param data
 */
export const updateRadiationStaff = (data: RadiationStaffForm) => {
  return request({
    url: '/radiation/radiationStaff',
    method: 'put',
    data: data
  });
};

/**
 * 删除放射工作人员
 * @param id
 */
export const delRadiationStaff = (id: string | number | Array<string | number>) => {
  return request({
    url: '/radiation/radiationStaff/' + id,
    method: 'delete'
  });
};
