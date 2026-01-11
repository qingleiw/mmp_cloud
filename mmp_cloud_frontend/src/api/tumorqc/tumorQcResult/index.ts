import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcResultVO, TumorQcResultForm, TumorQcResultQuery } from '@/api/tumorqc/tumorQcResult/types';

/**
 * 查询肿瘤质控结果列表
 * @param query
 * @returns {*}
 */

export const listTumorQcResult = (query?: TumorQcResultQuery): AxiosPromise<TumorQcResultVO[]> => {
  return request({
    url: '/tumorqc/tumorQcResult/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询肿瘤质控结果详细
 * @param id
 */
export const getTumorQcResult = (id: string | number): AxiosPromise<TumorQcResultVO> => {
  return request({
    url: '/tumorqc/tumorQcResult/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控结果
 * @param data
 */
export const addTumorQcResult = (data: TumorQcResultForm) => {
  return request({
    url: '/tumorqc/tumorQcResult',
    method: 'post',
    data: data
  });
};

/**
 * 修改肿瘤质控结果
 * @param data
 */
export const updateTumorQcResult = (data: TumorQcResultForm) => {
  return request({
    url: '/tumorqc/tumorQcResult',
    method: 'put',
    data: data
  });
};

/**
 * 删除肿瘤质控结果
 * @param id
 */
export const delTumorQcResult = (id: string | number | Array<string | number>) => {
  return request({
    url: '/tumorqc/tumorQcResult/' + id,
    method: 'delete'
  });
};
