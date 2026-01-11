import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QcManualDataVO, QcManualDataForm, QcManualDataQuery } from '@/api/qc/qcManualData/types';

/**
 * 查询人工补录数据列表
 * @param query
 * @returns {*}
 */

export const listQcManualData = (query?: QcManualDataQuery): AxiosPromise<QcManualDataVO[]> => {
  return request({
    url: '/qc/qcManualData/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询人工补录数据详细
 * @param id
 */
export const getQcManualData = (id: string | number): AxiosPromise<QcManualDataVO> => {
  return request({
    url: '/qc/qcManualData/' + id,
    method: 'get'
  });
};

/**
 * 新增人工补录数据
 * @param data
 */
export const addQcManualData = (data: QcManualDataForm) => {
  return request({
    url: '/qc/qcManualData',
    method: 'post',
    data: data
  });
};

/**
 * 修改人工补录数据
 * @param data
 */
export const updateQcManualData = (data: QcManualDataForm) => {
  return request({
    url: '/qc/qcManualData',
    method: 'put',
    data: data
  });
};

/**
 * 删除人工补录数据
 * @param id
 */
export const delQcManualData = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qc/qcManualData/' + id,
    method: 'delete'
  });
};
