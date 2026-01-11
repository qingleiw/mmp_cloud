import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcRectificationVO, TumorQcRectificationForm, TumorQcRectificationQuery } from '@/api/tumorqc/tumorQcRectification/types';

/**
 * 查询肿瘤质控整改列表
 * @param query
 * @returns {*}
 */

export const listTumorQcRectification = (query?: TumorQcRectificationQuery): AxiosPromise<TumorQcRectificationVO[]> => {
  return request({
    url: '/tumorqc/tumorQcRectification/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询肿瘤质控整改详细
 * @param id
 */
export const getTumorQcRectification = (id: string | number): AxiosPromise<TumorQcRectificationVO> => {
  return request({
    url: '/tumorqc/tumorQcRectification/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控整改
 * @param data
 */
export const addTumorQcRectification = (data: TumorQcRectificationForm) => {
  return request({
    url: '/tumorqc/tumorQcRectification',
    method: 'post',
    data: data
  });
};

/**
 * 修改肿瘤质控整改
 * @param data
 */
export const updateTumorQcRectification = (data: TumorQcRectificationForm) => {
  return request({
    url: '/tumorqc/tumorQcRectification',
    method: 'put',
    data: data
  });
};

/**
 * 删除肿瘤质控整改
 * @param id
 */
export const delTumorQcRectification = (id: string | number | Array<string | number>) => {
  return request({
    url: '/tumorqc/tumorQcRectification/' + id,
    method: 'delete'
  });
};
