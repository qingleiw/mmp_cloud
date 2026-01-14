import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { MedicalStatsVO, MedicalStatsQuery } from '@/api/ledger/medicalStats/types';

/**
 * 查询医疗统计数据列表
 * @param query
 * @returns {*}
 */

export const listMedicalStats = (query?: MedicalStatsQuery): AxiosPromise<MedicalStatsVO[]> => {
  return request({
    url: '/ledger/medicalStats/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询医疗统计数据详细
 * @param id
 * @returns {*}
 */
export const getMedicalStats = (id: string | number): AxiosPromise<MedicalStatsVO> => {
  return request({
    url: '/ledger/medicalStats/' + id,
    method: 'get'
  });
};

/**
 * 新增医疗统计数据
 * @param data
 * @returns {*}
 */
export const addMedicalStats = (data: any): AxiosPromise<any> => {
  return request({
    url: '/ledger/medicalStats',
    method: 'post',
    data: data
  });
};

/**
 * 修改医疗统计数据
 * @param data
 * @returns {*}
 */
export const updateMedicalStats = (data: any): AxiosPromise<any> => {
  return request({
    url: '/ledger/medicalStats',
    method: 'put',
    data: data
  });
};

/**
 * 删除医疗统计数据
 * @param id
 * @returns {*}
 */
export const delMedicalStats = (id: string | number): AxiosPromise<any> => {
  return request({
    url: '/ledger/medicalStats/' + id,
    method: 'delete'
  });
};
