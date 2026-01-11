import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcIndicatorRecordVO, TumorQcIndicatorRecordForm, TumorQcIndicatorRecordQuery } from '@/api/system/tumorQcIndicatorRecord/types';

/**
 * 查询质控指标监测记录列表
 * @param query
 * @returns {*}
 */

export const listTumorQcIndicatorRecord = (query?: TumorQcIndicatorRecordQuery): AxiosPromise<TumorQcIndicatorRecordVO[]> => {
  return request({
    url: '/system/tumorQcIndicatorRecord/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询质控指标监测记录详细
 * @param id
 */
export const getTumorQcIndicatorRecord = (id: string | number): AxiosPromise<TumorQcIndicatorRecordVO> => {
  return request({
    url: '/system/tumorQcIndicatorRecord/' + id,
    method: 'get'
  });
};

/**
 * 新增质控指标监测记录
 * @param data
 */
export const addTumorQcIndicatorRecord = (data: TumorQcIndicatorRecordForm) => {
  return request({
    url: '/system/tumorQcIndicatorRecord',
    method: 'post',
    data: data
  });
};

/**
 * 修改质控指标监测记录
 * @param data
 */
export const updateTumorQcIndicatorRecord = (data: TumorQcIndicatorRecordForm) => {
  return request({
    url: '/system/tumorQcIndicatorRecord',
    method: 'put',
    data: data
  });
};

/**
 * 删除质控指标监测记录
 * @param id
 */
export const delTumorQcIndicatorRecord = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/tumorQcIndicatorRecord/' + id,
    method: 'delete'
  });
};
