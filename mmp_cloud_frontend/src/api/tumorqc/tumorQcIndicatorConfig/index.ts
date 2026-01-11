import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcIndicatorConfigVO, TumorQcIndicatorConfigForm, TumorQcIndicatorConfigQuery } from '@/api/system/tumorQcIndicatorConfig/types';

/**
 * 查询肿瘤质控指标配置列表
 * @param query
 * @returns {*}
 */

export const listTumorQcIndicatorConfig = (query?: TumorQcIndicatorConfigQuery): AxiosPromise<TumorQcIndicatorConfigVO[]> => {
  return request({
    url: '/system/tumorQcIndicatorConfig/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询肿瘤质控指标配置详细
 * @param id
 */
export const getTumorQcIndicatorConfig = (id: string | number): AxiosPromise<TumorQcIndicatorConfigVO> => {
  return request({
    url: '/system/tumorQcIndicatorConfig/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控指标配置
 * @param data
 */
export const addTumorQcIndicatorConfig = (data: TumorQcIndicatorConfigForm) => {
  return request({
    url: '/system/tumorQcIndicatorConfig',
    method: 'post',
    data: data
  });
};

/**
 * 修改肿瘤质控指标配置
 * @param data
 */
export const updateTumorQcIndicatorConfig = (data: TumorQcIndicatorConfigForm) => {
  return request({
    url: '/system/tumorQcIndicatorConfig',
    method: 'put',
    data: data
  });
};

/**
 * 删除肿瘤质控指标配置
 * @param id
 */
export const delTumorQcIndicatorConfig = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/tumorQcIndicatorConfig/' + id,
    method: 'delete'
  });
};
