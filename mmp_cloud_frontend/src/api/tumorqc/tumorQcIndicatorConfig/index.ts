import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcIndicatorConfigVO, TumorQcIndicatorConfigForm, TumorQcIndicatorConfigQuery } from '@/api/tumorqc/tumorQcIndicatorConfig/types';

/**
 * 查询肿瘤质控指标配置列表
 * @param query
 * @returns {*}
 */

export const listTumorQcIndicatorConfig = (query?: TumorQcIndicatorConfigQuery): AxiosPromise<TumorQcIndicatorConfigVO[]> => {
  return request({
    url: '/tumorqc/tumorQcIndicatorConfig/list',
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
    url: '/tumorqc/tumorQcIndicatorConfig/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控指标配置
 * @param data
 */
export const addTumorQcIndicatorConfig = (data: TumorQcIndicatorConfigForm) => {
  return request({
    url: '/tumorqc/tumorQcIndicatorConfig',
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
    url: '/tumorqc/tumorQcIndicatorConfig',
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
    url: '/tumorqc/tumorQcIndicatorConfig/' + id,
    method: 'delete'
  });
};
