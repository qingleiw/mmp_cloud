import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcIndicatorDetailVO, TumorQcIndicatorDetailForm, TumorQcIndicatorDetailQuery } from '@/api/system/tumorQcIndicatorDetail/types';

/**
 * 查询质控指标明细数据列表
 * @param query
 * @returns {*}
 */

export const listTumorQcIndicatorDetail = (query?: TumorQcIndicatorDetailQuery): AxiosPromise<TumorQcIndicatorDetailVO[]> => {
  return request({
    url: '/system/tumorQcIndicatorDetail/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询质控指标明细数据详细
 * @param id
 */
export const getTumorQcIndicatorDetail = (id: string | number): AxiosPromise<TumorQcIndicatorDetailVO> => {
  return request({
    url: '/system/tumorQcIndicatorDetail/' + id,
    method: 'get'
  });
};

/**
 * 新增质控指标明细数据
 * @param data
 */
export const addTumorQcIndicatorDetail = (data: TumorQcIndicatorDetailForm) => {
  return request({
    url: '/system/tumorQcIndicatorDetail',
    method: 'post',
    data: data
  });
};

/**
 * 修改质控指标明细数据
 * @param data
 */
export const updateTumorQcIndicatorDetail = (data: TumorQcIndicatorDetailForm) => {
  return request({
    url: '/system/tumorQcIndicatorDetail',
    method: 'put',
    data: data
  });
};

/**
 * 删除质控指标明细数据
 * @param id
 */
export const delTumorQcIndicatorDetail = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/tumorQcIndicatorDetail/' + id,
    method: 'delete'
  });
};
