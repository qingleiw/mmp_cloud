import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { QualificationRiskMonitorVO, QualificationRiskMonitorForm, QualificationRiskMonitorQuery } from '@/api/qualification/qualificationRiskMonitor/types';

/**
 * 查询资质风险监测列表
 * @param query
 * @returns {*}
 */

export const listQualificationRiskMonitor = (query?: QualificationRiskMonitorQuery): AxiosPromise<QualificationRiskMonitorVO[]> => {
  return request({
    url: '/qualification/qualificationRiskMonitor/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询资质风险监测详细
 * @param id
 */
export const getQualificationRiskMonitor = (id: string | number): AxiosPromise<QualificationRiskMonitorVO> => {
  return request({
    url: '/qualification/qualificationRiskMonitor/' + id,
    method: 'get'
  });
};

/**
 * 新增资质风险监测
 * @param data
 */
export const addQualificationRiskMonitor = (data: QualificationRiskMonitorForm) => {
  return request({
    url: '/qualification/qualificationRiskMonitor',
    method: 'post',
    data: data
  });
};

/**
 * 修改资质风险监测
 * @param data
 */
export const updateQualificationRiskMonitor = (data: QualificationRiskMonitorForm) => {
  return request({
    url: '/qualification/qualificationRiskMonitor',
    method: 'put',
    data: data
  });
};

/**
 * 删除资质风险监测
 * @param id
 */
export const delQualificationRiskMonitor = (id: string | number | Array<string | number>) => {
  return request({
    url: '/qualification/qualificationRiskMonitor/' + id,
    method: 'delete'
  });
};
