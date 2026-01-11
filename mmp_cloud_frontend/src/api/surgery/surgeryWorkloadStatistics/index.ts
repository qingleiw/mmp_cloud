import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import {
  SurgeryWorkloadStatisticsVO,
  SurgeryWorkloadStatisticsForm,
  SurgeryWorkloadStatisticsQuery
} from '@/api/surgery/surgeryWorkloadStatistics/types';

/**
 * 查询手术工作量统计列表
 * @param query
 * @returns {*}
 */

export const listSurgeryWorkloadStatistics = (query?: SurgeryWorkloadStatisticsQuery): AxiosPromise<SurgeryWorkloadStatisticsVO[]> => {
  return request({
    url: '/surgery/surgeryWorkloadStatistics/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询手术工作量统计详细
 * @param id
 */
export const getSurgeryWorkloadStatistics = (id: string | number): AxiosPromise<SurgeryWorkloadStatisticsVO> => {
  return request({
    url: '/surgery/surgeryWorkloadStatistics/' + id,
    method: 'get'
  });
};

/**
 * 新增手术工作量统计
 * @param data
 */
export const addSurgeryWorkloadStatistics = (data: SurgeryWorkloadStatisticsForm) => {
  return request({
    url: '/surgery/surgeryWorkloadStatistics',
    method: 'post',
    data: data
  });
};

/**
 * 修改手术工作量统计
 * @param data
 */
export const updateSurgeryWorkloadStatistics = (data: SurgeryWorkloadStatisticsForm) => {
  return request({
    url: '/surgery/surgeryWorkloadStatistics',
    method: 'put',
    data: data
  });
};

/**
 * 删除手术工作量统计
 * @param id
 */
export const delSurgeryWorkloadStatistics = (id: string | number | Array<string | number>) => {
  return request({
    url: '/surgery/surgeryWorkloadStatistics/' + id,
    method: 'delete'
  });
};
