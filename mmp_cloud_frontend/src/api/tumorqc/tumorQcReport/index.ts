import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { TumorQcReportVO, TumorQcReportForm, TumorQcReportQuery } from '@/api/tumorqc/tumorQcReport/types';

/**
 * 查询肿瘤质控报告列表
 * @param query
 * @returns {*}
 */

export const listTumorQcReport = (query?: TumorQcReportQuery): AxiosPromise<TumorQcReportVO[]> => {
  return request({
    url: '/tumorqc/tumorQcReport/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询肿瘤质控报告详细
 * @param id
 */
export const getTumorQcReport = (id: string | number): AxiosPromise<TumorQcReportVO> => {
  return request({
    url: '/tumorqc/tumorQcReport/' + id,
    method: 'get'
  });
};

/**
 * 新增肿瘤质控报告
 * @param data
 */
export const addTumorQcReport = (data: TumorQcReportForm) => {
  return request({
    url: '/tumorqc/tumorQcReport',
    method: 'post',
    data: data
  });
};

/**
 * 修改肿瘤质控报告
 * @param data
 */
export const updateTumorQcReport = (data: TumorQcReportForm) => {
  return request({
    url: '/tumorqc/tumorQcReport',
    method: 'put',
    data: data
  });
};

/**
 * 删除肿瘤质控报告
 * @param id
 */
export const delTumorQcReport = (id: string | number | Array<string | number>) => {
  return request({
    url: '/tumorqc/tumorQcReport/' + id,
    method: 'delete'
  });
};
