import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  QcIndicatorCollectionConfigVO,
  QcIndicatorCollectionConfigForm,
  QcIndicatorCollectionConfigQuery
} from '@/api/qc/qcIndicatorCollectionConfig/types';

/**
 * 查询质控指标数据采集配置列表
 * @param query
 * @returns {*}
 */

export const listQcIndicatorCollectionConfig = (query?: QcIndicatorCollectionConfigQuery): AxiosPromise<QcIndicatorCollectionConfigVO[]> => {
  return request({
    url: '/qc/qcIndicatorCollectionConfig/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询质控指标数据采集配置详细
 * @param id
 */
export const getQcIndicatorCollectionConfig = (id: string | number): AxiosPromise<QcIndicatorCollectionConfigVO> => {
  return request({
    url: '/qc/qcIndicatorCollectionConfig/' + id,
    method: 'get'
  });
};

/**
 * 新增质控指标数据采集配置
 * @param data
 */
export const addQcIndicatorCollectionConfig = (data: QcIndicatorCollectionConfigForm) => {
  return request({
    url: '/qc/qcIndicatorCollectionConfig',
    method: 'post',
    data: data
  });
};

/**
 * 修改质控指标数据采集配置
 * @param data
 */
export const updateQcIndicatorCollectionConfig = (data: QcIndicatorCollectionConfigForm) => {
  return request({
    url: '/qc/qcIndicatorCollectionConfig',
    method: 'put',
    data: data
  });
};

/**
 * 删除质控指标数据采集配置
 * @param id
 */
export const delQcIndicatorCollectionConfig = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qc/qcIndicatorCollectionConfig/' + id,
    method: 'delete'
  });
};
