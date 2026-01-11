import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CoreSystemIndicatorVO, CoreSystemIndicatorForm, CoreSystemIndicatorQuery } from '@/api/system/coreSystemIndicator/types';

/**
 * 查询核心制度指标列表
 * @param query
 * @returns {*}
 */

export const listCoreSystemIndicator = (query?: CoreSystemIndicatorQuery): AxiosPromise<CoreSystemIndicatorVO[]> => {
  return request({
    url: '/system/coreSystemIndicator/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询核心制度指标详细
 * @param id
 */
export const getCoreSystemIndicator = (id: string | number): AxiosPromise<CoreSystemIndicatorVO> => {
  return request({
    url: '/system/coreSystemIndicator/' + id,
    method: 'get'
  });
};

/**
 * 新增核心制度指标
 * @param data
 */
export const addCoreSystemIndicator = (data: CoreSystemIndicatorForm) => {
  return request({
    url: '/system/coreSystemIndicator',
    method: 'post',
    data: data
  });
};

/**
 * 修改核心制度指标
 * @param data
 */
export const updateCoreSystemIndicator = (data: CoreSystemIndicatorForm) => {
  return request({
    url: '/system/coreSystemIndicator',
    method: 'put',
    data: data
  });
};

/**
 * 删除核心制度指标
 * @param id
 */
export const delCoreSystemIndicator = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/coreSystemIndicator/' + id,
    method: 'delete'
  });
};
