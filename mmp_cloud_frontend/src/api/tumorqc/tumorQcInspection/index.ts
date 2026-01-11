import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcInspectionVO, TumorQcInspectionForm, TumorQcInspectionQuery } from '@/api/system/tumorQcInspection/types';

/**
 * 查询肿瘤质控检查列表
 * @param query
 * @returns {*}
 */

export const listTumorQcInspection = (query?: TumorQcInspectionQuery): AxiosPromise<TumorQcInspectionVO[]> => {
  return request({
    url: '/system/tumorQcInspection/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询肿瘤质控检查详细
 * @param id
 */
export const getTumorQcInspection = (id: string | number): AxiosPromise<TumorQcInspectionVO> => {
  return request({
    url: '/system/tumorQcInspection/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控检查
 * @param data
 */
export const addTumorQcInspection = (data: TumorQcInspectionForm) => {
  return request({
    url: '/system/tumorQcInspection',
    method: 'post',
    data: data
  });
};

/**
 * 修改肿瘤质控检查
 * @param data
 */
export const updateTumorQcInspection = (data: TumorQcInspectionForm) => {
  return request({
    url: '/system/tumorQcInspection',
    method: 'put',
    data: data
  });
};

/**
 * 删除肿瘤质控检查
 * @param id
 */
export const delTumorQcInspection = (id: string | number | Array<string | number>) => {
  return request({
    url: '/system/tumorQcInspection/' + id,
    method: 'delete'
  });
};
