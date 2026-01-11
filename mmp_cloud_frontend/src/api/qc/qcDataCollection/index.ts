import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcDataCollectionVO, QcDataCollectionForm, QcDataCollectionQuery } from '@/api/system/qcDataCollection/types';

/**
 * 查询数据采集记录列表
 * @param query
 * @returns {*}
 */

export const listQcDataCollection = (query?: QcDataCollectionQuery): AxiosPromise<QcDataCollectionVO[]> => {
  return request({
    url: '/system/qcDataCollection/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询数据采集记录详细
 * @param id
 */
export const getQcDataCollection = (id: string | number): AxiosPromise<QcDataCollectionVO> => {
  return request({
    url: '/system/qcDataCollection/' + id,
    method: 'get'
  });
};

/**
 * 新增数据采集记录
 * @param data
 */
export const addQcDataCollection = (data: QcDataCollectionForm) => {
  return request({
    url: '/system/qcDataCollection',
    method: 'post',
    data: data
  });
};

/**
 * 修改数据采集记录
 * @param data
 */
export const updateQcDataCollection = (data: QcDataCollectionForm) => {
  return request({
    url: '/system/qcDataCollection',
    method: 'put',
    data: data
  });
};

/**
 * 删除数据采集记录
 * @param id
 */
export const delQcDataCollection = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/qcDataCollection/' + id,
    method: 'delete'
  });
};
