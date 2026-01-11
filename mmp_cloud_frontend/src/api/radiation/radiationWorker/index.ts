import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { RadiationWorkerVO, RadiationWorkerForm, RadiationWorkerQuery } from '@/api/system/radiationWorker/types';

/**
 * 查询放射工作人员列表
 * @param query
 * @returns {*}
 */

export const listRadiationWorker = (query?: RadiationWorkerQuery): AxiosPromise<RadiationWorkerVO[]> => {
  return request({
    url: '/system/radiationWorker/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询放射工作人员详细
 * @param id
 */
export const getRadiationWorker = (id: string | number): AxiosPromise<RadiationWorkerVO> => {
  return request({
    url: '/system/radiationWorker/' + id,
    method: 'get'
  });
};

/**
 * 新增放射工作人员
 * @param data
 */
export const addRadiationWorker = (data: RadiationWorkerForm) => {
  return request({
    url: '/system/radiationWorker',
    method: 'post',
    data: data
  });
};

/**
 * 修改放射工作人员
 * @param data
 */
export const updateRadiationWorker = (data: RadiationWorkerForm) => {
  return request({
    url: '/system/radiationWorker',
    method: 'put',
    data: data
  });
};

/**
 * 删除放射工作人员
 * @param id
 */
export const delRadiationWorker = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/radiationWorker/' + id,
    method: 'delete'
  });
};
