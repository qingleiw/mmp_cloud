import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CoreSystemConfigVO, CoreSystemConfigForm, CoreSystemConfigQuery } from '@/api/system/coreSystemConfig/types';

/**
 * 查询核心制度配置列表
 * @param query
 * @returns {*}
 */

export const listCoreSystemConfig = (query?: CoreSystemConfigQuery): AxiosPromise<CoreSystemConfigVO[]> => {
  return request({
    url: '/system/coreSystemConfig/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询核心制度配置详细
 * @param id
 */
export const getCoreSystemConfig = (id: string | number): AxiosPromise<CoreSystemConfigVO> => {
  return request({
    url: '/system/coreSystemConfig/' + id,
    method: 'get'
  });
};

/**
 * 新增核心制度配置
 * @param data
 */
export const addCoreSystemConfig = (data: CoreSystemConfigForm) => {
  return request({
    url: '/system/coreSystemConfig',
    method: 'post',
    data: data
  });
};

/**
 * 修改核心制度配置
 * @param data
 */
export const updateCoreSystemConfig = (data: CoreSystemConfigForm) => {
  return request({
    url: '/system/coreSystemConfig',
    method: 'put',
    data: data
  });
};

/**
 * 删除核心制度配置
 * @param id
 */
export const delCoreSystemConfig = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/coreSystemConfig/' + id,
    method: 'delete'
  });
};
