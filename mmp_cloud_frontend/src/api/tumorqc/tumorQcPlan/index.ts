import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcPlanVO, TumorQcPlanForm, TumorQcPlanQuery } from '@/api/tumorqc/tumorQcPlan/types';

/**
 * 查询肿瘤质控方案列表
 * @param query
 * @returns {*}
 */

export const listTumorQcPlan = (query?: TumorQcPlanQuery): AxiosPromise<TumorQcPlanVO[]> => {
  return request({
    url: '/tumorqc/tumorQcPlan/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询肿瘤质控方案详细
 * @param id
 */
export const getTumorQcPlan = (id: string | number): AxiosPromise<TumorQcPlanVO> => {
  return request({
    url: '/tumorqc/tumorQcPlan/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控方案
 * @param data
 */
export const addTumorQcPlan = (data: TumorQcPlanForm) => {
  return request({
    url: '/tumorqc/tumorQcPlan',
    method: 'post',
    data: data
  });
};

/**
 * 修改肿瘤质控方案
 * @param data
 */
export const updateTumorQcPlan = (data: TumorQcPlanForm) => {
  return request({
    url: '/tumorqc/tumorQcPlan',
    method: 'put',
    data: data
  });
};

/**
 * 删除肿瘤质控方案
 * @param id
 */
export const delTumorQcPlan = (id: string | number | Array<string | number>) => {
  return request({
    url: '/tumorqc/tumorQcPlan/' + id,
    method: 'delete'
  });
};
